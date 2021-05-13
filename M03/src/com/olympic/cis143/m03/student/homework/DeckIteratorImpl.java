package com.olympic.cis143.m03.student.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DeckIteratorImpl implements Deck {
	
	private List<Card> Deck = new ArrayList<>();
	private Iterator<Card> iterator;
	
	public DeckIteratorImpl(final boolean jokers) {
		this.createDeck(jokers);
	}
	
	private void createDeck(final boolean jokers) {
		for(Card.Suit cSuit: Card.Suit.values()) {
			if(Card.Suit.NONE == cSuit) {
				if(jokers) {
					this.Deck.add(new Card(Card.Suit.NONE, Card.Value.JOKER));
					this.Deck.add(new Card(Card.Suit.NONE, Card.Value.JOKER));
				}
			}
			else {
				for (Card.Value cValue: Card.Value.values()) {
					if (cValue != Card.Value.JOKER) {
						this.Deck.add(new Card(cSuit, cValue));
					}
				}
			}
		}
	}
	

	@Override
	public List<Card> getDeck() {
		return this.Deck;
	}

	@Override
	public void shuffle() {
		Collections.shuffle(this.Deck);
		this.iterator = this.Deck.iterator();
		
	}

	@Override
	public boolean hasNext() {
		return this.iterator.hasNext();
	}

	@Override
	public Card dealCard() {
		return this.iterator.next();
	}

}
