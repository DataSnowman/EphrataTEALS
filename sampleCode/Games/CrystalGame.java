package sampleCode.Games;

import java.util.Scanner;
import java.util.function.IntBinaryOperator;
import java.util.Random;

public class CrystalGame {


    public static String startGame() {
        String wordBank[] = {"spongebob", "patrick", "squidward", "sandy", "plankton", "krabs", "larry", "gary", "pearl", "neptune"};
        Random rand = new Random(); 
        int number = rand.nextInt(wordBank.length);
        int incorrectGuesses = 0;
        boolean gameOver = false;
        boolean letterGuessed = false;
        
        
        String word = wordBank[number];
        char[] wordChar = new char[word.length()]; 
        char[] blankWord = new char[word.length()];

       
        char letterGuess;


        for (int i = 0; i < word.length(); i++){
            blankWord[i] = '_';
        }

        for (int i = 0; i < word.length(); i++){
            wordChar[i] = word.charAt(i);
        }

        for (int i = 0; i < word.length(); i++){
            System.out.print(blankWord[i]);
            System.out.print(" ");
        }
        System.out.println();
        String userGuess;
        System.out.println("");
        Scanner console = new Scanner(System.in);
        System.out.println("Guess a letter");
        userGuess = console.nextLine();
        letterGuess = userGuess.charAt(0);

        int blanksLeft = word.length();
        while(incorrectGuesses < 6 && gameOver != true){
            blanksLeft = 0;
            letterGuessed = false;
            for(int i = 0; i < word.length(); i++){
                if(wordChar[i] == letterGuess){
                    blankWord[i] = wordChar[i];
                    letterGuessed = true;
                }
            }

            if(letterGuessed == false){
                incorrectGuesses = incorrectGuesses + 1;
            }
            

            for (int i = 0; i < word.length(); i++){
                System.out.print(blankWord[i]);
                System.out.print(" ");
            }

            for (int i = 0; i < word.length(); i++){
                if(blankWord[i] != wordChar[i]){
                    blanksLeft++;
                }
            }
            if(blanksLeft == 0){
                gameOver = true;
                break;
            } else {
                System.out.println();
                System.out.print("Incorrect guesses ");
                System.out.println(incorrectGuesses);
                System.out.println("Guess a letter");
                userGuess = console.nextLine();
                letterGuess = userGuess.charAt(0);
            }
            }
        

          if(gameOver == true){
              return "You WIN!!";
          } else { 
        return "Too many errors, you lose.";
          }

    }
    public static void main(String[] args) {
     System.out.println("H  H            A            N          N          GGG         M                 M            A              N          N");
     System.out.println("H  H           AA            N  N       N         G            M M             M M           AA              N  N       N ");
     System.out.println("H  H           A A           N   N      N       G              M   M          M  M           A A             N    N     N");
     System.out.println("HHHH          AAAAA          N      N   N      G    GGG        M     M      M    M          AAAAA            N      N   N");
     System.out.println("H  H         A     A         N        N N       G    G         M       M M       M         A    A            N        N N");
     System.out.println("H  H        A       A        N          N         GGG          M        M        M        A       A          N          N");
     /*Rules of the game: 
     1.To Start type in "yes". 
     2.To win the game you must guess the word in the blank slots, character by character. 
     3.You are able to get an error 6 times, if you get more than 6 errors you lose.
     4.Only type in 1 letter at a time 
     */
     Scanner console = new Scanner(System.in);
     System.out.println("Type 'yes' to hang a man.");
     String answer = console.nextLine();
        while(answer.equals("yes")){
           String win = startGame();
           System.out.println(win);

           System.out.println("Type 'yes' to hang a man.");
           answer = console.nextLine();
          
        }
       

}
    
}