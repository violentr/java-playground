package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JPanel {
    private final JButton helloButton;
    private final JButton goodbyeButton;


    public ToolBar() {
        helloButton = new JButton("Hello");
        goodbyeButton = new JButton("Goodbye");
        setSize(400, 100);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        ActionListener listener = e -> {
            if (e.getSource() == helloButton) {
                System.out.println("Hello button clicked");
            } else if (e.getSource() == goodbyeButton) {
                System.out.println("Goodbye button clicked");
            }
        };
        helloButton.addActionListener(listener);
        goodbyeButton.addActionListener(listener);
        add(helloButton);
        add(goodbyeButton);
    }
    public void addText(JTextArea textArea) {
        helloButton.addActionListener(e -> textArea.append("Hello\n"));
        goodbyeButton.addActionListener(e -> textArea.append("Goodbye\n"));
    }
}
