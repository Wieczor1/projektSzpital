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
import model.DAOs.DiagnozyDAO;
import model.DAOs.GenericDAO;
import model.entities.DiagnozyEntity;
import model.entities.LeczenieLekiEntity;
import model.entities.LekarzeEntity;
import model.entities.PacjenciEntity;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class PacjenciController {
    static public class Wrapper{
        public String imie;
        public String nazwisko;
        public Double wzrost;
        public Double masa;
        public Date dataPrzyjecia;
        public String leczenie;
        public String diagnoza;
        public PacjenciEntity pacjent;
        public DiagnozyEntity diagnozyEntity;
        public LeczenieController.Wrapper leczenieWrapper;

        public String getImie() {
            return imie;
        }

        public void setImie(String imie) {
            this.imie = imie;
        }

        public String getNazwisko() {
            return nazwisko;
        }

        public void setNazwisko(String nazwisko) {
            this.nazwisko = nazwisko;
        }

        public Double getWzrost() {
            return wzrost;
        }

        public void setWzrost(Double wzrost) {
            this.wzrost = wzrost;
        }

        public Double getMasa() {
            return masa;
        }

        public void setMasa(Double masa) {
            this.masa = masa;
        }

        public Date getDataPrzyjecia() {
            return dataPrzyjecia;
        }

        public void setDataPrzyjecia(Date dataPrzyjecia) {
            this.dataPrzyjecia = dataPrzyjecia;
        }

        public String getLeczenie() {
            return leczenie;
        }

        public void setLeczenie(String leczenie) {
            this.leczenie = leczenie;
        }

        public String getDiagnoza() {
            return diagnoza;
        }

        public void setDiagnoza(String diagnoza) {
            this.diagnoza = diagnoza;
        }

        public PacjenciEntity getPacjent() {
            return pacjent;
        }

        public void setPacjent(PacjenciEntity pacjent) {
            this.pacjent = pacjent;
        }

        public DiagnozyEntity getDiagnozyEntity() {
            return diagnozyEntity;
        }

        public void setDiagnozyEntity(DiagnozyEntity diagnozyEntity) {
            this.diagnozyEntity = diagnozyEntity;
        }

        public LeczenieController.Wrapper getLeczenieWrapper() {
            return leczenieWrapper;
        }

        public void setLeczenieWrapper(LeczenieController.Wrapper leczenieWrapper) {
            this.leczenieWrapper = leczenieWrapper;
        }

        public Wrapper(PacjenciEntity pacjent, DiagnozyEntity diagnozyEntity, LeczenieController.Wrapper leczenieWrapper) {
            this.pacjent = pacjent;
            this.diagnozyEntity = diagnozyEntity;
            this.leczenieWrapper = leczenieWrapper;
            this.imie = pacjent.getImie();
            this.nazwisko = pacjent.getNazwisko();
            this.wzrost = pacjent.getWzrost();
            this.masa = pacjent.getMasaCiala();
            this.dataPrzyjecia = pacjent.getDataPrzyjecia();
            this.leczenie = leczenieWrapper.toString();
            this.diagnoza = diagnozyEntity.getOpis();
        }
        public static ObservableList<Wrapper> getAll() {
            List<PacjenciEntity> pacjenci = (List<PacjenciEntity>) GenericDAO.getAll(PacjenciEntity.class);
            ObservableList<Wrapper> wrapped = FXCollections.observableArrayList();
            for (PacjenciEntity pacjenciEntity: pacjenci
            ) {
                wrapped.add(new Wrapper(pacjenciEntity, DiagnozyDAO.getDiagnozaById(pacjenciEntity.getIdDiagnozy()), LeczenieController.Wrapper.getWrapped(pacjenciEntity.getIdLeczenia())));
            }
            return wrapped;
//            System.out.println(lekarze);
        }
    }

    @FXML
    private HBox dodaj;

    @FXML
    private HBox usun;

    @FXML
    private HBox modyfikuj;

    @FXML
    private TableView<Wrapper> pacjenciTable;

    @FXML
    private TableColumn<Wrapper, String> imie;

    @FXML
    private TableColumn<Wrapper, String> nazwisko;

    @FXML
    private TableColumn<Wrapper, Double> wzrost;

    @FXML
    private TableColumn<Wrapper, Double> masa;

    @FXML
    private TableColumn<Wrapper, Date> dataPrzyjecia;

    @FXML
    private TableColumn<Wrapper, String> leczenie;

    @FXML
    private TableColumn<Wrapper, String> diagnoza;

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
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("view/views/createPacjentPopup.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Dodawanie");
        stage.initModality(Modality.APPLICATION_MODAL);

        CreatePacjentController controller =
                fxmlLoader.getController();
        controller.passTable(pacjenciTable);


        stage.setScene(scene);
        stage.show();
        stage.toFront();

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
    void modyfikujPopup(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("view/views/modifyPacjentPopup.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Modyfikacja");
        stage.initModality(Modality.APPLICATION_MODAL);

        ModifyPacjentController controller = fxmlLoader.getController();
        controller.passSelected(selected);
        controller.passTable(pacjenciTable);
        controller.setImieText(selected.getImie());
        controller.setNazwiskoText(selected.getNazwisko());
        controller.setWzrostText(String.valueOf(selected.getWzrost()));
        controller.setMasaText(String.valueOf(selected.getMasa()));
        controller.setDiagnoza(selected.getDiagnozyEntity());
        controller.setLeczenie(selected.getLeczenieWrapper());
        controller.setData(selected.getPacjent().getDataPrzyjecia());


        stage.setScene(scene);
        stage.show();
        stage.toFront();

    }

    @FXML
    void usunPopup(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("view/views/deletePacjentPopup.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Modyfikacja");
        stage.initModality(Modality.APPLICATION_MODAL);

        DeletePacjentController controller =
                fxmlLoader.getController();
        controller.passSelected(selected);

        if(selected != null) {
            controller.passSelected(selected);
            controller.passTable(pacjenciTable);
        }
        stage.setScene(scene);
        stage.show();
        stage.toFront();

    }
    Wrapper selected;

    @FXML
    void initialize() {
        imie.setCellValueFactory(new PropertyValueFactory<Wrapper, String>("imie"));
        wzrost.setCellValueFactory(new PropertyValueFactory<Wrapper, Double>("wzrost"));
        masa.setCellValueFactory(new PropertyValueFactory<Wrapper, Double>("masa"));
        nazwisko.setCellValueFactory(new PropertyValueFactory<Wrapper, String>("nazwisko"));
        dataPrzyjecia.setCellValueFactory(new PropertyValueFactory<Wrapper,Date>("dataPrzyjecia"));
        diagnoza.setCellValueFactory(new PropertyValueFactory<Wrapper, String>("diagnoza"));
        leczenie.setCellValueFactory(new PropertyValueFactory<Wrapper, String>("leczenie"));
        pacjenciTable.setItems(Wrapper.getAll());
        pacjenciTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
        @Override
        public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
            //Check whether item is selected and set value of selected item to Label
            selected = pacjenciTable.getSelectionModel().getSelectedItem();
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

}
