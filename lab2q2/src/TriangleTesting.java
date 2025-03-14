public class TriangleTesting {
    public static void main(String[] args) {
        Point2D p1 = new Point2D(0, 0);
        Point2D p2 = new Point2D(2, 7);
        Point2D p3 = new Point2D(3, 4);

        Triangle myTriangle = new Triangle(p1, p2, p3);

        System.out.println("Perimeter: " + myTriangle.perimeter());
        System.out.println("Area: " + myTriangle.area());
    }
}
