package sampleCode.FinalProjects.Solitaire;

import java.util.*;

// An abstraction representing a generic pile of cards.
// The other pile classes use this class to simplify
// their own logic.
public class CardPile {
    private ArrayList<Card> pile;
    private int firstVisible;

    // An empty pile.
    public CardPile() {
        initialize(new ArrayList<Card>());
    }

    // A pile starting with some invisible cards.
    public CardPile(ArrayList<Card> cards) {
        initialize(cards);
    }

    private void initialize(ArrayList<Card> cards) {
        this.pile = cards;
        this.firstVisible = cards.size();
    }

    // Flip the top card of the pile.
    public boolean flip() {
        if (!this.canFlip()) {
            // Move is invalid.
            return false;
        }

        // We have one more visible card now.
        this.firstVisible--;
        return true;
    }

    private boolean canFlip() {
        if (this.empty()) {
            // Cannot flip an empty pile
            return false;
        }

        // Top card must be invisible
        return this.firstVisible >= this.pile.size();
    }

    // Add a card to the top of the pile.
    public void add(Card card) {
        this.pile.add(card);
    }

    // Are there any cards in this pile?
    public boolean empty() {
        return this.pile.size() == 0;
    }

    // Remove the top card in the pile.
    public Card removeTop() {
        return this.pile.remove(this.topIndex());
    }

    // Check if we're able to see any cards.
    public boolean hasAnyVisible() {
        if (this.empty()) {
            // No cards at all in this pile
            return false;
        }

        // if visible card index is valid, then we have
        // at least one visible card
        return this.firstVisible < this.pile.size();
    }

    // Get the top card value (or 0, if empty).
    public int topValue() {
        if (this.empty()) {
            return 0;
        }

        return this.top().getValue();
    }

    // Display the top card of the pile (if not empty).
    public String toString() {
        return this.toString(this.topIndex());
    }

    // Display the card in this pile at a specific index (if possible).
    public String toString(int index) {
        if (this.empty() || index >= this.pile.size()) {
            // no card here -- return "blank space"
            return "    ";
        }
        
        String card = "";
        if (index < this.firstVisible) {
            // cards from here and below are invisible
            card = "XX";
        } else {
            // otherwise card is visible
            card = this.pile.get(index).toString();
        }

        return "[" + card + "]";
    }

    // Is the top card red?
    public boolean topIsRed() {
        return this.top().isRed();
    }

    // Return the "bottom" card, i.e. first visible card in this pile.
    public Card bottom() {
        return this.pile.get(this.firstVisible);
    }

    // Remove the first visible card.
    public Card removeBottom() {
        return this.pile.remove(this.firstVisible);
    }

    private Card top() {
        return this.pile.get(this.topIndex());
    }

    private int topIndex() {
        return this.pile.size() - 1;
    }
}
