package components;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        TextPanel textPanel = new TextPanel();
        ToolBar toolbar = new ToolBar();

        add(toolbar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        /* Decouple Toolbar from TextPanel by using a listener callback.
   This keeps MainFrame flexible: any component can handle emitted text,
   not just TextPanel passed through constructor dependencies. */
        toolbar.setTextListener(new StringListener() {
            @Override
            public void textEmitted(String text) {
                textPanel.appendText(text);
            }
        });
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
