package no.ntnu.oahjellj.idatt2001.assignment3.Model;

import java.util.ArrayList;

public class Hand {
    private ArrayList<PlayingCard> cards;

    public Hand(ArrayList<PlayingCard> cards) {
        this.cards = cards;
    }

    public boolean isFlush(){
        for(PlayingCard playingCard : cards) {
            if(playingCard.getSuit() != 'H') return false;
        }
        return true;
    }

    public boolean hasQueenOfSpades() {
        for(PlayingCard playingCard : cards) {
            if(playingCard.getSuit() == 'S' && playingCard.getFace() == 12) return true;
        }
        return false;
    }

    
}