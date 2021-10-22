package inlamningsuppgift2;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    private int rows = 4;
    private int columns = 4;
    private GameBoard gameBoardPanel = new GameBoard();
    private ResetButton resetButton = new ResetButton();


    App() {
        System.out.println("Start the application!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(Config.appWidth, Config.appHeight));
        setLocationRelativeTo(null);

        resetButton.addActionListener(event -> {
            resetTiles();
            gameBoardPanel.revalidate();
        });
        this.add("North", resetButton);

        this.add("Center", gameBoardPanel);

        setVisible(true);
    }

    private void resetTiles(){
        gameBoardPanel.setLayout(new GridLayout(rows, columns));
        gameBoardPanel.initializeTiles();
    }

}
