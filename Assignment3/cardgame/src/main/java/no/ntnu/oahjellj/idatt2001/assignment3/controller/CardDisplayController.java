package no.ntnu.oahjellj.idatt2001.assignment3.controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.HBox;
import no.ntnu.oahjellj.idatt2001.assignment3.model.Hand;

import java.io.File;
import java.io.IOException;

public class CardDisplayController {
    @FXML
    private HBox hBox;
    @FXML
    private ImageView cardImage1;
    @FXML
    private ImageView cardImage2;
    @FXML
    private ImageView cardImage3;
    @FXML
    private ImageView cardImage4;
    @FXML
    private ImageView cardImage5;

    private ImageView[] cardArray;
    private Hand hand;

    @FXML
    private void initialize() {
        cardArray = new ImageView[5];
        cardArray[0] = cardImage1;
        cardArray[1] = cardImage2;
        cardArray[2] = cardImage3;
        cardArray[3] = cardImage4;
        cardArray[4] = cardImage5;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
        setImages();
    }

    private void setImages() {
        for(int i = 0; i < 5; i++) {
            String location = "images/"+ Character.toLowerCase(hand.getCards().get(i).getSuit()) + hand.getCards().get(i).getFace() + ".png";
            cardArray[i].setImage(new Image(new File(location).toURI().toString()));
        }
    }
}
