package sampleCode.Chapter8.Constructors;

public class MarioKartClient {

    public static void main(String[] args) {
        MarioKartGame defaultGame = new MarioKartGame();
        System.out.println(defaultGame.getTrack());

        MarioKartGame customGame = new MarioKartGame("Rainbow Road", 40, "easy");
        System.out.println(customGame.getTrack());
    }
    
}
