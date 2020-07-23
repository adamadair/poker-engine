package com.adairpub.poker;

import java.util.HashMap;
import java.util.Map;

public class Card {
    private final CardRank rank;
    private final CardSuit suit;
    private int deckNumber;
    private long code;
    private String abbreviation;

    public CardRank getRank() {
        return rank;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public int getDeckNumber() {
        return deckNumber;
    }

    public long getCode() {
        return code;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * instantiate Card using deck number
     * @param number - an integer from 0-51
     */
    public Card(int number) {
        this.rank = CardRank.intToCardRank(number);
        this.suit = CardSuit.intToCardSuit(number);
        initialize();
    }

    /**
     * Instantiate a card using its abbreviation. For example "2D" is two of diamons.
     * @param abbreviation - card abbreviation
     */
    public Card(String abbreviation) {
        // use character 0 for rank and character 1 for suit
        String rankAbv = abbreviation.substring(0, 1);
        String suitAbv = abbreviation.substring(1, 2);
        this.rank = CardRank.stringToCardRank(rankAbv);
        this.suit = CardSuit.stringToCardSuit(suitAbv);
        initialize();
    }

    private void initialize() {
        this.code = 1L << (16 * this.suit.ordinal() + this.rank.ordinal());
        this.deckNumber = 13 * this.suit.ordinal() + this.rank.ordinal();
        this.abbreviation = String.format("%s%s", this.rank.toString(), this.suit.toString());
    }

    private static final Map<String, Card> CARD_MAP = new HashMap<>();

    static {
        for (int i = 0; i < 52; i++) {
            Card card = new Card(i);
            CARD_MAP.put(card.toString(), card);
        }
    }

    @Override
    public String toString() {
        return this.abbreviation;
    }

    public static Card fromString(String string) {
        return CARD_MAP.get(string);
    }

}
