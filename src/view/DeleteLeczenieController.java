package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.DAOs.LeczenieDAO;
import model.DAOs.LekiDAO;
import model.entities.LeczenieEntity;
import model.entities.LekiEntity;

public class DeleteLeczenieController {

    @FXML
    private Button tak;

    @FXML
    private Button anuluj;

    @FXML
    private Label error;
    private LeczenieController.Wrapper selected;
    private TableView<OddzialyController.Wrapper> row;

    @FXML
    void close(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

    }

    @FXML
    void confirm(ActionEvent event) {
        try {
            LeczenieDAO.deleteLeczenie(selected.getLeczenie().getIdLeczenia());
        }
        catch (Exception e) {
            error.setVisible(true);
            tak.setDisable(true);
            return;
        }
        row.getItems().remove(selected);
        close(event);

    }


    @FXML
    public void passSelected(LeczenieController.Wrapper selected) {
        this.selected = selected;

    }

    public void passTable(TableView<OddzialyController.Wrapper> row) {
        this.row = row;

    }

}
