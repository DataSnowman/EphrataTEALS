package sampleCode.FinalProjects.Solitaire;

// The entire tableau.
// Consists of 7 piles, initially containing an increasing number of cards.
public class Tableau {
    private TableauPile[] piles;

    // Deal out all 7 tableau piles.
    public Tableau(Deck deck) {
        this.piles = new TableauPile[7];
        for (int i = 0; i < this.piles.length; i++) {
            this.piles[i] = new TableauPile(deck, i + 1);
        }
    }

    // Flip the top card of the given pile.
    public boolean flip(int pile) {
        if (this.outOfRange(pile)) {
            // Bad index
            return false;
        }

        return this.piles[pile].flip();
    }

    private boolean outOfRange(int pile) {
        return (pile < 0) || (pile >= this.piles.length);
    }

    // Move cards from one pile to another.
    public boolean move(int fromPile, int toPile) {
        if (this.outOfRange(fromPile) || this.outOfRange(toPile)) {
            // Bad index
            return false;
        }

        if (fromPile == toPile) {
            // Can't move a pile to itself
            return false;
        }

        return this.piles[toPile].moveFrom(this.piles[fromPile]);
    }

    // Move a waste card from the stock to a pile.
    public boolean move(Stock stock, int toPile) {
        if (this.outOfRange(toPile)) {
            // Bad index
            return false;
        }

        return stock.moveWasteTo(this.piles[toPile]);
    }

    // Move the top card of a pile to the foundation.
    public boolean move(int fromPile, Foundations foundations) {
        if (this.outOfRange(fromPile)) {
            // Bad index
            return false;
        }

        return this.piles[fromPile].moveTo(foundations);
    }

    // Display the entire tableau.
    public String toString() {
        String rows = "";
        int r = 0;

        // In the worst possible case, we will have 6 hidden cards with
        // 13 cards (K -> Q -> ... -> A) stacked on top for a total of
        // 19 cards in a pile.
        while (r < 19) {
            String row = "";
            for (int c = 0; c < this.piles.length; c++) {
                row += this.piles[c].toString(r);
            }

            // As soon as the row is entirely blank, we must have
            // reached the end of all the piles. We can stop here.
            if (row.isBlank()) {
                // skip to the end
                r = 19;
            } else {
                rows += "\n" + row;
                r++;
            }
        }

        return rows;
    }
}
