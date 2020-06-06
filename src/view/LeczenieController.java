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
import model.DAOs.*;
import model.entities.LeczenieEntity;
import model.entities.LeczenieLekiEntity;
import model.entities.LekiEntity;
import model.entities.SaleEntity;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class LeczenieController {
    private Wrapper selected;

    public static class Wrapper {
        String leki;
//        String dawkowanie;
        String uwagi;
                LekiEntity lek;
        LeczenieEntity leczenie;
        List<LeczenieLekiEntity> leczLek;
        LeczenieLekiEntity leczL;
//        Leki
//        public Wrapper(List<LeczenieLekiEntity> leczLek) {
////            this.lek = lek;
////            this.leczenie = leczenie;
//            this.leczLek = leczLek;
//            for (LeczenieLekiEntity l : leczLek
//            ) {
//                this.leki = leki + LekiDAO.getLekById(l.getIdLeku()).getNazwaLeku() + "\n";
////                this.dawkowanie = dawkowanie + l.getDawkowanieMiligramy() + "\n";
//                this.uwagi = uwagi + getUwagi() + "\n";
//
//            }

            public Wrapper(LekiEntity l, LeczenieLekiEntity ll){
                this.leki = LekiDAO.getLekById(l.getIdLeku()).getNazwaLeku();
                this.uwagi = ll.getUwagi();
            }

        public Wrapper(LeczenieLekiEntity lek, LeczenieEntity leczenie) {
            this.leczL = lek;
            this.lek = LekiDAO.getLekById(lek.getIdLeku());
            this.leczenie = leczenie;
            this.uwagi = lek.getUwagi();
            this.leki = LekiDAO.getLekById(lek.getIdLeku()).getNazwaLeku();
        }

        public static ObservableList<Wrapper> getWrapped() {
            List<LeczenieEntity> leczenie = (List<LeczenieEntity>) GenericDAO.getAll(LeczenieEntity.class);
            ObservableList<Wrapper> wrapped = FXCollections.observableArrayList();
            for (LeczenieEntity e : leczenie
            ) {
                wrapped.add(new Wrapper(LeczenieLekiDAO.getLeczenieLekiById(e.getIdLeczenia()).get(0), e));
            }
            return wrapped;

        }

        public String getLeki() {
            return leki;
        }

        public void setLeki(String leki) {
            this.leki = leki;
        }
//
//        public String getDawkowanie() {
//            return dawkowanie;
//        }
//
//        public void setDawkowanie(String dawkowanie) {
//            this.dawkowanie = dawkowanie;
//        }

        public String getUwagi() {
            return uwagi;
        }

        public void setUwagi(String uwagi) {
            this.uwagi = uwagi;
        }

        public LekiEntity getLek() {
            return lek;
        }

        public void setLek(LekiEntity lek) {
            this.lek = lek;
        }
//
        public LeczenieEntity getLeczenie() {
            return leczenie;
        }

        public LeczenieLekiEntity getLeczL() {
            return leczL;
        }

        public void setLeczL(LeczenieLekiEntity leczL) {
            this.leczL = leczL;
        }

        @Override
        public String toString() {
            return leki + " " + uwagi;

        }
        static public Wrapper getWrapped(int idLeczenia){
                return new Wrapper(LeczenieLekiDAO.getLeczenieLekiById(idLeczenia).get(0), LeczenieDAO.getLeczenieById(idLeczenia));

        }
//
//        public void setLeczenie(LeczenieEntity leczenie) {
//            this.leczenie = leczenie;
//        }
    }

    @FXML
    private HBox dodaj;

    @FXML
    private HBox usun;

    @FXML
    private HBox modyfikuj;
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
    private TableView<Wrapper> leczenieTable;

    @FXML
    private TableColumn<Wrapper, String> leki;

//    @FXML
//    private TableColumn<Wrapper, String> dawkowanie;

    @FXML
    private TableColumn<Wrapper, String> uwagi;


    @FXML
    void dodajPopup(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("view/views/createLeczeniePopup.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Dodawanie");
        stage.initModality(Modality.APPLICATION_MODAL);
        CreateLeczenieController controller =
                fxmlLoader.getController();
        controller.passTable(leczenieTable);
        stage.setScene(scene);
        stage.show();
        stage.toFront();


    }

    @FXML
    void modyfikujPopup(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("view/views/modifyLeczeniePopup.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Modyfikacja"); // TODO ustawianie tytulow okien
        stage.initModality(Modality.APPLICATION_MODAL);
        ModifyLeczenieController controller =
                fxmlLoader.getController();
        controller.passTable(leczenieTable);
        controller.passSelected(selected);
        controller.setUwagiText(selected.getUwagi());
        controller.setLekiDawkowanie(selected.getLek());
//        controller.setNazwaText(selected.getNazwaLeku());
//        controller.setKodText(selected.getKodLeku());
//        controller.setRefundacja(selected.isRefundacja());

        stage.setScene(scene);
        stage.show();
        stage.toFront();

    }
//
    @FXML
    void usunPopup(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("view/views/deleteLeczeniePopup.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Usuwanie");
        stage.initModality(Modality.APPLICATION_MODAL);

        DeleteLeczenieController controller = fxmlLoader.getController();
//        controller.passSelected(selected);
//        controller.passTable(leczenieTable);

        stage.setScene(scene);
        stage.show();
        stage.toFront();

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
        void initialize () {
            leki.setCellValueFactory(new PropertyValueFactory<Wrapper, String>("leki"));
//            dawkowanie.setCellValueFactory(new PropertyValueFactory<Wrapper, String>("dawkowanie"));
            uwagi.setCellValueFactory(new PropertyValueFactory<Wrapper, String>("uwagi"));
            leczenieTable.setItems(FXCollections.observableArrayList(Wrapper.getWrapped()));
            leczenieTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
                @Override
                public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                    //Check whether item is selected and set value of selected item to Label
                    selected = leczenieTable.getSelectionModel().getSelectedItem();
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

