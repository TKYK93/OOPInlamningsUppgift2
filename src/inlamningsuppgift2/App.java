package inlamningsuppgift2;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    JPanel gameBoardPanel = new JPanel();
    JButton resetButton = new JButton();

    App() {
        System.out.println("Start the application!");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600, 700));
        setLocation(200, 100);

        resetButton.setMaximumSize(new Dimension(600,100));
        resetButton.setText("Reset");
        resetButton.setFont(new Font(Config.fontType, Font.BOLD, Config.fontSize));
        this.add("North", resetButton);

        setVisible(true);

    }

}
