package ua.khpi.oop.lunhol16.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import ua.khpi.oop.lunhol16.Animation.MyButtonSkin;
import ua.khpi.oop.lunhol16.App.Main;

public class Number {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button okButton;

    @FXML
    private Label numberLabel;

    @FXML
    void initialize() {
        okButton.setSkin(new MyButtonSkin(okButton));

        okButton.setOnAction(event -> {
            okButton.getScene().getWindow().hide();
        });

        numberLabel.setText(String.valueOf(Main.container.size()));

    }
}
