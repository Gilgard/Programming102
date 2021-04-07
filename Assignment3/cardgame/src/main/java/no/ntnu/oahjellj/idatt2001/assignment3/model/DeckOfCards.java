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
     *
     */
    public DeckOfCards() {
        this.deck = new PlayingCard[52];
        for(int i = 0; i < 52; i++) {
            for(int j = 0; j < 4; j++) {
                for(int k = 1; k < 14; k++) deck[i] = new PlayingCard(SUIT[j], k);
            }
        }
    }

    /**
     *
     * @param n
     * @return
     */
    public Hand dealHand(int n) {
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
