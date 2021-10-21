package inlamningsuppgift2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class App extends JFrame {
    GameBoard gameBoardPanel = new GameBoard();
    JButton resetButton = new JButton();

    App() {
        System.out.println("Start the application!");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600, 700));
        setLocation(200, 100);

        resetButton.setMaximumSize(new Dimension(600,100));
        resetButton.setText("Reset");
        resetButton.setFont(new Font(Config.fontType, Font.BOLD, Config.fontSize));
        resetButton.addActionListener(event -> {
            resetTiles();
            gameBoardPanel.revalidate();
        });
        this.add("North", resetButton);


        this.add("Center", gameBoardPanel);


        setVisible(true);
    }

    private void resetTiles(){
        gameBoardPanel.setTiles();
    }

}
