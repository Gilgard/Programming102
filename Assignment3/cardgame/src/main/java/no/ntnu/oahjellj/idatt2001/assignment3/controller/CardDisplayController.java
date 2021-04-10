package no.ntnu.oahjellj.idatt2001.assignment3.controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import no.ntnu.oahjellj.idatt2001.assignment3.App;
import no.ntnu.oahjellj.idatt2001.assignment3.model.Hand;

import java.io.File;
import java.util.Objects;

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

    public void setHand(Hand hand) {
        this.hand = hand;
        setImages();
    }

    private void setImages() {
        for(int i = 0; i < 5; i++) {
            String location = "images/" + Character.toLowerCase(hand.getCards().get(i).getSuit()) + hand.getCards().get(i).getFace() + ".png";
            Image image = new Image(Objects.requireNonNull(App.class.getResource(location)).toExternalForm());
            cardArray[i].setImage(image);
        }
    }
}
