package com.olympic.cis143.m08;

import java.util.List;

// Interface for the deck which has allowances to build the deck, shuffle the deck, checking to see if the deck is empty, and dealing cards
public interface Deck {
    
	// Gets the deck
    List<Card> getDeck();

    // Shuffle the deck
    void shuffle();

    // Checks to see if the deck has any cards left
    boolean hasNext();

    // Will remove the next card from the deck and return the card to the calling method
    Card dealCard();
}
