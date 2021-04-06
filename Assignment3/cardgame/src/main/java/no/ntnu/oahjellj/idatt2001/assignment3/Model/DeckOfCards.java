package no.ntnu.oahjellj.idatt2001.assignment3.Model;

import java.util.Random;

public class DeckOfCards {
    private static final char[] SUIT = { 'S', 'H', 'D', 'C' };
    private PlayingCard[] deck;
    private static final Random RANDOM = new Random();

    public DeckOfCards() {
        this.deck = new PlayingCard[52];
        for(int i = 0; i < 52; i++) {
            for(int j = 0; j < 4; j++) {
                for(int k = 1; k < 14; k++) deck[i] = new PlayingCard(SUIT[j], k);
            }
        }
    }

    public PlayingCard dealHand(int n) {
        return deck[RANDOM.nextInt(52)];
    }
}
