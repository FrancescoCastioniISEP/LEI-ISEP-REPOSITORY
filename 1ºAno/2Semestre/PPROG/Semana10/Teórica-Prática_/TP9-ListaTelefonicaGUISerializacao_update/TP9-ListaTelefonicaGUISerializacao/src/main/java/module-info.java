module pt.isep.tp9.listatelefonica.listatelefonica {
    requires javafx.controls;
    requires javafx.fxml;


    opens pt.isep.tp9.listatelefonica.ui to javafx.fxml;
    exports pt.isep.tp9.listatelefonica.ui;
}