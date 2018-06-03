package org.nannanness.bms.controller;

import javax.swing.*;
import java.awt.*;

/**
 * 小窗口背景图片
 */
public class SecondBackPanel extends JPanel {
    private static final long serialVersionUID =  1L;
    private Image image;
    public SecondBackPanel(){

    }
    public SecondBackPanel(String imagePath){
        image = new ImageIcon(imagePath).getImage();
    }
    @Override
    protected  void paintComponent(Graphics g){
        g.drawImage(image,0,0,this.getWidth(),this.getHeight(),this);
    }

}
