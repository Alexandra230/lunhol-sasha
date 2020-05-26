package ua.khpi.oop.lunhol16.Controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import ua.khpi.oop.lunhol16.Animation.MyButtonSkin;
import ua.khpi.oop.lunhol16.App.Main;
import ua.khpi.oop.lunhol16.Util.Util;

public class Clear {

    @FXML
    private Button okButton;

    @FXML
    private Button noButton;

    @FXML
    void initialize() {
        okButton.setSkin(new MyButtonSkin(okButton));
        noButton.setSkin(new MyButtonSkin(noButton));

        okButton.setOnAction(event -> {
            Main.container.clear();
            try {
                Util.save();
            } catch (IOException e) {
                e.printStackTrace();
            }
            okButton.getScene().getWindow().hide();
        });

        noButton.setOnAction(event -> {
            noButton.getScene().getWindow().hide();
        });
    }
}
