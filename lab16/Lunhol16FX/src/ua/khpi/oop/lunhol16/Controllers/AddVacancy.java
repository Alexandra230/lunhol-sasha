package ua.khpi.oop.lunhol16.Controllers;

import java.io.IOException;
import java.util.NoSuchElementException;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import ua.khpi.oop.lunhol16.Animation.Shake;
import ua.khpi.oop.lunhol16.App.Main;
import ua.khpi.oop.lunhol16.Head.HDR1;
import ua.khpi.oop.lunhol16.Util.Util;

public class AddVacancy {

    @FXML
    private Menu fileMenu;

    @FXML
    private MenuItem backMenuItem;

    @FXML
    private MenuItem exitMenuItem;

    @FXML
    private MenuItem clearMenuItem;

    @FXML
    private ImageView backImage;

    @FXML
    private TextField passportField;

    @FXML
    private TextField educationField;

    @FXML
    private TextField workoiongField;

    @FXML
    private TextField paymentField;

    @FXML
    private Button saveButton;

    @FXML
    private TextField dateField1;

    @FXML
    private TextField positionField2;

    @FXML
    private TextField marksField21;


    @FXML
    private TextField departmentField;


    private void shakesField(){
        Shake shake = new Shake(passportField);
        Shake shake1 = new Shake(educationField);
        Shake shake2 = new Shake(marksField21);
        Shake shake3 = new Shake(dateField1);
        Shake shake4 = new Shake(paymentField);
        Shake shake5 = new Shake(workoiongField);
        Shake shake6 = new Shake(positionField2);
        shake.playAnim();
        shake1.playAnim();
        shake2.playAnim();
        shake3.playAnim();
        shake4.playAnim();
        shake5.playAnim();
        shake6.playAnim();
    }

    private void errorMessage() {
        Util.createNewScene("error.fxml", "Error");
    }


    private HDR1 addVacancy() {
        HDR1 recruitment = new HDR1();
        try {
           // recruitment.setFirm(comanyField.getText());
            recruitment.setNumberPassport(Long.parseLong(passportField.getText()));
            recruitment.setWorkingConditions(workoiongField.getText());
            recruitment.setPayment(Integer.parseInt(paymentField.getText()));
            recruitment.setEducation(educationField.getText());
            recruitment.setMarks(Integer.parseInt(marksField21.getText()));
            recruitment.setDepartment(departmentField.getText());
            recruitment.setPosition(positionField2.getText());
            recruitment.setData(dateField1.getText());

        } catch (Exception e) {
            throw new NoSuchElementException();
        }
        return recruitment;
    }

    @FXML
    void initialize() {

        backImage.setOnMouseClicked(event -> {
            Util.createNewScene("home.fxml", "HDR");
            backImage.getScene().getWindow().hide();
        });

        backMenuItem.setOnAction(event -> {
            Util.createNewScene("home.fxml", "HDR");
            backImage.getScene().getWindow().hide();
        });

        exitMenuItem.setOnAction(event -> {
            backImage.getScene().getWindow().hide();
        });


        saveButton.setOnAction(event -> {
            try {
                Main.container.add(addVacancy());
            } catch (Exception e) {
                System.out.println("Repeat entered:");
                errorMessage();
                shakesField();
                Main.container.add(addVacancy());
            }
            try {
                Util.save();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Util.createNewScene("home.fxml", "HDR");
            saveButton.getScene().getWindow().hide();
        });

        clearMenuItem.setOnAction(event -> {
            passportField.setText("");
            educationField.setText("");
            paymentField.setText("");
            educationField.setText("");
            positionField2.setText("");
            dateField1.setText("");
            workoiongField.setText("");
            marksField21.setText("");
        });
    }
}
