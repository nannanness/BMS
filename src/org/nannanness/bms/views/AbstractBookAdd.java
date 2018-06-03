package org.nannanness.bms.views;

import org.nannanness.bms.controller.SecondBackPanel;
import org.nannanness.bms.tools.GUITools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/*
  *添加图书的界面
  *

 */
public abstract class AbstractBookAdd extends JFrame {
    private Font font = new Font("微软雅黑", Font.BOLD , 20);
    private JLabel bookName = new JLabel("图书名称:");
    public JTextField nameField = new JTextField();
    private JLabel bookAuthor = new JLabel("图书作者:");
    public JTextField authorField = new JTextField();
    private JLabel bookDescription = new JLabel("图书简介:");
    public JTextField descriptionField = new JTextField();
    private JLabel bookType = new JLabel("图书类别:");
    public  JComboBox typeBook = new JComboBox();  //图书的类别
    private JButton addBtn = new JButton("添加");
    private JButton editBtn = new JButton("取消");

    public AbstractBookAdd(){
        this.init();
        this.addComponent();
        this.addListener();
    }
    public void init(){
        this.setTitle("可以新增图书了");
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

        Font font = new Font("幼圆",Font.BOLD,14);
        bookName.setBounds(70,100,80,28);
        bookName.setFont(font);

        nameField.setBounds(150,100,110,38);
        nameField.setFont(font);
        //String  str = nameField.getText();

        bookAuthor.setBounds(70,180,80,28);
        bookAuthor.setFont(font);
        authorField.setBounds(150,180,110,38);

        bookDescription.setFont(font);
        bookDescription.setBounds(70,260,80,28);
        descriptionField.setBounds(150,260,110,38);

        bookType.setFont(font);
        bookType.setBounds(70,340,80,28);
        typeBook.setModel(new DefaultComboBoxModel(new Object[]{"-请选择-","科幻小说","文学艺术","互联网","职场提升","历史小说"}));
        typeBook.setBounds(150,340,110,38);

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
        panel.add(bookName);
        panel.add(nameField);
        panel.add(bookAuthor);
        panel.add(authorField);
        panel.add(bookDescription);
        panel.add(descriptionField);
        panel.add(bookType);
        panel.add(typeBook);
        panel.add(addBtn);
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
