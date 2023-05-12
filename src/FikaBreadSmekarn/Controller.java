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
            }
        });
        v.getButton5().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.BuyBuilding(m.getAlexandroBaker());
                System.out.println("You have " + m.getAlexandroBaker().getOwned() + " AlexandroBaker\nThey now cost " + m.getAlexandroBaker().getCost() + " FikaBröd");
                v.setFika(m.getFikabröd() + " FikaBröd\n" + m.getClickpower() + " Clicking Power");
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


    }

    public static void main(String[] args) {
        Model m = new Model();
        View v = new View();
        Controller thisIsTheProgram = new Controller(m, v);
        thisIsTheProgram.setVisible(true);

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://db.umea-ntig.se:3306/te20? "+
                    "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",m.getuser(),m.getpassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            Statement stmt = conn.createStatement();
            String SQLQuery = "SELECT * FROM fbs28";
            ResultSet result = stmt.executeQuery(SQLQuery);

            ResultSetMetaData metadata = result.getMetaData();

            int numCols = metadata.getColumnCount();
            for (int i = 1 ; i <= numCols ; i++) {
                System.out.println(metadata.getColumnClassName(i));
            }

            while (result.next()) {
                String output = "";
                output += result.getInt("Fikabröd") + ", " +
                        result.getString("password");
                System.out.println(output);
            }

            // insert

            // Scanner in = new Scanner(System.in);
            // System.out.println("Ange namn:");
            // String name = in.nextLine();
            // System.out.println("Ange lösenord:");
            // String password2 = in.nextLine();
//
            // for(int i = 0; i<1; i++) {
                 SQLQuery = "INSERT INTO fbs28(name,password) VALUES (" + m.getFikabröd() + ", '" + m.getUPassword() + "')";
                 stmt.executeUpdate(SQLQuery);
            System.out.println("Your Save is : " + m.getUPassword());
            // }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    }
