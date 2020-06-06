package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.DAOs.LekarzeDAO;
import model.DAOs.LekiDAO;



public class DeleteLekarzController {

    @FXML
    private Button tak;
    private LekarzeController.Wrapper selected;
    private TableView<LekarzeController.Wrapper> row;
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
            LekarzeDAO.deleteLekarz(selected.getLekarz().getIdLekarza());
        }
        catch (Exception e) {
            error.setVisible(true);
            tak.setDisable(true);
            return;
        }
        row.getItems().remove(selected);
        close(event);

    }
    public void passSelected(LekarzeController.Wrapper selected) {
        this.selected = selected;

    }

    public void passTable(TableView<LekarzeController.Wrapper> row) {
        this.row = row;

    }
}
