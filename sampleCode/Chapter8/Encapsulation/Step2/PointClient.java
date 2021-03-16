package sampleCode.Chapter8.Encapsulation.Step2;

// Procedural decomposition -- remove duplication of distance formula
public class PointClient {
    public static void main(String[] args) {
        double x1 = 0.0;
        double y1 = 0.0;
        double x2 = 5.0;
        double y2 = 12.0;
        double d1 = distance(x1, y1, x2, y2);
        System.out.println("Result #1 = " + d1);
        double x3 = 8.0;
        double y3 = 15.0;
        double d2 = distance(x1, y1, x3, y3);
        System.out.println("Result #2 = " + d2);
    }

    public static double distance(double x1, double y1, double x2, double y2) {
        double dx1 = x2 - x1;
        double dy1 = y2 - y1;
        return Math.sqrt(dx1 * dx1 + dy1 * dy1);
    }
}
