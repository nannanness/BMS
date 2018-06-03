package org.nannanness.bms.views;

import org.nannanness.bms.controller.SecondBackPanel;
import org.nannanness.bms.tools.GUITools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class AbstractAddUser extends JFrame{
    private JLabel userId = new JLabel("用户id:");
    protected JTextField idField = new JTextField();
    private JLabel userName = new JLabel("用户昵称:");
    protected JTextField nameField = new JTextField();
    private JLabel userEmail = new JLabel("用户邮箱:");
    protected JTextField emailField = new JTextField();
    private JLabel userAddress = new JLabel("用户地址:");
    protected JTextField addressField = new JTextField();
    private JButton addBtn = new JButton("添加");
    private JButton editBtn = new JButton("退出");

    public AbstractAddUser(){
        this.init();
        this.addComponent();
        this.addListener();

    }
    public void init(){
        this.setTitle("新增用户");
        Font font = new Font("微软雅黑",Font.BOLD,20);
        this.setFont(font);
        Image imglogo = Toolkit.getDefaultToolkit().getImage("img/add.png");
        this.setIconImage(imglogo);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400,600);
        GUITools.center(this);
        this.setResizable(false);
    }
    private void addComponent(){
        JPanel panel = new JPanel();
        panel = new SecondBackPanel("img/secondback.jpg");
        panel.setLayout(null);
        ImageIcon image = new ImageIcon("img/secondback");
        image.setImage(image.getImage().getScaledInstance(400,600,Image.SCALE_DEFAULT));
        Font font = new Font("幼圆",Font.BOLD,16);
        userId.setBounds(70,100,80,28);
        userId.setFont(font);
        idField.setBounds(150,100,130,38);
        idField.setFont(font);
        userName.setBounds(70,180,80,28);
        userName.setFont(font);
        nameField.setBounds(150,180,130,38);
        userEmail.setFont(font);
        userEmail.setBounds(70,260,80,28);
        emailField.setBounds(150,260,130,38);
        userAddress.setFont(font);
        userAddress.setBounds(70,340,80,28);
        addressField.setBounds(150,340,130,38);
        addBtn.setIcon(new ImageIcon("img/add.png"));
        //绘制焦点
        addBtn.setFocusPainted(false);
        //设置边框
        addBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        addBtn.setFont(font);
        addBtn.setBounds(40,460,120,38);
        editBtn.setFont(font);
        editBtn.setFocusPainted(false);
        editBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        editBtn.setIcon(new ImageIcon("img/reset.png"));
        editBtn.setBounds(200,460,120,38);
        panel.add(userAddress);
        panel.add(addressField);
        panel.add(addBtn);
        panel.add(userEmail);
        panel.add(emailField);
        panel.add(userName);
        panel.add(nameField);
        panel.add(userId);
        panel.add(idField);
        panel.add(editBtn);
        this.add(panel);
    }
    private void addListener() {
        addBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                add();
            }
        });
        editBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                edit();
            }
        });
    }
    public  abstract void edit();
    public abstract void add();
}
