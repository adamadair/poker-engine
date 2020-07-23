package com.adairpub.poker;

public enum PokerHand {
    HighCard("High Card"),
    OnePair(" One Pair"),
    TwoPair("Two Pair"),
    ThreeOfAKind("Three of a Kind"),
    Straight("Straight"),
    Flush("Flush"),
    FullHouse("Full House"),
    FourOfAKind("Four of a Kind"),
    StraightFlush("Straight Flush"),
    RoyalFlush("Royal Flush");

    PokerHand(String n){
        handName = n;
    }
    private final String handName;

    @Override
    public String toString() {
        return this.handName;
    }
}
