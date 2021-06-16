package com.olympic.cis143.m08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeckTest {

    
    public static void main(String[] args) throws Exception {
        DeckTest deckTest = new DeckTest();
        deckTest.testDeckInitialization();
        deckTest.testPlayerInitialization();
        deckTest.testSinglePlayerDeal();
        deckTest.testMultiPlayerDeal();
        deckTest.testBetting();
        deckTest.testGame();
    }
    
    //This section of testing is used to test Initialization of classes (deck and player)
    
    public void testDeckInitialization() {
    	
    	//create deck, capture unshuffled version, shuffle original deck and compare;
    	DeckImpl deck = new DeckImpl();
    	if(deck.getDeck().size() != 52) {
    		throw new RuntimeException("Deck does not have 52 cards");
    	}
    	List<Card> unshuffledDeck = deck.getDeck();
    	deck.shuffle();
    	
    	if(unshuffledDeck.equals(deck)) {
    		throw new RuntimeException("Deck Shuffle Failed");
    	}
    	System.out.println("Deck Initialization Passed");    	
    }
    
    public void testPlayerInitialization() {
    	
    	//test implementation of a player not including any cards yet
    	PlayerImpl PlayerOne = new PlayerImpl("Josh") ;
    	if (PlayerOne.getWallet() != 500) {
    		throw new RuntimeException("Wallet was not initialized to correct value");
    	}
    	if (PlayerOne.getName() != "Josh") {
    		throw new RuntimeException("User's Name did not get assigned properly");    		
    	}
    	if (PlayerOne.getBet() != 0){
    		throw new RuntimeException("User's Bet was not initialized to zero");    		
    	}
    	System.out.println("Player Initialization Passed");
    }
    
    
    // This section will start testing single player functionality
    
    public void testSinglePlayerDeal() {
    	DeckImpl deck = new DeckImpl();
    	deck.shuffle();
    	
    	/*  Dealer user base Player class but does not use bet/wallet as it's assumed
    	 * wallet is backed by Casino and is unlimited and dealer doesn't bet
    	*/
    	
    	PlayerImpl dealer = new PlayerImpl("Dealer");
        PlayerImpl josh = new PlayerImpl("Josh");
        
        
        //deal cards
        josh.drawCard(deck);
        dealer.drawCard(deck);
        josh.drawCard(deck);
        dealer.drawCard(deck);
        
        if (josh.getHand().size() != 2) {
        	throw new RuntimeException("Hand size for player Josh is not correct");
        }
        if (dealer.getHand().size() != 2) {
        	throw new RuntimeException("Hand size for player Dealer is not correct");
        }
        System.out.println("Single Player Hand Deal Passed");    	
    }
    
    public void testMultiPlayerDeal() {
    	DeckImpl deck = new DeckImpl();
    	deck.shuffle();
    	
    	/*  Dealer user base Player class but does not use bet/wallet as it's assumed
    	 * wallet is backed by Casino and is unlimited and dealer doesn't bet
    	*/
    	
    	PlayerImpl dealer = new PlayerImpl("Dealer");
        PlayerImpl josh = new PlayerImpl("Josh");
        PlayerImpl tracy = new PlayerImpl("Tracy");
        
        
        //deal cards
        josh.drawCard(deck);
        tracy.drawCard(deck);
        dealer.drawCard(deck);
        josh.drawCard(deck);
        tracy.drawCard(deck);
        dealer.drawCard(deck);
        
        if (josh.getHand().size() != 2) {
        	throw new RuntimeException("Hand size for player Josh is not correct");
        }
        if (tracy.getHand().size() != 2) {
        	throw new RuntimeException("Hand size for player Tracy is not correct");
        }
        if (dealer.getHand().size() != 2) {
        	throw new RuntimeException("Hand size for player Dealer is not correct");
        }
        System.out.println("Multi Player Hand Deal Passed");    	
    }
    
    
    /*
     * This tests betting works
     * 
     */
    public void testBetting() {
    	DeckImpl deck = new DeckImpl();
    	deck.shuffle();
    	
    	/*  Dealer user base Player class but does not use bet/wallet as it's assumed
    	 * wallet is backed by Casino and is unlimited and dealer doesn't bet
    	*/
    	
    	PlayerImpl dealer = new PlayerImpl("Dealer");
        PlayerImpl josh = new PlayerImpl("Josh");
        PlayerImpl tracy = new PlayerImpl("Tracy");
        
        //bet occurs here
        josh.setBet(20);
        tracy.setBet(30);
        
        //deal cards
        josh.drawCard(deck);
        tracy.drawCard(deck);
        dealer.drawCard(deck);
        josh.drawCard(deck);
        tracy.drawCard(deck);
        dealer.drawCard(deck);
        
        if (josh.getBet() != 20) {
        	throw new RuntimeException("Josh's Bet did not get recorded properly");
        }
        if (tracy.getBet() != 30) {
        	throw new RuntimeException("Tracy's Bet did not get recorded properly");
        }
        System.out.println("Test Betting Passed");
    }
    
    /*
     * This test will test the full round from initialization to checking the winning process:
     * This will be a interactive round, utilizing button press for player phase
     * 
     */
    public void testGame() {
        List<PlayerImpl> players = new ArrayList<>();
        PlayerImpl dealer = new PlayerImpl("Dealer");
        PlayerImpl tracy = new PlayerImpl("Tracy");

        int playContinues = 1;
        Scanner input = new Scanner(System.in);
        
        players.add(tracy);
        players.add(dealer);
        
        
        while (playContinues == 1) {
	        BlackJack playGame = new BlackJack();
	    
	        
	        playGame.playRound(players);
	        System.out.println("Play again = 1, End = 0");
	        playContinues = input.nextInt();
        }
    input.close(); // closure of the input scanner
    }
}    
