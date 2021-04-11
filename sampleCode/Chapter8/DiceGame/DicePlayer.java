package sampleCode.Chapter8.DiceGame;

public class DicePlayer {
    private String name;
    private Die[] dice;

    public DicePlayer(String name) {
        this.name = name;
        this.dice = new Die[5];
        for (int i = 0; i < dice.length; i++) {
            dice[i] = new Die();
        }
    }

    public String getName() {
        return name;
    }

    public Die[] getDice() {
        return dice;
    }

    public void rollDice()  {
        for (int i = 0; i < dice.length; i++) {
            dice[i].roll();
        }
    }

    public void reroll(int diePosition) {
        dice[diePosition].roll();
    }

    public int getScore() {
        int score = 0;
        for (int i  = 0; i < dice.length; i++) {
            score += dice[i].getCurrentFace();
        }
        return score;
    }

    public String toString()  {
        String result = "";
        for (int i = 0; i < dice.length; i++) {
            result += dice[i].toString() + "\n";
        }
        return result;
    }
    
}
