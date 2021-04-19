package sampleCode.Chapter8.CardLab;

public class CardClient {
    public static void main(String[] args) {
        // Create a Card representing the queen of diamonds.
        // Create a Card representing the 5 of hearts.
        // Create a Card representing the ace of clubs.
        // Print these three cards to the console, separated by ", "
        Card qd = new Card(12, "diamonds");
        Card fh = new Card(5, "hearts");
        Card ac = new Card(1, "clubs");
        System.out.println(qd + ", " + fh + ", " + ac);

        // Create a Deck with only values of 4-6 and suits of hearts and spades.
        // Shuffle the Deck.
        // Prints all of the Cards in the Deck, in their current shuffled order.
        int[] smallValues = { 4, 5, 6 };
        String[] smallSuits = { "hearts", "spades" };
        Deck smallDeck = new Deck(smallValues, smallSuits);
        smallDeck.shuffle();
        while (smallDeck.hasNext()) {
            Card card = smallDeck.draw();
            System.out.println(card);
        }

        // Create a standard 52-card Deck and shuffle it.
        // Draw the top two Cards from the deck and compare them
        // prints to the console whichever Card has the higher value.
        Deck fullDeck = new Deck();
        fullDeck.shuffle();
        Card top1 = fullDeck.draw();
        Card top2 = fullDeck.draw();
        int v1 = top1.getValue();
        int v2 = top2.getValue();
        if (v1 > v2) {
            System.out.println("The " + top1 + " is higher");
        } else if (v2 > v1) {
            System.out.println("The " + top2 + " is higher");
        } else {
            System.out.println("The " + top1 + " and the " + top2 + " have equal values");
        }
    }
}
