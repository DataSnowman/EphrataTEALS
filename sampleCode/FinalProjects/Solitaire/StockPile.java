package sampleCode.FinalProjects.Solitaire;

// Contains the rest of the deck leftover after dealing out the game.
// Each card flipped from the stock pile ends up on the waste pile.
public class StockPile {
    private Deck deck;

    // Initialize the stock pile with the leftover deck.
    public StockPile(Deck deck) {
        this.deck = deck;
    }

    // Flip 1 card to the waste pile.
    public boolean flip(WastePile pile) {
        if (this.deck.size() == 0) {
            // No more cards to flip
            return false;
        }
        
        pile.add(this.deck.draw());
        return true;
    }

    // Move all cards from the waste pile.
    public boolean moveFrom(WastePile pile) {
        if (this.deck.size() > 0) {
            // Can't move anything until all cards are flipped
            return false;
        }

        return pile.moveTo(this.deck);
    }

    // Display the deck.
    public String toString() {
        return this.deck.toString();
    }
}