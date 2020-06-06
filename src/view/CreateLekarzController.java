package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.DAOs.AdresyDAO;
import model.DAOs.GenericDAO;
import model.DAOs.LekarzeDAO;
import model.entities.AdresyEntity;
import model.entities.LekarzeEntity;

public class CreateLekarzController {
    @FXML
    private TextField imie;

    @FXML
    private TextField nazwisko;

    @FXML
    private TextField specjalizacja;

    @FXML
    private TextField ulica;

    @FXML
    private TextField miasto;

    @FXML
    private TextField kodPocztowy;

    @FXML
    private TextField nrDomu;

    @FXML
    private TextField nrLokalu;
    @FXML
    private Button tak;

    @FXML
    private Button anuluj;

    @FXML
    private Label error;

    @FXML
    private ComboBox<AdresyEntity> adresy;

    @FXML
    private RadioButton nowy;

    @FXML
    private ToggleGroup toggle;

    @FXML
    private RadioButton istniejacy;

    @FXML
    private VBox adresyFields;
    private TableView<LekarzeController.Wrapper> row;

    @FXML
    void close(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

    }

    @FXML
    void confirm(ActionEvent event) throws Exception {
        if (imie.getText().trim().equals("") || imie == null
                || nazwisko.getText().trim().equals("") || nazwisko == null
                || specjalizacja.getText().trim().equals("") || specjalizacja == null) {
            error.setVisible(true);
            return;
        }
        if (toggle.getSelectedToggle() == nowy) {
            if (miasto.getText().trim().equals("") || miasto == null
                    || ulica.getText().trim().equals("") || ulica == null
                    || kodPocztowy.getText().trim().equals("") || kodPocztowy == null
                    || nrDomu.getText().trim().equals("") || nrDomu == null
                    || nrLokalu.getText().trim().equals("") || nrLokalu == null) {
                error.setVisible(true);
                return;
            }
            System.out.println("nowy");
            int nrDom, nrLok;
            try {
                nrDom = Integer.parseInt(nrDomu.getText());
                nrLok = Integer.parseInt(nrLokalu.getText());
            } catch (Exception e) {
                error.setVisible(true);
                return;
            }
            //TODO walidacja zeby nie bylo nulla, zeby wpisywane teksty mialy bialy kolor, VARCHARY dobra dlugosc itd
            LekarzeEntity lekarz = null;
            try {
                lekarz = LekarzeDAO.createLekarz(AdresyDAO.createAdres(miasto.getText(), ulica.getText(), nrDom, kodPocztowy.getText(), nrLok).getIdAdresu(), imie.getText(), nazwisko.getText(), specjalizacja.getText());
            } catch (Exception ex) {
                error.setVisible(true);
                return;
            }
            row.getItems().add(new LekarzeController.Wrapper(lekarz, AdresyDAO.getAdresById(lekarz.getIdAdresu())));
        }
            if (toggle.getSelectedToggle() == istniejacy) {
//                System.out.println("nowy");
                if(adresy.getSelectionModel().getSelectedItem() == null){
                    error.setVisible(true);
                    return;
                }
                LekarzeEntity lekarz = null;
                try {
                    lekarz = LekarzeDAO.createLekarz(adresy.getSelectionModel().getSelectedItem().getIdAdresu(), imie.getText(), nazwisko.getText(), specjalizacja.getText());
                } catch (Exception e) {
                    error.setVisible(true);
                    return;
                }
                row.getItems().add(new LekarzeController.Wrapper(lekarz, AdresyDAO.getAdresById(lekarz.getIdAdresu())));
            }

            close(event);
        }
        public void passTable (TableView < LekarzeController.Wrapper > row) {
            this.row = row;

        }
        @FXML
        public void initialize () {
            adresy.setItems(FXCollections.observableList(GenericDAO.getAll(AdresyEntity.class)));


            toggle.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
                    if (toggle.getSelectedToggle() == nowy) {
                        adresyFields.setVisible(true);
                        adresy.setVisible(false);
                    }
                    if (toggle.getSelectedToggle() == istniejacy) {
                        adresyFields.setVisible(false);
                        adresy.setVisible(true);
                    }
                }
            });


        }
    }
