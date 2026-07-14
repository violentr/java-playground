package components;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private ToolBar toolbar;
    private TextPanel textPanel;
    private JTextArea textArea;
    public MainFrame() {
        toolbar = new ToolBar();
        textPanel = new TextPanel();
        textArea = new JTextArea();
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(toolbar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        add(textArea, BorderLayout.CENTER);
        setVisible(true);
        toolbar.addText(textArea);
    }
}
