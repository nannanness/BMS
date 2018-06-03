package org.nannanness.bms.controller;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    public void paintComponent(Graphics g){
        int x = 0, y = 0;
        ImageIcon icon = new ImageIcon("img/login2.0.jpg");
        g.drawImage(icon.getImage(), x, y, getSize().width, getSize().height, this);// 图片会自动缩放
    }
}
