package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ToolBar extends JPanel {
    private final JButton helloButton;
    private final JButton goodbyeButton;
    private StringListener textListener;

    public ToolBar() {
        helloButton = new JButton("Hello");
        goodbyeButton = new JButton("Goodbye");
        setLayout(new FlowLayout(FlowLayout.LEFT));

        ActionListener listener = e -> {
            if (e.getSource() == helloButton) {
                if (textListener != null) {
                    textListener.textEmitted("Hello button clicked");
                }
                System.out.println("Hello button clicked");
            } else if (e.getSource() == goodbyeButton) {
                if (textListener != null) {
                    textListener.textEmitted("Goodbye button clicked");
                }
                System.out.println("Goodbye button clicked");
            }
        };
        helloButton.addActionListener(listener);
        goodbyeButton.addActionListener(listener);

        add(helloButton);
        add(goodbyeButton);
    }
    public void setTextListener(StringListener listener) {
        textListener = listener;
    }
}
