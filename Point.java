import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/*
* class for storing the points
 */
public class Point implements Comparable<Point> {
    int x;
    int y;

    Point () {}

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * implements my own compare method
     */
    @Override
    public int compareTo(Point object) {
        if (this.x == object.x)
            return Integer.compare(this.y, object.y);
        else
            return Integer.compare(this.x, object.x);
    }

    private static int findNumberOfRectangles(List<Point> input) {
        int numberOfRectangles = 0;
        // this treeset contains the input
        TreeSet<Point> points = new TreeSet<>(input);

        // iterating over input
        for (Point pair : input) {
            for (Point value : input) {
                // if points are different
                if (pair.x != value.x && pair.y != value.y) {
                    final Point point1 = new Point(pair.x, value.y);
                    final Point point2 = new Point(value.x, pair.y);
                    // check if set contains that points and increment the result
                    if (points.contains(point1) && points.contains(point2)) {
                        numberOfRectangles++;
                    }
                }
            }
        }
        // here we have to divide by 4
        return numberOfRectangles / 4;
    }

    public static void main(String[] args) {
        // create the input list with points
        List<Point> points = Arrays.asList(new Point(1, 1), new Point(1, 3), new Point(2, 1),
                new Point(2, 3), new Point(3, 1), new Point(3, 3));

        // return the result and display it
        System.out.print(findNumberOfRectangles(points));
    }
}