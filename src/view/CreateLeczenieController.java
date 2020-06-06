package view;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.DAOs.GenericDAO;
import model.DAOs.LeczenieDAO;
import model.DAOs.LeczenieLekiDAO;
import model.DAOs.LekiDAO;
import model.entities.*;
import org.controlsfx.control.CheckComboBox;

public class CreateLeczenieController {

    @FXML
    private Button tak;

    @FXML
    private Button anuluj;

    @FXML
    private TextField uwagi;

    @FXML
    private ComboBox<LekiEntity> lekiDawkowanie;
    private LeczenieController.Wrapper selected;
    private TableView<LeczenieController.Wrapper> row;

    @FXML
    public void passSelected(LeczenieController.Wrapper selected) {
        this.selected = selected;

    }

    public void passTable(TableView<LeczenieController.Wrapper> row) {
        this.row = row;

    }


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
        if (uwagi.getText().trim().equals("") || uwagi == null || lekiDawkowanie.getSelectionModel().getSelectedItem() == null) // TODO comboboxy not null

        {
            System.out.println("tu1");
            error.setVisible(true);
            return;
        }

        LeczenieEntity lecz;
        LeczenieLekiEntity llk;
        try{
            lecz = LeczenieDAO.createLeczenie();
            llk = LeczenieLekiDAO.createLeczenieLeki(0, uwagi.getText(),lecz.getIdLeczenia(),lekiDawkowanie.getSelectionModel().getSelectedItem().getIdLeku());

        }
        catch(Exception e){
            System.out.println("tu2");
            error.setVisible(true);
            return;
        }
        row.getItems().add(new LeczenieController.Wrapper(llk, lecz));
//        row.getItems().clear();
//        row.setItems(FXCollections.observableArrayList(LeczenieController.Wrapper.getWrapped()));
        close(event);

    }




    @FXML
    void initialize() {
        lekiDawkowanie.getItems().addAll(GenericDAO.getAll(LekiEntity.class));

    }

}
