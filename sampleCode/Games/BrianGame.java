// YAHTZEE programmed by Brian Rogers.
// For rules, see `printHelp`.
import java.util.Scanner;

public class BrianGame {
    // Prints the help screen, explaining the rules of the game.
    public static void printHelp() {
        System.out.println("OBJECT");
        System.out.println("Get the highest possible score in 13 rounds.");
        System.out.println();
        System.out.println("GAME PLAY");
        System.out.println("Each round starts by rolling 5 dice.");
        System.out.println("Choose which dice to reroll; you may roll up to two more times.");
        System.out.println("At the end of the round, record your score in one of the free combinations.");
        System.out.println();
        System.out.println("SCORING");
        System.out.println("There are 13 scoring combinations, divided into 'upper' and 'lower' sections.");
        System.out.println();
        System.out.println("  UPPER SECTION");
        System.out.println("    Aces    total all 1's in your roll");
        System.out.println("    Twos    total all 2's in your roll");
        System.out.println("    Threes  total all 3's in your roll");
        System.out.println("    Fours   total all 4's in your roll");
        System.out.println("    Fives   total all 5's in your roll");
        System.out.println("    Sixes   total all 6's in your roll");
        System.out.println("* If the sum of the upper section is 63 or higher, score a 35 point bonus!");
        System.out.println();
        System.out.println("  LOWER SECTION");
        System.out.println("    3 of a kind     3 of the same die; total all dice");
        System.out.println("    4 of a kind     4 of the same die; total all dice");
        System.out.println("    Full House      3 of the same die plus another pair; 25 points");
        System.out.println("    Small Straight  4 consecutive numbers; 30 points");
        System.out.println("    Large Straight  5 consecutive numbers; 40 points");
        System.out.println("    Yahtzee         5 of the same die; 50 points");
        System.out.println("    Chance          no specific combination; total all dice");
        System.out.println("* For each Yahtzee you roll after the first, score a 100 point bonus!");
    }

