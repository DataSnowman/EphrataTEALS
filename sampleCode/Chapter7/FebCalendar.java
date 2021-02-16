package sampleCode.Chapter7;

// Print a simple calendar for the month of Feb 2021 two different ways.
// (Note: The ISO standard uses Monday as the start of the week; see
// https://en.wikipedia.org/wiki/ISO_week_date .)
public class FebCalendar {
    public static void main(String[] args) {
        showCalendar1();

        System.out.println();

        showCalendar2();
    }

    // Uses nested for loops.
    public static void showCalendar1() {
        String[] days = { "Mo", "Tu", "We", "Th", "Fr", "Sa", "Su" };

        System.out.println("\t\tFeb 2021");

        // Loop through all the weeks (for)
        for (int w = 0; w < 4; w++) {
            // Loop through all the days (for)
            for (int d = 0; d < 7; d++) {
                // Calculate the date based on the week and day number.
                int date = (7 * w) + d + 1;
                String day = days[d];
                System.out.print(day + " " + date + "\t");
            }

            // Finish the week, move to the next line.
            System.out.println();
        }
    }

    // Uses a for loop with a nested for-each loop.
    public static void showCalendar2() {
        String[] days = { "Mo", "Tu", "We", "Th", "Fr", "Sa", "Su" };
        int date = 0;

        System.out.println("\t\tFeb 2021");

        // Loop through all the weeks (for)
        for (int w = 0; w < 4; w++) {
            // Loop through all the days (for-each)
            for (String day : days) {
                // Calculate the date with a simple running count.
                date++;
                System.out.print(day + " " + date + "\t");
            }

            // Finish the week, move to the next line.
            System.out.println();
        }
    }
}
