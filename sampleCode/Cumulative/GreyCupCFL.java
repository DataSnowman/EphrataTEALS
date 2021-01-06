package sampleCode.Cumulative;
import java.util.Scanner;

// refer to https://en.wikipedia.org/wiki/65th_Grey_Cup

public class GreyCupCFL {

    public static void main (String[] args) {
        System.out.println("This program adds football scores by quarter.");
        System.out.println();

        Scanner scannerQuarter = new Scanner(System.in);
        System.out.print ("How many quarters do you want to add for the game?");
        int totalQuarters = scannerQuarter.nextInt();

        String team1 = "Montreal Alouettes";
        String team2 = "Edmonton Eskimos";

        sumScores(totalQuarters, team1);
        sumScores(totalQuarters, team2);
    }

    public static void sumScores(int quarters, String team){
        String teamName = team;

        //Print Team Header
        System.out.println ();
        System.out.println (teamName);
        System.out.println ();

        Scanner scannerScore = new Scanner(System.in);

        double sum = 0.0;                           // By using totalQuarters instead
        for (int j = 1;  j <= quarters;  j++) {     // of an actual number, we give
            System.out.print("#" + j + " Quarter? ");       // our program flexibility.
            double next = scannerScore.nextDouble();
            sum += next;
        }
        
        System.out.println ();
        System.out.println (team + " final score is: " + sum); 

    }
}
