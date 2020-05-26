package ua.khpi.oop.lunhol16.App;

import javafx.application.Application;
import javafx.stage.Stage;
import ua.khpi.oop.lunhol16.Util.Util;


public class RunProgram extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Util.createNewScene("welcome.fxml", "HDR");
    }
}