    // Entry point
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        runIntro(console);
        int finalScore = playGame(console);
        System.out.println("Great game! Your final score was " + finalScore + ".");
        console.close();
    }

    // Prints the title screen and optionally the help screen
    public static void runIntro(Scanner console) {
        System.out.println("_      _  __   __  __  ______ _____ _____ _____");
        System.out.println("\\\\    // //\\\\  ||  ||    ||      // ||    ||");
        System.out.println(" \\\\__// //__\\\\ ||__||    ||     //  ||__  ||__");
        System.out.println("   ||   ||  || ||  ||    ||    //   ||    ||");
        System.out.println("   ||   ||  || ||  ||    ||   //___ ||___ ||___");
        System.out.println();
        if (promptYesNo(console, "Do you want help?")) {
            printHelp();
        }
    }

    // Ask the user for a yes/no answer ("y" or "n") and return it as a boolean
    // ("y" -> true).
    // We use an infinite loop here to ensure we never return until the input is
    // found!
    public static boolean promptYesNo(Scanner console, String text) {
        while (true) {
            System.out.print(text + " (y/n) ");
            String response = console.next();
            if (response.equals("y")) {
                return true;
            } else if (response.equals("n")) {
                return false;
            }
        }
    }

    // Main game logic goes here; returns the grand total score at the end.
    public static int playGame(Scanner console) {
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        System.out.println("Let's play Yahtzee!");

        // Upper section scoring combinations (-1 means free/not recorded)
        int up1 = -1;
        int up2 = -1;
        int up3 = -1;
        int up4 = -1;
        int up5 = -1;
        int up6 = -1;

        // Lower section scoring combinations (-1 means free/not recorded)
        int lw3 = -1;
        int lw4 = -1;
        int lwFull = -1;
        int lwSmall = -1;
        int lwLarge = -1;
        int lwYahtzee = -1;
        int lwChance = -1;

        int lwBonus = 0;

        int grandTotal = 0;

        for (int i = 1; i <= 13; i++) {
            System.out.println("ROUND " + i + " . . . ");

            // Get the initial dice roll
            int d1 = rollDie(0);
            int d2 = rollDie(0);
            int d3 = rollDie(0);
            int d4 = rollDie(0);
            int d5 = rollDie(0);
            printDice(d1, d2, d3, d4, d5);

            // Do rerolls if the player wants
            int rerollsLeft = 2;
            while (rerollsLeft > 0) {
                if (promptYesNo(console, "Do you want to reroll?")) {
                    int dice = promptInt(console, "Which dice? (e.g. 135 to reroll #1, #3, and #5)", 0, 54321);

                    // Reset any die to be rerolled (each digit of the input specifies a die).
                    while (dice > 0) {
                        int die = dice % 10;
                        dice /= 10;
                        if (die == 1) {
                            d1 = 0;
                        } else if (die == 2) {
                            d2 = 0;
                        } else if (die == 3) {
                            d3 = 0;
                        } else if (die == 4) {
                            d4 = 0;
                        } else if (die == 5) {
                            d5 = 0;
                        }
                    }

                    System.out.println(". . . Rerolling . . .");
                    rerollsLeft--;
                    d1 = rollDie(d1);
                    d2 = rollDie(d2);
                    d3 = rollDie(d3);
                    d4 = rollDie(d4);
                    d5 = rollDie(d5);

                    printDice(d1, d2, d3, d4, d5);
                } else {
                    rerollsLeft = 0;
                }
            }

            // Display the options and record the user's chosen scoring combination.
            printScoringOption('a', "Aces", up1);
            printScoringOption('d', "Fours", up4);
            printScoringOption('g', "3 of a kind", lw3);
            printScoringOption('j', "Sm. Straight", lwSmall);
            System.out.println();
            printScoringOption('b', "Twos", up2);
            printScoringOption('e', "Fives", up5);
            printScoringOption('h', "4 of a kind", lw4);
            printScoringOption('k', "Lg. Straight", lwLarge);
            System.out.println();
            printScoringOption('c', "Threes", up3);
            printScoringOption('f', "Sixes", up6);
            printScoringOption('i', "Full House", lwFull);
            printScoringOption('l', "Yahtzee", lwYahtzee);
            System.out.println();
            printEmptyScoringOption();
            printEmptyScoringOption();
            printEmptyScoringOption();
            printScoringOption('m', "Chance", lwChance);
            System.out.println();

            char combo = ' ';
            while (combo == ' ') {
                combo = promptChar(console, "Enter a scoring combination.", 'a', 'm');
                if (combo == 'a') {
                    if (up1 < 0) {
                        up1 = scoreUpper(1, d1, d2, d3, d4, d5);
                    } else {
                        combo = printAlreadyScored("Aces");
                    }
                } else if (combo == 'b') {
                    if (up2 < 0) {
                        up2 = scoreUpper(2, d1, d2, d3, d4, d5);
                    } else {
                        combo = printAlreadyScored("Twos");
                    }
                } else if (combo == 'c') {
                    if (up3 < 0) {
                        up3 = scoreUpper(3, d1, d2, d3, d4, d5);
                    } else {
                        combo = printAlreadyScored("Threes");
                    }
                } else if (combo == 'd') {
                    if (up4 < 0) {
                        up4 = scoreUpper(4, d1, d2, d3, d4, d5);
                    } else {
                        combo = printAlreadyScored("Fours");
                    }
                } else if (combo == 'e') {
                    if (up5 < 0) {
                        up5 = scoreUpper(5, d1, d2, d3, d4, d5);
                    } else {
                        combo = printAlreadyScored("Fives");
                    }
                } else if (combo == 'f') {
                    if (up6 < 0) {
                        up6 = scoreUpper(6, d1, d2, d3, d4, d5);
                    } else {
                        combo = printAlreadyScored("Sixes");
                    }
                } else if (combo == 'g') {
                    if (lw3 < 0) {
                        lw3 = scoreKind(3, d1, d2, d3, d4, d5);
                    } else {
                        combo = printAlreadyScored("3 of a kind");
                    }
                } else if (combo == 'h') {
                    if (lw4 < 0) {
                        lw4 = scoreKind(4, d1, d2, d3, d4, d5);
                    } else {
                        combo = printAlreadyScored("4 of a kind");
                    }
                } else if (combo == 'i') {
                    if (lwFull < 0) {
                        lwFull = scoreFull(d1, d2, d3, d4, d5);
                    } else {
                        combo = printAlreadyScored("Full House");
                    }
                } else if (combo == 'j') {
                    if (lwSmall < 0) {
                        lwSmall = scoreStraight(4, d1, d2, d3, d4, d5);
                    } else {
                        combo = printAlreadyScored("Small Straight");
                    }
                } else if (combo == 'k') {
                    if (lwLarge < 0) {
                        lwLarge = scoreStraight(5, d1, d2, d3, d4, d5);
                    } else {
                        combo = printAlreadyScored("Large Straight");
                    }
                } else if (combo == 'l') {
                    if (lwYahtzee < 0) {
                        lwYahtzee = scoreYahtzee(d1, d2, d3, d4, d5);
                    } else {
                        combo = printAlreadyScored("Yahtzee");
                    }
                } else {
                    if (lwChance < 0) {
                        lwChance = scoreChance(d1, d2, d3, d4, d5);
                    } else {
                        combo = printAlreadyScored("Chance");
                    }
                }

                // If we're not already scoring a Yahtzee, let's also calculate the Yahtzee
                // bonus. The player must already have a Yahtzee to get the bonus.
                if (combo != 'l' && lwYahtzee > 0 && scoreYahtzee(d1, d2, d3, d4, d5) > 0) {
                    lwBonus += 100;
                }
            }

            // Display the scoring table
            grandTotal = 0;
            printSeparator('=');
            grandTotal += printUpperSection(up1, up2, up3, up4, up5, up6);
            printSeparator('-');
            grandTotal += printLowerSection(lw3, lw4, lwFull, lwSmall, lwLarge, lwYahtzee, lwChance, lwBonus);
            printSeparator('-');
            printScoreRow("GRAND TOTAL", grandTotal);
            printSeparator('=');
        }

        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        return grandTotal;
    }

    // Prints a scoring menu option. The option will not
    // appear if the combination was already filled.
    public static void printScoringOption(char letter, String name, int score) {
        String option;
        if (score < 0) {
            // Option is available
            option = letter + "=" + name;
        } else {
            // Already taken... display a blank space here instead
            option = "";
        }

        padRight(option, 15);
        System.out.print("| ");
    }

    // Prints an empty scoring menu option.
    public static void printEmptyScoringOption() {
        // Passing these inputs will guarantee an empty option.
        printScoringOption(' ', "", 0);
    }

    // Returns the dice score for a Chance.
    public static int scoreChance(int d1, int d2, int d3, int d4, int d5) {
        // Any die roll is a Chance! Just add them up.
        return d1 + d2 + d3 + d4 + d5;
    }

    // Returns the score for a Yahtzee.
    public static int scoreYahtzee(int d1, int d2, int d3, int d4, int d5) {
        // All die numbers must be equal for a valid Yahtzee.
        if (d1 == d2 && d2 == d3 && d3 == d4 && d4 == d5) {
            return 50;
        } else {
            return 0;
        }
    }

    // Returns the dice score for the specified upper combination value
    // (Aces - Sixes).
    public static int scoreUpper(int value, int d1, int d2, int d3, int d4, int d5) {
        int score = 0;
        if (d1 == value) {
            score += value;
        }

        if (d2 == value) {
            score += value;
        }

        if (d3 == value) {
            score += value;
        }

        if (d4 == value) {
            score += value;
        }

        if (d5 == value) {
            score += value;
        }

        return score;
    }

    // Packs the die numbers into a single 5 digit integer.
    // This makes them convenient to work with in a single loop.
    public static int packDice(int d1, int d2, int d3, int d4, int d5) {
        return (d1 * 10000) + (d2 * 1000) + (d3 * 100) + (d4 * 10) + d5;
    }

    // Returns the dice score for a "k of a kind" combination.
    public static int scoreKind(int k, int d1, int d2, int d3, int d4, int d5) {
        int dice = packDice(d1, d2, d3, d4, d5);
        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int sum = 0;

        // Now we actually make sure that there is a "k of a kind" in these dice
        boolean foundK = false;
        while (dice > 0) {
            int d = dice % 10;
            dice /= 10;
            sum += d;
            if (d == 1) {
                n1++;
                if (n1 == k) {
                    foundK = true;
                }
            } else if (d == 2) {
                n2++;
                if (n2 == k) {
                    foundK = true;
                }
            } else if (d == 3) {
                n3++;
                if (n3 == k) {
                    foundK = true;
                }
            } else if (d == 4) {
                n4++;
                if (n4 == k) {
                    foundK = true;
                }
            } else if (d == 5) {
                n5++;
                if (n5 == k) {
                    foundK = true;
                }
            } else if (d == 6) {
                n6++;
                if (n6 == k) {
                    foundK = true;
                }
            }
        }

        if (foundK) {
            // We found a "k of a kind"
            return sum;
        } else {
            // Otherwise, no points!
            return 0;
        }
    }

    // Returns the score for a full house combination.
    public static int scoreFull(int d1, int d2, int d3, int d4, int d5) {
        int dice = packDice(d1, d2, d3, d4, d5);
        int dx = 0;
        int dy = 0;
        int nx = 0;
        int ny = 0;

        // A full house should have only two die numbers (call them `dx` and `dy`)
        // in total. Loop through and make sure we have only these two, and count
        // them for later (`nx` and `ny`).
        while (dice > 0) {
            int d = dice % 10;
            dice /= 10;
            if (dx == 0) {
                // This must be the first iteration; save the die number for later.
                dx = d;
                nx = 1;
            } else if (dx == d) {
                // We found `dx` again!
                nx++;
            } else if (dy == 0) {
                // We found a die number different from `dx`; save this as `dy`.
                dy = d;
                ny = 1;
            } else if (dy == d) {
                // We found `dy` again!
                ny++;
            } else {
                // If we got here, we can't possibly have a full house -- there must be
                // at least 3 different numbers in this die roll.
                return 0;
            }
        }

        if (nx * ny == 6) {
            // This will only happen if we have a count of (2, 3) or (3, 2),
            // i.e. a true full house.
            return 25;
        } else {
            // We must have had (4, 1) or (1, 4)... not a full house!
            return 0;
        }
    }

    // Returns the score for a straight of n (= 4 or 5).
    public static int scoreStraight(int n, int d1, int d2, int d3, int d4, int d5) {
        int dice = packDice(d1, d2, d3, d4, d5);
        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;

        // Instead of returning an exact count of each die number, we will record a 1
        // if we see any of that die number.
        while (dice > 0) {
            int d = dice % 10;
            dice /= 10;
            if (d == 1) {
                n1 = 1;
            } else if (d == 2) {
                n2 = 1;
            } else if (d == 3) {
                n3 = 1;
            } else if (d == 4) {
                n4 = 1;
            } else if (d == 5) {
                n5 = 1;
            } else if (d == 6) {
                n6 = 1;
            }
        }

        if (n == 4) {
            // There are only 3 possible small straights...

            // {1,2,3,4}
            int s1 = n1 * n2 * n3 * n4;

            // {2,3,4,5}
            int s2 = n2 * n3 * n4 * n5;

            // {3,4,5,6}
            int s3 = n3 * n4 * n5 * n6;

            // At least one of these products must be nonzero if we have a valid straight,
            // which means their sum CANNOT be zero in that case.
            if (s1 + s2 + s3 > 0) {
                // Success!
                return 30;
            } else {
                // Better luck next time...
                return 0;
            }
        } else {
            // Using similar logic as above, determine if we have a large straight.
            int s1 = n1 * n2 * n3 * n4 * n5;
            int s2 = n2 * n3 * n4 * n5 * n6;
            if (s1 + s2 > 0) {
                // Success!
                return 40;
            } else {
                // Better luck next time...
                return 0;
            }
        }
    }

    // Prints an error message if the scoring combination is already taken.
    // Returns a space char for the calling code's convenience.
    public static char printAlreadyScored(String combination) {
        System.out.println("You've already recorded a score for " + combination + ".");
        return ' ';
    }

    // Ask the user for an integer between `low` and `high` and return it.
    // We use an infinite loop here to ensure we never return until the input is
    // found!
    public static int promptInt(Scanner console, String text, int low, int high) {
        while (true) {
            System.out.print(text + " ");
            int i = console.nextInt();
            if (i >= low) {
                if (i <= high) {
                    return i;
                }
            }
        }
    }

    // Ask the user for a character between `first` and `last` and return it.
    // We use an infinite loop here to ensure we never return until the input is
    // found!
    public static char promptChar(Scanner console, String text, char first, char last) {
        while (true) {
            System.out.print(text + " (" + first + "-" + last + ") ");

            // Scanner doesn't have nextChar...
            char c = console.next().charAt(0);

            // In Java, characters are really treated as numbers and specified in
            // their sort order (A-Z) so these comparisons work as you would expect.
            if (c >= first) {
                if (c <= last) {
                    return c;
                }
            }
        }
    }

    // Returns a random die roll, but only if d > 0.
    // Otherwise, it returns d unchanged.
    public static int rollDie(int d) {
        if (d != 0) {
            return d;
        }

        return 1 + (int) (Math.random() * 6);
    }

    // Prints the user's dice values, numbered for convenience.
    public static void printDice(int d1, int d2, int d3, int d4, int d5) {
        System.out.println("  #1      #2      #3      #4      #5");
        printDiceTop(d1, d2, d3, d4, d5);
        printDiceMiddle(d1, d2, d3, d4, d5);
        printDiceBottom(d1, d2, d3, d4, d5);
    }

    // Prints the top line of the dice output.
    public static void printDiceTop(int d1, int d2, int d3, int d4, int d5) {
        printDieTop(d1);
        printDieTop(d2);
        printDieTop(d3);
        printDieTop(d4);
        printDieTop(d5);
        System.out.println();
    }

    // Prints the top block of output for a single die.
    public static void printDieTop(int d) {
        String output = "[ ";
        if (d < 2) {
            output += "   ";
        } else if (d < 4) {
            output += "o  ";
        } else {
            output += "o o";
        }

        System.out.print(output + " ] ");
    }

    // Prints the middle line of the dice output.
    public static void printDiceMiddle(int d1, int d2, int d3, int d4, int d5) {
        printDieMiddle(d1);
        printDieMiddle(d2);
        printDieMiddle(d3);
        printDieMiddle(d4);
        printDieMiddle(d5);
        System.out.println();
    }

    // Prints the middle block of output for a single die.
    public static void printDieMiddle(int d) {
        String output = "[ ";
        if (d % 2 == 1) {
            output += " o ";
        } else if (d == 6) {
            output += "o o";
        } else {
            output += "   ";
        }

        System.out.print(output + " ] ");
    }

    // Prints the bottom line of the dice output.
    public static void printDiceBottom(int d1, int d2, int d3, int d4, int d5) {
        printDieBottom(d1);
        printDieBottom(d2);
        printDieBottom(d3);
        printDieBottom(d4);
        printDieBottom(d5);
        System.out.println();
    }

    // Prints the bottom block of output for a single die.
    public static void printDieBottom(int d) {
        String output = "[ ";
        if (d > 3) {
            output += "o o";
        } else if (d > 1) {
            output += "  o";
        } else {
            output += "   ";
        }

        System.out.print(output + " ] ");
    }

    // Prints a separator row for the scoring table, using the given symbol.
    public static void printSeparator(char symbol) {
        System.out.print("| ");
        for (int i = 0; i < 13; i++) {
            System.out.print(symbol);
        }

        System.out.print(" | ");
        for (int i = 0; i < 5; i++) {
            System.out.print(symbol);
        }

        System.out.println(" |");
    }

    // Prints a numeric row for the scoring table, using the given name and value.
    // A value < 0 indicates an unfilled entry. Returns the score value if positive,
    // 0 otherwise.
    public static int printScoreRow(String name, int value) {
        String str = "";
        if (value >= 0) {
            str += value;
        } else {
            value = 0;
        }

        printRow(name, str);
        return value;
    }

    // Prints a generic two-column row for the scoring table.
    public static void printRow(String col1, String col2) {
        System.out.print("| ");
        padRight(col1, 13);
        System.out.print(" | ");
        padLeft(col2, 5);
        System.out.println(" |");
    }

    // Pads the String value to the given width by printing spaces on the right
    // side; e.g., the value "Hello" with width 8 would print "Hello   " with
    // 3 spaces on the right.
    public static void padRight(String value, int width) {
        System.out.print(value);
        pad(value, width);
    }

    // Pads the String value to the given width by printing spaces on the left
    // side; e.g., the value "Hello" with width 8 would print "   Hello" with
    // 3 spaces on the left.
    public static void padLeft(String value, int width) {
        pad(value, width);
        System.out.print(value);
    }

    // This is a helper method for the other `pad...` methods.
    public static void pad(String value, int width) {
        for (int i = width - value.length(); i > 0; i--) {
            System.out.print(' ');
        }
    }

    // Prints the upper section of the scoring table.
    public static int printUpperSection(int up1, int up2, int up3, int up4, int up5, int up6) {
        int total = 0;
        total += printScoreRow("Aces", up1);
        total += printScoreRow("Twos", up2);
        total += printScoreRow("Threes", up3);
        total += printScoreRow("Fours", up4);
        total += printScoreRow("Fives", up5);
        total += printScoreRow("Sixes", up6);

        int upBonus = 0;
        if (total >= 63) {
            upBonus = 35;
        }

        total += printScoreRow("BONUS", upBonus);
        return total;
    }

    // Prints the lower section of the scoring table.
    public static int printLowerSection(int lw3, int lw4, int lwFull, int lwSmall, int lwLarge, int lwYahtzee,
            int lwChance, int lowBonus) {
        int total = 0;
        total += printScoreRow("3 of a kind", lw3);
        total += printScoreRow("4 of a kind", lw4);
        total += printScoreRow("Full House", lwFull);
        total += printScoreRow("Sm. Straight", lwSmall);
        total += printScoreRow("Lg. Straight", lwLarge);
        total += printScoreRow("YAHTZEE", lwYahtzee);
        total += printScoreRow("Chance", lwChance);
        total += printScoreRow("YAHTZEE BONUS", lowBonus);

        return total;
    }
}
