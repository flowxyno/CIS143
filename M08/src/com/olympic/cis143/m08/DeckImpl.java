package com.olympic.cis143.m08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Implements the Deck interface
public class  DeckImpl implements Deck {

   
	// Initializes the ArrayList for the deck
	// this will be a stack object
    private List<Card> deck = new ArrayList<>();

    public DeckImpl() {
        this.createDeck();
    }

    
    private void createDeck() {
    	int value = 0;
    	
    	for (Card.Suit suit: Card.Suit.values()) 
    	{    		
    		for(Card.Face face: Card.Face.values())
    		{
    			
    				switch (face) {
    				
    				case ACE:
    					value = 11;
    					break;
    				case KING:
    					value = 10;
    					break;
    				case QUEEN:
    					value = 10;
    					break;
    				case JACK:
    					value = 10;
    					break;
    				case _10:
    					value = 10;
    					break;
    				case _9:
    					value = 9;
    					break;
    				case _8:
    					value = 8;
    					break;
    				case _7:
    					value = 7;
    					break;
    				case _6:
    					value = 6;
    					break;
    				case _5:
    					value = 5;
    					break;
    				case _4:
    					value = 4;
    					break;
    				case _3:
    					value = 3;
    					break;
    				case _2:
    					value = 2;
    					break;
    				
    				}
    			
    				this.deck.add(new Card(suit,face,value));
    		}
    	}    	   	
    }

    // gets and returns the deck
    // Creates arrayList 
    @Override
    public List<Card> getDeck() {
        return this.deck;
    }
    
    // Randomize the cards Or "shuffle" them
    @Override
    public void shuffle() {
    	Collections.shuffle(this.deck);    	
    }

    // Checks to see if the deck is empty
    @Override
    public boolean hasNext() {
    	return this.deck.isEmpty();
    }
    
    @Override
    public Card dealCard() {
        if(this.deck.isEmpty())
        {
        	throw new RuntimeException("Deck is Empty. Just call the hasNext() before calling this method");
        }
        int deckSize = this.deck.size()-1;
        Card drawnCard = this.deck.get(deckSize);
        this.deck.remove(deckSize);
        return drawnCard;
    }
}
