package sampleCode.FinalProjects.Solitaire;

// The game table for solitaire, and the primary class used by the game client.
//
// Every game move is implemented here, each in its own method.
// If a given move is invalid, the method will return false.
//
// Note that this class mostly delegates to other classes which contain the
// detailed game logic.
public class GameTable {
    private Foundations foundations;
    private Tableau tableau;
    private Stock stock;

    // Shuffle and deal out a standard game of solitaire.
    public GameTable() {
        Deck deck = new Deck();
        deck.shuffle();
        this.foundations = new Foundations(deck.getSuits());
        this.tableau = new Tableau(deck);
        this.stock = new Stock(deck);
    }

    // Did we win?
    public boolean isWinner() {
        return this.foundations.containAllCards();
    }

    // Flip the card at the top of the tableau pile
    public boolean flipTableau(int pile) {
        return this.tableau.flip(pile);
    }

    // Flip 3 stock cards to the waste pile.
    public boolean flipStock() {
        return this.stock.flipThree();
    }

    // Replace the waste cards back into the stock pile.
    public boolean resetStock() {
        return this.stock.reset();
    }

    // Move cards from one tableau pile to another.
    public boolean moveBetweenTableau(int fromPile, int toPile) {
        return this.tableau.move(fromPile, toPile);
    }

    // Move the top card from a tableau pile to the foundation.
    public boolean moveTableauToFoundation(int fromPile) {
        return this.tableau.move(fromPile, this.foundations);
    }

    // Move the top waste card to the foundation.
    public boolean moveWasteToFoundation() {
        return this.stock.moveWasteTo(this.foundations);
    }

    // Move the top waste card to a tableau pile.
    public boolean moveWasteToTableau(int toPile) {
        return this.tableau.move(this.stock, toPile);
    }

    // Display the entire game table.
    public String toString() {
        return
            this.stock + "    " + this.foundations + "\n" +
            this.tableau;
    }
}
