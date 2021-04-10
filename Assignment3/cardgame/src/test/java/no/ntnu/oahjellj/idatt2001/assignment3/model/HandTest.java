package no.ntnu.oahjellj.idatt2001.assignment3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;



public class HandTest {
    @Test
    @DisplayName("Get cards test")
    public void testGetCards() {
        Hand hand = new Hand();
        ArrayList<PlayingCard> cards = new ArrayList<>();
        assertEquals(cards,hand.getCards());

        PlayingCard playingCard = new PlayingCard('S', 12);
        hand.add(playingCard);

        assertNotEquals(cards, hand.getCards());

        cards.add(playingCard);
        assertEquals(cards, hand.getCards());
    }

    @Test
    @DisplayName("Add card test")
    public void testAdd() {
        Hand hand = new Hand();
        PlayingCard playingCard1 = new PlayingCard('S', 12);
        assertTrue(hand.add(playingCard1));

        PlayingCard playingCard2 = new PlayingCard('S', 12);
        assertFalse(hand.add(playingCard2));
    }

    @Nested
    @DisplayName("Check hand tests")
    public class TestCheckHand {
        @Test
        @DisplayName("Sum of faces test")
        public void testSumOfFaces() {
            Hand hand = new Hand();
            assertEquals(0, hand.sumOfFaces());

            hand.add(new PlayingCard('H',13));
            hand.add(new PlayingCard('C',1));
            hand.add(new PlayingCard('H', 12));
            assertEquals(26, hand.sumOfFaces());
        }

        @Test
        @DisplayName("Get cards of hearth test")
        public void testGetCardsOfHearth() {
            Hand hand = new Hand();
            assertEquals("", hand.getCardsOfHeart());

            hand.add(new PlayingCard('H',13));
            hand.add(new PlayingCard('C',1));
            hand.add(new PlayingCard('H', 12));
            assertEquals("H13 H12", hand.getCardsOfHeart());
        }

        @Test
        @DisplayName("Is flush test")
        public void testIsFlush() {
            Hand hand = new Hand();
            assertFalse(hand.isFlush());

            hand.add(new PlayingCard('C',13));
            hand.add(new PlayingCard('C',1));
            assertTrue(hand.isFlush());

            hand.add(new PlayingCard('S', 12));
            assertFalse(hand.isFlush());
        }

        @Test
        @DisplayName("Has queen of spades test")
        public void testHasQueenOfSpades() {
            Hand hand = new Hand();
            assertFalse(hand.hasQueenOfSpades());

            hand.add(new PlayingCard('S', 12));
            assertTrue(hand.hasQueenOfSpades());
        }
    }

    @Test
    @DisplayName("Is empty test")
    public void testIsEmpty() {
        Hand hand = new Hand();
        assertTrue(hand.isEmpty());

        hand.add(new PlayingCard('S', 12));
        assertFalse(hand.isEmpty());
    }
}
