package no.ntnu.oahjellj.idatt2001.assignment3.controller;

import java.io.IOException;

import no.ntnu.oahjellj.idatt2001.assignment3.App;
import no.ntnu.oahjellj.idatt2001.assignment3.model.DeckOfCards;
import no.ntnu.oahjellj.idatt2001.assignment3.model.Hand;

import javafx.event.ActionEvent;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

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
    private final DeckOfCards deckOfCards = new DeckOfCards();
    private CardDisplayController cardDisplayController;

    /**
     *
     * @throws IOException
     */
    @FXML
    private void initialize() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/CardDisplayView.fxml"));
        Parent parent = fxmlLoader.load();
        cardDisplayController = fxmlLoader.getController();
        borderPane.setCenter(parent);
    }

    /**
     *
     * @param actionEvent
     */
    public void onDealHand(ActionEvent actionEvent) throws IOException {
        hand = deckOfCards.dealHand(5);
        cardDisplayController.setHand(hand);
    }

    /**
     *
     * @param actionEvent
     */
    public void onCheckHand(ActionEvent actionEvent) {
        if(hand.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("No hand dealt");
            alert.setHeaderText("Cannot check hand that is not dealt.");
            alert.showAndWait();
        }

        sumOfFaces.setText(hand.sumOfFaces() + "");
        heartCards.setText(hand.getCardsOfHeart());

        if (hand.isFlush()) {
            flush.setText("Yes");
        } else {
            flush.setText("No");
        }
        if (hand.hasQueenOfSpades()) {
            spadeQueen.setText("Yes");
        } else {
            spadeQueen.setText("No");
        }
    }
}
