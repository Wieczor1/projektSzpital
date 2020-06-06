package view;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.DAOs.GenericDAO;
import model.DAOs.LekiDAO;
import model.DAOs.PacjenciDAO;
import model.entities.DiagnozyEntity;
import model.entities.LekiEntity;
import model.entities.PacjenciEntity;

import java.sql.Date;
import java.time.LocalDate;

public class ModifyPacjentController {

    @FXML
    private Button tak;

    @FXML
    private Button anuluj;

    @FXML
    private TextField imie;

    @FXML
    private TextField nazwisko;

    @FXML
    private TextField wzrost;

    @FXML
    private TextField masa;

    @FXML
    private DatePicker data;

    @FXML
    private ComboBox<DiagnozyEntity> diagnoza;

    @FXML
    private ComboBox<LeczenieController.Wrapper> leczenie;

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

    public void passSelected(PacjenciController.Wrapper selected) {
        this.selected = selected;

    }

    public void passTable(TableView<PacjenciController.Wrapper> row) {
        this.row = row;

    }

    @FXML
    void confirm(ActionEvent event) {
        if (imie.getText().trim().equals("") || imie == null
                || nazwisko.getText().trim().equals("") || nazwisko == null
                || wzrost.getText().trim().equals("") || wzrost == null
                || masa.getText().trim().equals("") || masa == null
                || diagnoza.getSelectionModel().getSelectedItem() == null
                || leczenie.getSelectionModel().getSelectedItem() == null
                || data.getValue() == null) {
            System.out.println("tu1");
            error.setVisible(true);
            return;
        }
        if (!data.getValue().isBefore(LocalDate.now())) {
            error.setVisible(true);
            return;
        }
        double m, w;
        try {
            m = Double.parseDouble(masa.getText());
            w = Double.parseDouble(wzrost.getText());
        } catch (Exception e) {
            error.setVisible(true);
            return;
        }

        selected.getPacjent().setMasaCiala(m);
        selected.getPacjent().setWzrost(w);
        selected.getPacjent().setNazwisko(nazwisko.getText());
        selected.getPacjent().setImie(imie.getText());
        selected.getPacjent().setIdDiagnozy(diagnoza.getSelectionModel().getSelectedItem().getIdDiagnozy());
        selected.setDataPrzyjecia(Date.valueOf(data.getValue()));
        selected.setDiagnozyEntity(diagnoza.getSelectionModel().getSelectedItem());
        selected.getPacjent().setIdLeczenia(leczenie.getSelectionModel().getSelectedItem().getLeczenie().getIdLeczenia());
        selected.setLeczenieWrapper(leczenie.getSelectionModel().getSelectedItem());

        try {
            PacjenciDAO.UpdatePacjent(selected.getPacjent());
        } catch (Exception e) {
            System.out.println("tu2");
            error.setVisible(true);
            return;
        }
        close(event);
        row.getItems().clear();
        row.setItems(FXCollections.observableArrayList(PacjenciController.Wrapper.getAll()));

    }
    @FXML
    void initialize(){
        diagnoza.setItems(FXCollections.observableArrayList(GenericDAO.getAll(DiagnozyEntity.class)));
        leczenie.setItems(LeczenieController.Wrapper.getWrapped());
    }

    public void setImieText(String i) {
        imie.setText(i);
    }

    public void setNazwiskoText(String n) {
        nazwisko.setText(n);
    }

    public void setWzrostText(String w) {
        wzrost.setText(w);
    }

    public void setMasaText(String m) {
        masa.setText(m);
    }

    public void setDiagnoza(DiagnozyEntity diagnozyEntity) {
        diagnoza.setValue(diagnozyEntity);
    }

    public void setLeczenie(LeczenieController.Wrapper leczenieWrapper) {
        leczenie.setValue(leczenieWrapper);
    }

    public void setData(Date dataPrzyjecia) {
        data.setValue(dataPrzyjecia.toLocalDate());
    }
}
