package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import model.DatabaseHelper;
import dao.AviaoDAO;
import dao.VooDAO;
import model.Aviao;
import model.Voo;

public class Menu extends JFrame {
    private DatabaseHelper dbHelper;
    private AviaoDAO aviaoDAO;
    private VooDAO vooDAO;

    public Menu() {
        super("Controle de Passagens Aéreas");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        dbHelper = new DatabaseHelper();
        try {
            aviaoDAO = new AviaoDAO(dbHelper.getConnectionSource());
            vooDAO = new VooDAO(dbHelper.getConnectionSource());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        initComponents();
    }

    private void initComponents() {
        JMenuBar barra = new JMenuBar();
        JMenu prmt = new JMenu("Cadastro de Aeronaves");
        JMenu rsva = new JMenu("Reservas");
        JMenu end = new JMenu("Encerrar Sistema");

        JMenuItem prmt1 = new JMenuItem("Cadastrar Aeronave");
        JMenuItem prmt2 = new JMenuItem("Cadastrar Voo");
        JMenuItem rsva1 = new JMenuItem("Fazer Reserva");
        JMenuItem rsva2 = new JMenuItem("Consultar Lugares Vazios");
        JMenuItem rsva3 = new JMenuItem("Consultar Reservas Realizadas");
        JMenuItem end1 = new JMenuItem("Finalizar Sistema");

        prmt1.addActionListener(new GerenciadorBotoes());
        prmt2.addActionListener(new GerenciadorBotoes());
        rsva1.addActionListener(new GerenciadorBotoes());
        rsva2.addActionListener(new GerenciadorBotoes());
        rsva3.addActionListener(new GerenciadorBotoes());
        end1.addActionListener(new GerenciadorBotoes());

        prmt.add(prmt1);
        prmt.add(prmt2);
        rsva.add(rsva1);
        rsva.add(rsva2);
        rsva.add(rsva3);
        end.add(end1);

        barra.add(prmt);
        barra.add(rsva);
        barra.add(end);

        setJMenuBar(barra);
        setVisible(true);
    }

    private class GerenciadorBotoes implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();
            
            try{

            if (comando.equals("Cadastrar Aeronave")) {
                cadastrarAeronave();
            } else if (comando.equals("Cadastrar Voo")) {
                cadastrarVoo();
            } else if (comando.equals("Fazer Reserva")) {
                // implementação de fazer reserva
            } else if (comando.equals("Consultar Lugares Vazios")) {
                // implementação de consultar lugares vazios
            } else if (comando.equals("Consultar Reservas Realizadas")) {
                // implementação de consultar reservas realizadas
            } else if (comando.equals("Finalizar Sistema")) {
                finalizarSistema();
            }
        }
        
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

        private void cadastrarAeronave() {
            JLabel lblModelo = new JLabel("Modelo:");
            JTextField txtModelo = new JTextField(10);
            JLabel lblFileira = new JLabel("Fileira:");
            JTextField txtFileira = new JTextField(3);
            JLabel lblAssento = new JLabel("Assento:");
            JTextField txtAssento = new JTextField(3);

            Object[] message = {
                lblModelo, txtModelo,
                lblFileira, txtFileira,
                lblAssento, txtAssento
            };

            int option = JOptionPane.showConfirmDialog(null, message, "Cadastrar Aeronave", JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
                try {
                    String modelo = txtModelo.getText();
                    int fileira = Integer.parseInt(txtFileira.getText());
                    int assento = Integer.parseInt(txtAssento.getText());

                    Aviao aviao = new Aviao(modelo, fileira, assento);
                    aviaoDAO.create(aviao);

                    JOptionPane.showMessageDialog(null, "Aeronave cadastrada com sucesso!");
                } catch (NumberFormatException | SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
                }
            }
        }

        private void cadastrarVoo() {
            JLabel lblNumeroVoo = new JLabel("Número do Voo:");
            JTextField txtNumeroVoo = new JTextField(5);
            JLabel lblData = new JLabel("Data:");
            JFormattedTextField txtData = new JFormattedTextField(createFormatter("##/##/####"));
            JLabel lblHora = new JLabel("Hora:");
            JFormattedTextField txtHora = new JFormattedTextField(createFormatter("##:##"));

            try {
                java.util.List<Aviao> avioes = aviaoDAO.readAll();
                String[] modelos = new String[avioes.size()];
                for (int i = 0; i < avioes.size(); i++) {
                    modelos[i] = avioes.get(i).getModelo();
                }

                JComboBox<String> cbModelos = new JComboBox<>(modelos);

                Object[] message = {
                    lblNumeroVoo, txtNumeroVoo,
                    lblData, txtData,
                    lblHora, txtHora,
                    cbModelos
                };

                int option = JOptionPane.showConfirmDialog(null, message, "Cadastrar Voo", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.OK_OPTION) {
                    try {
                        int numeroVoo = Integer.parseInt(txtNumeroVoo.getText());
                        String data = txtData.getText();
                        String hora = txtHora.getText();
                        int aeronaveIndex = cbModelos.getSelectedIndex();

                        Aviao aviao = avioes.get(aeronaveIndex);
                        Voo voo = new Voo(aviao, numeroVoo, data, hora);
                        vooDAO.create(voo);

                        JOptionPane.showMessageDialog(null, "Voo cadastrado com sucesso!");
                    } catch (NumberFormatException | SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao buscar aeronaves: " + ex.getMessage());
            }
        }

        private void finalizarSistema() throws Exception {
            dbHelper.close();
            System.exit(0);
        }

        private MaskFormatter createFormatter(String s) {
            MaskFormatter formatter = null;
            try {
                formatter = new MaskFormatter(s);
                formatter.setPlaceholderCharacter('_');
            } catch (java.text.ParseException exc) {
                System.err.println("formatter is bad: " + exc.getMessage());
            }
            return formatter;
        }
    }

    public static void main(String[] args) {
        new Menu();
    }
}

