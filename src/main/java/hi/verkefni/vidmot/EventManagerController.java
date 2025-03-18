package hi.verkefni.vidmot;

import hi.verkefni.vinnsla.EventModel;
import hi.verkefni.vinnsla.Flokkur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import javafx.scene.control.TextInputDialog;

import java.io.IOException;
import java.util.Optional;

public class EventManagerController {
    @FXML
    private Label welcomeText;
    @FXML
    private BorderPane borderPane;
    @FXML
    private StackPane fxEventViews;
    //public MediaView fxMediaView;
    public Slider fxSlVolume;
    @FXML
    private Button playPauseAction;
    @FXML
    private Button rewindAction;
    private MediaPlayer mediaPlayer;
    EventView currentView;
    private ObservableList<EventModel> list = FXCollections.observableArrayList();
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Velkomin í Event Manager");
    }

    /**
     * Test á dummy aðferð
     */
    public void setjaUpp() {
        System.out.println("Dummy aðferð EventManagerController virkar!");
    }

    /**
     * Sækir event-view.fxml
     */
    public void initialize() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("event-view.fxml"));
            opna();
            AnchorPane eventView = loader.load();
            borderPane.setCenter(eventView);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("EventView sett í BorderPane");
    }

    /**
     * Notar fxEventViews til að sýna nýjan EventView. Fékk það ekki til að virka
     */
    public void nyr() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("event-view.fxml"));
            currentView = loader.load();
            fxEventViews.getChildren().add(currentView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Á að bæta í minnið í listann úr skrefi 1 í dæmablaði 9, en ekkert hefur breyst
     */
    public void vista() {
        if (currentView != null && currentView.getEventModel() != null) {
            list.add(currentView.getEventModel());
            System.out.println("Viðburður vistaður í minnið.");
        } else {
            System.out.println("Enginn viðburður til að vista.");
        }
    }

    /**
     * Copyað frá Ebbu í 9.5
     * @param targetView
     */
    private void switchView(EventView targetView) {
        for (Node node : fxEventViews.getChildren()) {
            node.setVisible(false); // Fela alla viðburðina
        }
        targetView.setVisible(true); // Sýna targetView fremstan
        targetView.setFocusTraversable(true);
    }

    /**
     * Kalla á opna í initialize og það er það fyrsta sem opnast, en ég næ ekki að finna viðburð
     */
    public void opna() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Leita að viðburði");
        dialog.setHeaderText("Sláðu inn heiti viðburðar:");
        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()) {
            String userInput = result.get();
            EventModel matchingEvent = findEventByName(userInput);

            if (matchingEvent != null) {
            } else {
                System.out.println("Viðburður fannst ekki.");
            }
        }
    }

    /**
     * Finn event eftir nafni, sem virkaði ekki
     * @param name
     * @return
     */
    public EventModel findEventByName(String name) {
        for (EventModel event : list) {
            if (event.getName().equalsIgnoreCase(name)) {
                return event;
            }
        }
        return null;
    }
    /**
     * Ég var með takka sem virkuðu. Virkuðu sérstaklega vel þegar ég copyaði píanómyndbandið frá Ebbu. Þá get ég pásað og spilað
     * @param actionEvent
     */
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
    /**
     * Ég var með takka sem virkuðu. Virkuðu sérstaklega vel þegar ég copyaði píanómyndbandið frá Ebbu. Þá gat ég spólað til baka
     * @param actionEvent
     */
    public void rewindAction(ActionEvent actionEvent) {
        mediaPlayer.seek(Duration.ZERO);
    }
}