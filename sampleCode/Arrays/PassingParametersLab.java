package sampleCode.Arrays;

import java.util.Arrays;

/** Used with the Passing Parameters lab on 2020-02-24. */
public class PassingParametersLab {

    public static void main(String[] args) {
        /***** PART 1 - uncomment the lines below. *****/
        // int myNum = 23;
        // System.out.println("myNum before change: " + myNum);
        // changeNumber(myNum);
        // System.out.println("myNum after change: " + myNum);

        /***** PART 2 - uncomment the lines below. *****/
        // int[] myArray = {45, 22, -1, 4, 16};
        // System.out.println("myArray before change: " + Arrays.toString(myArray));
        // changeArray(myArray);
        // System.out.println("myArray after change: " + Arrays.toString(myArray));

        /***** PART 3 - uncomment the lines below. *****/
        // String[] myStringArray = {"hello", "world"};
        // System.out.println("myStringArray before change: " + Arrays.toString(myStringArray));
        // changeArrayReference(myStringArray);
        // System.out.println("myStringArray after change: " + Arrays.toString(myStringArray));
    }

    /** Used in PART 1. */
    public static void changeNumber(int x) {
        x = x + 100;
    }

    /** Used in PART 2. */
    public static void changeArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] + 100;
        }
    }

    /** Used in PART 3. */
    public static void changeArrayReference(String[] original) {
        String[] updated = {"something", "else"};
        original = updated;
    }
}