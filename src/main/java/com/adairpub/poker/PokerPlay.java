package com.adairpub.poker;

public class PokerPlay {
    private PlayType type;
    private int amount;

    public PokerPlay(PlayType playType, int playAmount){
        type = playType;
        amount = playAmount;
    }

    public PlayType getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }
}
