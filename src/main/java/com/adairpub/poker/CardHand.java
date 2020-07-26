package com.adairpub.poker;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CardHand {
    private ArrayList<Card> cards = new ArrayList<>();

    public CardHand() {

    }

    public CardHand(CardHand h){
        cards.addAll(h.cards);
    }

    public CardHand(String handString){
        String []cs = handString.split(" ");
        for (String c : cs) {
            cards.add(new Card(c));
        }
    }

    public void clear(){
        cards.clear();
    }

    public void addCard(Card c){
        cards.add(c);
    }

    public void addCard(String c){
        cards.add(Card.fromString(c));
    }

    public void addAll(CardHand h){
        cards.addAll(h.cards);
    }

    public PokerHand getPokerHand(CardHand tableCards){
        CardHand hand = new CardHand(this);
        hand.cards.addAll(tableCards.cards);
        return hand.getPokerHand();
    }

    public PokerHand getPokerHand(){
        return PokerHand.Flush;
    }

    public long getHandCode(){
        long code = 0;
        for (Card card : cards) {
            code += card.getCode();
        }
        return code;
    }

    public int size(){
        return cards.size();
    }

    public boolean any(CardRank r){
        for (Card card : cards) {
            if(card.getRank()==r) return true;
        }
        return false;
    }

    public int strength(){
        return CardHandEvaluator.GetHandStrength(this);
    }

    public int strength(CardHand join){
        return CardHandEvaluator.GetHandStrength(this, join);
    }

    @Override
    public String toString() {
        return cards.stream().map(Card::toString).collect(Collectors.joining(" "));
    }
}
