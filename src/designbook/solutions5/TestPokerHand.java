package designbook.solutions5;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

public class TestPokerHand {

    // Helper method: Goi phuong thuc private bang Reflection
    private static boolean invokeIsStraightFlush(PokerHand hand) {
        try {
            Method method = PokerHand.class
                    .getDeclaredMethod("isStraightFlush");

            method.setAccessible(true);

            return (boolean) method.invoke(hand);

        } catch (ReflectiveOperationException e) {
            fail("Khong the goi isStraightFlush: " + e.getMessage());
            return false;
        }
    }

    // Exercise 8: Straight Flush hop le
    @Test
    void testIsStraightFlush_True() {

        PokerHand hand = new PokerHand(
                Card.get(Rank.TWO, Suit.CLUBS),
                Card.get(Rank.THREE, Suit.CLUBS),
                Card.get(Rank.FOUR, Suit.CLUBS),
                Card.get(Rank.FIVE, Suit.CLUBS),
                Card.get(Rank.SIX, Suit.CLUBS)
        );

        assertTrue(invokeIsStraightFlush(hand));
    }

    // Exercise 9: Sai chat
    @Test
    void testIsStraightFlush_WrongSuit() {

        PokerHand hand = new PokerHand(
                Card.get(Rank.TWO, Suit.CLUBS),
                Card.get(Rank.THREE, Suit.CLUBS),
                Card.get(Rank.FOUR, Suit.CLUBS),
                Card.get(Rank.FIVE, Suit.CLUBS),
                Card.get(Rank.SIX, Suit.DIAMONDS)
        );

        assertFalse(invokeIsStraightFlush(hand));
    }

    // Exercise 10: Sai thu tu lien tiep
    @Test
    void testIsStraightFlush_WrongRank() {

        PokerHand hand = new PokerHand(
                Card.get(Rank.TWO, Suit.CLUBS),
                Card.get(Rank.THREE, Suit.CLUBS),
                Card.get(Rank.FOUR, Suit.CLUBS),
                Card.get(Rank.FIVE, Suit.CLUBS),
                Card.get(Rank.SEVEN, Suit.CLUBS)
        );

        assertFalse(invokeIsStraightFlush(hand));
    }
}