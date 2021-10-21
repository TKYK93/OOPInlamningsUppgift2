package inlamningsuppgift2;

import javax.swing.*;
import java.awt.*;

public class Tile extends JButton {
    private int number;
    private final String fontStyle = "Ariel";
    private final int fontSize = 30;

    Tile(int number){
        this.number = number;
        setText("" + number);
        setFont(new Font(fontStyle, Font.BOLD, fontSize));
    }

    public int getNumber() {
        return number;
    }

}
