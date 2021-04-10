package no.ntnu.oahjellj.idatt2001.assignment3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

public class DeckOfCardTest {
    @Test
    @DisplayName("Constructed deck contains no duplicate cards")
    public void testDeckOfCards() {
        DeckOfCards deck = new DeckOfCards();
        assertEquals(52,deck.getDeck().length);

        HashSet<PlayingCard> noDupesHere = new HashSet<>();
        for (PlayingCard playingCard : deck.getDeck()) {
            assertTrue(noDupesHere.add(playingCard));
        }
    }

    @Nested
    @DisplayName("Deal hand tests")
    public class DealHandTest {

        private final DeckOfCards deck = new DeckOfCards();

        @Test
        @DisplayName("Dealt hand invalid size test")
        public void testInvalidSize() {
            assertThrows(IndexOutOfBoundsException.class, () -> deck.dealHand(-1));
            assertThrows(IndexOutOfBoundsException.class, () -> deck.dealHand(53));
        }

        @Test
        @DisplayName("Dealt hand is correct size test")
        public void testHandIsDealtCorrectly() {
            Hand hand = deck.dealHand(5);

            assertEquals(5, hand.getCards().size());
        }
    }
}
