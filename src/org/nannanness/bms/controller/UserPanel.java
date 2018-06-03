package org.nannanness.bms.controller;

import javax.swing.*;
import java.awt.*;
/*
用户界面的面板的背景图片子类
 */
public class UserPanel extends JPanel {
    public void paintComponent(Graphics g){
        int x = 0, y = 0;
        ImageIcon icon = new ImageIcon("img/bg.jpg");
        g.drawImage(icon.getImage(), x, y, getSize().width, getSize().height, this);// 图片会自动缩放
    }
}
