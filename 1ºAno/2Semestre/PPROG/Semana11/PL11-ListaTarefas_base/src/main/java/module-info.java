module org.isep.dei.pl11 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.isep.dei.pl11.ui to javafx.fxml;
    opens org.isep.dei.pl11.controller to javafx.fxml;
    exports org.isep.dei.pl11.ui;
}