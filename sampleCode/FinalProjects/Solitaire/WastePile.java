package sampleCode.FinalProjects.Solitaire;

// Contains all the cards flipped so far from the stock pile.
public class WastePile {
    private CardPile pile;

    // Initialize an empty pile.
    public WastePile() {
        this.pile = new CardPile();
    }

    // Add a card to the pile.
    public void add(Card card) {
        this.pile.add(card);
    }

    // Discard all waste cards back to the deck.
    public boolean moveTo(Deck deck) {
        boolean movedSome = false;

        // Keep going until we are empty.
        while (!this.pile.empty()) {
            deck.discard(this.pile.removeTop());

            // If we got here, then we moved
            // at least one card.
            movedSome = true;
        }

        return movedSome;
    }

    // Move the top waste card to the tableau pile.
    public boolean moveTo(TableauPile toPile) {
        if (this.pile.empty()) {
            // no cards to move
            return false;
        }

        Card top = this.pile.removeTop();
        if (!toPile.add(top)) {
            // move didn't work -- put the card back
            this.pile.add(top);
            return false;
        }

        return true;
    }

    // Move the top waste card to the foundation.
    public boolean moveTo(Foundations foundations) {
        if (this.pile.empty()) {
            // no cards to move
            return false;
        }

        Card top = this.pile.removeTop();
        if (!foundations.add(top)) {
            // move didn't work -- put the card back
            this.pile.add(top);
            return false;
        }

        return true;
    }

    // Display the pile.
    public String toString() {
        return this.pile.toString();
    }
}
