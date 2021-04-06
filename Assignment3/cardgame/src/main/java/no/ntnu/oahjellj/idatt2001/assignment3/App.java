package no.ntnu.oahjellj.idatt2001.assignment3;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

/**
 * JavaFX App
 */
public class App extends Application {
    private static final String TITLE = "CARD GAME";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/MainView.fxml"));

        primaryStage.setTitle(TITLE);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}