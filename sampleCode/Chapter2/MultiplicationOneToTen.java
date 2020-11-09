package sampleCode.Chapter2;

import java.util.Scanner;

// This MultiplicationOneToTen class would print a multiplication table on an entered number multiplied by 1 through 10

public class MultiplicationOneToTen {

    public static void main(String[] args) {
        System.out.println("Enter a number");

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
    
        scanner.close();

        Process(number);
    }

    //This static method that does the multiplication
     
    public static void Process(int number) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + (number * i));
        }
        System.out.println("The Iteration is Complete");
    }

}