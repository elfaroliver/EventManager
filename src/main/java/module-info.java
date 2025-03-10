module hi.verkefni.vidmot {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens hi.verkefni.vidmot to javafx.fxml;
    exports hi.verkefni.vidmot;
}