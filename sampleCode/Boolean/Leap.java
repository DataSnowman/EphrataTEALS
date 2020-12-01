package sampleCode.Boolean;

import java.util.Scanner;

public class Leap {

    public static void main(String[] args) {

        System.out.println("Enter a year to check if it is a Leap Year: ");

        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        System.out.println("Is a Leap Year: " + isLeapYear(year));

    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 || year % 400 == 0 && year % 100 > 0; 

        // Every year that is exactly divisible by four is a leap year
        // ... EXCEPT for years that are exactly divisible by 100
        // ... EXCEPT if they are exactly divisible by 400.

        // For example, 1600 and 2000 were leap years, but 1700, 1800, and 1900 were not leap years.

    }
    
}
