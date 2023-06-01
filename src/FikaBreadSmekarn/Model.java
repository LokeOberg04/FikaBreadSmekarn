package FikaBreadSmekarn;

import FikaBreadSmekarn.Assets.*;

import javax.swing.*;
import java.sql.*;

public class Model {

    AlexandroMaid AlexandroMaid = new AlexandroMaid();
    AlexandroBaker AlexandroBaker = new AlexandroBaker();

    AlexandroFactory AlexandroFactory = new AlexandroFactory();

    Alexandro Alexandro = new Alexandro();

    Cooki Cooki = new Cooki();
    int Fikabröd = 0;
    int Fps = 0;
    int Clickpower = 1;
    String uPassword = "password123";
    String user = "te20";

    String forum = "";
    JPasswordField pf = new JPasswordField();
    //String password = new String(pf.getPassword());

    String password = DatabaseLogin.password;
    public String getpassword() {
        return password;
    }

    public FikaBreadSmekarn.Assets.AlexandroMaid getAlexandroMaid() {
        return AlexandroMaid;
    }

    public FikaBreadSmekarn.Assets.AlexandroBaker getAlexandroBaker() {
        return AlexandroBaker;
    }

    public FikaBreadSmekarn.Assets.AlexandroFactory getAlexandroFactory() {
        return AlexandroFactory;
    }

    public FikaBreadSmekarn.Assets.Alexandro getAlexandro() {
        return Alexandro;
    }

    public FikaBreadSmekarn.Assets.Cooki getCooki() {
        return Cooki;
    }

    public int getClickpower() {
        return Clickpower;
    }

    public void importsave() {

        String SaveName = JOptionPane.showInputDialog("What is your save called? (important");

            Connection conn = null;

            try {
                conn = DriverManager.getConnection("jdbc:mysql://db.umea-ntig.se:3306/te20? "+
                        "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",getuser(),getpassword());
            } catch (SQLException e) {
                e.printStackTrace();
            }


            try {
                Statement stmt = conn.createStatement();
                String SQLQuery = "SELECT * FROM lo28cc WHERE SaveName = " + "'" + SaveName + "'";
                ResultSet result = stmt.executeQuery(SQLQuery);

                ResultSetMetaData metadata = result.getMetaData();

                int numCols = metadata.getColumnCount();
                for (int i = 1 ; i <= numCols ; i++) {
                    System.out.println(metadata.getColumnClassName(i));
                }

                while (result.next()) {

                    Fikabröd = result.getInt("FikaBread");
                    AlexandroMaid.setOwned(result.getInt("AlexandroMaids"));
                    AlexandroMaid.setCost((int) (15 * Math.pow(1.15, AlexandroMaid.getOwned())));
                    AlexandroBaker.setOwned(result.getInt("AlexandroBakers"));
                    AlexandroBaker.setCost((int) (300 * Math.pow(1.15, AlexandroBaker.getOwned())));
                    AlexandroFactory.setOwned(result.getInt("AlexandroFactories"));
                    AlexandroFactory.setCost((int) (6000 * Math.pow(1.15, AlexandroFactory.getOwned())));
                    Alexandro.setOwned(result.getInt("Alexandros"));
                    Alexandro.setCost((int) (120000 * Math.pow(1.15, Alexandro.getOwned())));
                    Cooki.setOwned(result.getInt("Cookis"));
                    Cooki.setCost((int) (2400000 * Math.pow(1.15, Cooki.getOwned())));
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

        String SaveName = JOptionPane.showInputDialog("What is your save Called? (important)");

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://db.umea-ntig.se:3306/te20? "+
                    "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",getuser(),getpassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            Statement stmt = conn.createStatement();
            String SQLQuery = "SELECT * FROM lo28cc WHERE SaveName = " + "'" + SaveName + "'";
            ResultSet result = stmt.executeQuery(SQLQuery);

            ResultSetMetaData metadata = result.getMetaData();

            int numCols = metadata.getColumnCount();
            for (int i = 1 ; i <= numCols ; i++) {
                System.out.println("METADATA THINGI ====" + metadata.getColumnClassName(i));
            }

            int SaveExists = 0;
            while (result.next()) {
                String output = "";
                output += result.getInt("Fikabread");
                System.out.println("output be like " + output);
                if (output.length() > 0) {
                    SaveExists = 1;
                }
            }

            // insert

            // Scanner in = new Scanner(System.in);
            // System.out.println("Ange namn:");
            // String name = in.nextLine();
            // System.out.println("Ange lösenord:");
            // String password2 = in.nextLine();
//
            // for(int i = 0; i<1; i++) {
            if (SaveExists == 1) {
                SQLQuery = "UPDATE lo28cc SET FikaBread = " + getFikabröd() + ", AlexandroMaids = " + getAlexandroMaid().getOwned() + ", AlexandroBakers = " + getAlexandroBaker().getOwned() + ", AlexandroFactories = " + getAlexandroFactory().getOwned() + ", Alexandros = " + getAlexandro().getOwned() + ", Cookis = " + getCooki().getOwned() + " WHERE SaveName = '" + SaveName + "'";
                stmt.executeUpdate(SQLQuery);
            } else {
                SQLQuery = "INSERT INTO lo28cc (FikaBread, AlexandroMaids, AlexandroBakers, AlexandroFactories, Alexandros, Cookis, SaveName) VALUES (" + getFikabröd() + "," +  getAlexandroMaid().getOwned() + "," + getAlexandroBaker().getOwned() + "," + getAlexandroFactory().getOwned() + "," + getAlexandro().getOwned() + "," +  getCooki().getOwned() + "," + "'" + SaveName + "')";
                stmt.executeUpdate(SQLQuery);
            }
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
            Clickpower = 1+(AlexandroMaid.getOwned() * AlexandroMaid.getFps() + AlexandroBaker.getOwned() * AlexandroBaker.getFps() + AlexandroFactory.getOwned() * AlexandroFactory.getFps() + Alexandro.getOwned() * Alexandro.getFps() + Cooki.getOwned() * Cooki.getFps());
        } else {
            System.out.println("You dont have enough Fikabröd");
        }
}

public void Click() {
        Clickpower = 1+(AlexandroMaid.getOwned() * AlexandroMaid.getFps() + AlexandroBaker.getOwned() * AlexandroBaker.getFps() + AlexandroFactory.getOwned() * AlexandroFactory.getFps() + Alexandro.getOwned() * Alexandro.getFps() + Cooki.getOwned() * Cooki.getFps());
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
