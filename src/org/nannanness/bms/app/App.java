package org.nannanness.bms.app;

import org.nannanness.bms.controller.LoginController;
import org.nannanness.bms.controller.ManagerLogin;
import org.nannanness.bms.views.AbstractLogin;
import org.nannanness.bms.views.AbstractManagerLogin;

public class App {
    public static void main(String[] args) {
        AbstractLogin login= new LoginController();
        login.setVisible(true);

//        AbstractManagerLogin login = new ManagerLogin();
//        login.setVisible(true);

    }
}
