package no.ntnu.oahjellj.idatt2001.assignment3.Controller;

import java.io.IOException;

import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import no.ntnu.oahjellj.idatt2001.assignment3.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class MainController {
    @FXML
    private BorderPane borderPane;

    @FXML
    private void initialize() throws IOException {
        Parent root = FXMLLoader.load(App.class.getResource("view/TodoListView.fxml"));
        borderPane.setCenter(root);
    }
}
