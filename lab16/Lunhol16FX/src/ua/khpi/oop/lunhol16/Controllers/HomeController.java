package ua.khpi.oop.lunhol16.Controllers;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.ColorInput;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import ua.khpi.oop.lunhol16.Animation.MyButtonSkin;
import ua.khpi.oop.lunhol16.Util.Util;

public class HomeController {

    @FXML
    private MenuItem newMenuItem;

    @FXML
    private MenuItem showAllMenuItem;

    @FXML
    private MenuItem exitMenuItem;

    @FXML
    private MenuItem clearMenuItem;

    @FXML
    private MenuItem numberMunuItem;

    @FXML
    private MenuItem AboutMenuItem;

    @FXML
    private Button newVacancyButton;

    @FXML
    private ImageView homeImageIco;

    @FXML
    private Button showAllVacanciesButton;

    @FXML
    private Button clearAllButton;

    @FXML
    private Button numberOfVacanciesButton;

    private void addVacancy() {
        Util.createNewScene("addVacancy.fxml", "HDR");
    }

    @FXML
    private ImageView closeImageView;

    @FXML
    void initialize() {
        clearAllButton.setSkin(new MyButtonSkin(clearAllButton));
        newVacancyButton.setSkin(new MyButtonSkin(newVacancyButton));
        showAllVacanciesButton.setSkin(new MyButtonSkin(showAllVacanciesButton));
        numberOfVacanciesButton.setSkin(new MyButtonSkin(numberOfVacanciesButton));

        homeImageIco.setOnMouseClicked(event -> {
            homeImageIco.getScene().getWindow().hide();
            Util.createNewScene("welcome.fxml", "HDR");
        });

        AboutMenuItem.setOnAction(event -> Util.createNewScene("aboutMenu.fxml", "About project"));

        newMenuItem.setOnAction(event -> {
            newVacancyButton.getScene().getWindow().hide();
            addVacancy();
        });

        closeImageView.setOnMouseClicked(event -> closeImageView.getScene().getWindow().hide());

        newVacancyButton.setOnAction(event -> {
            newVacancyButton.getScene().getWindow().hide();
            addVacancy();
        });

        exitMenuItem.setOnAction(event -> closeImageView.getScene().getWindow().hide());

        showAllVacanciesButton.setOnAction(event -> {
            Util.createNewScene("show.fxml", "Show");
            showAllVacanciesButton.getScene().getWindow().hide();
        });

        clearAllButton.setOnAction(event -> Util.createNewScene("clear.fxml", "Clear"));

        clearMenuItem.setOnAction(event -> Util.createNewScene("clear.fxml", "Clear"));

        numberOfVacanciesButton.setOnAction(event -> Util.createNewScene("number.fxml", "Number of vacancies"));

        numberMunuItem.setOnAction(event -> Util.createNewScene("number.fxml", "Number of vacancies"));

        showAllMenuItem.setOnAction(event -> {
            Util.createNewScene("show.fxml", "Show");
            showAllVacanciesButton.getScene().getWindow().hide();
        });

    }
}
