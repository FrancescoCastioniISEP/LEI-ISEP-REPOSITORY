package pt.isep.tp9.listatelefonica.ui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import pt.isep.tp9.listatelefonica.controller.AplicacaoController;

import java.io.IOException;

public class MainApp extends Application {
    public static final String TITULO_APLICACAO = "Lista Telefónica";
    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/JanelaPrincipalScene.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            String css = this.getClass().getResource("/styles/Styles.css").toExternalForm();
            scene.getStylesheets().add(css);

            stage.setTitle(TITULO_APLICACAO);
            stage.setScene(scene);

            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    Alert alerta = AlertaUI.criarAlerta(Alert.AlertType.CONFIRMATION, TITULO_APLICACAO,
                            "Confirmação da ação.", "Deseja mesmo encerrar a aplicação?");

                    if (alerta.showAndWait().get() == ButtonType.CANCEL) {
                        event.consume();
                    }
                    else {
                        AplicacaoController appController = ((JanelaPrincipalUI) loader.getController()).getAplicacaoController();
                        if (!appController.isListaTelefonicaVazia() && !appController.guardar()) {
                            AlertaUI.criarAlerta(Alert.AlertType.ERROR, TITULO_APLICACAO, "Exportar Lista.",
                                    "Problema a exportar a lista de contactos!").show();
                        }
                    }
                }
            });
            stage.show();
        } catch (IOException ex) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, TITULO_APLICACAO,
                    "Problemas no arranque da aplicação.", ex.getMessage()).show();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}