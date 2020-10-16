package sampleCode.Chapter3.Parameters;

public class TipCalculatorParams {
    public static void main(String[] args) {
        double brianMoney = 23;
        brianMoney -= calculateTip(12.5);
        System.out.println("Brian has $" + brianMoney);

        double darwinMoney = 17;
        darwinMoney -= calculateTip(11.50, 15);
        System.out.println("Darwin has $" + darwinMoney);
    }

    // Overloaded method definition for `calculateTip`
    public static double calculateTip(double mealTotal) {
        return calculateTip(mealTotal, 10.0);
    }

    public static double calculateTip(double mealTotal, double tipPercentage) {
        System.out.println("Your total without tip is $" + mealTotal);
        System.out.println("You chose to tip " + tipPercentage + "%");

        mealTotal *= 1 + (tipPercentage / 100);
        System.out.println("Your meal total is $" + mealTotal);

        return mealTotal;
    }
}
