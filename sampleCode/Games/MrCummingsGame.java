package sampleCode.Games;

import java.util.*;

public class MrCummingsGame {
public static void main (String[] args) {

Scanner console = new Scanner (System.in);
Random r = new Random();

introImage();

int money = 100;
int round=1;


// enter betting round
while (money>0) {
    // enter the round
    System.out.println ();
    System.out.println ("~~~~~~Let's begin the round!~~~~~~~");
    System.out.println ("~~~~~~~~This is round " + round + "~~~~~~~~~~~~");
    System.out.println ();

    // prompt for bet type
    System.out.println ("What kind of bet would you like to place? (odd, even, 1, 2, 3, 4, 5, 6)");
    String betType = console.next();

    // prompt for bet amount
    System.out.println ("Place your bet! You currently have $" + money + ". How much do you want to bet? Enter as a whole number without $.");
    int bet = console.nextInt();

    //roll the die
    int roll = r.nextInt(6) + 1;
    System.out.println ("The die came up a " + roll);

    if (betType.equals("even")) {

        if (roll % 2 == 0) {
        System.out.println ("You Won!");
         money = money+bet;
         System.out.println("You now have $" + money);
       
    }

        else {
        System.out.println ("You Loose!");
        money = money-bet;
        System.out.println("You now have $" + money);
    
    }}

    if (betType.equals("odd")) {

        if (roll % 2 == 1) {
        System.out.println ("You Won!");
        money = money+bet;
        System.out.println("You now have $" + money);
        }
    
        else {
         System.out.println ("You Loose!");
        money = money-bet;
        System.out.println("You now have $" + money);
        }}

    if (betType.equals("1")) {

            if (roll == 1) {
            System.out.println ("You Won!");
            money = money+6*bet;
            System.out.println("You now have $" + money);
            }
        
            else {
            System.out.println ("You Loose!");
            money = money-bet;
            System.out.println("You now have $" + money);
            }}

    if (betType.equals("2")) {

            if (roll == 2) {
            System.out.println ("You Won!");
            money = money+6*bet;
            System.out.println("You now have $" + money);
                }
            
            else {
            System.out.println ("You Loose!");
            money = money-bet;
            System.out.println("You now have $" + money);
                
             }}

    if (betType.equals("3")) {

            if (roll == 3) {
            System.out.println ("You Won!");
            money = money+6*bet;
            System.out.println("You now have $" + money);
                    }
                
            else {
            System.out.println ("You Loose!");
            money = money-bet;
            System.out.println("You now have $" + money);        
                    }}
            
    if (betType.equals("4")) {

            if (roll == 4) {
            System.out.println ("You Won!");
            money = money+6*bet;
            System.out.println("You now have $" + money);
                        }
                    
            else {
            System.out.println ("You Loose!");
            money = money-bet;
            System.out.println("You now have $" + money);
              }}

    if (betType.equals("5")) {

            if (roll == 5) {
            System.out.println ("You Won!");
            money = money+6*bet;
            System.out.println("You now have $" + money);
                                }
                            
            else {
            System.out.println ("You Loose!");
            money = money-bet;
            System.out.println("You now have $" + money); 
                                }}
                
    if (betType.equals("6")) {

            if (roll == 6) {
            System.out.println ("You Won!");
            money = money+6*bet;
            System.out.println("You now have $" + money);
                                    }
                                
            else {
            System.out.println ("You Loose!");
            money = money-bet;
            System.out.println("You now have $" + money);              
                                    }}

// increment the round #
round ++;

//asking if they want to quit
System.out.println();
System.out.println ("Type q to quit or type anything else to keep playing.");
String quit = console.next();

            if (quit.equals("q")) {
                System.out.println ("You have now quit and you are therefore a looser.");
                break;
            }
                
}}

//Intro message
public static void introImage() {
    System.out.println ();
    System.out.println ();
    System.out.print ("Welcome to!...");
    System.out.println ("Bettin' on a Die!");
    System.out.println ("You begin with $100.");
    System.out.println ("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println ();
}}