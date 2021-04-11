package sampleCode.Chapter8.DiceGame;

import java.util.Scanner;

/*****************************
 * DO NOT MODIFY THIS CLASS. *
 *****************************/

/**
 * Runs a game of dice. Each player gets 4 dice - after rolling, you
 * can choose to re-roll one of your dice. Whoever has the highest
 * total at the end of the round wins.
 */
public class DiceGame {
    public static void main(String[] args) {
        DicePlayer computer = new DicePlayer("Computer");
        DicePlayer human = new DicePlayer("You");
        Scanner in = new Scanner(System.in);

        printInstructions();
        String doContinue = in.next();

        while (doContinue.toLowerCase().equals("go")) {
            computerTurn(computer);
            playerTurn(in, human);

            determineWinner(computer, human);

            System.out.print("Type 'go' to play another round or 'exit' to quit: ");
            doContinue = in.next();
        }

        System.out.println("Thank you for playing!");

        in.close();
    }

    /** Print a welcome message for the player. */
    private static void printInstructions() {
        System.out.println("Welcome to the Dice Game!");
        System.out.println("You and a computer will each roll 4 dice.");
        System.out.println("Whichever player has the highest sum total");
        System.out.println("wins the round. After rolling your dice, you");
        System.out.println("will have the opportunity to reroll one of your dice.");
        System.out.print("Type 'go' to continue: ");
    }

    /** 
     * A computer turn consists of rolling all their dice, determining which die
     * has the lowest number, and re-rolling that die.
     */
    private static void computerTurn(DicePlayer computer) {
        computer.rollDice();
        Die[] rolledDice = computer.getDice();

        // Which die has the lowest value? Reroll that one.
        int lowestValue = 7; // impossible roll
        int dieWithLowestValue = 0;
        for (int i = 0; i < rolledDice.length; i++) {
            if (rolledDice[i].getCurrentNumber() < lowestValue) {
                lowestValue = rolledDice[i].getCurrentNumber();
                dieWithLowestValue = i;
            }
        }
        computer.reroll(dieWithLowestValue);
    }

    /**
     * A player turn consists of rolling all their dice, printing the dice,
     * asking whether they want to re-roll a die, and then handling their
     * decision to re-roll.
     */
    private static void playerTurn(Scanner in, DicePlayer player) {
        player.rollDice();
        System.out.println("You rolled:\n" + player);

        // Ask if they would like to re-roll a die.
        System.out.println("Would you like to reroll one? y/n");
        String answer = in.next();
        
        // If they want to re-roll, ask which die they want to re-roll.
        if (answer.equals("y")) {
            System.out.println("Which die would you like to reroll? Enter a number between 1 and 4");
            // We subtract one here since array indexes start at 0.
            int dieNumber = in.nextInt() - 1;
            player.reroll(dieNumber);
            System.out.println("Your new roll:");
            System.out.println(player.getDice()[dieNumber]);
        }
    }

    /**
     * The winner is the player with the highest sum total of their dice.
     */
    private static void determineWinner(DicePlayer computer, DicePlayer human) {
        int computerScore = computer.getScore();
        int humanScore = human.getScore();
        System.out.println("The computer scored: " + computerScore);
        System.out.println("You scored:          " + humanScore);

        if (computerScore > humanScore) {
            System.out.println("You lose :(");
        } else if (humanScore > computerScore) {
            System.out.println("You win!");
        } else {
            System.out.println("It was a tie!");
        }
    }
}
