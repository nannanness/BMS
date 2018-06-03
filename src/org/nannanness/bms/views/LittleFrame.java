package org.nannanness.bms.views;

import org.nannanness.bms.tools.GUITools;

import javax.swing.*;
import java.awt.*;

public class LittleFrame extends JFrame {

    protected int littleFrameWidth = 320;
    protected int littleFrameHeight = 370;
    protected JLabel name = new JLabel();
    protected JLabel id = new JLabel();
    protected JLabel email = new JLabel();
    protected JLabel adress = new JLabel();
    protected JTextField nameT = new JTextField();
    protected JTextField idT = new JTextField();
    protected JTextField emailT = new JTextField();
    protected JTextField adressT = new JTextField();
    protected JPanel panel = new JPanel();
    protected JButton btn1 = new JButton();
    protected JButton btn2 = new JButton();
    public LittleFrame(){
        initLittle();
        loadComponents();
    }

    public void initLittle(){
        this.setSize(littleFrameWidth,littleFrameHeight);
        this.setResizable(false);
    //    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("修改信息");
        Image logo = Toolkit.getDefaultToolkit().getImage("img/logo.png");
        this.setIconImage(logo);
        GUITools.center(this);
    }

    public void loadComponents(){
        panel.setLayout(null);
        name.setText("姓名：");
        id.setText("ID：");
        email.setText("邮箱：");
        adress.setText("住址：");
        name.setBounds(20,30,40,30);
        id.setBounds(20,80,40,30);
        email.setBounds(20,130,40,30);
        adress.setBounds(20,180,40,30);
        nameT.setBounds(90,30,150,30);
        idT.setBounds(90,80,150,30);
        emailT.setBounds(90,130,150,30);
        adressT.setBounds(90,180,150,30);
        btn1.setText("取消");
        btn1.setFocusPainted(false);
        btn1.setBackground(new Color(255, 255, 238,230));
        btn1.setBorder(BorderFactory.createRaisedBevelBorder());
        btn1.setBounds(20,250,120,40);
        btn2.setText("提交");
        btn2.setFocusPainted(false);
        btn2.setBackground(new Color(255, 255, 238,230));
        btn2.setBorder(BorderFactory.createRaisedBevelBorder());
        btn2.setBounds(180,250,120,40);
        // 添加
        panel.add(name);
        panel.add(id);
        panel.add(email);
        panel.add(adress);
        panel.add(nameT);
        panel.add(idT);
        panel.add(emailT);
        panel.add(adressT);
        panel.add(btn1);
        panel.add(btn2);
        // 添加panel
        this.add(panel);
    }
}
