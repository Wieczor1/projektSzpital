package view;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.DAOs.GenericDAO;
import model.DAOs.LekiDAO;
import model.DAOs.SaleDAO;
import model.entities.LekiEntity;
import model.entities.OddzialyEntity;
import model.entities.SaleEntity;

import javax.persistence.criteria.CriteriaBuilder;

public class CreateSalaController {
    @FXML
    private Button tak;

    @FXML
    private Button anuluj;

    @FXML
    private TextField nrSali;

    @FXML
    private TextField typ;

    @FXML
    private ComboBox<OddzialyEntity> oddzial;

    @FXML
    private Label error;
    private SaleController.Wrapper selected;
    private TableView<SaleController.Wrapper> row;

    @FXML
    void close(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

    }

    @FXML
    void confirm(ActionEvent event) {
        if (nrSali.getText().trim().equals("") || nrSali == null
                || typ.getText().trim().equals("")  || typ == null
        || oddzial.getSelectionModel().getSelectedItem() == null) //
            {
            System.out.println("tu1");
            error.setVisible(true);
            return;
        }
        int nr;
        try{
            nr = Integer.parseInt(nrSali.getText());
        }
        catch (Exception e){
            error.setVisible(true);
            return;
        }

        SaleEntity sala;
        try{
            sala = SaleDAO.createSala(oddzial.getSelectionModel().getSelectedItem().getIdOddzialu(), nr, typ.getText());
        }
        catch(Exception e){
            System.out.println("tu2");
            error.setVisible(true);
            return;
        }
        row.getItems().add(new SaleController.Wrapper(sala, oddzial.getSelectionModel().getSelectedItem()));
        close(event);

    }

    @FXML
    public void passSelected(SaleController.Wrapper selected) {
        this.selected = selected;

    }

    public void passTable(TableView<SaleController.Wrapper> row) {
        this.row = row;

    }

    @FXML
    void initialize(){
        oddzial.setItems(FXCollections.observableArrayList(GenericDAO.getAll(OddzialyEntity.class)));
    }
}
