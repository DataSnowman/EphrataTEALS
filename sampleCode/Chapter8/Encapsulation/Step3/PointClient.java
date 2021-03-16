package sampleCode.Chapter8.Encapsulation.Step3;

// Initial OO model for Point -- data only
public class PointClient {
    public static void main(String[] args) {
        Point p1 = new Point();
        p1.x = 0.0;
        p1.y = 0.0;
        Point p2 = new Point();
        p2.x = 5.0;
        p2.y = 12.0;
        double d1 = distance(p1, p2);
        System.out.println("Result #1 = " + d1);
        Point p3 = new Point();
        p3.x = 8.0;
        p3.y = 15.0;
        double d2 = distance(p1, p3);
        System.out.println("Result #2 = " + d2);
    }

    public static double distance(Point p1, Point p2) {
        double dx1 = p2.x - p1.x;
        double dy1 = p2.y - p1.y;
        return Math.sqrt(dx1 * dx1 + dy1 * dy1);
    }
}
