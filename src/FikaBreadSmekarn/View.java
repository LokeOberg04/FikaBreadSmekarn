package FikaBreadSmekarn;

import javax.swing.*;

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

    public JButton getButton1() {
        return button1;
    }

    public JButton getButton2() {
        return button4;
    }

    public JButton getButton3() {
        return button5;
    }

    public JButton getButton4() {
        return button3;
    }

    public JButton getButton5() {
        return button2;
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
