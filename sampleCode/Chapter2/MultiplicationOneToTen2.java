package sampleCode.Chapter2;

import java.util.Scanner;

public class MultiplicationOneToTen2 {

    public static void main(String[] args) {

        Process();
    }

//This static method that does he multiplication
 
    public static void Process() {
        
        System.out.println("Enter a number");

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        scanner.close();

        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + (number * i));
        }
        System.out.println("The Iteration is Complete");
    }
    
}
