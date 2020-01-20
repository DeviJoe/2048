package GUI;

import javax.swing.*;

/**
 * Класс, реализующий вызов и закрытие пустой формы Swing
 */
public class MainFrame extends JFrame {

    public MainFrame() {
        this.setTitle("2048");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(450,530);
        this.setLocationRelativeTo(null);
    }
}
