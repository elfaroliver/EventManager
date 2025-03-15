package hi.verkefni.vidmot;

import hi.verkefni.vinnsla.EventModel;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.IOException;

public class EventView extends AnchorPane {
    @FXML
    private MediaView mediaView;
    @FXML
    private Label eventNameLabel;
    private EventModel eventModel;
    private MediaPlayer mediaPlayer;

    public EventView() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("event-view.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException("Gat ekki hlaðið event-view.fxml", e);
        }
    }

    public void initialize() {
        // Athugar hvort eventModel er ekki null og setur upp bindingar
        if (eventModel != null) {
            eventNameLabel.textProperty().bind(eventModel.eventNameProperty());

            // Listener fyrir mediaProperty
            eventModel.mediaProperty().addListener((obs, oldMedia, newMedia) -> {
                if (newMedia != null) {
                    updateMediaPlayer(newMedia);
                }
            });
        }
    }

    private void updateMediaPlayer(Object newMedia) {

    }

    public void setEventModel(EventModel eventModel) {
        this.eventModel = eventModel;
        // Binding á properties koma hingað, held ég
        // Binding við property breyturnar
        eventNameLabel.textProperty().bind(eventModel.eventNameProperty());

        // Listener á media property
        eventModel.mediaProperty().addListener((obs, oldMedia, newMedia) -> {
            if (newMedia != null) {
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                }
                mediaPlayer = new MediaPlayer((Media) newMedia);
                mediaView.setMediaPlayer(mediaPlayer);
                mediaPlayer.play();
            }
        });
    }

    public EventModel getEventModel() {
        return eventModel;
    }

}
