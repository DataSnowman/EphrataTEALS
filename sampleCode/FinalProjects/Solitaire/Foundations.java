package sampleCode.FinalProjects.Solitaire;

// The foundations are where the A-K cards are placed.
// Consists of 4 piles, one for each suit.
public class Foundations {
    private FoundationPile[] piles;

    // Initialize all piles.
    public Foundations(char[] suits) {
        this.piles = new FoundationPile[suits.length];
        for (int i = 0; i < suits.length; i++) {
            this.piles[i] = new FoundationPile(suits[i]);
        }
    }

    // Is every pile complete (A-K)?
    public boolean containAllCards() {
        for (FoundationPile pile : piles) {
            if (!pile.containsAllCards()) {
                return false;
            }
        }

        return true;
    }

    // Add a card to the matching foundation.
    public boolean add(Card card) {
        // Try every pile...
        for (FoundationPile pile : piles) {
            if (pile.add(card)) {
                return true;
            }
        }

        // Nothing worked, so this move is invalid.
        return false;
    }

    // Display all the piles.
    public String toString() {
        String row = "";
        for (FoundationPile pile : piles) {
            row += pile;
        }

        return row;
    }
}
