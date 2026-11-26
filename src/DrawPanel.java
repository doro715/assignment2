import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    private final List<BufferedImage> images = new ArrayList<>();
    private final List<Point> points = new ArrayList<>();


    void moveit(int index, int x, int y) {
        Point p = points.get(index);
        p.x = x;
        p.y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        String[] paths = {"pics/Volvo240.jpg", "pics/Saab95.jpg"};
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        for (String path : paths) {
            try {
                // You can remove the "pics" part if running outside of IntelliJ and
                // everything is in the same folder.
                // volvoImage = ImageIO.read(new File("Volvo240.jpg"));
                 images.add(ImageIO.read(DrawPanel.class.getResourceAsStream(path)));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            points.add(new Point());
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < images.size(); i++) {
            g.drawImage(images.get(i), points.get(i).x, points.get(i).y, 200, 150, null);
        } // see javadoc for more info on the parameters
    }
}