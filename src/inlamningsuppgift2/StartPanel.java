package inlamningsuppgift2;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class StartPanel extends JPanel {
    private int rows;
    private int columns;

    StartPanel() {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        setPreferredSize(new Dimension(Config.appWidth, Config.appHeight));
        GridBagConstraints constraints = new GridBagConstraints();

        Label labelForColumns = new Label("columns");
        constraints.gridx = 0;	//位置x
        constraints.gridy = 0;	//位置y
        layout.setConstraints(labelForColumns, constraints);//現在の制約を使い
        this.add(labelForColumns);

        InputField field1 = new InputField();

        constraints.gridx = 1;	//位置x
        constraints.gridy = 0;	//位置y
//        constraints.gridwidth = 1;	//コンポーネントの表示領域のセル数 横
//        constraints.gridheight = 1;	//コンポーネントの表示領域のセル数 縦
        layout.setConstraints(field1, constraints);//現在の制約を使い
        this.add(field1);

        Label labelForRows = new Label("rows");
        constraints.gridx = 0;	//位置x
        constraints.gridy = 1;	//位置y
        layout.setConstraints(labelForRows, constraints);//現在の制約を使い
        this.add(labelForRows);


        InputField field2 = new InputField();

        constraints.gridx = 1;	//位置x
        constraints.gridy = 1;	//位置y
//        constraints.gridwidth = 1;	//コンポーネントの表示領域のセル数 横
//        constraints.gridheight = 1;	//コンポーネントの表示領域のセル数 縦
        layout.setConstraints(field2, constraints);//現在の制約を使い
        this.add(field2);


        JButton startButton = new JButton();
        startButton.setPreferredSize(new Dimension(200, 100));
        constraints.gridx = 0;	//位置x
        constraints.gridy = 2;	//位置y
        constraints.gridwidth = 2;	//コンポーネントの表示領域のセル数 横
        constraints.gridheight = 1;	//コンポーネントの表示領域のセル数 縦
        layout.setConstraints(startButton, constraints);//現在の制約を使い
        this.add(startButton);


    }

    class Label extends JLabel {

        Label(String text){
            setText(text);
            setPreferredSize(new Dimension(100, 50));
        }


    }

    class InputField extends JTextField {
        InputField() {
            setPreferredSize(new Dimension(100, 100));
            getDocument().addDocumentListener(new DocumentListener() {
                public void changedUpdate(DocumentEvent e) {
                    
                    warn();
                }
                public void removeUpdate(DocumentEvent e) {
                    warn();
                }
                public void insertUpdate(DocumentEvent e) {
                    warn();
                }

                public void warn() {
                    if (Integer.parseInt(getText())<=0){
                        JOptionPane.showMessageDialog(null,
                                "Error: Please enter number bigger than 0", "Error Message",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
        }
    }

}
