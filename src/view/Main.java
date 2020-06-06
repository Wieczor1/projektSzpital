package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("views/login.fxml"));
        primaryStage.setTitle("Szpital");
        primaryStage.setScene(new Scene(root, 626, 626));
        primaryStage.show();

    }

//TODO popraw postrzepione ikonki
    public static void main(String[] args) {
        launch(args);
    }
}