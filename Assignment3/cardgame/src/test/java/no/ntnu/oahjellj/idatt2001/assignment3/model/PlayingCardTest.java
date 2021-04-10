package no.ntnu.oahjellj.idatt2001.assignment3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayingCardTest {
    @Nested
    @DisplayName("Constructor tests")
    public class ConstructorTest {
        @Test
        @DisplayName("Out of bounds suit")
        public void testSuitOutOfBounds() {
            assertThrows(IllegalArgumentException.class, () -> new PlayingCard('R',1));
        }
        @Test
        @DisplayName("Out of bounds face")
        public void testFaceOutOfBounds() {
            assertThrows(IllegalArgumentException.class, () -> new PlayingCard('H',0));
            assertThrows(IllegalArgumentException.class, () -> new PlayingCard('H',14));
        }
    }

    @Nested
    @DisplayName("Getter tests")
    public class GetterTest {
        @Test
        @DisplayName("Get suit test")
        public void testGetSuit() {
            PlayingCard playingCard = new PlayingCard('S',12);
            assertEquals('S', playingCard.getSuit());
        }
        @Test
        @DisplayName("Get face test")
        public void testGetFace() {
            PlayingCard playingCard = new PlayingCard('S',12);
            assertEquals(12, playingCard.getFace());
        }
    }

    @Test
    @DisplayName("To string format test")
    public void testToString() {
        PlayingCard playingCard = new PlayingCard('S',12);
        assertEquals("S12", playingCard.toString());
    }

    @Test
    @DisplayName("Test equals")
    public void testEquals() {
        PlayingCard playingCard1 = new PlayingCard('S',12);
        PlayingCard playingCard2 = new PlayingCard('S',12);
        assertEquals(playingCard1, playingCard2);

        PlayingCard playingCard3 = new PlayingCard('H', 12);
        assertNotEquals(playingCard1, playingCard3);

        PlayingCard playingCard4 = new PlayingCard('S', 13);
        assertNotEquals(playingCard1, playingCard4);
    }
}
