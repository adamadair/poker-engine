package com.adairpub.poker;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CardTest {


    @Test
    public void getRank() {
        Card c1 = new Card(0);
        Card c2 = new Card("TD");
        assertEquals(CardRank.TWO, c1.getRank());
        assertEquals(CardRank.TEN, c2.getRank());
    }

    @Test
    public void getSuit() {
        Card c1 = new Card(0);
        Card c2 = new Card("TD");
        assertEquals(CardSuit.SPADES, c1.getSuit());
        assertEquals(CardSuit.DIAMONDS, c2.getSuit());
    }

    @Test
    public void getDeckNumber() {
        Card c1 = Card.fromString("2S");
        assertEquals(0, c1.getDeckNumber());
        Card c2 = new Card(42);

    }

    @Test
    public void getCode() {
        TestCard(Card.fromString("2S"), 1);
        TestCard(Card.fromString("3S"), 2);
        TestCard(Card.fromString("4S"), 4);
        TestCard(Card.fromString("5S"), 8);
        TestCard(Card.fromString("6S"), 16);
        TestCard(Card.fromString("7S"), 32);
        TestCard(Card.fromString("8S"), 64);
        TestCard(Card.fromString("9S"), 128);
        TestCard(Card.fromString("TS"), 256);
        TestCard(Card.fromString("JS"), 512);
        TestCard(Card.fromString("QS"), 1024);
        TestCard(Card.fromString("KS"), 2048);
        TestCard(Card.fromString("AS"), 4096);
        TestCard(Card.fromString("2H"), 65536);
        TestCard(Card.fromString("3H"), 131072L);
        TestCard(Card.fromString("4H"), 262144L);
        TestCard(Card.fromString("5H"), 524288L);
        TestCard(Card.fromString("6H"), 1048576L);
        TestCard(Card.fromString("7H"), 2097152L);
        TestCard(Card.fromString("8H"), 4194304L);
        TestCard(Card.fromString("9H"), 8388608L);
        TestCard(Card.fromString("TH"), 16777216L);
        TestCard(Card.fromString("JH"), 33554432L);
        TestCard(Card.fromString("QH"), 67108864L);
        TestCard(Card.fromString("KH"), 134217728L);
        TestCard(Card.fromString("AH"), 268435456L);
        TestCard(Card.fromString("2C"), 4294967296L);
        TestCard(Card.fromString("3C"), 8589934592L);
        TestCard(Card.fromString("4C"), 17179869184L);
        TestCard(Card.fromString("5C"), 34359738368L);
        TestCard(Card.fromString("6C"), 68719476736L);
        TestCard(Card.fromString("7C"), 137438953472L);
        TestCard(Card.fromString("8C"), 274877906944L);
        TestCard(Card.fromString("9C"), 549755813888L);
        TestCard(Card.fromString("TC"), 1099511627776L);
        TestCard(Card.fromString("JC"), 2199023255552L);
        TestCard(Card.fromString("QC"), 4398046511104L);
        TestCard(Card.fromString("KC"), 8796093022208L);
        TestCard(Card.fromString("AC"), 17592186044416L);
        TestCard(Card.fromString("2D"), 281474976710656L);
        TestCard(Card.fromString("3D"), 562949953421312L);
        TestCard(Card.fromString("4D"), 1125899906842624L);
        TestCard(Card.fromString("5D"), 2251799813685248L);
        TestCard(Card.fromString("6D"), 4503599627370496L);
        TestCard(Card.fromString("7D"), 9007199254740992L);
        TestCard(Card.fromString("8D"), 18014398509481984L);
        TestCard(Card.fromString("9D"), 36028797018963968L);
        TestCard(Card.fromString("TD"), 72057594037927936L);
        TestCard(Card.fromString("JD"), 144115188075855872L);
        TestCard(Card.fromString("QD"), 288230376151711744L);
        TestCard(Card.fromString("KD"), 576460752303423488L);
        TestCard(Card.fromString("AD"), 1152921504606846976L);
    }

    private void TestCard(Card c1, long code) {
        assertEquals(code, c1.getCode());
    }

    @Test
    public void getAbbreviation() {
        Card c1 = new Card("TD");
        assertEquals("TD", c1.getAbbreviation());
    }

    @Test
    public void fromString() {
        Card c1 = Card.fromString("AD");
        assertEquals(51, c1.getDeckNumber());
    }
}