package sampleCode.Games;

import java.util.Scanner;

public class WesGame2 {

    private static final Scanner console = new Scanner(System.in);

    public static void main(String[] args) {// follow the prompts.//
    
        System.out.println("Hello user! what is your name? ");
        String Name = console.nextLine();
        System.out.println("Really? " + Name + " is too weird to be a real name.");
        confirmation();
        Mascot();
        System.out.println("Thank you for playing the demo");
    
        console.close(); 
    }

	public static void confirmation() {
        
        System.out.print("is that REALLY your name? (type Y/N) ");
        String yN = console.nextLine();
        String a = yN;
        if (a.toLowerCase().contains("y")) {
            System.out.println("I still dont belive you, so you will have to answer 3 riddles before you can continue to the game");
        } else{
            calledIt();
        }
         
    }
    
    public static void calledIt() {
        
        System.out.println("I knew it!");
        System.out.print("whats your real name? ");
        String realName =console.nextLine();
        System.out.println("" + realName + " sounds like a real name, but you lied the first time so you will need to answer riddles 3 to continue to the game");
        
    }
    
    public static boolean Mascot() {
        
        System.out.println("what Is our school mascot?");
        String b = console.nextLine();
        if (b.toLowerCase().contains("tiger")){
            System.out.println("Good, next riddle.");
            System.out.println("What runs around the whole yard without moving?");
    String c = console.nextLine();
    if (c.toLowerCase().contains("fence")){
        System.out.println("Good, next riddle.");
        System.out.println("What goes on four feet in the morning, two feet at noon, and three feet in the evening? ");
        String d = console.nextLine();
        if (d.toLowerCase().contains("man")){
            System.out.println("You, have sucsefully passed the third riddle");
            return true;
        } else{
            System.out.println("You have failed");
            return false;
        }
        
    } else{
        System.out.println("You have failed");
        return false;
    }
        } else{
            System.out.println("You have failed");
           return false;
       }

    }
        
        
        
        
}