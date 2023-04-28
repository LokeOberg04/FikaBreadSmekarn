package FikaBreadSmekarn;

import javax.swing.*;
import java.awt.*;

public class Controller extends JFrame {


    Model model;
    View View;

    public Controller(Model m, View v) {

        this.model = m;
        this.View = v;
        this.setTitle("Client");


        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\loke.oberg\\IdeaProjects\\ChatProgram\\src\\resources\\B).png");
        this.setIconImage(icon);


        this.setContentPane(View.getPanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Model m = new Model();
        View v = new View();
        Controller thisIsTheProgram = new Controller(m, v);
        thisIsTheProgram.setVisible(true);
    }
    }
