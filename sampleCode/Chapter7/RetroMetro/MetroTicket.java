package sampleCode.Chapter7.RetroMetro;

public class MetroTicket {
    private int[] rides;
    private int punches;

    // Initializes a fresh metro ticket with a given number of rides.
    public MetroTicket(int numberOfRides) {
        // Start with a fresh ticket, no punches
        punches = 0;

        // Initialize the rides [1, 2, 3, ...]
        rides = new int[numberOfRides];
        for (int i = 0; i < numberOfRides; i++) {
            rides[i] = i + 1;
        }
    }

    // Checks if we have any rides left.
    public boolean hasRides() {
        return punches < rides.length;
    }

    // Punches the next ride number on the card (if any).
    public void punch() {
        // Check first if there are still any rides left
        if (hasRides()) {
            punches++;

            // Shift all values to the left
            // e.g. [1, 2, 3] --> [2, 3, 3]
            for (int i = 0; i < rides.length - 1; i++) {
                rides[i] = rides[i + 1];
            }

            // "Punch" the extra entry by marking it as 0
            // e.g. [2, 3, 3] --> [2, 3, 0]
            rides[rides.length - punches] = 0;
        }
    }

    // Returns a string showing the ticket, with X's in place of punched numbers.
    // e.g. "[ 2 3 X ]" for a 3 ride ticket with 1 punch
    public String toString() {
        String ticket = "[";

        for (int ride : rides) {
            // A zero indicates we punched the card, use an 'X'
            if (ride == 0) {
                ticket += " X";
            } else {
                ticket += " " + ride;
            }
        }

        ticket += " ]";
        return ticket;
    }
}
