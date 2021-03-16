package sampleCode.Chapter8.Encapsulation.Step5;

public class Point {
    // Private fields; prevent client code from reading or modifying
    private double x;
    private double y;

    public Point(double initX, double initY) {
        x = initX;
        y = initY;
    }

    public double distance(Point other) {
        double dx1 = other.x - x;
        double dy1 = other.y - y;
        return Math.sqrt(dx1 * dx1 + dy1 * dy1);
    }
}
