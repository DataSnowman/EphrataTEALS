package sampleCode.FinalProjects.Solitaire;

// The main executable class of the Solitaire game.
public class Game {
    public static void main(String[] args) {
        showTitle();
        if (promptPlayer()) {
            // Let the human play!
            Solitaire solitaire = new Solitaire();
            solitaire.play();
        } else {
            // Watch the computer play solitaire!
            SolitaireRobot robot = new SolitaireRobot();
            robot.play();
        }
    }

    private static void showTitle() {
        System.out.println(".........................................");
        System.out.println("::::::::::::    Solitaire    ::::::::::::");
        System.out.println("............ by Brian Rogers ............");
        System.out.println(":::::::::::::::::::::::::::::::::::::::::.");
    }

    private static boolean promptPlayer() {
        Menu menu = new Menu("Who is playing?", 2);
        menu.addLabel(1, "Human");
        menu.addLabel(2, "Computer");
        
        System.out.println(menu);
        return menu.prompt() == 1;
    }
}
