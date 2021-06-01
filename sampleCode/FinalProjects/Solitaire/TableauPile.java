package sampleCode.FinalProjects.Solitaire;

// A single tableau pile.
public class TableauPile {
    private CardPile pile;

    // Deal out the pile and flip top card.
    public TableauPile(Deck deck, int numberOfCards) {
        this.pile = new CardPile(deck.deal(numberOfCards));
        this.flip();
    }

    // Flip the top card.
    public boolean flip() {
        return this.pile.flip();
    }

    // Add a card to the top.
    public boolean add(Card card) {
        if (!this.canAdd(card)) {
            // Move is invalid
            return false;
        }

        this.pile.add(card);
        return true;
    }

    // Display a card at the specified index.
    public String toString(int index) {
        return this.pile.toString(index);
    }

    // Move the top card to the foundation.
    public boolean moveTo(Foundations foundations) {
        if (!this.pile.hasAnyVisible()) {
            // Can't move without a visible card.
            return false;
        }

        // Prepare to move -- pick up the top card.
        Card top = this.pile.removeTop();
        if (!foundations.add(top)) {
            // Move failed, need to put the card back.
            this.pile.add(top);
            return false;
        }

        return true;
    }

    public boolean moveFrom(TableauPile fromPile) {
        if (!this.canMoveFrom(fromPile)) {
            // Move is invalid.
            return false; 
        }

        // The bottom card from the other pile becomes the
        // top card in this pile. We loop until the other pile
        // has no more visible cards.
        while (fromPile.pile.hasAnyVisible()) {
            this.pile.add(fromPile.pile.removeBottom());
        }

        return true;
    }

    private boolean canMoveFrom(TableauPile fromPile) {
        if (fromPile.pile.empty()) {
            // There are no cards at all in the other pile
            return false;
        }

        if (!fromPile.pile.hasAnyVisible()) {
            // There are no visible cards in the other pile
            return false;
        }

        return this.canAdd(fromPile.pile.bottom());
    }

    private boolean canAdd(Card toAdd) {
        if (this.pile.empty()) {
            // Empty -- the only valid move in this case is K
            return toAdd.getValue() == 13;
        }

        if (!this.pile.hasAnyVisible()) {
            // No moves allowed -- there are no visible cards in this pile
            return false;
        }

        if (this.pile.topIsRed() == toAdd.isRed()) {
            // Cannot put same color on top of same color
            return false;
        }

        // Make sure top card value is one higher
        return this.pile.topValue() == toAdd.getValue() + 1;
    }
}
