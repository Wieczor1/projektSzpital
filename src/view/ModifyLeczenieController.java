package view;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.DAOs.GenericDAO;
import model.DAOs.LeczenieLekiDAO;
import model.DAOs.LekiDAO;
import model.entities.LekiEntity;
import model.entities.OddzialyEntity;

public class ModifyLeczenieController {

    @FXML
    private Button tak;

    @FXML
    private Button anuluj;

    @FXML
    private TextField uwagi;

    @FXML
    private ComboBox<LekiEntity> lekiDawkowanie;

    @FXML
    private Label error;
    private LeczenieController.Wrapper selected;
    private TableView<LeczenieController.Wrapper> row;


    @FXML
    void close(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    @FXML
    void confirm(ActionEvent event) {
        if (uwagi.getText().trim().equals("") || uwagi == null
          || lekiDawkowanie.getSelectionModel().getSelectedItem() == null) // TODO comboboxy not null

        {
            System.out.println("tu1");
            error.setVisible(true);
            return;
        }

        selected.getLeczL().setUwagi(uwagi.getText());
        selected.setLeki(lekiDawkowanie.getSelectionModel().getSelectedItem().getNazwaLeku());
        try {
            LeczenieLekiDAO.UpdateLeczenieLeki(selected.getLeczL());
        } catch (Exception e) {
            error.setVisible(true);
            return;
        }
        close(event);
        row.getItems().clear();
        row.setItems(FXCollections.observableArrayList(LeczenieController.Wrapper.getWrapped()));
    }

    public void passSelected(LeczenieController.Wrapper selected) {
        this.selected = selected;

    }

    public void passTable(TableView<LeczenieController.Wrapper> row) {
        this.row = row;

    }

    public void setUwagiText(String text) {
        uwagi.setText(text);
    }

    public void setLekiDawkowanie(LekiEntity lek) {
        lekiDawkowanie.setValue(lek);
    }

    @FXML
    void initialize() {
        lekiDawkowanie.setItems(FXCollections.observableArrayList(GenericDAO.getAll(LekiEntity.class)));

    }
}

