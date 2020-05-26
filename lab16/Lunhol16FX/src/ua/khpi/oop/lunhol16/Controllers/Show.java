package ua.khpi.oop.lunhol16.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import ua.khpi.oop.lunhol16.Animation.MyButtonSkin;
import ua.khpi.oop.lunhol16.Animation.Shake;
import ua.khpi.oop.lunhol16.App.Main;
import ua.khpi.oop.lunhol16.Head.HDR1;
import ua.khpi.oop.lunhol16.Util.Util;

import java.io.IOException;

public class Show {

    private ObservableList<HDR1> list = FXCollections.observableArrayList();

    @FXML
    private TableView<HDR1> tableViewId;

    @FXML
    private TableColumn<HDR1, Integer> idVacancy;

    @FXML
    private TableColumn<HDR1, Long> passportId;

    @FXML
    private TableColumn<HDR1, String> positionId;

    @FXML
    private TableColumn<HDR1, String> conditionsId;

    @FXML
    private TableColumn<HDR1, Integer> paymentId;

    @FXML
    private TableColumn<HDR1, String> dataId;

    @FXML
    private TableColumn<HDR1, String> departmentId;

    @FXML
    private TableColumn<HDR1, String> educationId;

    @FXML
    private ImageView refresh;

    @FXML
    private Button deleteId;

    @FXML
    private ImageView back;

    @FXML
    private TextField idField;

    @FXML
    private Button searchButton;

    private static String searchId;

    public static String getSearchId() {
        return searchId;
    }

    private void search() {
        searchId = idField.getText();
        if (searchId.equals("")){
            Shake shake = new Shake(idField);
            shake.playAnim();
        }
        Util.createNewScene("search.fxml", "Search");
    }

    @FXML
    void initialize() {
        searchButton.setSkin(new MyButtonSkin(searchButton));
        deleteId.setSkin(new MyButtonSkin(deleteId));

        initData();

        passportId.setCellValueFactory(new PropertyValueFactory<HDR1, Long>("numberPassport"));
        dataId.setCellValueFactory(new PropertyValueFactory<HDR1, String>("data"));
        conditionsId.setCellValueFactory(new PropertyValueFactory<HDR1, String>("workingConditions"));
        paymentId.setCellValueFactory(new PropertyValueFactory<HDR1, Integer>("payment"));
        departmentId.setCellValueFactory(new PropertyValueFactory<HDR1, String>("department"));
        educationId.setCellValueFactory(new PropertyValueFactory<HDR1, String>("education"));
        positionId.setCellValueFactory(new PropertyValueFactory<HDR1, String>("position"));
        idVacancy.setCellValueFactory(new PropertyValueFactory<HDR1, Integer>("id"));

        tableViewId.setItems(list);

        deleteId.setOnAction(event -> {
            Main.container.remove(tableViewId.getSelectionModel().getSelectedItem());
            try {
                Util.save();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        refresh.setOnMouseClicked(event -> {
            refresh.getScene().getWindow().hide();
            Util.createNewScene("show.fxml", "Show");
        });

        back.setOnMouseClicked(event -> {
            Util.createNewScene("home.fxml", "HDR1");
            back.getScene().getWindow().hide();
        });

        searchButton.setOnAction(event -> search());

    }

    private void initData() {
        for (int i = 0; i < Main.container.size(); i++) {
            list.add(Main.container.getElementByIndex(i));
        }
    }
}
