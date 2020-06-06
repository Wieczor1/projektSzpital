package view;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.DAOs.GenericDAO;
import model.DAOs.PacjenciDAO;
import model.entities.DiagnozyEntity;
import model.entities.PacjenciEntity;

import java.sql.Date;
import java.time.LocalDate;

public class CreatePacjentController {

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
    void initialize(){
        diagnoza.setItems(FXCollections.observableArrayList(GenericDAO.getAll(DiagnozyEntity.class)));
        leczenie.setItems(LeczenieController.Wrapper.getWrapped());
    }
    @FXML
    void confirm(ActionEvent event) {
        if (imie.getText().trim().equals("") || imie == null
                || nazwisko.getText().trim().equals("")  || nazwisko == null
                || wzrost.getText().trim().equals("")  || wzrost == null
                || masa.getText().trim().equals("")  || masa == null
                || diagnoza.getSelectionModel().getSelectedItem() == null
                || leczenie.getSelectionModel().getSelectedItem() == null
                || data.getValue() == null)

        {
            System.out.println("tu1");
            error.setVisible(true);
            return;
        }
        if(!data.getValue().isBefore(LocalDate.now())){
            error.setVisible(true);
            return;
        }
        double m,w;
        try{
            m = Double.parseDouble(masa.getText());
            w = Double.parseDouble(wzrost.getText());
        }
        catch (Exception e)
        {
            error.setVisible(true);
            return;
        }

        PacjenciEntity pacjent;
        try{
            pacjent = PacjenciDAO.createPacjenci(imie.getText(),nazwisko.getText(),w,m, diagnoza.getSelectionModel().getSelectedItem().getIdDiagnozy(), leczenie.getSelectionModel().getSelectedItem().getLeczenie().getIdLeczenia(), Date.valueOf(data.getValue()));
        }
        catch(Exception e){
            System.out.println("tu2");
            error.setVisible(true);
            return;
        }
        row.getItems().add(new PacjenciController.Wrapper(pacjent, diagnoza.getSelectionModel().getSelectedItem(), leczenie.getSelectionModel().getSelectedItem()));
        close(event);

    }

}
