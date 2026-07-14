package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ToolBar extends JPanel {
    private final JButton helloButton;
    private final JButton goodbyeButton;

    public ToolBar(TextPanel textPanel) {
        helloButton = new JButton("Hello");
        goodbyeButton = new JButton("Goodbye");
        setLayout(new FlowLayout(FlowLayout.LEFT));

        ActionListener listener = e -> {
            if (e.getSource() == helloButton) {
                textPanel.appendText("Hello button clicked");
                System.out.println("Hello button clicked");
            } else if (e.getSource() == goodbyeButton) {
                textPanel.appendText("Goodbye button clicked");
                System.out.println("Goodbye button clicked");
            }
        };
        helloButton.addActionListener(listener);
        goodbyeButton.addActionListener(listener);

        add(helloButton);
        add(goodbyeButton);
    }
}
