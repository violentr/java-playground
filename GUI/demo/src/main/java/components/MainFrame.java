package components;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private ToolBar toolbar;
    private TextPanel textPanel;

    public MainFrame() {
        toolbar = new ToolBar();
        textPanel = new TextPanel();
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(toolbar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        setVisible(true);
    }
}
