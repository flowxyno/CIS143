package com.olympic.cis143.m08;

import java.util.List;

// Interface player to build the individual players
public interface Player {

	
	//sets name of player
    void setName(String playerName);
    
    //gets player name
    String getName();

    //set player's wallet amount
    void setWallet(int amount);

    //get players wallet amount
    int getWallet();

    //get players hand
    List<Card> getHand();
    
    //set players bet
    void setBet(int amount);
    
    //get players bet;
    int getBet();
	
}
