package hi.verkefni.vinnsla;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.print.attribute.standard.Media;
import java.time.LocalDate;
import java.time.LocalTime;

public class EventModel {
    private Flokkur flokkur;
    private SimpleStringProperty vidburdur = new SimpleStringProperty();
    //private SimpleObjectProperty<Flokkur> flokkur;
    private SimpleObjectProperty<LocalDate> dagsetning = new SimpleObjectProperty<>(LocalDate.now());
    private SimpleObjectProperty<LocalTime> timi = new SimpleObjectProperty<>(LocalTime.now());
    private final SimpleObjectProperty<Media> kynningarMyndband = new SimpleObjectProperty<Media>();


    public EventModel(SimpleStringProperty vidburdur) {
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
    }
}
