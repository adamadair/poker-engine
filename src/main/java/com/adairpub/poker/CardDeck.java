package com.adairpub.poker;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a 52 card French deck of playing cards.
 * Once instantiated the cards in the deck are in suite order Spades, Hearts, Clubs, and then Diamonds.
 * Each Suit is in order 2 through Ace.
 * <p>
 * Use one of the shuffle method to shuffle the cards in the Deck.
 */
public class CardDeck {
    private final ArrayList<Card> deck;

    public CardDeck() {
        deck = new ArrayList<>();
        reset();
    }

    public void reset() {
        deck.clear();
        for (int i = 0; i < 52; i++) {
            this.deck.add(new Card(i));
        }
    }

    public int getDeckSize(){
        return deck.size();
    }

    public Card next() {
        if (deck.size() == 0) {
            return null;
        }
        return deck.remove(0);
    }

    public void shuffle() {
        shuffle(new SecureRandom());
    }

    public void shuffle(SecureRandom random) {
        Collections.shuffle(deck, random);
    }
}
