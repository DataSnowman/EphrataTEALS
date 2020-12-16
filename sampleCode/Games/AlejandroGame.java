
package sampleCode.Games;

import  java.util.Scanner;
// Java scanner must be imported in order to get user input


/* RULES : You will roll a dice by typing in "!roll", Your opponent will do the same ,Whoever rolls the biggest number receives 1 point
If on the next roll you receive the same roll from the previous time Your points will decrease by 1 
If you get a tie, both of you will have a randomized roll from 1 to 2 points
First one to 10 points wins the game and becomes the king of luck :) \nHAVE FUN!
NOTE: The players CAN reach more than 10 points at the end of the game */

public class AlejandroGame {

    public static void main(String args[]) {
        
        Scanner console = new Scanner(System.in);

        intro1();
        // Intro 1 Will show the HUGE title of the game :)
        intro2();
        // Intro 2 will explain the following rules of the game to the user

        //USER INTERACTION
        System.out.print("Hello, Player 1 what is your name? ");
        String player1 = console.nextLine();
        System.out.print("Hello, Player 2, what is your name? ");
        String player2 = console.nextLine();
        // This will be the users input, they willl type in their names in order to organize the game a little more

        int points1 = 0;
        int points2 = 0;
        // I must set both player points to 0 becuse nobody wants their oppponent to enter a game with points already :)

        int player1Roll = 0;
        int player2Roll = 0;
        // The players roll was set to 0 since it needs to start with containing nothing

        int checkSameRoll1 = player1Roll;
        int checkSameRoll2 = player2Roll;
        // This is to check if the player rolled the same number, so there for i have to set the varible to the players roll since it begins with 0
    
        // LOOPS

        while(points1 < 10 && points2 < 10){
        // This while loop will run the game until one of the players reaches 10 points and wins the game

        System.out.print( player1 + " please type \"!roll\" ");    
        String roll1 = console.nextLine();

        //RANDOMNESS

        player1Roll = (int)(Math.random() * 6) + 1; 
        // For both of these sets, the user will be asked to type in "!roll"
        // Then will proceed to create a randomzied roll between 1 and 6 into the varible
        System.out.println();                                                            
        System.out.println(player1 + " rolled " + player1Roll);                                  
        System.out.println();
        
        System.out.print(player2 + " please type \"!roll\" ");
        String roll2 = console.nextLine();
        player2Roll = (int)(Math.random() * 6) + 1;

        System.out.println();
        System.out.println(player2 + " rolled " + player2Roll);
        System.out.println();
        

        char initialsOfPlayer1 = player1.charAt(0);
        char initialsOfPlayer2 = player2.charAt(0);
        // These are just to lable the tables that will have the players scores with intials of the players

        //CONDITIONAL LOGIC

        if (roll1.equals("!roll") & roll2.equals("!roll")){
        // This If statement will see if the user did indeed follow the directions and continue the program if they do
        // If they dont they will be requested to try again

            // These If statements are going to determine which roll was higher, then proceed to give a point to the highest roll
            if (player1Roll > player2Roll){
            
                points1++;

                System.out.println(player1 + " Wins this round" );
                System.out.println();
                System.out.println("  " + initialsOfPlayer1 + "   " + initialsOfPlayer2);
                System.out.println("---------");
                System.out.println("| " + points1 + " | " + points2 + " |" );
                System.out.println("---------");

            } else if(player2Roll > player1Roll) {

                points2++;

                System.out.println(player2 + " Wins this round" );
                System.out.println();
                System.out.println("  " + initialsOfPlayer1 + "   " + initialsOfPlayer2);
                System.out.println("---------");
                System.out.println("| " + points1 + " | " + points2 + " |" );
                System.out.println("---------");

            } else if (player1Roll == player2Roll) {
                // Here the players tie, then they will get a randomized roll from 1 to 2 points to add

                points1 = points1 + (int)(Math.random() * 2) + 1;
                points2 = points2 + (int)(Math.random() * 2) + 1;

                System.out.println("You both tied!");
                System.out.println();
                System.out.println("  " + initialsOfPlayer1 + "   " + initialsOfPlayer2);
                System.out.println("---------");
                System.out.println("| " + points1 + " | " + points2 + " |" );
                System.out.println("---------");

            } 

            // These If statements will check if the players previous roll was the same, and if so, it will decrease their points by 1
            if (player1Roll == checkSameRoll1 ){

                points1--;

                System.out.println( player1 + " You had the same roll twice, therefore you loose 1 point Haha :)" + " You now have " + points1 + " point(s)");
                System.out.println();
                System.out.println("  " + initialsOfPlayer1 + "   " + initialsOfPlayer2);
                System.out.println("---------");
                System.out.println("| " + points1 + " | " + points2 + " |" );
                System.out.println("---------");
    
            } else if (player2Roll == checkSameRoll2) {
    
                points2--;

                System.out.println( player2 + " You had the same roll twice, therefore you loose 1 point Haha :)" + " You now have " + points2 + " point(s)");
                System.out.println();
                System.out.println("  " + initialsOfPlayer1 + "   " + initialsOfPlayer2);
                System.out.println("---------");
                System.out.println("| " + points1 + " | " + points2 + " |" );
                System.out.println("---------");
    
            } 
            // After all of that, now this variable will update the roll that was just done
            checkSameRoll1 = player1Roll;
            checkSameRoll2 = player2Roll;

            


        } else {
            System.out.println("You typed the wrong word, Try again");
        }

    }
        //These  If statements will announce which player is the winner
        if (points1 > points2) {

            System.out.println(player1 + " Wins with a total of " + points1);
            System.out.println();
            System.out.println(" ████  █      ███  █   █ █████ ████     ████    █   █  ███  █   █   █   █ █████ █   █ ");
            System.out.println(" █   █ █     █   █  █ █  █     █   █      ██     █ █  █   █ █   █   █   █   █   ██  █ ");
            System.out.println(" ████  █     █████   █   ████  ████       ██      █   █   █ █   █   █ █ █   █   █ █ █ ");
            System.out.println(" █     █     █   █   █   █     █   █      ██      █   █   █ █   █   ██ ██   █   █  ██ ");
            System.out.println(" █     █████ █   █   █   █████ █   █   ████████   █    ███  █████   █   █ █████ █   █ ");
            System.out.println();


        } else if (points2 > points1) {

            System.out.println(player2 + " Wins with a total of " + points2);
            System.out.println();
            System.out.println(" ████  █      ███  █   █ █████ ████     ██████    █   █  ███  █   █   █   █ █████ █   █");
            System.out.println(" █   █ █     █   █  █ █  █     █   █        ██     █ █  █   █ █   █   █   █   █   ██  █ ");
            System.out.println(" ████  █     █████   █   ████  ████       ██        █   █   █ █   █   █ █ █   █   █ █ █ ");
            System.out.println(" █     █     █   █   █   █     █   █     ██         █   █   █ █   █   ██ ██   █   █  ██ ");
            System.out.println(" █     █████ █   █   █   █████ █   █    ███████     █    ███  █████   █   █ █████ █   █ ");
            System.out.println();

        } else if (points1 == points2) {

            System.out.println("IT WAS A TIE!");
            System.out.println();
            System.out.println("█████ █████    █   █  ███  █████     ███     █████ █████ █████ ");
            System.out.println("  █     █      █   █ █   █ █        █   █      █     █   █     ");
            System.out.println("  █     █      █ █ █ █████ █████    █████      █     █   ████  ");
            System.out.println("  █     █      ██ ██ █   █     █    █   █      █     █   █     ");
            System.out.println("█████   █      █   █ █   █ █████    █   █      █   █████ █████ ");
            System.out.println();

        } 

    }

