package sampleCode.Chapter8.DiceGame;

import java.util.Random;

/** Represents a standard six-sided die. */
public class Die {
    private int currentFace;

    public Die() {
        this.currentFace = 1;
    }

    public int getCurrentFace() {
        return currentFace;
    }

    public int roll() {
        Random rand = new Random();
        currentFace = rand.nextInt(6) + 1;
        return currentFace;
    }

    public String toString()  {
        String result = drawLine();

        if (currentFace == 1) {
            result += drawNoDots() + drawOneMiddleDot() + drawNoDots();
        } else if (currentFace == 2) {
            result += drawOneLeftDot() + drawNoDots() + drawOneRightDot();
        } else if (currentFace == 3) {
            result += drawOneLeftDot() + drawOneMiddleDot() + drawOneRightDot();
        } else if (currentFace == 4) {
            result += drawTwoDots() + drawNoDots() + drawTwoDots();
        } else if (currentFace == 5) {
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