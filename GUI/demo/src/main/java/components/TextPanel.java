package components;

import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {
    private final JTextArea textArea;

    public TextPanel(){
        textArea = new JTextArea();
        textArea.setEditable(false);
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }
    public void appendText(String text){
       textArea.append(text + "\n");
    }
}
