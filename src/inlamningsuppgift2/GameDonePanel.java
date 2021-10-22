package inlamningsuppgift2;

import javax.swing.*;
import java.awt.*;

public class GameDonePanel extends JLabel {

    GameDonePanel() {
        setText("Congrats!!! You cleared the game!!");
        setFont(new Font(Config.fontType, Font.BOLD, 30));
        setBackground(Color.red);
        setPreferredSize(new Dimension(600, 600));
    }

}
