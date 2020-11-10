package sampleCode.Chapter2;

import java.util.Scanner;

public class NestedMultiplication {
    public static void main(String[] args) {
        // We want to print out a multiplication table, like so:
        //          col 1   col 2      col 3   ...
        // row 1:  1       2       3       4       5
        // row 2:  2       4       6       8       10
        // row 3:  3       6       9       12      15
        //
        //     . . . and so on . . .
        //
        // Let's use nested loops!

        Scanner console = new Scanner(System.in);
        System.out.print("Enter the number: ");

        int size = console.nextInt();

        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size; col++) {
                int product = row * col;
                System.out.print(product + "\t");
            }

            System.out.println();
        }
    }
}
