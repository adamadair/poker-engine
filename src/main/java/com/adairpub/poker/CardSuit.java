package com.adairpub.poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Enumeration of Card suits: SPADES, HEARTS, CLUBS, DIAMONDS
 * @author Adam Adair - adamadair@outlook.com
 */
public enum CardSuit {
    SPADES("S"),
    HEARTS("H"),
    CLUBS("C"),
    DIAMONDS("D");

    private static final List<CardSuit> SUIT_LIST = new ArrayList<>();

    private final String abbreviation;

    static {
        SUIT_LIST.addAll(Arrays.asList(values()));
    }

    CardSuit(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public static CardSuit intToCardSuit(int number) {
        return SUIT_LIST.get((number / 13) % 4);
    }

    public static CardSuit stringToCardSuit(String suit){
        switch (suit.toUpperCase()) {
            case "S": return SPADES;
            case "H": return HEARTS;
            case "C": return CLUBS;
            case "D": return DIAMONDS;
        }
        return null;
    }

    @Override
    public String toString() {
        return this.abbreviation;
    }
}
