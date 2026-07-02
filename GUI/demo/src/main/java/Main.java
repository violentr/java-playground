import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public Main() {
        initialize();
    }

    private void initialize() {
        JButton button = new JButton("Click me!");
        /* add an action listener */
        button.addActionListener(e -> System.out.println("Hello, World!"));

        /* make sure the GUI is created on the event dispatch thread */
        JFrame frame = new JFrame("Hello, World!");
        /* make sure close is working */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(button);
        frame.setVisible(true);
    }
}
