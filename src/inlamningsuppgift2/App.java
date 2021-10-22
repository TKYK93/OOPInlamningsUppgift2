package inlamningsuppgift2;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    GameBoard gameBoardPanel = new GameBoard();
    ResetButton resetButton = new ResetButton();
    StartPanel sp = new StartPanel();

    App() {
        System.out.println("Start the application!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(Config.appWidth, Config.appHeight));
        setLocationRelativeTo(null);

        resetButton.addActionListener(event -> {
            resetTiles();
            gameBoardPanel.revalidate();
        });
//        this.add("North", resetButton);
//
//        this.add("Center", gameBoardPanel);

        this.add("Center", sp);

        setVisible(true);
    }

    private void resetTiles(){
        gameBoardPanel.setLayout(new GridLayout(4,4));
        gameBoardPanel.initializeTiles();
    }

}
