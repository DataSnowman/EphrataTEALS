package sampleCode.Chapter8.Encapsulation.Step4;

// Simplify data initialization with constructor
public class PointClient {
    public static void main(String[] args) {
        Point p1 = new Point(0.0, 0.0);
        Point p2 = new Point(5.0, 12.0);
        double d1 = distance(p1, p2);
        System.out.println("Result #1 = " + d1);
        Point p3 = new Point(8.0, 15.0);
        double d2 = distance(p1, p3);
        System.out.println("Result #2 = " + d2);
    }

    public static double distance(Point p1, Point p2) {
        double dx1 = p2.x - p1.x;
        double dy1 = p2.y - p1.y;
        return Math.sqrt(dx1 * dx1 + dy1 * dy1);
    }
}
