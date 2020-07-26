package com.adairpub.poker;

import java.util.ArrayList;
import java.util.Collections;

public class PokerGameConfiguration {
    private final int[] DEFAULT_BLIND_LEVELS = {
            20, 40, 60, 80, 100, 120, 140, 160, 180, 200,  // 100 hands
            220, 240, 260, 280, 300,                       // 150 hands
            400, 500, 600, 700, 800,                       // 200 hands
            900, 1000, 1100, 1200, 2000                    // 250 hands
    };

    private int startingChips;
    private int maxHands;
    private int blindLevelLength;
    private final ArrayList<Integer> bigBlindList;
    private final ArrayList<PokerPlayer> players;

    public int getMaxHands() {
        return maxHands;
    }

    public void setMaxHands(int maxHands) {
        this.maxHands = maxHands;
    }

    public int getBlindLevelLength() {
        return blindLevelLength;
    }

    public void setBlindLevelLength(int blindLevelLength) {
        this.blindLevelLength = blindLevelLength;
    }

    public int getPlayerNumber() {
        return players.size();
    }

    public int getStartingChips() {
        return startingChips;
    }

    public void setStartingChips(int chips) {
        startingChips = chips;
    }

    /**
     * default constructor, results in game the plays a maximum of 250 hands, and
     * blind lengths of 10 hands.
     */
    public PokerGameConfiguration() {
        bigBlindList = new ArrayList<>();
        players = new ArrayList<>();
        maxHands = 250;
        blindLevelLength = 10;
        startingChips = 1000;
        setBigBlinds(DEFAULT_BLIND_LEVELS);
    }

    /**
     * Set the list of big blinds for the game.
     */
    public void setBigBlinds(int[] blinds) {
        bigBlindList.clear();
        for (int blind : blinds) {
            bigBlindList.add(blind);
        }
    }

    /**
     * Get the big blind chip number for the hand in question
     *
     * @param handNumber - the number of hand, starting at 1
     * @return big blind amount
     */
    public int getHandBigBlind(int handNumber) {
        int blindIndex = getBlindIndex(handNumber);
        if (blindIndex == -1) return 2;
        if (blindIndex < bigBlindList.size()) {
            return bigBlindList.get(blindIndex);
        }
        return bigBlindList.get(bigBlindList.size() - 1);
    }

    public int getHandSmallBlind(int handNumber) {
        int blindIndex = getBlindIndex(handNumber);
        if (blindIndex == -1) return 1;
        if (blindIndex < bigBlindList.size()) {
            return bigBlindList.get(blindIndex) / 2;
        }
        return bigBlindList.get(bigBlindList.size() - 1) / 2;
    }

    private int getBlindIndex(int handNumber) {
        if (bigBlindList.size() == 0) return -1;
        if (blindLevelLength == 0) return -1;
        return (handNumber - 1) / blindLevelLength;
    }

    public void addPlayer(PokerPlayer p) {
        players.add(p);
    }

    public void setPlayers(PokerPlayer[] p) {
        players.clear();
        Collections.addAll(players, p);
    }
}
