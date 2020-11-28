package sampleCode.Games;

import java.util.Scanner;  // Import the Scanner class

public class RockPaperScissor {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);


        // Prompt for User Choice
        System.out.print("Choose Rock, Paper, or Scissors; To end enter Quit: ");
        String userChoice = console.next().toLowerCase();
        
        //while(!userChoice.equalsIgnoreCase("quit")){ //while infinite loop
        
        double computerChoice = Math.random();
        String computerChoiceString = "";

        //System.out.println(userChoice); // for testing
        //System.out.println(computerChoice); // for testing

        if (computerChoice < 0.34) {
            computerChoiceString = "rock";
        } else if(computerChoice <= 0.67) {
            computerChoiceString = "paper";
        } else {
            computerChoiceString = "scissors";
        }

        //System.out.println(computerChoiceString); // for testing
        

        // Calculate winner
        String winner = whoWon(userChoice,computerChoiceString);
        System.out.println(winner);
      //} //end of While
       
    }

    public static String whoWon(String choice1, String choice2) {
        String x = "You chose " + choice1 + " and the Computer chose " + choice2;

            if(choice1.equals(choice2)){
                return  x + " -- The result is a tie!";
            }
            else if(choice1.equals("rock") && choice2.equals("scissors")){
                return x + " -- Rock crushes Scissors: You win!";
            }
            else if(choice1.equals("rock") && choice2.equals("paper")){
                return x + " -- Paper covers Rock: Computer wins";
            }
            else if(choice1.equals("paper") && choice2.equals("rock")){
                return x + " -- Paper covers Rock: You win!";
            }
            else if(choice1.equals("paper") && choice2.equals("scissors")){
                return x + " -- Scissors cut Paper: Computer wins";
            }
            else if(choice1.equals("scissors") && choice2.equals("paper")){
                return x + " -- Scissors cut Paper: You win!";
            }
            else if(choice1.equals("scissors") && choice2.equals("rock")){
                return x + " -- Rock crushes Scissors: Computer wins";
            }
            
            else
               return "Quit or Error in Logic so Trouble Shoot";
    }
    
}