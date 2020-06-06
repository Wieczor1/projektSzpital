package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DAOs.LekiDAO;
import model.DAOs.OddzialyDAO;
import model.entities.LekiEntity;
import model.entities.OddzialyEntity;

import java.awt.*;

public class CreateLekController {

    @FXML
    private Button tak;

    @FXML
    private Button anuluj;

    @FXML
    private TextField kod;

    @FXML
    private TextField opis;

    @FXML
    private CheckBox refundacja;

    @FXML
    private Label error;
    private LekiEntity selected;
    private TableView<LekiEntity> row;


    @FXML
    void close(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

    }

    public void passSelected(LekiEntity selected) {
        this.selected = selected;

    }

    public void passTable(TableView<LekiEntity> row) {
        this.row = row;

    }
    @FXML
    void confirm(ActionEvent event) {
        if (kod.getText().trim().equals("") || kod == null
                || opis.getText().trim().equals("")  || opis == null) // TODO comboboxy not null

        {
            System.out.println("tu1");
            error.setVisible(true);
            return;
        }

        LekiEntity lek;
        try{
            lek = LekiDAO.createLeki(kod.getText(), opis.getText(), refundacja.isSelected());
        }
        catch(Exception e){
            System.out.println("tu2");
            error.setVisible(true);
            return;
        }
        row.getItems().add(lek);
        close(event);

    }


}
