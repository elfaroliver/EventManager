package hi.verkefni.vinnsla;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

import javax.print.attribute.standard.Media;
import java.time.LocalDate;
import java.time.LocalTime;

public class EventModel {
    //private Flokkur flokkur;
    private SimpleStringProperty vidburdur = new SimpleStringProperty();
    private SimpleObjectProperty<Flokkur> flokkur = new SimpleObjectProperty<>();
    private SimpleObjectProperty<LocalDate> dagsetning = new SimpleObjectProperty<>(LocalDate.now());
    private SimpleObjectProperty<LocalTime> timi = new SimpleObjectProperty<>(LocalTime.now());
    private final SimpleObjectProperty<Media> kynningarMyndband = new SimpleObjectProperty<Media>();

    public EventModel(String vidburdur, Flokkur flokkur, LocalDate dagsetning, LocalTime timi, Media kynningarMyndband) {
        this.vidburdur.set(vidburdur);
        this.flokkur.set(flokkur);
        this.dagsetning.set(dagsetning);
        this.timi.set(timi);
        this.kynningarMyndband.set(kynningarMyndband);
    }

    public SimpleStringProperty vidburdurProperty() {
        return vidburdur;
    }

    public SimpleObjectProperty<Flokkur> flokkurProperty() {
        return flokkur;
    }

    public SimpleObjectProperty<LocalDate> dagsetningProperty() {
        return dagsetning;
    }

    public SimpleObjectProperty<LocalTime> timiProperty() {
        return timi;
    }

    public SimpleObjectProperty<Media> kynningarMyndbandProperty() {
        return kynningarMyndband;
    }

    public ObservableValue<String> eventNameProperty() {
        return eventNameProperty();
    }

    public ObservableValue<Object> mediaProperty() {
        return mediaProperty();
    }


    /*public EventModel(SimpleStringProperty vidburdur) {
        this.vidburdur = vidburdur;
    }

    public String getVidburdur() {
        return vidburdur.get();
    }

    public SimpleStringProperty vidburdurProperty() {
        return vidburdur;
    }

    public void setVidburdur(String vidburdur) {
        this.vidburdur.set(vidburdur);
    }*/
}
