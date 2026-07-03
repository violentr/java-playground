import javax.swing.*;

public class HelloWorld {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main main = new Main();
        });
    }
}
