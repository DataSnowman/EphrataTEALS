package sampleCode.Chapter8.Point;

public class Point {
    // fields -- State
    int x;
    int y;

    // behavior -- instance methods
    public void translate(int dx, int dy) {
        x = x + dx;
        y = y + dy;
    }
}
