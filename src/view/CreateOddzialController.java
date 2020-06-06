package view;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.DAOs.AdresyDAO;
import model.DAOs.GenericDAO;
import model.DAOs.OddzialyDAO;
import model.entities.AdresyEntity;
import model.entities.LekarzeEntity;
import model.entities.OddzialyEntity;

public class CreateOddzialController {

    @FXML
    private Button tak;

    @FXML
    private Button anuluj;

    @FXML
    private TextField nazwa;

    @FXML
    private TextField nrTelefonu;

    @FXML
    private ComboBox<LekarzeEntity> ordynator;

    @FXML
    private Label error;
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
    void close(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

    }

    @FXML
    void confirm(ActionEvent event) {
        if (nazwa.getText().trim().equals("") || nazwa == null
                || nrTelefonu.getText().trim().equals("") || nrTelefonu == null || ordynator.getSelectionModel().getSelectedItem() == null) // TODO comboboxy not null

        {
            System.out.println("tu1");
            error.setVisible(true);
            return;
        }

        OddzialyEntity oddzial;
        try{
            oddzial = OddzialyDAO.createOddzial(ordynator.getSelectionModel().getSelectedItem().getIdLekarza(), nazwa.getText(), nrTelefonu.getText());
        }
        catch(Exception e){
            System.out.println("tu2");
            error.setVisible(true);
            return;
        }
        row.getItems().add(new OddzialyController.Wrapper(oddzial, ordynator.getSelectionModel().getSelectedItem()));
        close(event);
    }

    @FXML
    void initialize() {
        ordynator.setItems(FXCollections.observableArrayList(GenericDAO.getAll(LekarzeEntity.class)));

    }

}
