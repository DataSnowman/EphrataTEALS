package sampleCode.Chapter7;

import java.util.Arrays;

public class metroCardRidesStatic {

    public static void main(String[] args) {

    int [] rides = {5, 4, 3, 2, 1};
    firstToLast(rides);
    System.out.println(Arrays.toString(rides));
    //lastToFirstRight(rides);
    //System.out.println(Arrays.toString(rides));
}

    public static void firstToLast (int[] metroCardRides) {
        int first = metroCardRides[0];
        for (int j = 0; j < metroCardRides.length - 1; j++) {
            metroCardRides[j] = metroCardRides[j + 1];
        }
        //metroCardRides[metroCardRides.length - 1] = 0;
        metroCardRides[metroCardRides.length - 1] = first;
    }

    public static void lastToFirstRight (int[] metroCardRides) {
        int last = metroCardRides[metroCardRides.length - 1];
        for (int j = metroCardRides.length - 1; j >= 1; j--) {
            metroCardRides[j] = metroCardRides[j - 1];
        }
        metroCardRides[0] = last;
    }

}
