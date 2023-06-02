package FikaBreadSmekarn;

import FikaBreadSmekarn.Assets.AlexandroBaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Timer;
import java.util.TimerTask;

public class Controller extends JFrame {


    Model model;
    View View;

    public Controller(Model m, View v) {

        this.model = m;
        this.View = v;
        this.setTitle("FikaBreadSmekarn");

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

                m.BuyBuilding(m.getAlexandroFactory());
                System.out.println("You have " + m.getAlexandroFactory().getOwned() + " AlexandroFactory\nThey now cost " + m.getAlexandroFactory().getCost() + " FikaBröd");
                v.setFika(m.getFikabröd() + " FikaBröd\n" + m.getClickpower() + " Clicking Power");
                v.setFactory("<html>AlexandroFactory <br> You own " + m.getAlexandroFactory().getOwned() + "<br> They Cost " + m.getAlexandroFactory().getCost() + "</html>");
            }
        });
        v.getButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                m.BuyBuilding(m.getAlexandro());
                System.out.println("You have " + m.getAlexandro().getOwned() + " Alexandro\nThey now cost " + m.getAlexandro().getCost() + " FikaBröd");
                v.setFika(m.getFikabröd() + " FikaBröd\n" + m.getClickpower() + " Clicking Power");
                v.setAlexandro("<html>Alexandro <br> You own " + m.getAlexandro().getOwned() + "<br> They Cost " + m.getAlexandro().getCost() + "</html>");
            }
        });
        v.getButton3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                m.BuyBuilding(m.getCooki());
                System.out.println("You have " + m.getCooki().getOwned() + " Cooki\nThey now cost " + m.getCooki().getCost() + " FikaBröd");
                v.setFika(m.getFikabröd() + " FikaBröd\n" + m.getClickpower() + " Clicking Power");
                v.setCooki("<html>Cooki <br> You own " + m.getCooki().getOwned() + "<br> They Cost " + m.getCooki().getCost() + "</html>");
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
                m.setClickpower(1+(m.getAlexandroMaid().getOwned() * m.getAlexandroMaid().getFps() + m.getAlexandroBaker().getOwned() * m.getAlexandroBaker().getFps() + m.getAlexandroFactory().getOwned() * m.getAlexandroFactory().getFps() + m.getAlexandro().getOwned() * m.getAlexandro().getFps() + m.getCooki().getOwned() * m.getCooki().getFps()));
                v.setFika(m.getFikabröd() + " FikaBröd\n" + m.getClickpower() + " Clicking Power");
                v.setMaid("<html>AlexandroMaid <br> You own " + m.getAlexandroMaid().getOwned() + "<br> They Cost " + m.getAlexandroMaid().getCost() + "</html>");
                v.setBaker("<html>AlexandroBaker <br> You own " + m.getAlexandroBaker().getOwned() + "<br> They Cost " + m.getAlexandroBaker().getCost() + "</html>");
                v.setFactory("<html>AlexandroFactory <br> You own " + m.getAlexandroFactory().getOwned() + "<br> They Cost " + m.getAlexandroFactory().getCost() + "</html>");
                v.setAlexandro("<html>Alexandro <br> You own " + m.getAlexandro().getOwned() + "<br> They Cost " + m.getAlexandro().getCost() + "</html>");
                v.setCooki("<html>Cooki <br> You own " + m.getCooki().getOwned() + "<br> They Cost " + m.getCooki().getCost() + "</html>");
            }
        });


    }

    public static void main(String[] args) {
        Model m = new Model();
        View v = new View();
        Controller thisIsTheProgram = new Controller(m, v);
        thisIsTheProgram.setVisible(true);

        java.util.Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
            m.Click();
                v.setFika(m.getFikabröd() + " FikaBröd\n" + m.getClickpower() + " Clicking Power");
            }
        }, 0, 1000);//wait 0 milliseconds before doing the action and do it every 1000ms (1 second)


    }
    }
