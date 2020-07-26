package com.adairpub.poker;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardHandEvaluatorTest {
    private static final String HIGH_CARD_HAND = "2H 4D 7C 9S TH";
    private static final String ONE_PAIR_HAND = "2H 2D 7C 9S TH";
    private static final String TWO_PAIR_HAND = "2H 2D 7C 7S TH";
    private static final String THREE_OF_KIND_HAND = "2H 2D 2C 9S TH";
    private static final String FOUR_OF_KIND_HAND = "2H 2D 2C 2S TH";
    private static final String STRAIGHT_HAND = "3H 4D 5H 6C 7S";
    private static final String ACE_LOW_STRAIGHT_HAND = "AH 2D 3H 4C 5S";
    private static final String FLUSH_HAND = "2C 4C 6C JC KC";
    private static final String FULL_HOUSE_HAND = "4C 4H QS QD QC";
    private static final String STRAIGHT_FLUSH_HAND = "3S 4S 5S 6S 7S";
    private static final String ROYAL_FLUSH_HAND = "TS JS QS KS AS";

    @Test
    public void handEvaluatorTest()
    {
        testHand(HIGH_CARD_HAND, PokerHand.HighCard);
        testHand(ONE_PAIR_HAND, PokerHand.OnePair);
        testHand(TWO_PAIR_HAND, PokerHand.TwoPair);
        testHand(THREE_OF_KIND_HAND, PokerHand.ThreeOfAKind);
        testHand(FOUR_OF_KIND_HAND, PokerHand.FourOfAKind);
        testHand(STRAIGHT_HAND, PokerHand.Straight);
        testHand(ACE_LOW_STRAIGHT_HAND, PokerHand.Straight);
        testHand(FLUSH_HAND, PokerHand.Flush);
        testHand(FULL_HOUSE_HAND, PokerHand.FullHouse);
        testHand(STRAIGHT_FLUSH_HAND, PokerHand.StraightFlush);
        testHand(ROYAL_FLUSH_HAND, PokerHand.RoyalFlush);
    }

    private void testHand(String hand, PokerHand expectedHand)
    {
        CardHand h = new CardHand(hand);
        assertEquals(CardHandEvaluator.evaluate(h), expectedHand);
    }
}