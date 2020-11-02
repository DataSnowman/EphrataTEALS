// Remember to change this line if you move the file
package sampleCode.Chapter4;

import java.util.Scanner;

/**
 * Helps a user figure out if the creature they are looking at is a
 * dragon, unicorn, vampire, centaur, kraken, or elf.
 * 
 * This program uses a concept called "nesting", where if and else
 * statements appear within the body of other if and else statements,
 * like nesting dolls.
 */
public class MythicalCreatures {
	
	public static void main(String[] args) {
        // Initialize Scanner.
		Scanner console = new Scanner(System.in);

		// Intro text.
		System.out.println("Welcome to the mythical creature classifer!");
		System.out.println("Please answer the following questions to determine");
		System.out.println("which mythical creature you are looking at.\n");

		// 1. First question prompt and response.
		int answer = getUserAnswer(console, "Does the creature live in the sea?");

        // 1 means yes (true) and 0 means no (false)
		if (answer == 1) {
            // Creature lives in the sea - must be a kraken.
		    printResult("kraken");
		} else {
			// Creature lives on land. Could be a dragon, unicorn, vampire,
            // elf, or centaur.
            
			// 2. Second question prompt and response.
			answer = getUserAnswer(console, "Does the creature walk on two legs?");
			if (answer == 1) {
				// Creature walks on two legs. Could be a vampire or an elf.
                
				// 3. Third question prompt and response.
				answer = getUserAnswer(console, "Is the creature undead?");
				if (answer == 1) {
                    // Creature is undead - must be a vampire.
					printResult("vampire");
				} else {
					// Creature is not undead - must be an elf.
					printResult("elf");
				}
			} else {
				// Creature does not walk on two legs. Could be a
                // unicorn, dragon, or centaur.
                
				// 3. Third question prompt and response.
				answer = getUserAnswer(console, "Can the creature fly?");
				if (answer == 1) {
					// Creature can fly - must be a dragon.
					printResult("dragon");
				} else {
                    // Creature cannot fly - must be either a unicorn or centaur.
                    
                    // 4. Fourth question prompt and response.
                    answer = getUserAnswer(console, "Does the creature have a human face?");
                    if (answer == 1) {
                        // Creature has a human face - must be a centaur.
                        printResult("centaur");
                    } else {
                        // Creature does not have a human face - must be a unicorn.
                        printResult("unicorn");
                    }
				}
			}
        }
        
        // Close the Scanner - we don't need to read more user input.
        console.close();
	}

    // Prompt the user with a yes or no question, then return their result.
	public static int getUserAnswer(Scanner console, String question) {
        System.out.println(question);
		System.out.print("Enter 1 for yes or 0 for no: ");
		return console.nextInt();
	}

    // Print out a message for the given creature.
	public static void printResult(String creature) {
		System.out.println("Your creature is a " + creature + "!");
	}
}