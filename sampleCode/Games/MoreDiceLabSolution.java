package sampleCode.Games;

import java.util.Scanner;
import java.util.Random;

public class MoreDiceLabSolution {
    public static void main(String[] args) {
        printIntro();
        Scanner console = new Scanner(System.in);
        
        int playerArmies = 0;
        int computerArmies = 0;

        Random random = new Random();

        // Uncomment the following lines once you finish Part 1
        // Remember to makes changes to the public static int initializeArmies
        
        System.out.println("Enter minimum number of Armies and Press ENTER.");
        int minArmies = console.nextInt();
        System.out.println("Enter maximum number of Armies and Press ENTER.");
        int maxArmies = console.nextInt();
        
        // Also modify single parameter calls to initializeArmies with multiple parameters
        // See Part 1: add more Armies 1 where you need to modify the initializeArmies method
        playerArmies = initializeArmies(random, minArmies, maxArmies);
        computerArmies = initializeArmies(random, minArmies, maxArmies);
        //playerArmies = initializeArmies(random);
        //computerArmies = initializeArmies(random);

        printArmies(playerArmies, computerArmies);

        String userChoice = "";
        while(!userChoice.equalsIgnoreCase("quit")){ //while loop fixed

        System.out.println("Press ENTER to roll the dice. To end enter Quit");
        userChoice = console.nextLine().toLowerCase();

        int playerDie = 0;
        int computerDie = 0;

        // Modify to work with multiple dice being rolled
        int dicePlayerFirst = 0;
        int dicePlayerSecond = 0;
        int diceComputerFirst = 0;
        int diceComputerSecond = 0;

        // Three roles for player
        for(int i = 1; i <= 3; i++){
            System.out.print("Number " + i + ": ");
            playerDie = rollDie(random);
            if(playerDie > dicePlayerFirst){
                dicePlayerSecond = dicePlayerFirst;
                dicePlayerFirst = playerDie;
            } else if ((dicePlayerFirst > playerDie) && (dicePlayerSecond < playerDie)){ 
                dicePlayerSecond = playerDie;
            } else 
            {System.out.println("Done!");}

            System.out.println(dicePlayerFirst);
            System.out.println(dicePlayerSecond);
        }

        // Two roles for computer
        for(int i = 1; i <= 2; i++){
            System.out.print("Number " + i + ": ");
            computerDie = rollDie(random);
            if(computerDie > diceComputerFirst){
                diceComputerSecond = diceComputerFirst;
                diceComputerFirst = computerDie;
            } else 
            {   diceComputerSecond = computerDie;
                System.out.println("Done!");
            }

            System.out.println(diceComputerFirst);
            System.out.println(diceComputerSecond);
        }
        //playerDie = rollDie(random);
        //computerDie = rollDie(random);

        //System.out.println("The player rolled:   " + playerDie);
        //System.out.println("The computer rolled: " + computerDie);
        //System.out.println();

        // Add code here to determine the winner according to Part 3
        // Part 3: determine winner
        // ...
        String diceFirstWinner = "";
        if (computerArmies > 0 && diceComputerFirst >= dicePlayerFirst && playerArmies > 0){
            diceFirstWinner = "Computer Wins!";
            playerArmies = playerArmies - 1;
        } else if (playerArmies > 0 && dicePlayerFirst > diceComputerFirst && computerArmies > 0){
            diceFirstWinner = "Player Wins";
            computerArmies = computerArmies -1;
        } else {
            System.out.println("Game Over! To end enter Quit");
        }

        System.out.println("The first dice winner is:   " + diceFirstWinner);

        String diceSecondWinner = "";
        if (computerArmies > 0 && diceComputerSecond >= dicePlayerSecond && playerArmies > 0){
            diceSecondWinner = "Computer Wins!";
            playerArmies = playerArmies - 1;
        } else if (playerArmies > 0 && dicePlayerSecond > diceComputerSecond && computerArmies > 0){
            diceSecondWinner = "Player Wins";
            computerArmies = computerArmies -1;
        } else {
            System.out.println("Game Over! To end enter Quit");
        }

        System.out.println("The second dice winner is:   " + diceSecondWinner);

        printArmies(playerArmies, computerArmies);

        } //end of While
    }

    public static void printIntro() {
        System.out.println("Welcome to the");
        System.out.println("DDD  III  CCC EEEE");
        System.out.println("D  D  I  C    E ");
        System.out.println("D  D  I  C    EEE ");
        System.out.println("D  D  I  C    E ");
        System.out.println("DDD  III  CCC EEEE");
        System.out.println();
        System.out.println("L      A    BBBB");
        System.out.println("L     A A   B   B");
        System.out.println("L    AAAAA  BBBB");
        System.out.println("L    A   A  B   B");
        System.out.println("LLLL A   A  BBBB");
        System.out.println();
    }

    public static void printArmies(int playerArmies, int computerArmies) {
        System.out.println("Player armies . . . . " + playerArmies);
        System.out.println("Computer armies . . . " + computerArmies);
        System.out.println();
    }

    // Part 1: add more Armies 1
    public static int initializeArmies(Random random, int min, int max) {
        // Generate random number between 5 to 10 
        //int armies = (int)(Math.random() * (max - min + 1)) + min;
        int armynum = random.nextInt(max - min + 1) + min;
        return armynum;
    }

    public static int rollDie (Random random) {
        // Generate random number between 1 to 6 
        //int dicenum = (int)(Math.random() * (max - min + 1)) + min;
        int dicenum = random.nextInt(2) + 5;
        return dicenum;
    }
}