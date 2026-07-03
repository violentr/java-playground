import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private JButton button;
    private JTextArea textArea;

    public Main() {
        super("Hello, World!");
        initialize();
    }

    private void initialize() {
        setLayout(new BorderLayout());
        button = new JButton("Click me!");
        textArea = new JTextArea();

        setSize(400, 300);
        setVisible(true);
        /* make sure close is working */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(textArea, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);

        /* add an action listener */
        button.addActionListener(e -> System.out.println("Hello, World!"));
    }
}
