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

import java.io.IOException;
import java.util.Objects;

public class AdresyController {

    @FXML
    private HBox dodaj;

    @FXML
    private HBox usun;

    @FXML
    private HBox modyfikuj;

    @FXML
    private TableView<AdresyEntity> adresyTable;

    @FXML
    private TableColumn<AdresyEntity, String> miasto;

    @FXML
    private TableColumn<AdresyEntity, String> kodPocztowy;

    @FXML
    private TableColumn<AdresyEntity, String> ulica;

    @FXML
    private TableColumn<AdresyEntity, Integer> nrDomu;

    @FXML
    private TableColumn<AdresyEntity, Integer> nrLokalu;

    AdresyEntity selected;
    private TableView<AdresyController> row;

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
    void dodajPopup(MouseEvent event) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getClassLoader().getResource("view/views/createAdresPopup.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Dodawanie");
            stage.initModality(Modality.APPLICATION_MODAL);
            CreateAdresController controller =
                    fxmlLoader.getController();
            controller.passTable(adresyTable);
            stage.setScene(scene);
            stage.show();
            stage.toFront();

    }

    @FXML
    void modyfikujPopup(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("view/views/modifyAdresPopup.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Modyfikacja"); // TODO ustawianie tytulow okien
        stage.initModality(Modality.APPLICATION_MODAL);
        ModifyAdresController controller =
                fxmlLoader.getController();
        controller.passTable(adresyTable);
        controller.passSelected(selected);
        controller.setKodPocztowyText(selected.getKodPocztowy());
        controller.setMiastoText(selected.getMiasto());
        controller.setUlicaText(selected.getUlica());
        controller.setNrDomuText(String.valueOf(selected.getNumerDomu()));
        controller.setNrLokaluText(String.valueOf(selected.getNumerLokalu()));
        stage.setScene(scene);
        stage.show();
        stage.toFront();

    }

    @FXML
    void usunPopup(MouseEvent event) throws IOException { //TODO w aktywnej zakladce zmien kolor np PACJENCI PRZYCIEMNIJ
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("view/views/deleteAdresPopup.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Usuwanie");
        stage.initModality(Modality.APPLICATION_MODAL);

        DeleteAdresController controller = fxmlLoader.getController();
        controller.passSelected(selected);
        controller.passTable(adresyTable);

        stage.setScene(scene);
        stage.show();
        stage.toFront();


    }


    @FXML
    void initialize() {
        miasto.setCellValueFactory(new PropertyValueFactory<AdresyEntity, String>("miasto"));
        kodPocztowy.setCellValueFactory(new PropertyValueFactory<AdresyEntity, String>("kodPocztowy"));
        ulica.setCellValueFactory(new PropertyValueFactory<AdresyEntity, String>("ulica"));
        nrDomu.setCellValueFactory(new PropertyValueFactory<AdresyEntity, Integer>("numerDomu"));
        nrLokalu.setCellValueFactory(new PropertyValueFactory<AdresyEntity, Integer>("numerLokalu"));


        adresyTable.setItems(FXCollections.observableList(GenericDAO.getAll(AdresyEntity.class)));

        adresyTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                //Check whether item is selected and set value of selected item to Label
                selected = adresyTable.getSelectionModel().getSelectedItem();
                if(selected != null)
                {
                    modyfikuj.setVisible(true);
                    usun.setVisible(true);
                }
                if(selected == null)
                {
                    modyfikuj.setVisible(false);
                    usun.setVisible(false);
                }
            }
        });//TODO zamien tak na Zapisz itd
    }

}
