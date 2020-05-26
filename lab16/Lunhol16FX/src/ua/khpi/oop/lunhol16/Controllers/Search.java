package ua.khpi.oop.lunhol16.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import ua.khpi.oop.lunhol16.Animation.MyButtonSkin;
import ua.khpi.oop.lunhol16.App.Main;

public class Search {


    @FXML
    private Label id;

    @FXML
    private Label numberPassport;

    @FXML
    private Label position;

    @FXML
    private Label conditions;

    @FXML
    private Label paymnet;

    @FXML
    private Label marks;

    @FXML
    private Label date;

    @FXML
    private Label education;

    @FXML
    private Label error;

    @FXML
    private Button okButton;


    private void show() {
        if (Show.getSearchId().equals("")) {
            error.setText("No such values!");
        } else {
            for (int i = 0; i < Main.container.size(); i++) {
                if (String.valueOf(Main.container.getElementByIndex(i).getId()).equals(Show.getSearchId())) {
                    id.setText(String.valueOf(Main.container.getElementByIndex(i).getId()));
                    numberPassport.setText(String.valueOf(Main.container.getElementByIndex(i).getNumberPassport()));
                    position.setText(String.valueOf(Main.container.getElementByIndex(i).getPosition()));
                    conditions.setText(String.valueOf(Main.container.getElementByIndex(i).getWorkingConditions()));
                    paymnet.setText(String.valueOf(Main.container.getElementByIndex(i).getPayment()));
                    marks.setText(String.valueOf(Main.container.getElementByIndex(i).getMarks()));
                    date.setText(String.valueOf(Main.container.getElementByIndex(i).getData()));
                    education.setText(String.valueOf(Main.container.getElementByIndex(i).getEducation()));
                }
                break;
            }
        }
    }


    @FXML
    void initialize() {
        show();

        okButton.setSkin(new MyButtonSkin(okButton));

        okButton.setOnAction(event -> {
            okButton.getScene().getWindow().hide();
        });
    }
}
