package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.DAOs.GenericDAO;
import model.entities.AdresyEntity;
import model.entities.LekiEntity;

import java.io.IOException;
import java.util.Objects;

public class LekiController {
    @FXML
    public void changeSceneToLekarze(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/views/lekarze.fxml")));

            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void changeSceneToAdresy(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/views/adresy.fxml")));

            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void changeSceneToDiagnozy(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/views/diagnozy.fxml")));

            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void changeSceneToLeczenie(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/views/leczenie.fxml")));

            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @FXML
    void changeSceneToLeki(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/views/leki.fxml")));

            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void changeSceneToPacjenci(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/views/pacjenci.fxml")));

            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void changeSceneToOddzialy(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/views/oddzialy.fxml")));

            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }


    @FXML
    void changeSceneToSale(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/views/sale.fxml")));

            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }
    @FXML
    void changeSceneToPacjenciLekarz(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/views/lekarzPacjenci.fxml")));

            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void changeSceneToDiagnozyLekarz(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/views/lekarzDiagnozy.fxml")));

            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void changeSceneToLeczenieLekarz(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/views/lekarzLeczenie.fxml")));

            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void changeSceneToLekiLekarz(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/views/lekarzLeki.fxml")));

            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }
    @FXML
    private HBox dodaj;

    @FXML
    private HBox usun;

    @FXML
    private HBox modyfikuj;

    @FXML
    private TableView<LekiEntity> lekiTable;

    @FXML
    private TableColumn<LekiEntity, String> nazwa;

    @FXML
    private TableColumn<LekiEntity, String> kod;

    @FXML
    private TableColumn<LekiEntity, Boolean> refundacja;


    LekiEntity selected;

    @FXML
    void dodajPopup(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("view/views/createLekPopup.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Dodawanie");
        stage.initModality(Modality.APPLICATION_MODAL);
        CreateLekController controller =
                fxmlLoader.getController();
        controller.passTable(lekiTable);
        stage.setScene(scene);
        stage.show();
        stage.toFront();

    }

    @FXML
    void modyfikujPopup(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("view/views/modifyLekPopup.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Modyfikacja"); // TODO ustawianie tytulow okien
        stage.initModality(Modality.APPLICATION_MODAL);
        ModifyLekController controller =
                fxmlLoader.getController();
        controller.passTable(lekiTable);
        controller.passSelected(selected);
        controller.setNazwaText(selected.getNazwaLeku());
        controller.setKodText(selected.getKodLeku());
        controller.setRefundacja(selected.isRefundacja());

        stage.setScene(scene);
        stage.show();
        stage.toFront();
    }

    @FXML
    void usunPopup(MouseEvent event) throws IOException { // TODO RANO - dokonczyc crudy, rejestracje i 3 uzytkownikow, reszta z kartki to raczej bonusy
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("view/views/deleteLekPopup.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Usuwanie");
        stage.initModality(Modality.APPLICATION_MODAL);

        DeleteLekController controller = fxmlLoader.getController();
        controller.passSelected(selected);
        controller.passTable(lekiTable);

        stage.setScene(scene);
        stage.show();
        stage.toFront();
    }
    @FXML
    void initialize() {
        kod.setCellValueFactory(new PropertyValueFactory<LekiEntity, String>("kodLeku"));
        refundacja.setCellValueFactory(new PropertyValueFactory<LekiEntity, Boolean>("refundacja"));
        nazwa.setCellValueFactory(new PropertyValueFactory<LekiEntity, String>("nazwaLeku"));
        lekiTable.setItems(FXCollections.observableList(GenericDAO.getAll(LekiEntity.class)));

        lekiTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                //Check whether item is selected and set value of selected item to Label
                selected = lekiTable.getSelectionModel().getSelectedItem();
                if (selected != null) {
                    modyfikuj.setVisible(true);
                    usun.setVisible(true);
                }
                if (selected == null) {
                    modyfikuj.setVisible(false);
                    usun.setVisible(false);
                }
            }
        });

    }
}
