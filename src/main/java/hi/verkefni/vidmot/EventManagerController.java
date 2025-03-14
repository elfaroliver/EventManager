package hi.verkefni.vidmot;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EventManagerController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Velkomin í Event Manager");
    }

    public void setjaUpp() {
        System.out.println("Dummy aðferð EventManagerController virkar!");
    }
}