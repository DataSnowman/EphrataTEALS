package sampleCode.Chapter8.Point;

public class Client {

    public static void main(String[] args) {

        Point p1 = new Point();
        p1.x = 3;
        p1.y = 5;
        Point p2 = new Point();
        p2.x = 12;
        p2.y = 4;

        p1.translate(-1, -2);
        p2.translate(6, 8);

    }
    
}
