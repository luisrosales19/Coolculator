import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class RoundedButton extends JButton {
    public RoundedButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false); // Remove focus ring around text
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        int diameter = Math.min(getWidth(), getHeight());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fill circle with background color
        g2.setColor(getBackground());
        g2.fillOval(0, 0, diameter - 1, diameter - 1);

        // Ensures text is centered in the button
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Optional: if you want a border, uncomment and set your preferred color
        // Graphics2D g2 = (Graphics2D) g.create();
        // g2.setColor(Color.BLACK); // Set border color
        // int diameter = Math.min(getWidth(), getHeight());
        // g2.drawOval(0, 0, diameter - 1, diameter - 1);
        // g2.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        int max = Math.max(size.width, size.height);
        setPreferredSize(new Dimension(max, max)); // Force button to be circular
        return new Dimension(max, max);
    }

    @Override
    public boolean contains(int x, int y) {
        Shape shape;
        int diameter = Math.min(getWidth(), getHeight());
        shape = new Ellipse2D.Float(0, 0, diameter, diameter);
        return shape.contains(x, y);
    }
}


