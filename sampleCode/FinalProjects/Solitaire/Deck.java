package sampleCode.FinalProjects.Solitaire;

import java.util.*;

// A standard 52-card deck.
public class Deck {
    private ArrayList<Card> deck;
    private char[] suits;

    // Initialize all cards using the standard suits and values.
    public Deck() {
        int[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
        char[] suits = { '♠', '♥', '♦', '♣' };
        this.suits = suits;
        initializeCards(values, suits);
    }

    private void initializeCards(int[] values, char[] suits) {
        this.deck = new ArrayList<Card>();
        for (int value : values) {
            for (char suit : suits) {
                Card card = new Card(value, suit);
                this.deck.add(card);
            }
        }
    }

    // Deal out a list of cards.
    public ArrayList<Card> deal(int numberOfCards) {
        ArrayList<Card> cards = new ArrayList<Card>();
        for (int i = 0; i < numberOfCards; i++) {
            cards.add(this.draw());
        }

        return cards;
    }

    // How many cards are left?
    public int size() {
        return this.deck.size();
    }

    // Get the suits we used when initializing the deck.
    public char[] getSuits() {
        // create a copy so the caller can't modify it!
        char[] suitsCopy = new char[this.suits.length];
        for (int i = 0; i < this.suits.length; i++) {
            suitsCopy[i] = this.suits[i];
        }

        return suitsCopy;
    }

    // Shuffle the cards.
    public void shuffle() {
        Collections.shuffle(this.deck);
    }

    // Draw the top card (index 0 in this case).
    public Card draw() {
        return this.deck.remove(0);
    }

    // Put the card back (at the end of the deck).
    public void discard(Card card) {
        this.deck.add(card);
    }

    // Display the deck.
    public String toString() {
        if (this.size() == 0) {
            // empty deck...
            return "    ";
        } else {
            // top card is hidden!
            return "[XX]";
        }
    }
}
