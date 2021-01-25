package sampleCode.Random;

import java.util.Random;
import java.util.Scanner;

/**
 * Illustrate generating random values in Java.
 */
public class RandomLecture {
    
    public static void main(String[] args) {
        // Math.random() --> 0.0 <= random < 1.0
        // 6-sided die: (int) (Math.random() * 6) + 1

        // Random class - easier!
        Random rand = new Random();

        rand.nextInt(); // random int between -2^31 to 2^31 - 1
        rand.nextInt(6); // random int between 0 (inclusive) to the number passed in (exclusive)
        rand.nextDouble(); // same Math.random() random double between 0 (inclusive) to 1.0 (exclusive)
        rand.nextBoolean(); // random boolean (either true or false)

        for (int i = 0; i < 100; i++) {
            // rand.nextInt(<range>) + <starting value>
            // Random grades between 60 to 100
            int randomValue = rand.nextInt(41) + 60;
            System.out.println(randomValue);
        }
    }
}
