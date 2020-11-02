package sampleCode.Chapter3.Scanner;

import java.util.Scanner;  // Import the Scanner class

public class TipCalculatorParamsScanner {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        // Prompt for meal cost
        System.out.print("Enter Brian's Meal cost: ");
        double brianMeal = console.nextDouble();

        // Prompt for tip %
        System.out.print("Enter Brian's tip %: ");
        int brianTipPercentage = console.nextInt();

        // Calculate the tip
        double totalWithTip = calculateTip(brianMeal, brianTipPercentage);
        System.out.println("Brian will pay $" + totalWithTip + " including tip");
    }
    
    public static double calculateTip(double mealTotal, double tipPercentage) {
        mealTotal *= 1 + (tipPercentage / 100);
        return mealTotal;
    }
}
