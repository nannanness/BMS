package org.nannanness.bms.controller;


import org.nannanness.bms.domain.RegisterUser;
import org.nannanness.bms.service.IReturnUserService;
import org.nannanness.bms.service.serviceImpl.ReturnUserServiceImpl;
import org.nannanness.bms.views.AbstractAddUser;

import javax.swing.*;

/**
 * 添加用户的子类
 */
public class AddUser extends AbstractAddUser {
    IReturnUserService service = new ReturnUserServiceImpl();
    @Override
    public void edit() {
        this.setVisible(false);
    }

    @Override
    public void add() {
        String id = idField.getText();
        String name = nameField.getText();
        String email = emailField.getText();
        String address = addressField.getText();
        RegisterUser reguser = new RegisterUser(id,name,email,address);
//        service.insert(reguser);
        idField.setText("");
        nameField.setText("");
        emailField.setText("");
        addressField.setText("");
        JOptionPane.showMessageDialog(this, "成功添加用户", "馆长提醒",JOptionPane.INFORMATION_MESSAGE);
        this.setVisible(false);
    }
}
