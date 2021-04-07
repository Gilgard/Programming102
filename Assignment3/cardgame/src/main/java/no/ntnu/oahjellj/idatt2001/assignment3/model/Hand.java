package no.ntnu.oahjellj.idatt2001.assignment3.model;

import java.util.ArrayList;

/**
 *
 */
public class Hand {
    private final ArrayList<PlayingCard> cards;

    /**
     *
     */
    public Hand() {
        this.cards = new ArrayList<>();
    }

    /**
     *
     * @param cards
     */
    public Hand(ArrayList<PlayingCard> cards) {
        this.cards = cards;
    }

    /**
     *
     * @return
     */
    public ArrayList<PlayingCard> getCards() {
        return cards;
    }

    /**
     *
     * @param playingCard
     * @return
     */
    public boolean add(PlayingCard playingCard) {
        if(!cards.contains(playingCard)) {
            cards.add(playingCard);
            return true;
        }
        return false;
    }

    /**
     *
     * @return
     */
    public boolean isFlush(){
        //TODO: fix this to check for any color
        return true;
    }

    /**
     *
     * @return
     */
    public boolean hasQueenOfSpades() {
        for(PlayingCard playingCard : cards) {
            if(playingCard.getSuit() == 'S' && playingCard.getFace() == 12) return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}