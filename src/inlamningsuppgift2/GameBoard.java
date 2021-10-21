package inlamningsuppgift2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class GameBoard extends JPanel {
    private Tile[][] tiles = new Tile[4][4];

    GameBoard() {
        setMaximumSize(new Dimension(600, 600));
        setLayout(new GridLayout(4,4));
        setTiles();
    }

    public void setTiles() {
        removeAll();

        // create a random order array
        ArrayList<Integer> list = new ArrayList<>();
        for(int j = 1 ; j < 16 ; j++) {
            list.add(j);
        }
        Collections.shuffle(list);

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++){
                if(i == 3 && j == 3){
                    Tile emptyTile = new Tile(16, 3, 3);
                    emptyTile.setBackground(Color.red);
                    emptyTile.setText("");
                    tiles[3][3] = emptyTile;
                    add(emptyTile);
                    break;
                }
                Tile currentTile = new Tile(list.remove(0), j, i);
                tiles[i][j] = currentTile;
                add(currentTile);
            }
        }
    }

    public boolean showIsGameDone () {
        int[][] correctTiles = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
                };

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(tiles[i][j].getNumber() != correctTiles[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
