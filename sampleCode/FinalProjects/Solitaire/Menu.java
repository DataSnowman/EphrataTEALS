package sampleCode.FinalProjects.Solitaire;

import java.util.*;

// A basic menu of choices numbered 1 to N.
public class Menu {
    private String title;
    private String[] labels;

    // Initialize menu with number of choices.
    public Menu(String title, int choices) {
        this.title = title;
        this.labels = new String[choices];
    }

    // Add a label for a numbered choice.
    public void addLabel(int choice, String label) {
        this.labels[choice - 1] = label;
    }

    // Prompt the user for their choice.
    public int prompt() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice < 1 || choice > this.labels.length) {
            choice = promptChoice(scanner);
        }

        return choice;
    }

    private int promptChoice(Scanner scanner) {
        System.out.print("Your choice (1-" + this.labels.length + "): ");
        if (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                // Throw away this invalid input
                scanner.nextLine();
            }
        }

        // Choice was not valid.
        return 0;
    }

    // Display the menu and labeled choices.
    public String toString() {
        String rows = this.title;
        for (int i = 0; i < this.labels.length; i++) {
            int c = i + 1;
            String label = this.labels[i];
            if (label != null) {
                rows += "\n[" + c + "] " + label;
            }
        }

        return rows;
    }
}
