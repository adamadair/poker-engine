package com.adairpub.poker;

import com.stevebrecher.HandEval;

/**
 * Static class for evaluating poker hands.
 */
public class CardHandEvaluator {

    private CardHandEvaluator() {

    }

    public static PokerHand evaluate(CardHand hand) {
        return CardHandToPokerHand(hand);
    }

    public static PokerHand evaluate(CardHand holeCards, CardHand tableCards) {
        CardHand hand = new CardHand(tableCards);
        hand.addAll(holeCards);
        return CardHandToPokerHand(hand);
    }

    private static PokerHand CardHandToPokerHand(CardHand hand) {
        int strength = GetHandStrength(hand);
        if (strength < HandEval.PAIR)
            return PokerHand.HighCard;
        if (strength < HandEval.TWO_PAIR)
            return PokerHand.OnePair;
        if (strength < HandEval.THREE_OF_A_KIND)
            return PokerHand.TwoPair;
        if (strength < HandEval.STRAIGHT)
            return PokerHand.ThreeOfAKind;
        if (strength < HandEval.FLUSH)
            return PokerHand.Straight;
        if (strength < HandEval.FULL_HOUSE)
            return PokerHand.Flush;
        if (strength < HandEval.FOUR_OF_A_KIND)
            return PokerHand.FullHouse;
        if (strength < HandEval.STRAIGHT_FLUSH)
            return PokerHand.FourOfAKind;
        if (hand.any(CardRank.TEN) && hand.any(CardRank.JACK) && hand.any(CardRank.QUEEN) && hand.any(CardRank.KING)
                && hand.any(CardRank.ACE)) {
            return PokerHand.RoyalFlush;
        }
        return PokerHand.StraightFlush;
    }

    public static int GetHandStrength(CardHand h) {
        return GetHandStrength(h.getHandCode(), h.size());
    }

    public static int GetHandStrength(CardHand hole, CardHand table){
        return GetHandStrength(hole.getHandCode() + table.getHandCode(),
                hole.size() + table.size());
    }

    private static int GetHandStrength(long handCode, int handSize) {
        switch (handSize) {
            case 5:
                return HandEval.hand5Eval(handCode);
            case 6:
                return HandEval.hand6Eval(handCode);
            case 7:
                return HandEval.hand7Eval(handCode);
            default:
                return 0;
        }
    }
}
