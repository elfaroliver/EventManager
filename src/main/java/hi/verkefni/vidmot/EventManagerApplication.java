package hi.verkefni.vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EventManagerApplication extends Application {

    private static EventManagerController controller;

    public static void setController(EventManagerController C) {
        controller = C;
    }

    public static EventManagerController getController() {
        return controller;
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("eventmanager-view.fxml"));
        Parent root = loader.load();
        controller = loader.getController();  // Controller vistaður

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}