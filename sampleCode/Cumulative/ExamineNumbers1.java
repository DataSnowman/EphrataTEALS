package sampleCode.Cumulative;

import java.util.Scanner;

public class ExamineNumbers1 {

    public static void main (String[] args) {
        System.out.println("This program adds your numbers.");
        System.out.println();
    
        Scanner scanner = new Scanner(System.in);
        System.out.print ("How many numbers do you want to add?");
        int totalNumber = scanner.nextInt();

        double sum = 0.0;                               // By using totalNumber instead
        for (int j = 1;  j <= totalNumber;  j++) {         // of an actual number, we give
                System.out.print("#" + j + "? ");       // our program flexibility.
                double next = scanner.nextDouble();
                sum += next;
        }

            System.out.println ();
            System.out.println ("Your numbers add to " + sum); 

    }
}
