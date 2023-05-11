package FikaBreadSmekarn;

import javax.swing.*;
import java.awt.event.ActionListener;

public class View {

    private JPanel Panel;
    private JTextPane textPane1;
    private JButton fikaBrödButton;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JTextArea textArea1;

    public JButton getFikaBrödButton() {
        return fikaBrödButton;
    }

    public View() {

    }

    public JPanel getPanel() {
        return Panel;
    }


    public void setFika(String c) {
        textPane1.setText(c);
    }
}
