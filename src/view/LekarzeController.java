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
import model.entities.AdresyEntity;
import model.entities.LekarzeEntity;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class LekarzeController {
    static public class Wrapper{
        public String imie;
        public String nazwisko;
        public String specjalizacja;
        public String miasto;
        public String kodPocztowy;
        public String ulica;
        public int nrDomu;
        public int nrLokalu;

        public void setImie(String imie) {
            this.imie = imie;
        }

        public void setNazwisko(String nazwisko) {
            this.nazwisko = nazwisko;
        }

        public void setSpecjalizacja(String specjalizacja) {
            this.specjalizacja = specjalizacja;
        }

        public void setMiasto(String miasto) {
            this.miasto = miasto;
        }

        public void setKodPocztowy(String kodPocztowy) {
            this.kodPocztowy = kodPocztowy;
        }

        public void setUlica(String ulica) {
            this.ulica = ulica;
        }

        public void setNrDomu(int nrDomu) {
            this.nrDomu = nrDomu;
        }

        public void setNrLokalu(int nrLokalu) {
            this.nrLokalu = nrLokalu;
        }

        public void setLekarz(LekarzeEntity lekarz) {
            this.lekarz = lekarz;
        }

        public void setAdres(AdresyEntity adres) {
            this.adres = adres;
        }

        public Wrapper(LekarzeEntity lekarz, AdresyEntity adres) {
            this.imie = lekarz.getImie();
            this.nazwisko = lekarz.getNazwisko();
            this.specjalizacja = lekarz.getSpecjalizacja();
            this.miasto = adres.getMiasto();
            this.kodPocztowy = adres.getKodPocztowy();
            this.ulica = adres.getUlica();
            this.nrDomu = adres.getNumerDomu();
            this.nrLokalu = adres.getNumerLokalu();
            this.lekarz = lekarz;
            this.adres = adres;
        }

        static public ObservableList<Wrapper> getLekarzAndAdres() throws Exception {
            List<LekarzeEntity> lekarze = (List<LekarzeEntity>) GenericDAO.getAll(LekarzeEntity.class);
            ObservableList<Wrapper> wrapped = FXCollections.observableArrayList();
            for (LekarzeEntity lekarz: lekarze
                 ) {
                wrapped.add(new Wrapper(lekarz, AdresyDAO.getAdresById(lekarz.getIdAdresu())));
            }
            return wrapped;
//            System.out.println(lekarze);
        }

        LekarzeEntity lekarz;
        AdresyEntity adres;

        public String getImie() {
            return imie;
        }

        public String getNazwisko() {
            return nazwisko;
        }

        public String getSpecjalizacja() {
            return specjalizacja;
        }

        public String getMiasto() {
            return miasto;
        }

        public String getKodPocztowy() {
            return kodPocztowy;
        }

        public String getUlica() {
            return ulica;
        }

        public int getNrDomu() {
            return nrDomu;
        }

        public int getNrLokalu() {
            return nrLokalu;
        }

        public LekarzeEntity getLekarz() {
            return lekarz;
        }

        public AdresyEntity getAdres() {
            return adres;
        }
    }
    @FXML
    private TableView<Wrapper> lekarzeTable;

    @FXML
    private TableColumn<Wrapper, String> imie;

    @FXML
    private TableColumn<Wrapper, String> nazwisko;

    @FXML
    private TableColumn<Wrapper, String> specjalizacja;

    @FXML
    private TableColumn<Wrapper, String> miasto;

    @FXML
    private TableColumn<Wrapper, String> kodPocztowy;

    @FXML
    private TableColumn<Wrapper, String> ulica;

    @FXML
    private TableColumn<Wrapper, String> nrDomu;

    @FXML
    private TableColumn<Wrapper, String> nrLokalu;
    @FXML
    private HBox dodaj;

    @FXML
    private HBox usun;

    @FXML
    private HBox modyfikuj;
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


    Wrapper selected;

    @FXML
    public void initialize() throws Exception {
        imie.setCellValueFactory(new PropertyValueFactory<Wrapper, String>("imie"));
        nazwisko.setCellValueFactory(new PropertyValueFactory<Wrapper, String>("nazwisko"));
        specjalizacja.setCellValueFactory(new PropertyValueFactory<Wrapper, String>("specjalizacja"));
        miasto.setCellValueFactory(new PropertyValueFactory<Wrapper, String>("miasto"));
        kodPocztowy.setCellValueFactory(new PropertyValueFactory<Wrapper, String>("kodPocztowy"));
        ulica.setCellValueFactory(new PropertyValueFactory<Wrapper, String>("ulica"));
        nrDomu.setCellValueFactory(new PropertyValueFactory<Wrapper, String>("nrDomu"));
        nrLokalu.setCellValueFactory(new PropertyValueFactory<Wrapper, String>("nrLokalu"));

//        imie.setCellFactory(TextFieldTableCell.forTableColumn());
//        imie.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<Wrapper, String>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<Wrapper, String> t) {
//                        ((Wrapper) t.getTableView().getItems().get(
//                                t.getTablePosition().getRow())
//                        ).setImie(t.getNewValue());
//                    }
//                }
//        );

//        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
//        lastNameCol.setOnEditCommit(
//                new EventHandler<CellEditEvent<Person, String>>() {
//                    @Override
//                    public void handle(CellEditEvent<Person, String> t) {
//                        ((Person) t.getTableView().getItems().get(
//                                t.getTablePosition().getRow())
//                        ).setLastName(t.getNewValue());
//                    }
//                }
//        );
//
//        emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
//        emailCol.setOnEditCommit(
//                new EventHandler<CellEditEvent<Person, String>>() {
//                    @Override
//                    public void handle(CellEditEvent<Person, String> t) {
//                        ((Person) t.getTableView().getItems().get(
//                                t.getTablePosition().getRow())
//                        ).setEmail(t.getNewValue());
//                    }
//                }

        lekarzeTable.setItems(Wrapper.getLekarzAndAdres());

        lekarzeTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                //Check whether item is selected and set value of selected item to Label
                selected = lekarzeTable.getSelectionModel().getSelectedItem();
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
//    @FXML
//    void start() throws IOException {
//        FXMLLoader loader = new FXMLLoader(
//                getClass().getResource("view/views/lekarze.fxml")
//        );
//        loader.setController(this);
//        Parent root = (Parent) loader.load();
//    }

    @FXML
    void usunPopup(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("view/views/deleteLekarzPopup.fxml"));

        // fxmlLoader.setController(NewWindowController);
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/views/lekarze.fxml")));
//
//        Node node = (Node) event.getSource();
//
//        Stage stage = (Stage) node.getScene().getWindow();
//
//        stage.setScene(new Scene(root));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Potwierdzenie");
        stage.initModality(Modality.APPLICATION_MODAL);
//        DeleteLekarzController delete = new DeleteLekarzController();

        DeleteLekarzController controller =
                fxmlLoader.getController();
        controller.passSelected(selected);

        if(selected != null) {
            controller.passSelected(selected);
            controller.passTable(lekarzeTable);
        }
        stage.setScene(scene);
        stage.show();
        stage.toFront();
    }

    @FXML
    void dodajPopup(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("view/views/createLekarzPopup.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Dodawanie");
        stage.initModality(Modality.APPLICATION_MODAL);
////        DeleteLekarzController delete = new DeleteLekarzController();
//
        CreateLekarzController controller =
                fxmlLoader.getController();
        controller.passTable(lekarzeTable);

//        if(selected != null) {
//            controller.passSelected(selected);
//            controller.passTable(lekarzeTable);
//        }
        stage.setScene(scene);
        stage.show();
        stage.toFront();
    }

    @FXML
    void modyfikujPopup(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("view/views/modifyLekarzPopup.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Modyfikacja");
        stage.initModality(Modality.APPLICATION_MODAL);

        ModifyLekarzController controller = fxmlLoader.getController();
        controller.passSelected(selected);
        controller.passTable(lekarzeTable);
        controller.setImieText(selected.getImie());
        controller.setNazwiskoText(selected.getNazwisko());
        controller.setSpecjalizacjaText(selected.getSpecjalizacja());


        stage.setScene(scene);
        stage.show();
        stage.toFront();

    }
    public void changeSceneToAdresy(MouseEvent event) { // TODO ustaw w kazdej scenie przelaczanir do innych
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/views/adresy.fxml")));

            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
