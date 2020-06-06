package view;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DAOs.AdresyDAO;
import model.DAOs.GenericDAO;
import model.DAOs.LekarzeDAO;
import model.entities.AdresyEntity;


public class ModifyAdresController {

    private AdresyEntity selected;
    private TableView<AdresyEntity> row;

    public void passSelected(AdresyEntity selected) {
        this.selected = selected;

    }

    public void passTable(TableView<AdresyEntity> row) {
        this.row = row;

    }

    @FXML
    private Button tak;

    @FXML
    private Button anuluj;

    @FXML
    private TextField miasto;

    @FXML
    private TextField ulica;

    @FXML
    private TextField kodPocztowy;

    @FXML
    private TextField nrLokalu;

    @FXML
    private TextField nrDomu;

    @FXML
    private Label error;


    @FXML
    void close(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    public void setNrLokaluText(String nrLokalu) {
        this.nrLokalu.setText(nrLokalu);

    }
    public void setNrDomuText(String nrDomu) {
        this.nrDomu.setText(nrDomu);

    }

    public void setMiastoText(String miasto) {
        this.miasto.setText(miasto);

    }
    public void setKodPocztowyText(String kodPocztowy) {
        this.kodPocztowy.setText(kodPocztowy);

    }
    public void setUlicaText(String ulica) {
        this.ulica.setText(ulica);

    }

    @FXML
    void confirm(ActionEvent event) {

        if (miasto.getText().trim().equals("") || miasto == null
                || ulica.getText().trim().equals("") || ulica == null
                || kodPocztowy.getText().trim().equals("") || kodPocztowy == null
                || nrDomu.getText().trim().equals("") || nrDomu == null
                || nrLokalu.getText().trim().equals("") || nrLokalu == null)
        {
            error.setVisible(true);
            return;
        }
        int nrDom, nrLok;
        try
        {
            nrDom = Integer.parseInt(nrDomu.getText());
            nrLok = Integer.parseInt(nrLokalu.getText());
        }
        catch(Exception e){
            error.setVisible(true);
            return;
        }
            selected.setNumerLokalu(nrLok);
            selected.setNumerDomu(nrDom);
            selected.setMiasto(miasto.getText());
            selected.setKodPocztowy(kodPocztowy.getText());
            selected.setUlica(ulica.getText());
        try {
            AdresyDAO.UpdateAdres(selected);
        } catch (Exception e) {
            error.setVisible(true);
            return;
        }
        close(event);
            row.getItems().clear();
            row.setItems(FXCollections.observableList(GenericDAO.getAll(AdresyEntity.class)));
//            selected.getLekarz().setNazwisko(nazwisko.getText());
//            selected.getLekarz().setSpecjalizacja(specjalizacja.getText());
//            LekarzeDAO.UpdateLekarz(selected.getLekarz());
//            close(event);
//            row.setItems(FXCollections.observableArrayList(LekarzeController.Wrapper.getLekarzAndAdres()));

    }
}
