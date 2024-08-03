

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class Menu extends JFrame {
    private Aviao[] aeronaves = new Aviao[10];
    private int aeronavesCounts = 0;

    private Voo[] voos = new Voo[10];
    private int voosCount = 0;

    private JMenuBar barra = new JMenuBar();
    private JMenu prmt = new JMenu("Parâmetros do Sistema");
    private JMenu rsva = new JMenu("Reserva de Passagens");
    private JMenu end = new JMenu("Sair");

    private JMenuItem prmt1 = new JMenuItem("Cadastrar Aeronave");
    private JMenuItem prmt2 = new JMenuItem("Cadastrar Vôo");
    private JMenuItem prmt3 = new JMenuItem("Voltar");

    private JMenuItem rsva1 = new JMenuItem("Fazer reserva");
    private JMenuItem rsva2 = new JMenuItem("Consultar lugares vazios");
    private JMenuItem rsva3 = new JMenuItem("Consultar reservas realizadas");
    private JMenuItem rsva4 = new JMenuItem("Voltar");

    private JMenuItem end1 = new JMenuItem("Fechar");

    private JPanel panelAeronave = new JPanel();
    private JPanel panelVoo = new JPanel();
    private JPanel panelReserva = new JPanel();

    private void hideAllPanels() {
        panelAeronave.setVisible(false);
        panelVoo.setVisible(false);
        panelReserva.setVisible(false);
    }

    public Menu() {
        setJMenuBar(barra);
        barra.add(prmt);
        barra.add(rsva);
        barra.add(end);

        // Cadastrar Aeronave
        prmt.add(prmt1);
        prmt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                hideAllPanels();
                panelAeronave.removeAll();
                JLabel labelModelo = new JLabel("Modelo da Aeronave: ");
                JTextField textFieldModelo = new JTextField("", 10);

                JLabel labelFileiras = new JLabel("Fileiras da aeronave: ");
                JTextField textFieldFileiras = new JTextField("", 10);

                JLabel labelAssentos = new JLabel("Assentos por fileira da aeronave: ");
                JTextField textFieldAssentos = new JTextField("", 10);

                JButton button = new JButton("Cadastrar");
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        try {
                            if (aeronavesCounts < aeronaves.length) {
                                int fileiras = Integer.parseInt(textFieldFileiras.getText());
                                int assentos = Integer.parseInt(textFieldAssentos.getText());
                                Aviao aeronave = new Aviao(textFieldModelo.getText(), fileiras, assentos);
                                aeronaves[aeronavesCounts] = aeronave;
                                aeronavesCounts++;
                                textFieldModelo.setText("");
                                textFieldFileiras.setText("");
                                textFieldAssentos.setText("");
                            } else {
                                JOptionPane.showMessageDialog(null, "Limite de aeronaves cadastradas excedido");
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Valor Inválido");
                        }
                    }
                });

                panelAeronave.add(labelModelo);
                panelAeronave.add(textFieldModelo);
                panelAeronave.add(labelFileiras);
                panelAeronave.add(textFieldFileiras);
                panelAeronave.add(labelAssentos);
                panelAeronave.add(textFieldAssentos);
                panelAeronave.add(button);

                panelAeronave.setVisible(true);
                add(panelAeronave);
                setVisible(true);
            }
        });

        // Cadastrar Vôo
        prmt.add(prmt2);
        prmt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                hideAllPanels();
                panelVoo.removeAll();
                JLabel labelNroVoo = new JLabel("Informe o número de voo: ");
                JTextField textFieldNroVoo = new JTextField("", 15);

                JLabel labelData = new JLabel("Informe a data de voo: ");
                MaskFormatter mascaraData;
                try {
                    mascaraData = new MaskFormatter("##/##/####");
                    mascaraData.setPlaceholderCharacter('_');
                } catch (ParseException e) {
                    throw new RuntimeException("Erro ao criar máscara de data", e);
                }
                JFormattedTextField jFormattedTextData = new JFormattedTextField(mascaraData);

                JLabel labelHora = new JLabel("Informe o horário do voo: ");
                MaskFormatter mascaraHora;
                try {
                    mascaraHora = new MaskFormatter("##:##");
                    mascaraHora.setPlaceholderCharacter('_');
                } catch (ParseException e) {
                    throw new RuntimeException("Erro ao criar máscara de hora", e);
                }
                JFormattedTextField jFormattedTextHora = new JFormattedTextField(mascaraHora);

                JLabel labelSelecioneAviao = new JLabel("Escolha o avião");
                JComboBox<Aviao> comboSelecioneAviao = new JComboBox<>(aeronaves);

                JButton button = new JButton("Cadastrar");
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        try {
                            if (voosCount < voos.length) {
                                int numero = Integer.parseInt(textFieldNroVoo.getText());
                                Voo voo = new Voo((Aviao) comboSelecioneAviao.getSelectedItem(), numero,
                                        jFormattedTextData.getText(), jFormattedTextHora.getText());
                                voos[voosCount] = voo;
                                voosCount++;
                                JOptionPane.showMessageDialog(null, "Voo cadastrado com sucesso !!!");
                                textFieldNroVoo.setText("");
                                jFormattedTextData.setText("");
                                jFormattedTextHora.setText("");
                            } else {
                                JOptionPane.showMessageDialog(null, "Limite de voos cadastrados excedido");
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Valor Inválido");
                        }
                    }
                });

                panelVoo.add(labelNroVoo);
                panelVoo.add(textFieldNroVoo);
                panelVoo.add(labelData);
                panelVoo.add(jFormattedTextData);
                panelVoo.add(labelHora);
                panelVoo.add(jFormattedTextHora);
                panelVoo.add(labelSelecioneAviao);
                panelVoo.add(comboSelecioneAviao);
                panelVoo.add(button);

                panelVoo.setVisible(true);
                add(panelVoo);
                setVisible(true);
            }
        });

        // Voltar no menu de parâmetros
        prmt.add(prmt3);
        prmt3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hideAllPanels();
                setVisible(true);
            }
        });

        // Fazer reserva
        rsva.add(rsva1);
        rsva1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                hideAllPanels();
                panelReserva.removeAll();
                JLabel labelEscolhaAviao = new JLabel("Escolha o avião");
                JComboBox<Aviao> comboEscolhaAviao = new JComboBox<>(aeronaves);

                JLabel labelEscolhaFileira = new JLabel("Escolha a fileira");
                JTextField textFieldEscolhaFileira = new JTextField("", 10);

                JLabel labelEscolhaAssento = new JLabel("Escolha o assento");
                JTextField textFieldEscolhaAssento = new JTextField("", 10);

                JLabel labelNomePassageiro = new JLabel("Digite o nome do passageiro: ");
                JTextField textFieldNomePassageiro = new JTextField("", 10);

                JLabel labelCPFPassageiro = new JLabel("Digite o CPF do Passageiro");
                JTextField textFieldCPFPassageiro = new JTextField("", 11);

                JButton button = new JButton("Reservar");
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        try {
                            int fileira = Integer.parseInt(textFieldEscolhaFileira.getText());
                            int assento = Integer.parseInt(textFieldEscolhaAssento.getText());
                            Aviao aviao = (Aviao) comboEscolhaAviao.getSelectedItem();
                            Passageiro passageiro = new Passageiro(textFieldNomePassageiro.getText(), textFieldCPFPassageiro.getText());
                            aviao.setPassageiro(fileira, assento, passageiro);
                            JOptionPane.showMessageDialog(null, "Reserva efetuada com sucesso !!!");
                            textFieldCPFPassageiro.setText("");
                            textFieldNomePassageiro.setText("");
                            textFieldEscolhaAssento.setText("");
                            textFieldEscolhaFileira.setText("");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Valor Inválido");
                        }
                    }
                });

                panelReserva.add(labelEscolhaAviao);
                panelReserva.add(comboEscolhaAviao);
                panelReserva.add(labelEscolhaFileira);
                panelReserva.add(textFieldEscolhaFileira);
                panelReserva.add(labelEscolhaAssento);
                panelReserva.add(textFieldEscolhaAssento);
                panelReserva.add(labelNomePassageiro);
                panelReserva.add(textFieldNomePassageiro);
                panelReserva.add(labelCPFPassageiro);
                panelReserva.add(textFieldCPFPassageiro);
                panelReserva.add(button);

                panelReserva.setVisible(true);
                add(panelReserva);
                setVisible(true);
            }
        });

        // Consultar lugares vazios
        rsva.add(rsva2);
        rsva2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                hideAllPanels();
                panelReserva.removeAll();
                JLabel labelSelecioneAviao = new JLabel("Escolha o avião");
                JComboBox<Aviao> comboSelecioneAviao = new JComboBox<>(aeronaves);

                JButton button = new JButton("Consultar");
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        // Implementar a lógica para consultar lugares vazios
                    }
                });

                panelReserva.add(labelSelecioneAviao);
                panelReserva.add(comboSelecioneAviao);
                panelReserva.add(button);

                panelReserva.setVisible(true);
                add(panelReserva);
                setVisible(true);
            }
        });

        // Consultar reservas realizadas
        rsva.add(rsva3);
        rsva3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                hideAllPanels();
                panelReserva.removeAll();
                JLabel labelSelecioneAviao = new JLabel("Escolha o Avião");
                JComboBox<Aviao> comboSelecioneAviao = new JComboBox<>(aeronaves);

                JButton button = new JButton("Consultar");
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            Aviao aviao = (Aviao) comboSelecioneAviao.getSelectedItem();
                            StringBuilder message = new StringBuilder("As reservas feitas são: \n");
                            for (int x = 0; x < aviao.lugares.length; x++) {
                                for (int y = 0; y < aviao.lugares[x].length; y++) {
                                    if (aviao.verificaPoltrona(x, y)) {
                                        Passageiro passageiro = aviao.getPassageiro(x, y);
                                        message.append("[").append(x).append(", ").append(y).append("] - ")
                                                .append(passageiro.getNome()).append(" - ")
                                                .append(passageiro.getCpf()).append("\n");
                                    }
                                }
                            }
                            JOptionPane.showMessageDialog(null, message.toString());
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Valor Inválido");
                        }
                    }
                });

                panelReserva.add(labelSelecioneAviao);
                panelReserva.add(comboSelecioneAviao);
                panelReserva.add(button);

                panelReserva.setVisible(true);
                add(panelReserva);
                setVisible(true);
            }
        });

        // Voltar no menu de reserva
        rsva.add(rsva4);
        rsva4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                hideAllPanels();
                setVisible(true);
            }
        });

        // Sair
        end.add(end1);
        end1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setTitle("Menu");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
 }
