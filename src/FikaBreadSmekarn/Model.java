package FikaBreadSmekarn;

import FikaBreadSmekarn.Assets.AlexandroBaker;
import FikaBreadSmekarn.Assets.AlexandroMaid;
import FikaBreadSmekarn.Assets.Building;

import javax.swing.*;

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
