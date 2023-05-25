package FikaBreadSmekarn;

import FikaBreadSmekarn.Assets.AlexandroBaker;
import FikaBreadSmekarn.Assets.AlexandroMaid;
import FikaBreadSmekarn.Assets.Building;

import javax.swing.*;
import java.sql.*;

public class Model {

    AlexandroMaid AlexandroMaid = new AlexandroMaid();
    AlexandroBaker AlexandroBaker = new AlexandroBaker();
    int Fikabröd = 0;
    int Fps = 0;
    int Clickpower = 1;
    String uPassword = "password123";
    String user = "te20";

    String forum = "";
    JPasswordField pf = new JPasswordField();
    //String password = new String(pf.getPassword());

    String password = JOptionPane.showInputDialog(pf, "password");
    public String getpassword() {
        return password;
    }

    public FikaBreadSmekarn.Assets.AlexandroMaid getAlexandroMaid() {
        return AlexandroMaid;
    }

    public FikaBreadSmekarn.Assets.AlexandroBaker getAlexandroBaker() {
        return AlexandroBaker;
    }

    public int getClickpower() {
        return Clickpower;
    }

    public void importsave() {

            Connection conn = null;

            try {
                conn = DriverManager.getConnection("jdbc:mysql://db.umea-ntig.se:3306/te20? "+
                        "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",getuser(),getpassword());
            } catch (SQLException e) {
                e.printStackTrace();
            }


            try {
                Statement stmt = conn.createStatement();
                String SQLQuery = "SELECT * FROM lo28cc";
                ResultSet result = stmt.executeQuery(SQLQuery);

                ResultSetMetaData metadata = result.getMetaData();

                int numCols = metadata.getColumnCount();
                for (int i = 1 ; i <= numCols ; i++) {
                    System.out.println(metadata.getColumnClassName(i));
                }

                while (result.next()) {

                    Fikabröd = result.getInt("FikaBread");
                    AlexandroMaid.setOwned(result.getInt("AlexandroMaids"));
                    AlexandroBaker.setOwned(result.getInt("AlexandroBakers"));
                    String output = "";
                    output += result.getInt("FikaBread") + ", " +
                            result.getInt("AlexandroMaids") + ", " +
                        result.getInt("AlexandroBakers");
                    System.out.println(output);
                }

                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    public void save() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://db.umea-ntig.se:3306/te20? "+
                    "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",getuser(),getpassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            Statement stmt = conn.createStatement();
            String SQLQuery = "SELECT * FROM lo28cc";
            ResultSet result = stmt.executeQuery(SQLQuery);

            ResultSetMetaData metadata = result.getMetaData();

            int numCols = metadata.getColumnCount();
            for (int i = 1 ; i <= numCols ; i++) {
                System.out.println(metadata.getColumnClassName(i));
            }

            //while (result.next()) {
            //    String output = "";
            //    output += result.getInt("Fikabröd") + ", " +
            //            result.getString("password");
            //    System.out.println(output);
            //}

            // insert

            // Scanner in = new Scanner(System.in);
            // System.out.println("Ange namn:");
            // String name = in.nextLine();
            // System.out.println("Ange lösenord:");
            // String password2 = in.nextLine();
//
            // for(int i = 0; i<1; i++) {
            SQLQuery = "UPDATE lo28cc SET FikaBread = " + getFikabröd() + ", AlexandroMaids = " + getAlexandroMaid().getOwned() + ", AlexandroBakers = " + getAlexandroBaker().getOwned();
            stmt.executeUpdate(SQLQuery);
            // }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void setClickpower(int clickpower) {
        Clickpower = clickpower;
    }

    public void BuyBuilding(Building Building) {
        if(Fikabröd > Building.getCost()-1) {
            Fikabröd -= Building.getCost();
            Building.setCost((int) (Building.getCost() * 1.15));
            Building.setOwned(Building.getOwned() + 1);
            Clickpower = 1+(AlexandroMaid.getOwned() * AlexandroMaid.getFps() + AlexandroBaker.getOwned() * AlexandroBaker.getFps());
        } else {
            System.out.println("You dont have enough Fikabröd");
        }
}

public void Click() {
        Clickpower = 1+(AlexandroMaid.getOwned() * AlexandroMaid.getFps() + AlexandroBaker.getOwned() * AlexandroBaker.getFps());
    Fikabröd += Clickpower;
}

public int getFikabröd() {
    return Fikabröd;
}

    public String getuser() {
        return user;
    }
    public String getUPassword() {
        return uPassword;
    }

}
