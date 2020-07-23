package com.adairpub.poker;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardSuitTest {

    /**
     * Test getting suite for card number, valid numbers are from 0..52
     */
    @Test
    public void numberToCardSuit() {
        assertEquals(CardSuit.SPADES, CardSuit.intToCardSuit(0));
        assertEquals(CardSuit.SPADES, CardSuit.intToCardSuit(12));
        assertEquals(CardSuit.HEARTS, CardSuit.intToCardSuit(13));
        assertEquals(CardSuit.HEARTS, CardSuit.intToCardSuit(25));
        assertEquals(CardSuit.CLUBS, CardSuit.intToCardSuit(26));
        assertEquals(CardSuit.CLUBS, CardSuit.intToCardSuit(38));
        assertEquals(CardSuit.DIAMONDS, CardSuit.intToCardSuit(39));
        assertEquals(CardSuit.DIAMONDS, CardSuit.intToCardSuit(51));
        assertEquals(CardSuit.SPADES, CardSuit.intToCardSuit(52)); // overflow is handled
    }

    @Test
    public void testToString() {
        assertEquals("S", CardSuit.SPADES.toString());
        assertEquals("H", CardSuit.HEARTS.toString());
        assertEquals("C", CardSuit.CLUBS.toString());
        assertEquals("D", CardSuit.DIAMONDS.toString());
    }

    @Test
    public void values() {
        int i = 0;
        for (CardSuit value : CardSuit.values()) {
            i++;
            System.out.println(value.toString());
        }
        assertEquals(4, i);
    }

    @Test
    public void stringToCardSuit() {
        assertEquals(CardSuit.SPADES, CardSuit.stringToCardSuit("S"));
        assertEquals(CardSuit.HEARTS, CardSuit.stringToCardSuit("H"));
        assertEquals(CardSuit.CLUBS, CardSuit.stringToCardSuit("C"));
        assertEquals(CardSuit.DIAMONDS, CardSuit.stringToCardSuit("D"));
    }
}