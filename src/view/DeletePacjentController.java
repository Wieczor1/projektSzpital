package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.DAOs.PacjenciDAO;
import model.entities.PacjenciEntity;

public class DeletePacjentController {

    @FXML
    private Button tak;

    @FXML
    private Button anuluj;

    @FXML
    private Label error;
    private PacjenciController.Wrapper selected;
    private TableView<PacjenciController.Wrapper> row;

    @FXML
    void close(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

    }

    @FXML
    void confirm(ActionEvent event) {
        try {
            PacjenciDAO.deletePacjent(selected.getPacjent().getIdPacjenta());
        }
        catch (Exception e) {
            error.setVisible(true);
            tak.setDisable(true);
            return;
        }
        row.getItems().remove(selected);
        close(event);

    }

    public void passSelected(PacjenciController.Wrapper selected) {
        this.selected = selected;

    }

    public void passTable(TableView<PacjenciController.Wrapper> row) {
        this.row = row;

    }

}
