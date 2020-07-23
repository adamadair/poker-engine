package com.adairpub.poker;

public enum BetRound {
    START,  // the state where no cards have been dealt
    PREFLOP,
    FLOP,
    TURN,
    RIVER;

    public boolean hasNext() {
        return this != RIVER;
    }

    public BetRound getNext() {
        switch (this) {
            case START:
                return PREFLOP;
            case PREFLOP:
                return FLOP;
            case FLOP:
                return TURN;
            case TURN:
                return RIVER;
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
