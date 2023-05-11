package FikaBreadSmekarn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller extends JFrame {


    Model model;
    View View;

    public Controller(Model m, View v) {

        this.model = m;
        this.View = v;
        this.setTitle("FikaBreadSmekarn");


        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\loke.oberg\\IdeaProjects\\ChatProgram\\src\\resources\\B).png");
        this.setIconImage(icon);

        this.setContentPane(v.getPanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        v.getFikaBrödButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.Click();
                v.setFika(m.getFikabröd() + " FikaBröd");
            }
        });

    }

    public static void main(String[] args) {
        Model m = new Model();
        View v = new View();
        Controller thisIsTheProgram = new Controller(m, v);
        thisIsTheProgram.setVisible(true);
    }
    }
