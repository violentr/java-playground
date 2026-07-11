package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JPanel implements ActionListener {
    private final JButton helloButton;
    private final JButton goodbyeButton;


    public ToolBar() {
        helloButton = new JButton("Hello");
        goodbyeButton = new JButton("Goodbye");
        setSize(400, 100);
        setLayout(new FlowLayout(FlowLayout.CENTER));

        add(helloButton);
        add(goodbyeButton);
         helloButton.addActionListener(this);
         goodbyeButton.addActionListener(this);
    }
//    public void addText(JTextArea textArea) {
//        helloButton.addActionListener(e -> textArea.append("Hello\n"));
//        goodbyeButton.addActionListener(e -> textArea.append("Goodbye\n"));
//    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked: " + e.getActionCommand());
    }
}
