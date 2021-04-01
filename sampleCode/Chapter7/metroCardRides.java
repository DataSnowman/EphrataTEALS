package sampleCode.Chapter7;

import java.util.Arrays;

public class metroCardRides {

    public static void main(String[] args) {

    int [] rides = {5, 4, 3, 2, 1};
    System.out.println(Arrays.toString(rides));
    
    //Check logic in main then comment out and use static method
    /*
    int first = rides[0];
    System.out.println(first);
    System.out.println(Arrays.toString(rides));

    for (int j = 0; j < rides.length - 1; j++) {
        rides[j] = rides[j + 1];
    }
    
    //rides[rides.length - 1] = first;

    int newFirst = rides[0];
    System.out.println(newFirst);
    System.out.println(Arrays.toString(rides));
    */
    }
}
