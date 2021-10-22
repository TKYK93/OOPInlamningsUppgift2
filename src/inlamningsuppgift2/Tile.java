package inlamningsuppgift2;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tile extends JButton {
    private int number;
    private int xPos;
    private int yPos;

    Tile(int number, int xPos, int yPos){
        this.number = number;
        this.xPos = xPos;
        this.yPos = yPos;
        setText("" + number);
        setFont(new Font(Config.fontType, Font.BOLD, Config.fontSize));
        setSize(new Dimension(150, 150));
        setBorder(new LineBorder(new Color(149,	112,	79)));
        setBackground(new Color(186, 140, 99) );
    }

    public int getNumber() {
        return number;
    }

    public int getXPos() {
        return xPos;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

}
