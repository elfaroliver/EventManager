package hi.verkefni.vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class Menu {

    @FXML
    private MenuItem closeItem;
    @FXML
    private MenuItem vistaItem;
    @FXML
    private MenuItem nyrItem;
    @FXML
    private MenuItem opnaItem;
    @FXML
    private MenuItem lokaItem;
    @FXML
    private MenuItem umItem;

    @FXML
    private void initialize() {
        // Meira seinna
    }

    @FXML
    private void handleOpna(ActionEvent event) {
        System.out.println("Opna valið");
        EventManagerController controller = EventManagerApplication.getController();
        controller.setjaUpp();  // Dummy aðferð testuð inní EventManagerController
    }

    @FXML
    private void handleLoka(ActionEvent event) {
        System.out.println("Loka valið");
    }

    @FXML
    private void handleUm(ActionEvent event) {
        System.out.println("Um valið");
    }
    @FXML
    private void handleVista(ActionEvent event) {
        System.out.println("Vista valið");
    }
    @FXML
    private void handleNyr(ActionEvent event) {
        System.out.println("Nýr valið");
    }
}
