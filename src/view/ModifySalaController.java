package view;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.DAOs.GenericDAO;
import model.DAOs.OddzialyDAO;
import model.DAOs.SaleDAO;
import model.entities.OddzialyEntity;

public class ModifySalaController {

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
    public void passSelected(SaleController.Wrapper selected) {
        this.selected = selected;

    }

    public void passTable(TableView<SaleController.Wrapper> row) {
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
        if (nrSali.getText().trim().equals("") || nrSali == null || typ.getText().trim().equals("") || typ == null || oddzial.getSelectionModel().getSelectedItem() == null)
        {
            error.setVisible(true);
            return;
        }
        int nr;
        try{
            nr = Integer.parseInt(nrSali.getText());
        }
        catch (Exception e)
        {
            error.setVisible(true);
            return;
        }

        selected.getSala().setTypSali(typ.getText());
        selected.getSala().setNrSali(nr);
        selected.getSala().setIdOddzialu(oddzial.getSelectionModel().getSelectedItem().getIdOddzialu());

        try {
            SaleDAO.UpdateSala(selected.getSala());
        } catch (Exception e) {
            error.setVisible(true);
            return;
        }
        close(event);
        row.getItems().clear();
        row.setItems(FXCollections.observableArrayList(SaleController.Wrapper.getSalaAndOddzial()));

    }

    @FXML
    void initialize() {
            oddzial.setItems(FXCollections.observableArrayList(GenericDAO.getAll(OddzialyEntity.class)));
        }

    public void setNrSali(int nr) {
        nrSali.setText(String.valueOf(nr));
    }

    public void setTypSali(String typSali) {
        typ.setText(typSali);
    }

    public void setOddzial(OddzialyEntity oddz) {
        oddzial.setValue(oddz);
    }
}

