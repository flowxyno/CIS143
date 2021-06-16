package com.olympic.cis143.m08;

/**
 Class to hold information about the Card. Cards are held in decks and have a Suit and value.
 
  Note that jokers are created with a suit of NONE. Note that, other than joker cards, NONE should not ever be a suit.
 */
public class Card {

    enum Suit {
        HEARTS,
        CLUBS,
        DIAMONDS,
        SPADES
    }

    
    
    enum Face {
        ACE,
        KING,
        QUEEN,
        JACK,
        _10,
        _9,
        _8,
        _7,
        _6,
        _5,
        _4,
        _3,
        _2
    }
    
    private int value;

    
    private Suit suit;

    
    private Face face;

    /**
     suit - The SUITE of the card
     face - The Face of the card.
     value - the numerical value of the card for totaling purposes 
     */
    public Card(final Suit suit, final Face face, final int value) {
        this.suit = suit;
        this.face = face;
        this.value = value;
    }
    
    public Suit getSuit() {
        return this.suit;
    }

    
    public Face getFace() {
        return face;
    }
    
    public int getValue() {
    	return value;
    }


    // returns the face and suit of the card drawn
    public boolean equals(final Card card) {
        if (card.face == this.face && card.suit == this.suit) {
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "[ Suit: " + this.suit + ", Face: " + face + " ]";
    }
}
