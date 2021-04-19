package sampleCode.Chapter8.CardLab;

public class Deck {
    // Each Deck should have state to represent the cards it contains and
    // the next card to be played.
    // The cards in the deck should be represented by an array of Card objects.
    // The next card to be played should be tracked by an index that indicates the
    // current "top" Card. This index will start at 0 and get incremented every time
    // a card is dealt from the deck, until you reach the end of the deck.
    private Card[] deck;
    private int topCard;

    // Constructor that takes two parameters -
    // an array of values (as integers) and an array of suits (as strings) -
    // and initializes the array of cards with one Card to represent every combination
    // of those values and suits. For example, calling this constructor with an array
    // of values [1, 2, 3] and suits ["hearts", "diamonds"] will create a Deck containing
    // the following cards:
    // Ace of hearts, 2 of hearts, 3 of hearts, ace of diamonds, 2 of diamonds, 3 of diamonds.
    public Deck(int[] values, String[] suits) {
        this.topCard = 0;
        initializeCards(values, suits);
    }

    // Constructor that takes no parameters and initializes a standard 52-card deck
    // (i.e. with values 1-13 and the four standard suits - spades, clubs, hearts, and diamonds)
    public Deck() {
        this.topCard = 0;
        int[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
        String[] suits = { "spades", "hearts", "diamonds", "clubs" };
        initializeCards(values, suits);
    }

    private void initializeCards(int[] values, String[] suits) {
        int n = values.length * suits.length;
        deck = new Card[n];
        int index = 0;
        for (int value : values) {
            for (String suit : suits) {
                Card card = new Card(value, suit);
                this.deck[index] = card;
                index++;
            }
        }
    }

    // Both of your constructors should initialize the index that tracks the next card to 0.
    // This way the first draw will be from the "top" of the deck.
    // Both constructors share the logic to initialize the array of cards based on an array
    // of values and an array of suits. You must implement this logic only once. Specifically,
    // you must implement a method initializeCards() inside the Deck class which both
    // constructors call for initialization. It is up to you to determine what the correct set
    // of parameters is for this method. Finally, remember the importance of encapsulation!
    // The logic to initialize the cards should not be accessible to client code.

    // Implement a shuffle() method which shuffles the cards in the deck using the
    // CardShuffler class.
    public void shuffle() {
        CardShuffler shuffler = new CardShuffler();
        deck = shuffler.shuffle(deck);
    }

    // Implement a hasNext() method which returns true if the client should be able to draw
    // another card from the deck and false otherwise.
    public boolean hasNext() {
        return this.topCard < this.deck.length;
    }

    // Implement a draw() method which "draws" the next card from the deck. Specifically,
    // this method should get the "top" Card from the array of cards (according to the index
    // you defined in the Deck state), increment the index (so that the next time draw()
    // is called it will get the next card), and return the Card to the user.
    public Card draw() {
        Card next = this.deck[this.topCard];
        topCard++;
        return next;

        /* Another possible implementation:

        int oldIndex = topCard;
        topCard++;
        return deck[oldIndex];

        */
    }

    // Implement a toString() method that returns a string representation of the Deck.
    // It is up to you exactly what this representation is, but it must include
    // a) how many cards are in the Deck and b) what the current "top" card is.
    // For example, calling toString() on a standard 52-card deck where the top card is
    // a king of spades should return something like:
    // "A deck with 52 cards. The next card is the king of spades."
    public String toString() {
        return
            "A deck with " + this.deck.length + " cards. " +
            "The next card is the " + this.deck[this.topCard];
    }
}
