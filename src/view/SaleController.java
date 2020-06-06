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
import model.DAOs.GenericDAO;
import model.DAOs.OddzialyDAO;
import model.entities.OddzialyEntity;
import model.entities.SaleEntity;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class SaleController {
    public static class Wrapper{
        int nrSali;
        String typ;
        String oddzialNazwa;
        SaleEntity sala;
        OddzialyEntity oddzial;

        public Wrapper(SaleEntity sala, OddzialyEntity oddzial) {
            this.sala = sala;
            this.oddzial = oddzial;
            this.nrSali = sala.getNrSali();
            this.typ = sala.getTypSali();
            this.oddzial = oddzial;
                    this.oddzialNazwa = oddzial.getNazwa();
        }

        public int getNrSali() {
            return nrSali;
        }

        public void setNrSali(int nrSali) {
            this.nrSali = nrSali;
        }

        public String getTyp() {
            return typ;
        }

        public void setTyp(String typ) {
            this.typ = typ;
        }

        public String getOddzialNazwa() {
            return oddzialNazwa;
        }

        public void setOddzialNazwa(String oddzialNazwa) {
            this.oddzialNazwa = oddzialNazwa;
        }

        public SaleEntity getSala() {
            return sala;
        }

        public void setSala(SaleEntity sala) {
            this.sala = sala;
        }

        public OddzialyEntity getOddzial() {
            return oddzial;
        }

        public void setOddzial(OddzialyEntity oddzial) {
            this.oddzial = oddzial;
        }

        static public ObservableList<Wrapper> getSalaAndOddzial(){
            List<SaleEntity> sale = (List<SaleEntity>) GenericDAO.getAll(SaleEntity.class);
            ObservableList<Wrapper> wrapped = FXCollections.observableArrayList();
            for (SaleEntity sala: sale
            ) {
                wrapped.add(new Wrapper(sala, OddzialyDAO.getOddzialById(sala.getIdOddzialu())));
            }
            return wrapped;
//            System.out.println(lekarze);
        }
    }
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
    Wrapper selected;
    @FXML
    private HBox dodaj;

    @FXML
    private HBox usun;

    @FXML
    private HBox modyfikuj;

    @FXML
    private TableView<Wrapper> saleTable;

    @FXML
    private TableColumn<Wrapper, String> nrSali;

    @FXML
    private TableColumn<Wrapper, String> typ;

    @FXML
    private TableColumn<Wrapper, String> oddzial;

    @FXML
    void dodajPopup(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("view/views/createSalaPopup.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Dodawanie");
        stage.initModality(Modality.APPLICATION_MODAL);
        CreateSalaController controller =
                fxmlLoader.getController();
        controller.passTable(saleTable);
        stage.setScene(scene);
        stage.show();
        stage.toFront();

    }

    @FXML
    void modyfikujPopup(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("view/views/modifySalaPopup.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Modyfikacja"); // TODO ustawianie tytulow okien
        stage.initModality(Modality.APPLICATION_MODAL);
        ModifySalaController controller =
                fxmlLoader.getController();
        controller.passTable(saleTable);
        controller.passSelected(selected);
        controller.setNrSali(selected.getNrSali());
        controller.setTypSali(selected.getTyp());
        controller.setOddzial(selected.getOddzial());

        stage.setScene(scene);
        stage.show();
        stage.toFront();

    }

    @FXML
    void usunPopup(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("view/views/deleteSalaPopup.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Usuwanie");
        stage.initModality(Modality.APPLICATION_MODAL);

        DeleteSalaController controller = fxmlLoader.getController();
        controller.passSelected(selected);
        controller.passTable(saleTable);

        stage.setScene(scene);
        stage.show();
        stage.toFront();

    }

    @FXML
    void initialize(){
        nrSali.setCellValueFactory(new PropertyValueFactory<Wrapper, String>("nrSali"));
        typ.setCellValueFactory(new PropertyValueFactory<Wrapper, String>("typ"));
        oddzial.setCellValueFactory(new PropertyValueFactory<Wrapper, String>("oddzialNazwa"));
        saleTable.setItems(Wrapper.getSalaAndOddzial());
        saleTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                //Check whether item is selected and set value of selected item to Label
                selected = saleTable.getSelectionModel().getSelectedItem();
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
