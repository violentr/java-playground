package components;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        TextPanel textPanel = new TextPanel();
        ToolBar toolbar = new ToolBar(textPanel);

        add(toolbar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
