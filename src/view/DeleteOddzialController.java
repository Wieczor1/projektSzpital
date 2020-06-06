package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.DAOs.AdresyDAO;
import model.DAOs.OddzialyDAO;

public class DeleteOddzialController {
    private OddzialyController.Wrapper selected;
    private TableView<OddzialyController.Wrapper> row;

    @FXML
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
    private Label error;

    @FXML
    void close(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

    }

    @FXML
    void confirm(ActionEvent event) {
        try {
            OddzialyDAO.deleteOddzial(selected.getOddzialy().getIdOddzialu());
        } catch (Exception e) {
            e.printStackTrace();
            error.setVisible(true);
            tak.setDisable(true);
            return;
        }
        row.getItems().remove(selected);
        close(event);


    }
}
