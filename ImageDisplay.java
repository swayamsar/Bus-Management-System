import javax.swing.*;

public class ImageDisplay {
    public static void main(String[] args) {
        // Create Frame
        JFrame frame = new JFrame("Image Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        // Load Image
        ImageIcon imageIcon = new ImageIcon("bus.jpg"); // Ensure the image is in the project folder
        JLabel label = new JLabel(imageIcon);
        
        // Add to Frame
        frame.add(label);
        frame.setVisible(true);
    }
}
