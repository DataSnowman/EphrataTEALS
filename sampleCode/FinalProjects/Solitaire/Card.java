package sampleCode.FinalProjects.Solitaire;

public class Card {
    private int value;
    private char suit;

    public Card(int value, char suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return this.value;
    }

    public char getSuit() {
        return this.suit;
    }

    public boolean isRed() {
        return this.suit == '♦' || this.suit == '♥';
    }

    public String toString() {
        return this.valueToString() + this.suit;
    }

    private String valueToString() {
        if (this.value == 1) {
            return "A";
        } else if (this.value == 10) {
            return "T";
        } else if (this.value == 11) {
            return "J";
        } else if (this.value == 12) {
            return "Q";
        } else if (this.value == 13) {
            return "K";
        } else {
            return "" + this.value;
        }
    }
}
