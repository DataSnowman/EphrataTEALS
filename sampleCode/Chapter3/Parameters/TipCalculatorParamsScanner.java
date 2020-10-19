package sampleCode.Chapter3.Parameters;

import java.util.Scanner;  // Import the Scanner class

public class TipCalculatorParamsScanner {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        // Obtain Brian's inputs

        System.out.println("Enter Brian's Money in wallet: ");
        double brianMoney = console.nextDouble();

        System.out.println("Enter Brian's Meal cost: ");
        double brianMeal = console.nextDouble();

        // Obtain Darwin's inputs

        System.out.println("Enter Darwin's Money in wallet: ");
        double darwinMoney = console.nextDouble();
        
        System.out.println("Enter Darwin's Meal cost: ");
        double darwinMeal = console.nextDouble();
        
        System.out.println("Enter Darwin's Tip %: ");
        double darwinTip = console.nextDouble();

        console.close();//write at end of code.

        // Calculate Brian's Money in Wallet
        brianMoney -= calculateTip(brianMeal);
        System.out.println("Brian has $" + brianMoney + " in his wallet");

        // Calculate Darwin's Money in Wallet
        darwinMoney -= calculateTip(darwinMeal, darwinTip);
        System.out.println("Darwin has $" + darwinMoney + " in his wallet");
    }

    // Overloaded method definition for `calculateTip`
    public static double calculateTip(double mealTotal) {
        mealTotal = mealTotal + (mealTotal * 0.10);
        return mealTotal;
    }

    public static double calculateTip(double mealTotal, double tipPercentage) {
        System.out.println("Your total without tip is $" + mealTotal);
        System.out.println("You chose to tip " + tipPercentage + "%");
        mealTotal *= 1 + (tipPercentage / 100);
        System.out.println("Your meal total is $" + mealTotal);
        return mealTotal;
    }
}