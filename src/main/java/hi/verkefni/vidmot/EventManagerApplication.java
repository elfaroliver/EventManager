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
        controller = loader.getController();  // Hér vistum við controllerinn

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /*@Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EventManagerApplication.class.getResource("eventManager-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }*/

    public static void main(String[] args) {
        launch();
    }
}