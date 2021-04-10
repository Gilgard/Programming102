package no.ntnu.oahjellj.idatt2001.assignment3.model;

import java.util.Random;

/**
 * A full deck of cards
 */
public class DeckOfCards {
    private static final char[] SUIT = { 'S', 'H', 'D', 'C' };
    private PlayingCard[] deck;
    private static final Random RANDOM = new Random();

    /**
     * Constructs the deck with 13 cards of each suit
     */
    public DeckOfCards() {
        this.deck = new PlayingCard[52];
        int i = 0;
            for(int j = 0; j < 4; j++) {
                for(int k = 1; k < 14; k++) {
                    deck[i] = new PlayingCard(SUIT[j], k);
                    i++;
                }
            }
    }

    public PlayingCard[] getDeck() {
        return deck.clone();
    }

    /**
     * Deals a hand of size n with no duplicates
     * @param n : Desired size of the hand : int
     * @return a hand with n cards
     */
    public Hand dealHand(int n) {
        if (n > 52) throw new IndexOutOfBoundsException("Deck does not contain enough cards");
        if (n < 0) throw new IndexOutOfBoundsException("Cannot deal a negative number of cards");

        Hand hand = new Hand();
        int i = 0;

        while (i < n){
            if(hand.add(deck[RANDOM.nextInt(52)])) {
                i++;
            }
        }

        return hand;
    }
}
