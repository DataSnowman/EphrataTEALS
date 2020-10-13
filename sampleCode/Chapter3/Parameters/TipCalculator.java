package sampleCode.Chapter3.Parameters;

public class TipCalculator {
    public static void main(String[] args) {
        double mealTotal = 12.50;
        System.out.println("Your total without tip is $" + mealTotal);

        double tipPercentage = 10.0;
        System.out.println("You chose to tip " + tipPercentage + "%");

        mealTotal *= 1 + (tipPercentage / 100);
        System.out.println("Your meal total is $" + mealTotal);
    }
}
