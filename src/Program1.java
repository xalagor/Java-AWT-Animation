import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class Program1 extends JComponent {
    private double angle;

    public Program1() {
        angle = 0;
        Timer timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += 0.05;
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        Graphics2D g2d = (Graphics2D) g;
        double x = 0.5 * width;
        double y = 0.5 * height;
        // double r = 0.75 * Math.min(x, y);
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, 600, 400);
        g2d.setColor(Color.GRAY);
        x += 160 * Math.cos(angle);
        y += 60 * Math.sin(angle);
        // r = Math.max(0.1 * r, 5);
        g2d.fill(circle(x, y, 12));
        g2d.setColor(Color.blue);
        g2d.fill(circle(300, 140, 60));
    }

    private Shape circle(double x, double y, double r) {
        return new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Point on circle");
                frame.add(new Program1());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(600, 400);
                frame.setBackground(Color.black);
                frame.setVisible(true);
            }
        });
    }
}