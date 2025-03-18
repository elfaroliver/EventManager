package hi.verkefni.vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.io.IOException;

public class EventManagerController {
    @FXML
    private Label welcomeText;
    @FXML
    private BorderPane borderPane;
    public MediaView fxMediaView;
    public Slider fxSlVolume;
    private MediaPlayer mediaPlayer;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Velkomin í Event Manager");
    }

    public void setjaUpp() {
        System.out.println("Dummy aðferð EventManagerController virkar!");
    }

    public void initialize() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("event-view.fxml"));
            AnchorPane eventView = loader.load();
            borderPane.setCenter(eventView);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //EventView eventView = new EventView(); // Býr til nýtt instance af EventView(sem er ekki að virka)
        //borderPane.setCenter(eventView);
        System.out.println("EventView sett í BorderPane");
    }


    public void playPauseAction(ActionEvent actionEvent) {
        Button playButton = (Button) actionEvent.getSource();
        System.out.println(playButton.getText());
        if (playButton.getText().equals(">")) {
            mediaPlayer.play();
            System.out.println("play " + mediaPlayer.getStatus());
            playButton.setText("||");
        } else {
            mediaPlayer.pause();
            System.out.println("pause " + mediaPlayer.getStatus());
            playButton.setText(">");
        }
    }

    public void rewindAction(ActionEvent actionEvent) {
        mediaPlayer.seek(Duration.ZERO);
    }
}