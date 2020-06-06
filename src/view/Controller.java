package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DAOs.UzytkownicyDAO;
import model.entities.UzytkownicyEntity;

import java.io.IOException;
import java.util.Objects;

public class Controller {

    @FXML
    private Button LoginButton;

    @FXML
    private PasswordField password;

    @FXML
    private TextField userName;

    @FXML
    void checkUzytkownik(ActionEvent event) throws IOException {
//        password.getText();
        if (password == null || password.getText().trim().equals("") || userName.getText().trim().equals("") || userName == null) {
            System.out.println("tu!");
            return;

        } else {
//            System.out.println("DUPA");
            UzytkownicyEntity uzytkownik = UzytkownicyDAO.getUzytkownikByUsernameAndPassword(userName.getText(), password.getText());
            if (uzytkownik != null) {
                if (uzytkownik.getUprawnienia().equals("ADMIN")) changeSceneToMain(event);
                if (uzytkownik.getUprawnienia().equals("LEKARZ")) changeSceneToMainLekarz(event);
                if (uzytkownik.getUprawnienia().equals("PIELEGNIARKA")) changeSceneToMainPielegniarka(event);

            }


        }
    }

    @FXML
    void changeSceneToMain(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/views/main.fxml")));

            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    @FXML
    void changeSceneToMainLekarz(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/views/lekarzMain.fxml")));

            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    @FXML
    void changeSceneToMainPielegniarka(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/views/pielegniarkaMain.fxml")));

            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
