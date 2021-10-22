package inlamningsuppgift2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tile extends JButton implements ActionListener {
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
        addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("x = " + xPos + ", y = " + yPos);
    }

}
