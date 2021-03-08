package sampleCode.Chapter8.Point;

public class Client {

    public static void main(String[] args) {

        Point p1 = new Point();
        p1.x = 3;
        p1.y = 5;

        Point p2 = new Point();
        p2.x = 12;
        p2.y = 4;

        // For p1 Subtract 1 from x and 2 from y
        // For p2 Add 6 to x and 8 to y
        p1.translate(-1, -2);
        p2.translate(6, 8);

    }

}
