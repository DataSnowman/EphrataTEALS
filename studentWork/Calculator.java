package studentWork;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        // Read the ‘x’ value
        System.out.print("x=");
        double xValue = console.nextDouble();

        // Read the ‘y’ value
        System.out.print("y=");
        double yValue = console.nextDouble();

        // Use the ‘multNumbers’ method to find the product of x and y
	
        double product = multNumbers(xValue, yValue);

        System.out.println("The product is " + product);
    }

    // ‘multNumbers’ takes two decimal numbers and returns the product
    public static double multNumbers(double x, double y) {
		return x * y;
    }

}
