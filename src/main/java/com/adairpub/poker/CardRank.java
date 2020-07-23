package com.adairpub.poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Enumeration of Card ranks, TWO through ACE.
 * @author Adam Adair - adamadair@outlook.com
 */
public enum CardRank {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("T"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
    ACE("A");

    private static final List<CardRank> CR_LIST = new ArrayList<>();
    private final String abbreviation;

    static {
        CR_LIST.addAll(Arrays.asList(values()));
    }

    CardRank(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public static CardRank intToCardRank(int number) {
        return CR_LIST.get(number % 13);
    }

    public static CardRank stringToCardRank(String rank) {
        switch (rank.toUpperCase()) {
            case "2":
                return TWO;
            case "3":
                return THREE;
            case "4":
                return FOUR;
            case "5":
                return FIVE;
            case "6":
                return SIX;
            case "7":
                return SEVEN;
            case "8":
                return EIGHT;
            case "9":
                return NINE;
            case "T":
                return TEN;
            case "J":
                return JACK;
            case "Q":
                return QUEEN;
            case "K":
                return KING;
            case "A":
                return ACE;
        }
        return null;
    }

    @Override
    public String toString() {
        return this.abbreviation;
    }

}
