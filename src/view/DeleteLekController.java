package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.DAOs.AdresyDAO;
import model.DAOs.LekarzeDAO;
import model.DAOs.LekiDAO;
import model.entities.AdresyEntity;
import model.entities.LekiEntity;

public class DeleteLekController {
    private LekiEntity selected;
    private TableView<LekiEntity> row;
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
            LekiDAO.deleteLek(selected.getIdLeku());
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
    public void passSelected(LekiEntity selected) {
        this.selected = selected;

    }

    public void passTable(TableView<LekiEntity> row) {
        this.row = row;

    }
}
