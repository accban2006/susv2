import javax.swing.*;
import java.awt.*;

public class TriangleDrawer extends JPanel {
    private Point2D p1, p2, p3;

    public TriangleDrawer(Point2D p1, Point2D p2, Point2D p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);

        int x1 = (int) p1.getX() * 50 + 100;  // Scale and shift for visibility
        int y1 = 400 - (int) p1.getY() * 50;
        int x2 = (int) p2.getX() * 50 + 100;
        int y2 = 400 - (int) p2.getY() * 50;
        int x3 = (int) p3.getX() * 50 + 100;
        int y3 = 400 - (int) p3.getY() * 50;

        g.drawLine(x1, y1, x2, y2);
        g.drawLine(x2, y2, x3, y3);
        g.drawLine(x3, y3, x1, y1);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Triangle Drawer");
        TriangleDrawer panel = new TriangleDrawer(new Point2D(0, 0), new Point2D(2, 7), new Point2D(3, 4));

        frame.add(panel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
