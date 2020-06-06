package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.DAOs.AdresyDAO;
import model.DAOs.LekarzeDAO;
import model.entities.AdresyEntity;
import model.entities.LekarzeEntity;

import javax.persistence.criteria.CriteriaBuilder;

public class CreateAdresController {
    private AdresyEntity selected;
    private TableView<AdresyEntity> row;

    @FXML
    private Label error;

    @FXML
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
    private VBox adresyFields;

    @FXML
    void close(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

    }

    @FXML
    void confirm(ActionEvent event) {// TODO co moze nie tak byc? puste stringi, blad parsowania oraz za dlugie varchary, data moze byc zjebana itd
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
        AdresyEntity adres;
        try{
            adres = AdresyDAO.createAdres(miasto.getText(),ulica.getText(),nrDom, kodPocztowy.getText(), nrLok);
        }
        catch(Exception e){
            error.setVisible(true);
            return;
        }
        row.getItems().add(adres);
        close(event);
    }

}
