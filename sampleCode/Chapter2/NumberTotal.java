package sampleCode.Chapter2;

public class NumberTotal {
    public static void main(String[] args) {
        

    int total = 25;
        for (int number = 1; number <= (total / 2); number++) {
        total = total - number;
        System.out.println(total + " " + number);
        }
    }
}
