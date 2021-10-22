package inlamningsuppgift2;

import javax.swing.*;
import java.awt.*;

public class ResetButton extends JButton {

    ResetButton(){
        setMaximumSize(new Dimension(Config.appWidth,100));
        setText("Reset");
        setFont(new Font(Config.fontType, Font.BOLD, Config.fontSize));
    }

}
