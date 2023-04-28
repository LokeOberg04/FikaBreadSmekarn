package FikaBreadSmekarn;

import javax.swing.*;

public class View {

    private JPanel JPanel;
    private JTextPane textPane1;
    private JButton fikaBrödButton;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JTextArea textArea1;

    public JPanel getPanel() {
        return JPanel;
    }

    public void setMessage(String c) {
        textArea1.setText(c);
    }
}