    //PROCEDURAL DECOMPOSITION

// These Are the methods that I could make 
public static void intro2() {

    System.out.println("");
    System.out.println("▀█▀ █▄ █ █▀▀ ▀█▀ █▀█ █ █ █▀▀ ▀█▀ ▀█▀ █▀█ █▄ █ █▀▀");
    System.out.println("▄█▄ █ ▀█ ▄██  █  █▀▄ █▄█ █▄▄  █  ▄█▄ █▄█ █ ▀█ ▄██ ");
    System.out.println("");
    System.out.println("Hello, welcome to, FIRST TO TEN, in this game");
    System.out.println("you will roll a dice by typing in \"!roll\", \nYour opponent will do the same \nWhoever rolls the biggest number receives 1 point ");
    System.out.println("If on the next roll you receive the same roll from the previous time \nYou will receive 2 points no matter what");
    System.out.println("First one to 10 points wins the game and becomes the king of luck :) \nHAVE FUN!");
    System.out.println();



}
public static void intro1() {

    System.out.println("____________________________________________________________________________");
    System.out.println("                              Welcome to The                                ");
    System.out.println();
    System.out.println("             ████  █████  ████ █████     ████  ███  █   █ █████  ");
    System.out.println("             █   █   █   █     █        █     █   █ ██ ██ █     ");
    System.out.println("             █   █   █   █     ████     █  ██ █████ █ █ █ ████  ");
    System.out.println("             █   █   █   █     █        █   █ █   █ █   █ █     ");
    System.out.println("             ████  █████  ████ █████     ███  █   █ █   █ █████ ");
    System.out.println("____________________________________________________________________________");
      

}



}




