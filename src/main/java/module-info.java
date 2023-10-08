module com.example.labfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;
    requires java.prefs;

    opens com.example.labfx to javafx.fxml, java.xml.bind;
    exports com.example.labfx;
}

