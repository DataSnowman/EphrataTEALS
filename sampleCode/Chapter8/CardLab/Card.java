package sampleCode.Chapter8.CardLab;

public class Card {
    // Each Card should have state to represent its value and suit.
    // The card's value should be represented by a number between 1 and 13,
    // where 1 = Ace, 11 = Jack, 12 = Queen and 13 = King.
    // The card's suit should be represented by a string (e.g. "hearts", "diamonds").
    // Hide the data! The client should not be able to directly access or change ("mutate")
    // any of the fields.
    private int value;
    private String suit;

    // Constructor allows the client to specify the Card's value and suit.
    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    // Accessor method called getValue() that returns the Card's value.
    public int getValue() {
        return this.value;
    }

    // Accessor method called getSuit() that returns the Card's suit.
    public String getSuit() {
        return this.suit;
    }

    // toString() method that returns a string representation of the Card.
    // For aces and face cards, this method should return the name of the card,
    // not its numeric value. For example, calling toString() on a Card with the
    // value 11 and the suit "hearts" should return "jack of hearts", not "11 of hearts".
    public String toString() {
        if (value == 1) {
            return "ace of " + this.suit;
        } else if (value == 11) {
            return "jack of " + this.suit;
        } else if (value == 12) {
            return "queen of " + this.suit;
        } else if (value == 13) {
            return "king of " + this.suit;
        } else {
            // concatenate the int with the string to create a new string
            return this.value + " of " + this.suit;
        }
    }
}
