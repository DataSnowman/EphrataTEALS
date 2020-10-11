package sampleCode.Chapter3.Parameters;

public class BmiParameterCalc {
    public static void main(String[] args) {

        // declare variables
        double height;
        double weight;

        // assign variables
        height = 75;
        weight = 228;

        calcBMI(height, weight);

    }

    public static void calcBMI(double h, double w) {
            double bmi = w / (h * h) * 703;
            System.out.println("My BMI is: " + bmi);
        }
    
}
