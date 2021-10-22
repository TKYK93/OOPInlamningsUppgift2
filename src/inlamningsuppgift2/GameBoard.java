package inlamningsuppgift2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GameBoard extends JPanel {
    private int rows = 4;
    private int columns = 4;
    private Tile[][] tiles = new Tile[rows][columns];

    GameBoard() {
        setMaximumSize(new Dimension(Config.gameBoardWidth, Config.gameBoardHeight));
        setLayout(new GridLayout(rows,columns));
        // ----- For test only in case of 4 x 4 -----------
        testForGameClearFuncInitialize();
        // -------------------------------
//        initializeTiles();
    }

    // For test only in case of 4 x 4
    public void testForGameClearFuncInitialize() {
        ArrayList<Integer> listTest = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 15));
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                int tileNumber = listTest.remove(0);
                Tile currentTile = new Tile(tileNumber, j, i);
                if(tileNumber == rows * columns){
                    currentTile.setBackground(new Color(223,212,202));
                    currentTile.setText("");
                }
                currentTile.addActionListener(event -> {
                    swapTiles(currentTile);
                    boolean isGameDone = checkIsGameDone();
                    if(isGameDone){
                        System.out.println("Congrats!! Game is clear!!");
                        showGameClearMessage();
                    }
                });
                tiles[i][j] = currentTile;
                add(currentTile);
            }
        }
    }

    public void initializeTiles() {
        removeAll();

        // create a random order array
        ArrayList<Integer> list = new ArrayList<>();
        for(int j = 1 ; j < rows*columns ; j++) {
            list.add(j);
        }
        Collections.shuffle(list);

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++){
                if(i == rows-1 && j == columns-1){
                    Tile emptyTile = new Tile(rows*columns, 3, 3);
                    emptyTile.setText("");
                    emptyTile.setBackground(new Color(223,212,202));
                    tiles[rows-1][columns-1] = emptyTile;
                    add(emptyTile);
                    break;
                }

                int tileNumber = list.remove(0);
                Tile currentTile = new Tile(tileNumber, j, i);
                currentTile.addActionListener(event -> {
                    swapTiles(currentTile);
                    boolean isGameDone = checkIsGameDone();
                    if(isGameDone){
                        showGameClearMessage();
                    }
                });
                tiles[i][j] = currentTile;
                add(currentTile);
            }
        }
    }

    private void setTilesFromList(){
        removeAll();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                add(tiles[i][j]);
            }
        }
        revalidate();
    }

    public Tile getEmptyTile(){
        for(int i = 0; i < rows ; i++){
            for(int j = 0; j < columns;j++){
                if(tiles[i][j].getNumber() == rows * columns){
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
                return x == emptyX && y - 1 == emptyY;

            case "DOWN":
                return x == emptyX && y + 1 == emptyY;

            case "LEFT":
                return x - 1  == emptyX && y == emptyY;

            case "RIGHT":
                return x + 1 == emptyX && y == emptyY;

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
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < columns; j++){
                    if(tiles[i][j].getNumber() == tile.getNumber()){
                        emptyTile.setXPos(tileX);
                        emptyTile.setYPos(tileY);
                        tiles[i][j] = emptyTile;
                    } else if(tiles[i][j].getNumber() == rows*columns){
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

    public boolean checkIsGameDone () {
        int correctNumber = 1;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(tiles[i][j].getNumber() != correctNumber){
                    return false;
                }
                correctNumber++;
            }
        }
        return true;
    }

    public void showGameClearMessage(){
        removeAll();
        setLayout(new BorderLayout());
        add(new GameDonePanel());
        revalidate();
    }
}
