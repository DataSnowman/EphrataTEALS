package sampleCode.FinalProjects.Solitaire;

// An interactive game of solitaire.
public class Solitaire {
    private GameTable table;
    private Menu moveMenu;
    private Menu fromPileMenu;
    private Menu toPileMenu;

    // Initialize the game and menus.
    public Solitaire() {
        this.table = new GameTable();
        this.moveMenu = initMoveMenu();
        this.fromPileMenu = new Menu("From which pile?", 7);
        this.toPileMenu = new Menu("To which pile?", 7);
    }

    // Keep going until the player decides to give up.
    public void play() {
        boolean keepGoing = true;
        while (keepGoing) {
            display();
            keepGoing = nextMove();
        }

        afterGame();
    }

    private void display() {
        System.out.println("----------------------------");
        System.out.println(this.table);
        System.out.println("(1) (2) (3) (4) (5) (6) (7)");
    }

    private void afterGame() {
        if (this.table.isWinner()) {
            System.out.println("Winner!");
        } else {
            System.out.println("Better luck next time.");
        }
    }

    private boolean nextMove() {
        System.out.println(this.moveMenu.toString());

        // Ask for a new move
        int move = this.moveMenu.prompt();
        if (move == 6) {
            // Player wants to quit -- do it now.
            return false;
        }

        // Is the move actually valid?
        if (!tryMove(move)) {
            System.out.println("Sorry, that's not allowed.");
        }

        // Player didn't quit, so let the game continue.
        return true;
    }

    private boolean tryMove(int move) {
        boolean moveIsValid = true;
        if (move == 1) {
            moveIsValid = flipStock();
        } else if (move == 2) {
            moveIsValid = moveTableauPiles();
        } else if (move == 3) {
            moveIsValid = this.table.moveWasteToFoundation();
        } else if (move == 4) {
            moveIsValid = moveWasteToTableau();
        } else if (move == 5) {
            moveIsValid = moveTableauToFoundation();
        }

        return moveIsValid;
    }

    private boolean flipStock() {
        // First try flipping the actual stock
        if (this.table.flipStock()) {
            return true;
        }

        // Otherwise try resetting the stock
        return this.table.resetStock();
    }

    private boolean moveTableauPiles() {
        // Get the player's choice of piles
        int fromPile = choosePile(this.fromPileMenu);
        int toPile = choosePile(this.toPileMenu);

        if (!this.table.moveBetweenTableau(fromPile, toPile)) {
            // Move was not allowed
            return false;
        }

        // If we successfully moved, try to flip any card we uncovered.
        // (Don't worry if this fails, as the pile may be empty now.)
        this.table.flipTableau(fromPile);
        return true;
    }

    private boolean moveWasteToTableau() {
        // Get the player's choice of pile
        int toPile = choosePile(this.toPileMenu);

        return this.table.moveWasteToTableau(toPile);
    }

    private boolean moveTableauToFoundation() {
        // Get the player's choice of pile
        int fromPile = choosePile(this.fromPileMenu);

        if (!this.table.moveTableauToFoundation(fromPile)) {
            // Move was not allowed
            return false;
        }

        // If we successfully moved, try to flip any card we uncovered.
        // (Don't worry if this fails, as the pile may be empty now.)
        this.table.flipTableau(fromPile);
        return true;
    }

    private int choosePile(Menu menu) {
        System.out.println(menu);
        int pile = menu.prompt();

        // Piles are zero indexed, but player choices start at 1...
        return pile - 1;
    }

    private Menu initMoveMenu() {
        Menu menu = new Menu("What do you want to do?", 6);
        menu.addLabel(1, "Flip stock");
        menu.addLabel(2, "Move tableau piles");
        menu.addLabel(3, "Move from waste to foundation");
        menu.addLabel(4, "Move from waste to tableau");
        menu.addLabel(5, "Move from tableau to foundation");
        menu.addLabel(6, "Give up");
        return menu;
    }
}
