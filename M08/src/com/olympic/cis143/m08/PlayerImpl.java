package com.olympic.cis143.m08;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

//Implementation of the Player interface
public class PlayerImpl implements Player {
	
	private String name;
	private int wallet;
	private int bet;
	private List<Card> playersHand = new ArrayList<>();
	private int handcount;
	int total = 0;
	int aces = 0;
	
	

	PlayerImpl(String name){
		createPlayer(name);
	}
	
	@Override
	//sets name of player
    public void setName(String playerName) {
		this.name = playerName;
	}
    
	@Override
    //gets player name
    public String getName() {
		return this.name;
	}

	@Override
    //set player's wallet amount
    public void setWallet(int amount) {
		this.wallet = amount;
	}

	@Override
    //get players wallet amount
    public int getWallet() {
		return this.wallet;
	}

	@Override
    //set players hand getPlayerHand
    public List<Card> getHand() {
		return this.playersHand;
	}
	
	@Override
	//get players bet
    public int getBet() {
		return this.bet;
	}
    
	@Override
    //set players bet;
    public void setBet(int amount) {
		this.bet = amount;
	}

	//creates player. sets default wallet to $500 and initializes variables
	public void createPlayer(String name) {
		
		this.name = name;
		this.wallet = 500; 
		this.bet = 0;
		this.handcount = 0;
		
	}
	
    public void drawCard(DeckImpl deck) {
    	this.playersHand.add(deck.dealCard());    	
	}
    
    public int getTotal() {
    	
    	//set initial variable used for getting hand total
    	int total = 0;
    	int aces = 0;
    	
    	
    	//Here we will calc total based off ace's being 11
    	ListIterator<Card> handIterator = playersHand.listIterator();
    	while (handIterator.hasNext()) {
    		Card card = handIterator.next();
    		if (card.getValue() == 11) {
    			aces++;
    			
    		}
    		total += card.getValue();
    		
    		//Now we will go through the hand and if the value is over 21, we will start reducing ace values to 1 to see if we can get closer. We due this by subtracting 10
    		for (int j = 0; j< aces; j++) {
    			if (total > 21) {
    				total -= 10;
    			}	
    		}    		
    	}    		
    	return total;    	
    }
    
    public boolean checkBlackjack() {
    	return (this.getTotal() == 21);
    }
    
    public void clearCards() {
    	this.playersHand.clear();
    }
    
    public void addMoney(int amount) {
    	this.setWallet(this.getWallet() + amount);
    }
    
    public void removeMoney(int amount) {
    	this.setWallet(this.getWallet() - amount);
    }
	
}