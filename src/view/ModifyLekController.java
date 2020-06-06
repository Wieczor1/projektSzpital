package view;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.DAOs.AdresyDAO;
import model.DAOs.GenericDAO;
import model.DAOs.LekiDAO;
import model.entities.AdresyEntity;
import model.entities.LekiEntity;

public class ModifyLekController {

    @FXML
    private Button tak;

    @FXML
    private Button anuluj;

    @FXML
    private TextField nazwa;

    @FXML
    private TextField kod;

    @FXML
    private CheckBox refundacja;

    @FXML
    private Label error;
    private LekiEntity selected;
    private TableView<LekiEntity> row;

    @FXML
    void close(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    @FXML
    void confirm(ActionEvent event) {
        if (kod.getText().trim().equals("") || kod == null
                || nazwa.getText().trim().equals("")  || nazwa == null) // TODO comboboxy not null

        {
            System.out.println("tu1");
            error.setVisible(true);
            return;
        }
        selected.setKodLeku(kod.getText());
        selected.setNazwaLeku(nazwa.getText());
        selected.setRefundacja(refundacja.isSelected());

        try {
            LekiDAO.UpdateLek(selected);
        } catch (Exception e) {
            error.setVisible(true);
            return;
        }
        close(event);
        row.getItems().clear();
        row.setItems(FXCollections.observableList(GenericDAO.getAll(LekiEntity.class)));
    }

    public void passSelected(LekiEntity selected) {
        this.selected = selected;

    }

    public void passTable(TableView<LekiEntity> row) {
        this.row = row;

    }

    public void setNazwaText(String text) {
        nazwa.setText(text);
    }

    public void setKodText(String text) {
        kod.setText(text);
    }

    public void setRefundacja(Boolean bool) {
        refundacja.setSelected(bool);
    }
}
