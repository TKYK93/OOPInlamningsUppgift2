package inlamningsuppgift2;

import javax.swing.*;
import java.awt.*;

public class Tile extends JButton {
    private int number;

    Tile(int number){
        this.number = number;
        setText("" + number);
        setFont(new Font(Config.fontType, Font.BOLD, Config.fontSize));
    }

    public int getNumber() {
        return number;
    }

}
