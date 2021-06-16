package com.olympic.cis143.m08;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BlackJack{
	
	public int playRound(List<PlayerImpl> players) {
		
		int playerBet = 0;
		
		Scanner input = new Scanner(System.in);
		for(int i = 0; i < players.size() -1; i++) {
			System.out.println("Afternoon " + players.get(i).getName());
			System.out.println("Your wallet has " + players.get(i).getWallet() +" dollars left");
	        System.out.println("Please input how much you want to bet: ");
	        
	        playerBet = input.nextInt();
	        
	        //while loop for input validation
	        while (playerBet == 0 || playerBet > players.get(i).getWallet()) {
	        	System.out.println("That was an incorrect amount");
	    		System.out.println("Your wallet has" + players.get(i).getWallet() +" dollars left");
	            System.out.println("Please inpute how much you want to bet: ");
	            playerBet = input.nextInt();
	        }
	        players.get(i).setBet(playerBet);
	        System.out.println("You have bet" + players.get(i).getBet());
		}
        
        //Initialize Deck
        DeckImpl deck = new DeckImpl();
        deck.shuffle();
        
        //deal cards
        // Stream of the players arrayList to give two cards to each player
        // Use of Lambda Expression to cut down on vervose code
        players.stream()
               .forEach(s -> s.drawCard(deck)); 
                              
        players.stream()
               .forEach(s -> s.drawCard(deck));
                                  
        players.stream()
               .forEach(s -> System.out.println("" + s.getName() + " has drawn " + s.getTotal()));
       //check for Blackjack, dealer first, then players
        for (int i=0; i < players.size(); i++) {
        	if (players.get(i).getName().equals("Dealer")){
        	   if (players.get(i).checkBlackjack()) {
        		   return this.roundEnd(1, i, players);
        	   }        	          		
        	}else
        	if (players.get(i).checkBlackjack()) {
            	return this.roundEnd(2,i, players);
            }        	          		     		      
        }
        
        //Start players turn, assumption is dealer is last in List, and players are in the beginning or List
        int playerAction = 3;
        
        for (int k = 0; k < players.size()-1; k++) {
        	System.out.println("It is player " + players.get(k).getName() + "'s turn, please choose an option");
        	System.out.println("Press 1 to hit, press 0 to stand");
        	playerAction = input.nextInt();
        	//output for players decision
        	if (playerAction == 1) {
        		System.out.println(players.get(k).getName() + " hits");
        	}else
        		System.out.println(players.get(k).getName() + " has decided to stay");
        	
        	//validate input
        	while (playerAction > 1){
    			System.out.println("Incorrect value! Press 1 to hit, press 0 to stay, or press 2 to double down");
    			playerAction = input.nextInt();
    		}
        	
        	//here we action on the hit/stand 
        	while(playerAction != 0) {
        		players.get(k).drawCard(deck);
        		System.out.println(players.get(k).getTotal());
        		if (players.get(k).getTotal() > 21) {
        			return this.roundEnd(3, k, players);
        		}
        		if (players.get(k).getTotal() == 21) {
        		    System.out.println("You've drawn 21!");
        		    playerAction = 0;
        		}
        		if (playerAction != 0) {
        			System.out.println("Your hand is now " + players.get(k).getTotal() + ". Press 1 to hit, press 0 to stand");
                	playerAction = input.nextInt();
        		}
        	}
        }
        	
        	//play dealers turn
        	int dealerIndex = players.size()-1;
        	
        	System.out.println("It is the Dealers turn");
        	System.out.println("the Dealer has " + players.get(dealerIndex).getTotal());      		
        	
        	while (players.get(dealerIndex).getTotal() < 17) {
        		players.get(dealerIndex).drawCard(deck);
        		System.out.println("Dealer now has" + players.get(dealerIndex).getTotal() + ".");
        		if (players.get(dealerIndex).getTotal() > 21) {
        			return this.roundEnd(4,dealerIndex, players);
        		}
        	}
        	
        	//determine winner by hand totals
        	for (int r = 0; r < players.size()-1; r++) {
        		
        		if (players.get(r).getTotal() > players.get(dealerIndex).getTotal()) {
        			return this.roundEnd(7,r, players);
        		} else if (players.get(dealerIndex).getTotal() == players.get(r).getTotal()) {
        			return this.roundEnd(5,r, players);
        		} else {
        			return this.roundEnd(6,r, players);
        		}        		
        	
        	} 	
        input.close(); // closure of the input scanner
		return -1; // test for if everything breaks
	}
	
	public int roundEnd(int result, int playerIndex, List<PlayerImpl> players) {
		
		// calculate all the end of round conditions
		int dealerindex = players.size() -1;
		switch (result) {
				case 1:
					System.out.println("That sucks, Dealer got Blackjack!");
					for (int r = 0; r < players.size()-1; r++) {
						players.get(r).removeMoney(players.get(r).getBet());
					}
					break;
				case 2:
					System.out.println("You have blackjack! You have won!");
					players.get(playerIndex).addMoney(players.get(playerIndex).getBet() * 2);
					for (int r = 0; r < players.size()-1; r++) {
						if (r != playerIndex) {
							players.get(r).removeMoney(players.get(r).getBet());
						}
					}
					break;
				case 3:
					System.out.println("You've busted with a total of " + players.get(playerIndex).getTotal() + "!");
					players.get(playerIndex).removeMoney(players.get(playerIndex).getBet());
					break;
				case 4:
					System.out.println("Dealer has busted with " + players.get(dealerindex).getTotal() + ", you have won!");
					for (int r = 0; r < players.size()-1; r++) {
						players.get(r).addMoney(players.get(r).getBet());
					}
					break;
				case 5:
					System.out.println("You've tied!");
					players.get(playerIndex).setBet(0);
					break;
				case 6:
					System.out.println("You've lost!");
					//players.get(playerIndex).setWallet(players.get(playerIndex).getWallet() - players.get(playerIndex).getBet());
					players.get(playerIndex).removeMoney(players.get(playerIndex).getBet());
					break;
				case 7:
					System.out.println("You've won!");
					//players.get(playerIndex).setWallet(players.get(playerIndex).getWallet() + players.get(playerIndex).getBet());
					players.get(playerIndex).addMoney(players.get(playerIndex).getBet());
					break;
										
		}
		for (int t = 0; t < players.size(); t++) {
			   players.get(t).clearCards();	
			}

	return players.get(0).getBet();
	}

}
	
	
	
	
	
