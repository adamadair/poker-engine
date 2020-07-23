package com.adairpub.poker;

import java.util.ArrayList;

public class PokerGame {
    public static final int MAX_PLAYERS = 10;
    private ArrayList<PokerPlayer> players;       // The list of players at the table
    private int[] bigBlinds;                    // the list of possible big blinds
    private int handNumber;                     // the current hand number
    private int blindLength;                    // how many hands to play at each blind level
    private int blindLevel;                     // current blind level
    private int buttonIndex;                    // where is the button
    private boolean isHeadToHead;               // true if there is only 2 players left in the game
    private boolean isGameOver;                 // true if one player has All the chips, or max hands has been reached
    private boolean isHandComplete;
    private int currentPlayer;

    public PokerGame() {
        players = new ArrayList<>();
        buttonIndex = 0;
        currentPlayer = 0;
    }

    public void addPlayer(PokerPlayer player) throws PokerException {
        if (players.size() == MAX_PLAYERS) {
            throw new PokerException("The maximum number of players allowed at the table is 10.");
        }
        players.add(player);
    }

    public PokerPlayer GetCurrentPlayer(){
        return players.get(currentPlayer);
    }

}
