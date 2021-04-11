package sampleCode.Chapter8.DiceGame;

import java.util.Scanner;

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

            System.out.print("Type 'go' to play another round: ");
            doContinue = in.next();
        }

        System.out.println("Thank you for playing!");

        in.close();
    }

    private static void printInstructions() {
        System.out.println("Welcome to the Dice Game!");
        System.out.println("You and a computer will each roll 5 dice.");
        System.out.println("Whichever player has the highest sum total");
        System.out.println("wins the round. After rolling your dice, you");
        System.out.println("will have the opportunity to reroll one of your dice.");
        System.out.print("Type 'go' to continue: ");
    }

    private static void computerTurn(DicePlayer computer) {
        computer.rollDice();
        Die[] rolledDice = computer.getDice();

        // Which die has the lowest value? Reroll that one.
        int lowestValue = 7; // impossible roll
        int dieWithLowestValue = 0;
        for (int i = 0; i < rolledDice.length; i++) {
            if (rolledDice[i].getCurrentFace() < lowestValue) {
                lowestValue = rolledDice[i].getCurrentFace();
                dieWithLowestValue = i;
            }
        }
        computer.reroll(dieWithLowestValue);
    }

    // Roll the player's dice and ask if they want to reroll one.
    private static void playerTurn(Scanner in, DicePlayer player) {
        player.rollDice();
        System.out.println("You rolled: ");
        System.out.println(player);
        System.out.println("Would you like to reroll one? y/n");
        String answer = in.next();
        
        if (answer.equals("y")) {
            System.out.println("Which die would you like to reroll? Enter a number between 1 and 5");
            int dieNumber = in.nextInt();
            player.reroll(dieNumber - 1);
        }
    }

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
