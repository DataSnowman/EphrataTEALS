package sampleCode.FinalProjects.Solitaire;

// An automated solitaire player.
public class SolitaireRobot {
    private GameTable table;
    private int movesSinceReset;

    // Initialize the game and the move tracking data.
    public SolitaireRobot() {
        this.table = new GameTable();
        this.movesSinceReset = 0;
    }

    // Play an entire game of solitaire.
    public void play() {
        boolean keepGoing = true;
        while (keepGoing) {
            display();
            tryAllMoves();
            keepGoing = afterAllMoves();
        }

        afterGame();
    }

    private void display() {
        System.out.println(". . . . . . . . . . . . . . .");
        System.out.println(this.table);
        System.out.println(". . . . . . . . . . . . . . .");
    }

    private void tryAllMoves() {
        // Try to make as many moves as possible until there are no more left.
        int movesThisRound = -1;
        while (movesThisRound != 0) {
            // First, try every possible single card move.
            movesThisRound = tryAllSingleMoves();

            // After we've exhausted single card moves, try
            // to move between tableau piles where possible.
            tryMoveBetweenTableau();

            this.movesSinceReset += movesThisRound;
        }
    }

    private int tryAllSingleMoves() {
        int totalMoves = 0;
        int movesThisCycle = -1;
        while (movesThisCycle != 0) {
            // Keep making single card moves until we run out.
            // This ensures we make as much progress as we can
            // before attempting to move tableau piles.
            movesThisCycle = trySingleMoves();
            totalMoves += movesThisCycle;
        }

        return totalMoves;
    }

    private int trySingleMoves() {
        int count = 0;
        for (int i = 0; i < 7; i++) {
            if (this.table.flipTableau(i)) {
                System.out.println("Flipped tableau pile " + i + ".");
                count++;
            }

            if (this.table.moveTableauToFoundation(i)) {
                System.out.println("Moved from tableau pile " + i + " to the foundation.");
                count++;
            }

            if (this.table.moveWasteToFoundation()) {
                System.out.println("Moved from waste pile to the foundation.");
                count++;
            }

            if (this.table.moveWasteToTableau(i)) {
                System.out.println("Moved from waste pile to tableau pile " + i + ".");
                count++;
            }
        }

        return count;
    }

    private void tryMoveBetweenTableau() {
        for (int from = 0; from < 7; from++) {
            tryAllTableauMoves(from);
        }
    }

    private void tryAllTableauMoves(int from) {
        for (int to = 0; to < 7; to++) {
            if (this.table.moveBetweenTableau(from, to)) {
                System.out.println("Moved from tableau pile " + from + " to " + to + ".");

                // We successfully moved, no need to try any more.
                return;
            }
        }
    }

    private boolean afterAllMoves() {
        // Try to flip cards from the stock.
        if (this.table.flipStock()) {
            System.out.println("Flipped stock.");
            return true;
        } else {
            // We have no more cards to flip, so try to reset.
            return tryReset();
        }
    }

    private boolean tryReset() {
        if (this.table.resetStock()) {
            System.out.println("Reset stock.");
        }

        System.out.println("(Made " + this.movesSinceReset + " moves since last reset.)");

        if (this.movesSinceReset == 0) {
            // Last time around we weren't able to make any moves.
            // The game must be over...
            return false;
        } else {
            // We made at least one move last time, so let's reset and go again...
            this.movesSinceReset = 0;
            return true;
        }
    }

    private void afterGame() {
        System.out.println("+----------------+");
        System.out.println("| No more moves! |");
        System.out.println("+----------------+");
        display();

        if (this.table.isWinner()) {
            System.out.println("Winner!");
        } else {
            System.out.println("Better luck next time.");
        }
    }
}
