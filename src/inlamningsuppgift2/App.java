package inlamningsuppgift2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

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
        resetButton.addActionListener(event -> {
            initiateTiles();
            gameBoardPanel.revalidate();
        });
        this.add("North", resetButton);

        gameBoardPanel.setMaximumSize(new Dimension(600, 600));
        this.add("Center", gameBoardPanel);
        gameBoardPanel.setLayout(new GridLayout(4,4));
        initiateTiles();

        setVisible(true);
    }

    private void initiateTiles(){
        gameBoardPanel.removeAll();
        ArrayList<Integer> list = new ArrayList<>();
        for(int j = 1 ; j < 16 ; j++) {
            list.add(j);
        }
        Collections.shuffle(list);
        for(int i = 0; i < list.size(); i++){
            Tile tile = new Tile(list.get(i));
            tile.setSize(new Dimension(150, 150));
            gameBoardPanel.add(tile);
        }
    }

}
