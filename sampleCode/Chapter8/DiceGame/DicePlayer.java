package sampleCode.Chapter8.DiceGame;

/** A player in the dice game has four dice to roll. */
public class DicePlayer {
    // TODO (1): A DicePlayer has a String name and an array of Die objects called dice.

    public DicePlayer(String name) {
        // TODO (2): Set the name, and intialize the Die array with 4 new Die objects.
    }

    // TODO (1): Write getters for name and the Die array.

    public void rollDice()  {
        // TODO (3): Roll each die in the Die array.
    }

    public void reroll(int diePosition) {
        // TODO (4): Roll only the Die at index diePosition.
    }

    /********************************************/
    /* No modifications needed below this line. */
    /********************************************/

    /** Get the score for this player, which is the sum of all their dice rolls. */
    public int getScore() {
        int score = 0;
        for (int i  = 0; i < dice.length; i++) {
            score += dice[i].getCurrentNumber();
        }
        return score;
    }

    public String toString()  {
        String result = "";
        for (int i = 0; i < dice.length; i++) {
            result += "(" + (i + 1) + ")\n";
            result += dice[i].toString() + "\n";
        }
        return result;
    }
    
}
