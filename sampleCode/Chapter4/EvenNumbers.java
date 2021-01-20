package sampleCode.Chapter4;

import java.util.Scanner;

public class EvenNumbers {
    
    public static void main(String[] args){

        System.out.print("Type a number: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        if (number%2 == 0){
            System.out.println("even");
        }
        else {
            System.out.println("odd");
        }
    }
}