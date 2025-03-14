module org.dei.pl10A {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;


    opens org.dei.pl10A to javafx.fxml;
    exports org.dei.pl10A;
}