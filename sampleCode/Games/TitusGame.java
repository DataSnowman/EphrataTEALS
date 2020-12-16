package sampleCode.Games;

import java.util.Scanner;
 
public class TitusGame { 
 
    public static int slotmachine() {
 
        int payout = 0;
        int slot1 = (int)(Math.random() * (9 - 1)) + 1;
        int slot2 = (int)(Math.random() * (9 - 1)) + 1;
        int slot3 = (int)(Math.random() * (9 - 1)) + 1;
        System.out.println(" _________________ ");
        System.out.println("/  |   |   |   |  \\");
        System.out.println("|  | " + slot1 + " | " + slot2 + " | " + slot3 + " |  |");
        System.out.println("\\__|___|___|___|__/");
        
        if  ((slot1 == slot2) && (slot1 == slot3) && slot1 == 7) {
            payout = 50;
        } else if  ((slot1 == slot2) && (slot1 == slot3)) {
            payout = 20;
            }       
    
        return payout;  // payout + 20 jackpot = 50
        }    
 
    public static void main(String[] args) {
 
        Scanner myObj = new Scanner(System.in);
        System.out.println("It costs 5 tokens to play. Match the row to win. Jackpot is a row of 7s. How many tokens do you have?");
 
        int tokens = myObj.nextInt();
    
        if (tokens >= 5) {
        
            System.out.println("You have " + tokens + " tokens");
        
 
 
        } else { 
            System.out.println("You do not have enough tokens to play");
            }
 
        int again = 1;
        while (tokens >=5 && again == 1 ) {
        tokens = (tokens - 5);
    
    
        tokens = slotmachine() + tokens;
        System.out.println("You have " + tokens + " tokens");
        System.out.println("It costs 5 tokens to play. Match the row to win. Jackpot is a row of 7s. Would you like to play again? (yes=1 no=2)");
        again = myObj.nextInt();
        }
    }
}   
