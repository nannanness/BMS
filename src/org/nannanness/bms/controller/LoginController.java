package org.nannanness.bms.controller;

import org.nannanness.bms.domain.User;
import org.nannanness.bms.service.IUserService;
import org.nannanness.bms.service.serviceImpl.UserServiceImpl;
import org.nannanness.bms.tools.VerifiCodeUtil;
import org.nannanness.bms.views.AbstractLogin;
import org.nannanness.bms.views.AbstractRegister;
import org.nannanness.bms.views.AbstractUser;

import javax.swing.*;
import java.awt.*;

public class LoginController extends AbstractLogin {
    private IUserService userService = new UserServiceImpl();


    public LoginController(){

    }

    @Override
    public void checkCode() {
        String metaCode = VerifiCodeUtil.getCode();
        String useCod = codText.getText();
        if(useCod.equals("")){
            codeTips.setIcon(new ImageIcon("img/wrong.png"));
            codeTips.setText("请输入验证码");
            code.setIcon(new ImageIcon(VerifiCodeUtil.getBufferdImage(col_1_width,globalHeight)));
        }else{
            if(!useCod.equalsIgnoreCase(metaCode)){
                codeTips.setIcon(new ImageIcon("img/wrong.png"));
                codeTips.setText("验证码有误");
                code.setIcon(new ImageIcon(VerifiCodeUtil.getBufferdImage(col_1_width,globalHeight)));
            }else{
                codeTips.setIcon(new ImageIcon("img/right.png"));
                codeTips.setText("");
                boolCode = true;
                return;
            }
        }
        boolCode = false;
    }

    @Override
    public void register() {
        res = new AbstractRegister();
        res.setVisible(true);
    }

    @Override
    public void login() {
        login.setBorder(BorderFactory.createLoweredBevelBorder());
        if(boolCode){
        }else {
            checkCode();
        }
        String username = userText.getText();
        String password = new String(pswText.getPassword());
        user = userService.login(username,password);
        if(userCut){
            if(boolCode){
                if((user != null) && (user.getID() == 20151001)){
                    JOptionPane.showMessageDialog(panel, "成功登录", "馆长提醒",JOptionPane.INFORMATION_MESSAGE);
                    this.setVisible(false);
                    manager = new ManagerLogin();
                    manager.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(panel, "用户名或不正确密码", "馆长提醒",JOptionPane.ERROR_MESSAGE);
                }
            }else {
                JOptionPane.showMessageDialog(panel, "验证码有误", "馆长提醒",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            if(boolCode){
                if((user != null) && boolCode){
                    JOptionPane.showMessageDialog(panel, "成功登录", "馆长提醒",JOptionPane.INFORMATION_MESSAGE);
                    userView = new UserController();
                    userView.getUser(user);
                    this.setVisible(false);
                    userView.loadOneMoreTime();
                    userView.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(panel, "用户名或不正确密码", "馆长提醒",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(panel, "验证码有误", "馆长提醒",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void cut() {
        userCut = !userCut;
        if(userCut){
            title.setText("<html>管理员你好<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;今天也要元气满满<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地干活哦！</html>");
            img = new ImageIcon("img/loginManagerLogo.png");
            img.setImage(img.getImage().getScaledInstance(logoWidth,logoHeight,Image.SCALE_DEFAULT));
            loginLogo.setIcon(img);
        }else {
            title.setText("<html>馆长说：<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;爱读书的人<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;运气不会太差</html>");
            img = new ImageIcon("img/loginLogo.png");
            img.setImage(img.getImage().getScaledInstance(logoWidth,logoHeight,Image.SCALE_DEFAULT));
            loginLogo.setIcon(img);
        }
    }
}
