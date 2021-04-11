package no.ntnu.oahjellj.idatt2001.assignment3.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import no.ntnu.oahjellj.idatt2001.assignment3.App;
import no.ntnu.oahjellj.idatt2001.assignment3.model.DeckOfCards;
import no.ntnu.oahjellj.idatt2001.assignment3.model.Hand;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.util.Locale;


@DisplayName("Tests for CardDisplayController")
@ExtendWith(ApplicationExtension.class)
public class CardDisplayControllerTest {
    private CardDisplayController cardDisplayController;
    private final DeckOfCards deck = new DeckOfCards();

    @Start
    public void start (Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("view/CardDisplayView.fxml"));
        stage.setScene(new Scene(loader.load(), 300, 300));
        cardDisplayController = loader.getController();
        stage.show();
        stage.toFront();
    }

    @Test
    @DisplayName("Hand set correctly test")
    public void testSetHand() {
        Hand hand = deck.dealHand(5);
        cardDisplayController.setHand(hand);
        assertEquals(hand, cardDisplayController.getHand());
    }

    @Test
    @DisplayName("Images set correctly test")
    public void testSetImages() {
        Hand hand = deck.dealHand(5);
        cardDisplayController.setHand(hand);
        cardDisplayController.setImages();
        ImageView[] cardImages = cardDisplayController.getCardArray();

        for (int i = 0; i < cardImages.length; i++) {
            String cardID = hand.getCards().get(i).toString().toLowerCase(Locale.ROOT);
            assertTrue(cardImages[i].getImage().getUrl().contains(cardID));
        }
    }
}
