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
import model.DAOs.AdresyDAO;
import model.DAOs.GenericDAO;
import model.DAOs.OddzialyDAO;
import model.entities.AdresyEntity;
import model.entities.OddzialyEntity;

public class ModifyOddzialController {

    private OddzialyController.Wrapper selected;
    private TableView<OddzialyController.Wrapper> row;

    public void passSelected(OddzialyController.Wrapper selected) {
        this.selected = selected;

    }

    public void passTable(TableView<OddzialyController.Wrapper> row) {
        this.row = row;

    }
    @FXML
    private Button tak;

    @FXML
    private Button anuluj;

    @FXML
    private TextField nazwa;

    @FXML
    private TextField nrTelefonu;

    @FXML
    private Label error;

    @FXML
    void close(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    public void setNazwaText(String text){
        nazwa.setText(text);
    }

    public void setNrTelefonuText(String nrtelefonu){
        nrTelefonu.setText(nrtelefonu);
    }

    @FXML
    void confirm(ActionEvent event) {
        if (nazwa.getText().trim().equals("") || nazwa == null || nrTelefonu.getText().trim().equals("") || nrTelefonu == null)
        {
            error.setVisible(true);
            return;
        }

        selected.getOddzialy().setNazwa(nazwa.getText());
        selected.getOddzialy().setNrTelefonu(nrTelefonu.getText());
        selected.setNazwa(nazwa.getText());
        selected.setNrTelefonu(nrTelefonu.getText());

        try {
            OddzialyDAO.UpdateOddzial(selected.getOddzialy());
        } catch (Exception e) {
            error.setVisible(true);
            return;
        }
        close(event);
        row.getItems().clear();
        row.setItems(FXCollections.observableArrayList(OddzialyController.Wrapper.getOddzialAndOrdynator()));

    }

}
