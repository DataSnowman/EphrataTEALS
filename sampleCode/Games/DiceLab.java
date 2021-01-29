package sampleCode.Games;

import java.util.Scanner;

public class DiceLab {
    public static void main(String[] args) {
        printIntro();
        Scanner console = new Scanner(System.in);

        int playerArmies = 0;
        int computerArmies = 0;

        // Uncomment the following lines once you finish Part 1
        // 
        // playerArmies = initializeArmies(random);
        // computerArmies = initializeArmies(random);

        printArmies(playerArmies, computerArmies);

        System.out.println("Press ENTER to roll the dice.");
        console.nextLine();

        int playerDie = 0;
        int computerDie = 0;

        // Uncomment the following lines once you finish Part 2
        //
        // playerDie = rollDie(random);
        // computerDie = rollDie(random);

        System.out.println("The player rolled:   " + playerDie);
        System.out.println("The computer rolled: " + computerDie);
        System.out.println();

        // Add code here to determine the winner according to Part 3
        //
        // ...

        printArmies(playerArmies, computerArmies);
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
}
