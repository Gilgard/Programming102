package no.ntnu.oahjellj.idatt2001.assignment3.controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;

import no.ntnu.oahjellj.idatt2001.assignment3.model.Hand;
import no.ntnu.oahjellj.idatt2001.assignment3.model.PlayingCard;

import java.io.IOException;

public class CardDisplayController {
    @FXML
    private Image cardImage1 = new Image("images/defaultWhite.jpg");

    @FXML
    private Image cardImage2 = new Image("images/defaultWhite.jpg");

    @FXML
    private Image cardImage3 = new Image("images/defaultWhite.jpg");

    @FXML
    private Image cardImage4 = new Image("images/defaultWhite.jpg");

    @FXML
    private Image cardImage5 = new Image("images/defaultWhite.jpg");

    private Image[] cardList = {cardImage1, cardImage2, cardImage3, cardImage4, cardImage5};
    private Hand hand;

    @FXML
    private void initialize() throws IOException {
    }

    public void setHand(Hand hand) {
        this.hand = hand;
        setImages();
    }

    private void setImages() {
        for(PlayingCard playingCard : hand.getCards()) {
            //todo: get images from folder
        }
    }
}
