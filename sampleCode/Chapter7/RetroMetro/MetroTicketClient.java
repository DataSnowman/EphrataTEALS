package sampleCode.Chapter7.RetroMetro;

public class MetroTicketClient {
    public static void main(String[] args) {
        System.out.println("I'm buying a 5 ride ticket.");
        MetroTicket ticket = new MetroTicket(5);

        while (ticket.hasRides()) {
            System.out.println(" . . . ");
            System.out.println("I'd like a ride on the metro!");
            System.out.println("Here's my ticket: " + ticket);
            
            System.out.println("<*** PUNCH ***>");
            ticket.punch();
        }

        System.out.println(" ~ ~ ~ ");
        System.out.println("I'm all out of rides!");
        System.out.println("Final ticket: " + ticket);
    }
}
