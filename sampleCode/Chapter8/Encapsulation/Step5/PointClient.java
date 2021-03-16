package sampleCode.Chapter8.Encapsulation.Step5;

// Improve abstraction by moving all behavioral details inside Point class
public class PointClient {
    public static void main(String[] args) {
        Point p1 = new Point(0.0, 0.0);
        Point p2 = new Point(5.0, 12.0);
        double d1 = p1.distance(p2);
        System.out.println("Result #1 = " + d1);
        Point p3 = new Point(8.0, 15.0);
        double d2 = p1.distance(p3);
        System.out.println("Result #2 = " + d2);
    }
}
