package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import model.DAOs.AdresyDAO;
import model.DAOs.GenericDAO;
import model.DAOs.LekarzeDAO;
import model.entities.LekarzeEntity;
import model.entities.OddzialyEntity;
import org.hibernate.sql.Delete;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class OddzialyController {
    static public class Wrapper{
        String nazwa;
        String nrTelefonu;
        String ordynator;
        OddzialyEntity oddzialy;
        LekarzeEntity lekarz;

        public Wrapper(OddzialyEntity oddzialy, LekarzeEntity lekarz) {
            this.nazwa = oddzialy.getNazwa();
            this.nrTelefonu = oddzialy.getNrTelefonu();
            this.ordynator = lekarz.getImie() + " " + lekarz.getNazwisko();
            this.oddzialy = oddzialy;
            this.lekarz = lekarz;
        }
        static public ObservableList<Wrapper> getOddzialAndOrdynator(){
            List<OddzialyEntity> oddzialy = GenericDAO.getAll(OddzialyEntity.class);
            ObservableList<Wrapper> wrapped = FXCollections.observableArrayList();
            for (OddzialyEntity oddzial: oddzialy
            ) {
                wrapped.add(new Wrapper(oddzial, LekarzeDAO.getLekarzById(oddzial.getIdOrdynatora())));
            }
            return wrapped;
//            System.out.println(lekarze);
        }

        public String getNazwa() {
            return nazwa;
        }

        public void setNazwa(String nazwa) {
            this.nazwa = nazwa;
        }

        public String getNrTelefonu() {
            return nrTelefonu;
        }

        public void setNrTelefonu(String nrTelefonu) {
            this.nrTelefonu = nrTelefonu;
        }

        public String getOrdynator() {
            return ordynator;
        }

        public void setOrdynator(String ordynator) {
            this.ordynator = ordynator;
        }

        public OddzialyEntity getOddzialy() {
            return oddzialy;
        }

        public void setOddzialy(OddzialyEntity oddzialy) {
            this.oddzialy = oddzialy;
        }

        public LekarzeEntity getLekarz() {
            return lekarz;
        }

        public void setLekarz(LekarzeEntity lekarz) {
            this.lekarz = lekarz;
        }
    }

    @FXML
    private HBox dodaj;
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
    private HBox usun;

    @FXML
    private HBox modyfikuj;

    @FXML
    private TableView<Wrapper> oddzialyTable;

    @FXML
    private TableColumn<Wrapper, String> nazwa;

    @FXML
    private TableColumn<Wrapper, String> ordynator;

    @FXML
    private TableColumn<Wrapper, String> nrTelefonu;
    private Wrapper selected;

    @FXML
    void initialize() {
        nazwa.setCellValueFactory(new PropertyValueFactory<Wrapper, String>("nazwa"));
        ordynator.setCellValueFactory(new PropertyValueFactory<Wrapper, String>("ordynator"));
        nrTelefonu.setCellValueFactory(new PropertyValueFactory<Wrapper, String>("nrTelefonu"));
        oddzialyTable.setItems(FXCollections.observableArrayList(Wrapper.getOddzialAndOrdynator()));

        oddzialyTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                //Check whether item is selected and set value of selected item to Label
                selected = oddzialyTable.getSelectionModel().getSelectedItem();
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
        });
    }


    @FXML
    void dodajPopup(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("view/views/createOddzialPopup.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Dodawanie");
        stage.initModality(Modality.APPLICATION_MODAL);
////        DeleteLekarzController delete = new DeleteLekarzController();
//
        CreateOddzialController controller =
                fxmlLoader.getController();
        controller.passTable(oddzialyTable);

//        if(selected != null) {
//            controller.passSelected(selected);
//            controller.passTable(lekarzeTable);
//        }
        stage.setScene(scene);
        stage.show();
        stage.toFront();

    }
    @FXML
    void changeSceneToSalePielegniarka(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/views/pielegniarkaSale.fxml")));

            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void changeSceneToPacjenciPielegniarka(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/views/pielegniarkaPacjenci.fxml")));

            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }
    @FXML
    void changeSceneToOddzialyPielegniarka(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/views/pielegniarkaOddzialy.fxml")));

            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }
    @FXML
    void modyfikujPopup(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("view/views/modifyOddzialPopup.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Modyfikacja");
        stage.initModality(Modality.APPLICATION_MODAL);
//
        ModifyOddzialController controller =
                fxmlLoader.getController();
        controller.passTable(oddzialyTable);
        controller.passSelected(selected);
        controller.setNazwaText(selected.getNazwa());
        controller.setNrTelefonuText(selected.getNrTelefonu());

        stage.setScene(scene);
        stage.show();
        stage.toFront();

    }

    @FXML
    void usunPopup(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("view/views/deleteOddzialPopup.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Dodawanie");
        stage.initModality(Modality.APPLICATION_MODAL);
////        DeleteLekarzController delete = new DeleteLekarzController();
//
        DeleteOddzialController controller =
                fxmlLoader.getController();
        controller.passTable(oddzialyTable);
        controller.passSelected(selected);


//        if(selected != null) {
//            controller.passSelected(selected);
//            controller.passTable(lekarzeTable);
//        }
        stage.setScene(scene);
        stage.show();
        stage.toFront();

    }

}
