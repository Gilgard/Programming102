package no.ntnu.oahjellj.idatt2001.assignment3.model;

import javafx.scene.control.Label;

import java.util.ArrayList;

/**
 * A class representing a hand of cards, can contain any number of cards
 */
public class Hand {
    private final ArrayList<PlayingCard> cards;

    /**
     * Constructs the Hand by initializing the arraylist
     */
    public Hand() {
        this.cards = new ArrayList<>();
    }

    /**
     * Gets the cards int the hand
     * @return a list of PlayingCards
     */
    public ArrayList<PlayingCard> getCards() {
        return cards;
    }

    /**
     *  Adds the given card to the list of cards in
     *  the hand if not already added.
     * @param playingCard : PlayingCard
     * @return true if card was successfully added
     */
    public boolean add(PlayingCard playingCard) {
        if(!cards.contains(playingCard)) {
            cards.add(playingCard);
            return true;
        }
        return false;
    }

    /**
     * Sums the faces of all the cards in the hand
     * @return int
     */
    public int sumOfFaces() {
        int score = 0;
        for (PlayingCard playingCard : cards) {
            score += playingCard.getFace();
        }
        return score;
    }

    /**
     * Makes a string of all the cards with the suit heart H
     * @return list of cards : String
     */
    public String getCardsOfHeart() {
        StringBuilder heartCards = new StringBuilder();
        for (PlayingCard playingCard : cards) {
            if (playingCard.getSuit() == 'H') heartCards.append(playingCard).append(" ");
        }
        return heartCards.toString().trim();
    }

    /**
     * Checks if hand only has cards of one suit
     * @return true if hand is flush
     */
    public boolean isFlush(){
        if(isEmpty()) return false;
        char suit = cards.get(0).getSuit();
        for(PlayingCard playingCard : cards) {
            if(playingCard.getSuit() != suit) return false;
        }
        return true;
    }

    /**
     * Checks if queen of spades (S12) is in the hand
     * @return true if the hand contains S12
     */
    public boolean hasQueenOfSpades() {
        for(PlayingCard playingCard : cards) {
            if(playingCard.getSuit() == 'S' && playingCard.getFace() == 12) return true;
        }
        return false;
    }

    /**
     * Checks that the hand has any cards
     * @return true if the hand is empty
     */
    public boolean isEmpty() {
        return cards.isEmpty();
    }
}