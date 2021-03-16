package sampleCode.Chapter8.Encapsulation.Step1;

// All code in `main`
public class PointClient {
    public static void main(String[] args) {
        double x1 = 0.0;
        double y1 = 0.0;
        double x2 = 5.0;
        double y2 = 12.0;
        double dx1 = x2 - x1;
        double dy1 = y2 - y1;
        double d1 = Math.sqrt(dx1 * dx1 + dy1 * dy1);
        System.out.println("Result #1 = " + d1);
        double x3 = 8.0;
        double y3 = 15.0;
        double dx2 = x3 - x1;
        double dy2 = y3 - y1;
        double d2 = Math.sqrt(dx2 * dx2 + dy2 * dy2);
        System.out.println("Result #2 = " + d2);
    }
}
