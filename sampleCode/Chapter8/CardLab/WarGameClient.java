/**
 * Game of War
 * 
 * Game Rules:
 * 1. Each player draws a card from their deck. The player with the higher card value
 *    wins that round adds both cards to the bottom of their deck.
 * 2. If the cards have the same value, no one wins the cards.
 * 3. The game ends when one player has all the cards.
 */
public class WarGameClient {

    public static void main(String[] args) {
        // 1. Create a standard 52-card Deck and shuffle it.

        // 2. Deal half the deck to each player. We will have two players,
        // each represented as a Deck.

        // 3. We want the game to continue until one of the players runs out of cards.
        // Fill in the condition of the while loop below. (Hint: what method on Deck
        // helps us check if there are cards left in the deck?)
        while ()  {
            // 4. Draw the top card of each player's deck. Print each of the cards.

            // 5. Determine which card has the higher value. Add both cards to the bottom
            // of the player's deck that drew the higher card. In the case of a tie,
            // do not give the cards to either player. Instead, print "It's a tie!".

            // 6. Print the size of each deck.
        }

        // 7. We finally finished a game of War! Call the determineWinner method to see who won.
    }

    /**
     * 8. Write a method to determine who won the game. A player won the game if they
     * have more cards in their deck than the other player. If the players have the
     * same number of cards in each of their decks, then it is a tie. Print the outcome.
     */
    private static void determineWinner(Deck player1, Deck player2) {

    }
}