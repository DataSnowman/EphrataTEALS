package sampleCode.FinalProjects.Solitaire;

// A single foundation pile for a given suit.
public class FoundationPile {
    private CardPile pile;
    private char suit;

    // Initialize the pile for this suit.
    public FoundationPile(char suit) {
        this.pile = new CardPile();
        this.suit = suit;
    }

    // Is this pile complete (A-K)?
    public boolean containsAllCards() {
        // Do we have a K on top?
        return this.pile.topValue() == 13;
    }

    // Add a card to this pile.
    public boolean add(Card card) {
        if (!this.canAdd(card)) {
            return false;
        }

        this.pile.add(card);
        return true;
    }

    private boolean canAdd(Card card) {
        if (card.getSuit() != this.suit) {
            // Suit must match
            return false;
        }

        // The new card must be one higher.
        return this.pile.topValue() + 1 == card.getValue();
    }

    // Display the pile.
    public String toString() {
        if (this.pile.empty()) {
            // Placeholder if empty
            return " " + this.suit + this.suit + " ";
        }

        return this.pile.toString();
    }
}
