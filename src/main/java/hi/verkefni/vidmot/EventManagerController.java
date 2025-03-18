package hi.verkefni.vidmot;

import hi.verkefni.vinnsla.EventModel;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import javafx.scene.control.TextInputDialog;

import java.io.IOException;

public class EventManagerController {
    @FXML
    private Label welcomeText;
    @FXML
    private BorderPane borderPane;
    @FXML
    private StackPane fxEventViews;
    //public MediaView fxMediaView;
    public Slider fxSlVolume;
    private MediaPlayer mediaPlayer;
    EventView currentView;
    private ObservableList<EventModel> list = FXCollections.observableArrayList();
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
        System.out.println("EventView sett í BorderPane");
    }

    public void nyr() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("event-view.fxml"));
            currentView = loader.load();
            fxEventViews.getChildren().add(currentView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void vista() {
        if (currentView != null && currentView.getEventModel() != null) {
            list.add(currentView.getEventModel());
            System.out.println("Viðburður vistaður í minnið.");
        } else {
            System.out.println("Enginn viðburður til að vista.");
        }
    }

    private void switchView(EventView targetView) {
        for (Node node : fxEventViews.getChildren()) {
            node.setVisible(false); // Fela alla viðburðina
        }
        targetView.setVisible(true); // Sýna targetView fremstan
        targetView.setFocusTraversable(true);
    }

    public void opna() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Opna viðburð");
        dialog.setHeaderText("Sláðu inn heiti viðburðar:");

        dialog.showAndWait().ifPresent(eventName -> {
            EventModel foundEvent = null;
            for (EventModel event : list) {
                if (event.getName().equals(eventName)) {
                    foundEvent = event;
                    break;
                }
            }

            if (foundEvent != null) {
                EventView existingEventView = findEventView(foundEvent);

                if (existingEventView != null) {
                    currentView = existingEventView;
                    System.out.println("Viðburður fundinn");
                } else {
                    EventView newEventView = new EventView();
                    newEventView.setEventModel(foundEvent);
                    currentView = newEventView;

                    fxEventViews.getChildren().add(currentView);
                    System.out.println("Nýr viðburður búinn");
                }
                fxEventViews.getChildren().forEach(child -> child.setVisible(false));
                currentView.setVisible(true);
            } else {
                System.out.println("Enginn viðburður með þessu heiti fannst");
            }
        });
    }

    private EventView findEventView(EventModel eventModel) {
        for (Node node : fxEventViews.getChildren()) {
            if (node instanceof EventView) {
                EventView eventView = (EventView) node;
                if (eventView.getEventModel().equals(eventModel)) {
                    return eventView;
                }
            }
        }
        return null;
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