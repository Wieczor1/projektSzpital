package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DAOs.GenericDAO;
import model.DAOs.LekarzeDAO;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.entities.LekarzeEntity;

import java.awt.*;
import java.awt.Label;
import java.io.IOException;


public class ModifyLekarzController {

    @FXML
    private Button tak;

    @FXML
    private Button anuluj;

    @FXML
    private TextField imie;

    @FXML
    private TextField nazwisko;

    @FXML
    private TextField specjalizacja;

    private LekarzeController.Wrapper selected;
    private TableView<LekarzeController.Wrapper> row;
    @FXML
    private Label error;


    @FXML
    void close(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    @FXML // TODO przycisk odsylajacy do modifikacji adresu w lekarzu, w sensie klucza obcnego
    void confirm(ActionEvent event) throws Exception {
        if (imie.getText().trim().equals("") || imie == null
                || nazwisko.getText().trim().equals("") || nazwisko == null
                || specjalizacja.getText().trim().equals("") || specjalizacja == null) {
            error.setVisible(true);
            return;
        }
        selected.getLekarz().setImie(imie.getText());
        selected.getLekarz().setNazwisko(nazwisko.getText());
        selected.getLekarz().setSpecjalizacja(specjalizacja.getText());
        try {
            LekarzeDAO.UpdateLekarz(selected.getLekarz());
        } catch (Exception e) {
            error.setVisible(true);
            return;
        }
        close(event);
        row.getItems().clear();
        row.setItems(FXCollections.observableArrayList(LekarzeController.Wrapper.getLekarzAndAdres()));

//        ObservableList<TableColumn<LekarzeController.Wrapper, ?>> column = row.getColumns();
//        column.get(0).setOnEditCommit( new EventHandler<TableColumn.CellEditEvent<LekarzeController.Wrapper, String>>() {
//                                           @Override
//                                           public void handle(TableColumn.CellEditEvent<LekarzeController.Wrapper, String> t) {
//                                               ((LekarzeController.Wrapper) t.getTableView().getItems().get(
//                                                       t.getTablePosition().getRow())
//                                               ).setImie(t.getNewValue());
//                                           }
//                                       }

//        );
    }

    @FXML
    void initialize() throws IOException { //TODO
    }

    @FXML
    public void passSelected(LekarzeController.Wrapper selected) {
        this.selected = selected;

    }

    public void passTable(TableView<LekarzeController.Wrapper> row) {
        this.row = row;

    }

    public TextField getImie() {
        return imie;
    }

    public void setImieText(String imie) {
        this.imie.setText(imie);

    }
    public void setNazwiskoText(String imie) {
        this.nazwisko.setText(imie);

    }
    public void setSpecjalizacjaText(String imie) {
        this.specjalizacja.setText(imie);
    }


    public TextField getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(TextField nazwisko) {
        this.nazwisko = nazwisko;
    }

    public TextField getSpecjalizacja() {
        return specjalizacja;
    }

    public void setSpecjalizacja(TextField specjalizacja) {
        this.specjalizacja = specjalizacja;
    }
}
