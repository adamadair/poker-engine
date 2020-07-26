package com.adairpub.poker;

public class PokerPlayer {

    public PokerPlayer(){
        holeCards = new CardHand();
    }

    private CardHand holeCards;
    private int chips;
    private PokerHand hand;
    private int bet;
    private String name;
    private int seat;

    public CardHand getHoleCards() {
        return holeCards;
    }

    public void addHoleCard(Card c){

    }

    public void setHoleCards(CardHand holeCards) {
        this.holeCards = holeCards;
    }

    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    public PokerHand getHand() {
        return hand;
    }

    public void setHand(PokerHand hand) {
        this.hand = hand;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }
}
