package FikaBreadSmekarn;

import FikaBreadSmekarn.Assets.AlexandroBaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

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
                v.setFika(m.getFikabröd() + " FikaBröd\n" + m.getClickpower() + " Clicking Power");
            }
        });
        v.getButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            m.BuyBuilding(m.getAlexandroMaid());
                System.out.println("You have " + m.getAlexandroMaid().getOwned() + " AlexandroMaids\nThey now cost " + m.getAlexandroMaid().getCost() + " FikaBröd");
                v.setFika(m.getFikabröd() + " FikaBröd\n" + m.getClickpower() + " Clicking Power");
                v.setMaid("<html>AlexandroMaid <br> You own " + m.getAlexandroMaid().getOwned() + "<br> They Cost " + m.getAlexandroMaid().getCost() + "</html>");
            }
        });
        v.getButton5().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.BuyBuilding(m.getAlexandroBaker());
                System.out.println("You have " + m.getAlexandroBaker().getOwned() + " AlexandroBaker\nThey now cost " + m.getAlexandroBaker().getCost() + " FikaBröd");
                v.setFika(m.getFikabröd() + " FikaBröd\n" + m.getClickpower() + " Clicking Power");
                v.setBaker("<html>AlexandroBaker <br> You own " + m.getAlexandroBaker().getOwned() + "<br> They Cost " + m.getAlexandroBaker().getCost() + "</html>");
            }
        });
        v.getButton4().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("3");
            }
        });
        v.getButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("4");
            }
        });
        v.getButton3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("5");
            }
        });

        v.getSave().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            m.save();
            }
        });

        v.getImportButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.importsave();
                m.setClickpower(1+(m.getAlexandroMaid().getOwned() * m.getAlexandroMaid().getFps() + m.getAlexandroBaker().getOwned() * m.getAlexandroBaker().getFps()));
                v.setFika(m.getFikabröd() + " FikaBröd\n" + m.getClickpower() + " Clicking Power");
                v.setMaid("<html>AlexandroMaid <br> You own " + m.getAlexandroMaid().getOwned() + "<br> They Cost " + m.getAlexandroMaid().getCost() + "</html>");
                v.setBaker("<html>AlexandroBaker <br> You own " + m.getAlexandroBaker().getOwned() + "<br> They Cost " + m.getAlexandroBaker().getCost() + "</html>");
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
