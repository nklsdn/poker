package com.example.lib;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A deck of cards, from which cards are dealt to the players and the community hand.
 */

public class Deck{
    private ArrayList<Card> mCards = new ArrayList<Card>();

    /**
     * Create a deck with 52 cards from 2 of clubs to ace of spades
     * unshuffled, arranged by suits.
     */
    Deck() {
        ArrayList<Card> unshuffledDeck = new ArrayList<>();

        /* Add cards to unshuffled deck. */
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Value value : Card.Value.values()) {
                unshuffledDeck.add(new Card(value, suit));
            }
        }

        mCards = unshuffledDeck;
    }

    /**
     * Create a deck with specified cards (for playing with modified deck).
     * @param cards cards which will be in the deck
     */
    Deck(ArrayList cards) {
        mCards = cards;
    }

    /** Shuffle deck. */
    public void shuffle() {
        Collections.shuffle(mCards);
        System.out.println("Deck shuffled.");
    }

    /**
     * Deals the first card in the deck to specified hand.
     * Dealt card is removed from the deck.
     * @param hand the hand to which the card is dealt
     */
    public void dealTo(Hand hand) {
        hand.add(mCards.remove(0));
    }

    /**
     * Returns a string with the cards in the deck. Not used in actual game, but can be used for
     * testing.
     * @return string displaying the cards in the deck
     */
    public String show() {
        String temp = "";

        for (int i = 0; i<mCards.size(); i++ ) {
            temp = temp + mCards.get(i).strCard() + " ";
        }

        return temp;
    }

    /**
     * Returns the number of cards in the deck. Not used in actual game, but can be used for
     * testing.
     * @return number of cards in the deck
     */
    public int size() {
        return mCards.size();
    }

    public ArrayList<Card> getCards() {
        return mCards;
    }

    public void setCards(ArrayList<Card> cards) {
        mCards = cards;
    }


}
