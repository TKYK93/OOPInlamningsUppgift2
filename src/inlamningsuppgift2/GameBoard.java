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
        initializeTiles();
    }

    public void initializeTiles() {
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
                currentTile.addActionListener(event -> {
                    swapTiles(currentTile);
                });
                tiles[i][j] = currentTile;
                add(currentTile);
            }
        }
    }

    private void setTilesFromList(){
        removeAll();
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                add(tiles[i][j]);
            }
        }
        revalidate();
    }

    public Tile getEmptyTile(){
        for(int i = 0; i < 4 ; i++){
            for(int j = 0; j < 4;j++){
                if(tiles[i][j].getNumber() == 16){
                    return tiles[i][j];
                }
            }
        }
        return null;
    }

    public boolean checkIsNextTileEmpty(Tile tile, String direction) {
        Tile emptyTile = getEmptyTile();

        if(emptyTile == null){
            return false;
        }

        int x = tile.getXPos();
        int y = tile.getYPos();

        int emptyX = emptyTile.getXPos();
        int emptyY = emptyTile.getYPos();

        switch(direction){
            case "UP":
                if(x == emptyX && y - 1 == emptyY){
                    return true;
                }
                return false;

            case "DOWN":
                if(x == emptyX && y + 1 == emptyY){
                    return true;
                }
                return false;
            case "LEFT":
                if(x - 1  == emptyX && y == emptyY){
                    return true;
                }
                return false;
            case "RIGHT":
                if(x + 1 == emptyX && y == emptyY){
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    public boolean swapTiles(Tile tile){

        boolean isUpEmpty = checkIsNextTileEmpty(tile, "UP");
        boolean isDownEmpty = checkIsNextTileEmpty(tile, "DOWN");
        boolean isLeftEmpty = checkIsNextTileEmpty(tile, "LEFT");
        boolean isRightEmpty = checkIsNextTileEmpty(tile, "RIGHT");

        if(isUpEmpty || isDownEmpty || isLeftEmpty || isRightEmpty ){
            Tile emptyTile = getEmptyTile();
            int emptyTileX = emptyTile.getXPos();
            int emptyTileY = emptyTile.getYPos();
            int tileX = tile.getXPos();
            int tileY = tile.getYPos();
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    if(tiles[i][j].getNumber() == tile.getNumber()){
                        emptyTile.setXPos(tileX);
                        emptyTile.setYPos(tileY);
                        tiles[i][j] = emptyTile;
                    } else if(tiles[i][j].getNumber() == 16){
                        tile.setXPos(emptyTileX);
                        tile.setYPos(emptyTileY);
                        tiles[i][j] = tile;
                    }
                }
            }
            setTilesFromList();
            return true;
        }
        return false;
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
