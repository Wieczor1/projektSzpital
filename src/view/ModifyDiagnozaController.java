package view;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DAOs.DiagnozyDAO;
import model.DAOs.GenericDAO;
import model.entities.DiagnozyEntity;

public class ModifyDiagnozaController {

    @FXML
    private Button tak;

    @FXML
    private Button anuluj;

    @FXML
    private TextField kod;

    @FXML
    private TextField opis;

    @FXML
    private Label error;
    private DiagnozyEntity selected;
    private TableView<DiagnozyEntity> row;

    @FXML
    void close(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }


    void setKodText(String text){
        kod.setText(text);
    }
    void setOpisText(String text){
        opis.setText(text);
    }

    @FXML
    void confirm(ActionEvent event) {
        if (kod.getText().trim().equals("") || kod == null || opis.getText().trim().equals("") || opis == null)
        {
            error.setVisible(true);
            return;
        }


        selected.setKodDiagnozy(kod.getText());
        selected.setOpis(opis.getText());

        try {
            DiagnozyDAO.UpdateDiagnoza(selected);
        } catch (Exception e) {
            error.setVisible(true);
            return;
        }
        close(event);
        row.getItems().clear();
        row.setItems(FXCollections.observableArrayList(GenericDAO.getAll(DiagnozyEntity.class)));

    }

    @FXML
    public void passSelected(DiagnozyEntity selected) {
        this.selected = selected;

    }

    public void passTable(TableView<DiagnozyEntity> row) {
        this.row = row;

    }

}
