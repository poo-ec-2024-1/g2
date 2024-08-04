package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import model.Aviao;
import model.DatabaseManager;
import model.Passageiro;
import model.Voo;
import java.sql.SQLException;

public class MenuController {

    @FXML
    private Pane panelAeronave;
    @FXML
    private Pane panelVoo;
    @FXML
    private Pane panelReserva;

    @FXML
    private TextField modeloField;
    @FXML
    private TextField fileiraField;
    @FXML
    private TextField assentosField;

    @FXML
    private Button saveAeronaveButton;

    @FXML
    private ComboBox<Aviao> aviaoComboBox;
    @FXML
    private TextField numeroVooField;
    @FXML
    private TextField dataField;
    @FXML
    private TextField horaField;
    @FXML
    private Button saveVooButton;

    @FXML
    private ComboBox<Voo> vooComboBox;
    @FXML
    private TextField nomeField;
    @FXML
    private TextField cpfField;
    @FXML
    private TextField fileiraReservaField;
    @FXML
    private TextField assentoReservaField;
    @FXML
    private Button saveReservaButton;

    private DatabaseManager dbManager;

    public void initialize() throws SQLException {
        dbManager = new DatabaseManager();

        // Populate ComboBoxes and other initialization
    }

    @FXML
    private void saveAeronave() {
        String modelo = modeloField.getText();
        int fileiras = Integer.parseInt(fileiraField.getText());
        int assentos = Integer.parseInt(assentosField.getText());

        Aviao aviao = new Aviao(modelo, fileiras, assentos);
        try {
            dbManager.getAviaoDao().create(aviao);
            // Show success message
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Show error message
        }
    }

    @FXML
    private void saveVoo() {
        Aviao aviao = aviaoComboBox.getValue();
        int numeroVoo = Integer.parseInt(numeroVooField.getText());
        String data = dataField.getText();
        String hora = horaField.getText();

        Voo voo = new Voo(aviao, numeroVoo, data, hora);
        try {
            dbManager.getVooDao().create(voo);
            // Show success message
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Show error message
        }
    }

    @FXML
    private void saveReserva() {
        Voo voo = vooComboBox.getValue();
        String nome = nomeField.getText();
        String cpf = cpfField.getText();
        int fileira = Integer.parseInt(fileiraReservaField.getText());
        int assento = Integer.parseInt(assentoReservaField.getText());

        Passageiro passageiro = new Passageiro(nome, cpf);
        try {
            dbManager.getPassageiroDao().create(passageiro);
            // Show success message
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Show error message
        }
    }
}
