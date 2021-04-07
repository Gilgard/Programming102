package no.ntnu.oahjellj.idatt2001.assignment3.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import no.ntnu.oahjellj.idatt2001.assignment3.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import no.ntnu.oahjellj.idatt2001.assignment3.model.DeckOfCards;
import no.ntnu.oahjellj.idatt2001.assignment3.model.Hand;

/**
 *
 */
public class MainController {
    @FXML
    private BorderPane borderPane;

    @FXML
    private Label sumOfFaces;

    @FXML
    private Label heartCards;

    @FXML
    private Label flush;

    @FXML
    private Label spadeQueen;

    private Hand hand = new Hand();
    private DeckOfCards deckOfCards = new DeckOfCards();

    /**
     *
     * @throws IOException
     */
    @FXML
    private void initialize() throws IOException {
        Parent root = FXMLLoader.load(App.class.getResource("view/CardDisplayView.fxml"));
        borderPane.setCenter(root);
    }

    /**
     *
     * @param actionEvent
     */
    public void onDealHand(ActionEvent actionEvent) {
        hand = deckOfCards.dealHand(5);
    }

    /**
     *
     * @param actionEvent
     */
    public void onCheckHand(ActionEvent actionEvent) {
        if(hand.isEmpty()) {
            //TODO: open dialog "no cards dealt yet"
        }
    }

}
