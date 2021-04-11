package no.ntnu.oahjellj.idatt2001.assignment3.controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import no.ntnu.oahjellj.idatt2001.assignment3.App;
import no.ntnu.oahjellj.idatt2001.assignment3.model.Hand;

import java.util.Objects;

/**
 * Controller for window showing images of cards
 */
public class CardDisplayController {
    @FXML
    private ImageView cardImageView1;
    @FXML
    private ImageView cardImageView2;
    @FXML
    private ImageView cardImageView3;
    @FXML
    private ImageView cardImageView4;
    @FXML
    private ImageView cardImageView5;

    private ImageView[] cardArray;
    private Hand hand;

    @FXML
    private void initialize() {
        cardArray = new ImageView[5];
        cardArray[0] = cardImageView1;
        cardArray[1] = cardImageView2;
        cardArray[2] = cardImageView3;
        cardArray[3] = cardImageView4;
        cardArray[4] = cardImageView5;
    }

    /**
     * Sets the given hand
     **/
    public void setHand(Hand hand) {
        this.hand = hand;
    }

    /**
     * Gets the hand
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * Updates the ImageViews to the current hand
     */
    public void setImages() {
        for(int i = 0; i < 5; i++) {
            String location = "images/" + Character.toLowerCase(hand.getCards().get(i).getSuit()) + hand.getCards().get(i).getFace() + ".png";
            Image image = new Image(Objects.requireNonNull(App.class.getResource(location)).toExternalForm());
            cardArray[i].setImage(image);
        }
    }

    /**
     * Gets cardArray
     */
    public ImageView[] getCardArray() {
        return cardArray;
    }
}
