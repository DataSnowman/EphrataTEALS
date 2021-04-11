package sampleCode.Chapter8.DiceGame;

import java.util.Random;

/*****************************
 * DO NOT MODIFY THIS CLASS. *
 *****************************/

/** Represents a standard six-sided die. */
public class Die {
    private int currentNumber;

    public Die() {
        this.currentNumber = 1;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public int roll() {
        Random rand = new Random();
        currentNumber = rand.nextInt(6) + 1;
        return currentNumber;
    }

    public String toString()  {
        String result = drawLine();

        if (currentNumber == 1) {
            result += drawNoDots() + drawOneMiddleDot() + drawNoDots();
        } else if (currentNumber == 2) {
            result += drawOneLeftDot() + drawNoDots() + drawOneRightDot();
        } else if (currentNumber == 3) {
            result += drawOneLeftDot() + drawOneMiddleDot() + drawOneRightDot();
        } else if (currentNumber == 4) {
            result += drawTwoDots() + drawNoDots() + drawTwoDots();
        } else if (currentNumber == 5) {
            result += drawTwoDots() + drawOneMiddleDot() + drawTwoDots();
        } else {
            result += drawTwoDots() + drawTwoDots() + drawTwoDots();
        }

        return result + drawLine();
    }

    /** 
     * Methods below this line are all helpers for toString.
     * Note: "\n" is an escape sequence for a new line (like hitting  enter).
     * It is a special sequence of characters that tells the computer to
     * insert a new line.
     */

    private String drawLine() {
        return "-----\n";
    }

    private String drawNoDots()  {
        return "|   |\n";
    }
    
    private String drawTwoDots() {
        return "|o o|\n";
    }

    private String drawOneMiddleDot() {
        return "| o |\n";
    }

    private String drawOneLeftDot() {
        return "|o  |\n";
    }

    private String drawOneRightDot() {
        return "|  o|\n";
    }
}