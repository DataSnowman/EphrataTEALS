package sampleCode.Cumulative;
import java.util.Scanner;

public class ProcessingNumbers {

    public static void main (String[] args) {
        System.out.println("This program allows the user to enter a bunch of integers and then:");
        System.out.println("0) Prints sum of integers entered");    //Calculate with sumall Method
        System.out.println("1) Prints smallest and largest integers entered");   //Calculate with minMax Method
        System.out.println("2) Prints sum of all even integers entered");    //Calculate with sumEven Method
        System.out.println("3) Prints largest odd integers entered");     //Calculate with largestOdd Method
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.print ("How many numbers do you want to enter?");
        int totalNumbers = scanner.nextInt();

        sumAll(totalNumbers);
        //minMax(totalNumbers);
        //sumEven(totalNumbers);
        //largestOdd(totalNumbers);
    }

    // Write with sumall Method
    public static void sumAll(int totalNumbers){

        Scanner scannerSum = new Scanner(System.in);
        int sum = 0;                                        // By using totalNumber instead
        for (int j = 1;  j <= totalNumbers;  j++) {         // of an actual number, we give
            System.out.print("#" + j + "? ");               // our program flexibility.
            int next = scannerSum.nextInt();
            sum += next;
        }

        System.out.println ();
        System.out.println ("Your numbers add to " + sum); 
    }

    //Group1 Write minMax Method





    //Group2 sumEven Method





    //Group3 largestOdd Method




    
}
