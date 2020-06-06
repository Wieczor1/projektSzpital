package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DAOs.AdresyDAO;
import model.DAOs.DiagnozyDAO;
import model.entities.AdresyEntity;
import model.entities.DiagnozyEntity;

public class CreateDiagnozaController {

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
    private TableView<DiagnozyEntity> row;
    private DiagnozyEntity selected;

    @FXML
    void close(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

    }

    @FXML
    void confirm(ActionEvent event) {
        if (kod.getText().trim().equals("") || kod == null
                || kod.getText().trim().equals("") || kod == null)
        {
            error.setVisible(true);
            return;
        }
        DiagnozyEntity diagnoza;
        try{
            diagnoza = DiagnozyDAO.createDiagnoza(kod.getText(),opis.getText());
        }
        catch(Exception e){
            error.setVisible(true);
            return;
        }
        row.getItems().add(diagnoza);
        close(event);

    }

    @FXML
    public void passSelected(DiagnozyEntity selected) {
        this.selected = selected;

    }

    public void passTable(TableView<DiagnozyEntity> row) {
        this.row = row;

    }
}
