package org.isep.dei.pl11.ui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/JanelaPrincipalScene.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(this.getClass().getResource("/styles/Styles.css").toExternalForm());

        stage.setTitle("Lista de Tarefas");
        stage.setScene(scene);

        stage.sizeToScene();
        stage.setResizable(false);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
