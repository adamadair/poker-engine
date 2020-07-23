package com.adairpub.poker;

import org.junit.Test;

import java.security.SecureRandom;
import java.util.HashMap;

import static org.junit.Assert.*;

public class CardDeckTest {

    @Test
    public void deckTest() {
        CardDeck deck = new CardDeck();
        assertEquals(52, deck.getDeckSize());
        HashMap<String,Card> map = new HashMap<>();
        for(int i = 0; i < 52; ++i){
            Card c = deck.next();
            assertFalse(map.containsKey(c.toString()));
            map.put(c.toString(), c);
        }
        assertEquals(0,deck.getDeckSize());
        deck.reset();
        map.clear();
        assertEquals(52, deck.getDeckSize());
        deck.shuffle();
        boolean isShuffled = false;
        for(int i = 0; i < 52; ++i){
            Card c = deck.next();
            assertFalse(map.containsKey(c.toString()));
            map.put(c.toString(), c);
            if(i!=c.getDeckNumber()){
                isShuffled=true;
            }
        }
        assertTrue(isShuffled);
    }

    @Test
    public void shuffleTest(){
        SecureRandom r = new SecureRandom();
        r.setSeed(1847283788L);
        CardDeck d1 = new CardDeck();
        d1.shuffle(r);
        CardDeck d2 = new CardDeck();
        r.setSeed(-4881838953L);
        d2.shuffle(r);
        int differences = 0;
        for(int i = 0; i < 52; ++i){
            Card c1 = d1.next();
            Card c2 = d2.next();
            if(!c1.toString().equals(c2.toString())){
                ++differences;
            }
        }
        assertTrue(differences>0);
        System.out.println("Difference count = " + differences);
    }
}