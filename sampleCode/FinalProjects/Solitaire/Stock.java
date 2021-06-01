package sampleCode.FinalProjects.Solitaire;

// The cards in the upper left corner of the game table, consisting of
// a stock pile (the main deck) and a waste pile (where cards are flipped).
public class Stock {
    private StockPile stock;
    private WastePile waste;

    // Give the remaining cards in the deck to the stock pile.
    public Stock(Deck deck) {
        this.stock = new StockPile(deck);
        this.waste = new WastePile();
    }

    // Move all the waste pile cards back to the stock pile.
    public boolean reset() {
        return this.stock.moveFrom(this.waste);
    }

    // Try to flip up to 3 cards from the stock pile to the waste pile.
    public boolean flipThree() {
        boolean flippedSome = false;
        for (int i = 0; i < 3; i++) {
            if (!this.flipOne()) {
                // No more cards to flip, stop here.
                return flippedSome;
            }

            // If we got here, we successfully flipped at least one card.
            flippedSome = true;
        }

        return flippedSome;
    }

    // Flip 1 card from the stock pile to the waste pile.
    public boolean flipOne() {
        return this.stock.flip(this.waste);
    }

    // Move a card from the waste pile to the tableau pile.
    public boolean moveWasteTo(TableauPile pile) {
        return this.waste.moveTo(pile);
    }

    // Move a card from the waste pile to a foundation pile.
    public boolean moveWasteTo(Foundations foundations) {
        return this.waste.moveTo(foundations);
    }

    // Display the stock area.
    public String toString() {
        return "" + this.stock + this.waste;
    }
}
