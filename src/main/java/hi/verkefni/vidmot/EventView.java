package hi.verkefni.vidmot;

import hi.verkefni.vinnsla.EventModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;

public class EventView extends AnchorPane {
    private EventModel eventModel;

    @FXML
    private Text eventNameText;

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
        // Binda EventModel properties við viðmótið
        eventNameText.textProperty().bind(eventModel.vidburdurProperty());

        // Bæta við listener fyrir media property í EventModel
        eventModel.kynningarMyndbandProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                if (newValue != null) {
                    // Búa til nýjan MediaPlayer þegar nýtt media er sett
                    if (mediaPlayer != null) {
                        mediaPlayer.stop();  // Stoppa gamla MediaPlayer
                    }
                    mediaPlayer = new MediaPlayer(newValue);  // Búa til nýjan MediaPlayer
                    mediaPlayer.play();  // Spila nýja media ef það er ekki null
                }
            }
        });
    }

    public void setEventModel(EventModel eventModel) {
        this.eventModel = eventModel;
        // Binding á properties koma hingað, held ég
    }

    public EventModel getEventModel() {
        return eventModel;
    }

}
