package sampleCode.Chapter3.Scanner;

import java.util.Scanner;  // Import the Scanner class

public class TipCalculatorParamsScanner {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        // Prompt for total money
        System.out.println("Enter Brian's Money in wallet: ");
        double brianMoney = console.nextDouble();

        // Prompt for meal cost
        System.out.println("Enter Brian's Meal cost: ");
        double brianMeal = console.nextDouble();

        // Calculate the tip and show money left
        brianMoney -= calculateTip(brianMeal);
        System.out.println("Brian has $" + brianMoney + " in his wallet");

        console.close();//write at end of code.
    }

    // Overloaded method definition for `calculateTip`
    public static double calculateTip(double mealTotal) {
        return calculateTip(mealTotal, 10.0); // assume 10%
    }

    public static double calculateTip(double mealTotal, double tipPercentage) {
        System.out.println("Your total without tip is $" + mealTotal);
        System.out.println("You chose to tip " + tipPercentage + "%");
        mealTotal *= 1 + (tipPercentage / 100);
        System.out.println("Your meal total is $" + mealTotal);
        return mealTotal;
    }
}
