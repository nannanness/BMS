package org.nannanness.bms.views;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import org.nannanness.bms.controller.LoginPanel;
import org.nannanness.bms.controller.SecondBackPanel;
import org.nannanness.bms.tools.GUITools;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 图书详询表
 */
public abstract class AbstractSpecificInfo extends JFrame {
    // 建表
    public JTable specificTable = null;
    protected String[] colNames = new String[] {"图书姓名","图书类别","图书简介","图书出版社","图书作者","图书库存"};
    //首页按钮
    protected JButton homePageBtn = new JButton("首页");
    //下一页
    protected JButton nextPageBtn = new JButton("上一页");
    //上一页
    protected JButton backPageBtn = new JButton("下一页");
    //末页
    protected JButton lastPageBtn = new JButton("末页");
    //删除按钮
    protected JButton deleteBtn = new JButton("删除");
    protected JButton addBtn = new JButton("添加");
    //末页步骤
    protected JLabel jumpHead = new JLabel();
    protected JLabel jumpTail = new JLabel();
    protected JTextField jumpNumber = new JTextField();
    protected JButton jumpButton = new JButton();
    protected JLabel atPre = new JLabel();
    protected JLabel atPreNum = new JLabel();
    protected JLabel atPreTail = new JLabel();
    protected JLabel sumHead = new JLabel();
    protected JLabel sumHeadNum = new JLabel();
    protected JLabel sumTail = new JLabel();

    public AbstractSpecificInfo(){
        this.init();
        this.addComponents();
        this.addListener();
    }
    public void init(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,480);
        this.setResizable(false);
        Image icon = Toolkit.getDefaultToolkit().getImage("img/bg.png");
        this.setIconImage(icon);
        this.setVisible(true);
        this.setTitle("图书详询");
        GUITools.center(this);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    //给表中赋值

    public void addComponents() {
        JPanel bigPanel_1 = new JPanel();
        bigPanel_1 = new SecondBackPanel("img/secondback.jpg");
        bigPanel_1.setLayout(null);

        Object[][] userdata = {};
        JScrollPane scrollPanel1 = new JScrollPane();
        scrollPanel1.setBounds(45, 20, 515, 350);
        specificTable = new JTable(userdata, colNames);
        specificTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单选
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        specificTable.setDefaultRenderer(Object.class, r);
        specificTable.getTableHeader().setReorderingAllowed(false);//列不能移动
        scrollPanel1.setViewportView(specificTable);
        //首页 下一页 上一页 末页 设置位置 文本域 绘制焦点 背景
        homePageBtn.setBounds(5, 380, 80, 20);
        homePageBtn.setBackground(new Color(255,255,238,220));
        nextPageBtn.setBounds(105, 380, 80, 20);
        nextPageBtn.setBackground(new Color(255,255,238,220));
        backPageBtn.setBounds(205, 380, 80, 20);
        backPageBtn.setBackground(new Color(255,255,238,220));
        lastPageBtn.setBounds(305, 380, 80, 20);
        lastPageBtn.setBackground(new Color(255,255,238,220));
        deleteBtn.setBounds(405,380,80,20);
        deleteBtn.setBackground(new Color(255,255,238,220));
        addBtn.setBounds(505,380,80,20);
        addBtn.setBackground(new Color(255,255,238,220));
        homePageBtn.setFocusPainted(false);
        //homePageBtn.setBackground(new Color(255, 255, 238, 200));
        backPageBtn.setFocusPainted(false);
        //backPageBtn.setBackground(new Color(255, 255, 238, 200));
        nextPageBtn.setFocusPainted(false);
        //nextPageBtn.setBackground(new Color(255, 255, 238, 200));
        lastPageBtn.setFocusPainted(false);
        //lastPageBtn.setBackground(new Color(255, 255, 238, 200));
        atPre.setText("当前:");
        atPre.setBounds(75, 420, 30, 20);
        atPreNum.setText("1");
        atPreNum.setBounds(105, 420, 30, 20);
        atPreTail.setText("页");
        atPreTail.setBounds(135, 420, 15, 20);
        jumpHead.setText("跳至：");
        jumpHead.setBounds(165, 420, 40, 20);
        jumpNumber.setBounds(205, 420, 35, 20);
        jumpTail.setText("页");
        jumpTail.setBounds(245, 420, 15, 20);
        jumpButton.setText("跳转");
        jumpButton.setBackground(new Color(255,255,238,220));
        jumpButton.setBounds(285, 420, 80, 20);
        jumpButton.setFocusPainted(false);
        sumHead.setText("总数:");
        sumHead.setBounds(385, 420, 35, 20);
        sumHeadNum.setText("");
        sumHeadNum.setBounds(426, 420, 30, 20);
        sumTail.setText("页");
        sumTail.setBounds(466, 420, 15, 20);


        //jumpButton.setBackground(new Color(255, 255, 238, 200));
        bigPanel_1.add(atPre);
        bigPanel_1.add(atPreNum);
        bigPanel_1.add(atPreTail);
        bigPanel_1.add(sumHead);
        bigPanel_1.add(sumHeadNum);
        bigPanel_1.add(sumTail);
        bigPanel_1.add(jumpHead);
        bigPanel_1.add(jumpTail);
        bigPanel_1.add(jumpNumber);
        bigPanel_1.add(jumpButton);
        bigPanel_1.add(homePageBtn);
        bigPanel_1.add(nextPageBtn);
        bigPanel_1.add(backPageBtn);
        bigPanel_1.add(lastPageBtn);
        bigPanel_1.add(deleteBtn);
        bigPanel_1.add(addBtn);
        bigPanel_1.add(scrollPanel1);
        this.add(bigPanel_1);
    }
    public void addListener(){
        homePageBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                homePage();
            }
        });
        nextPageBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nextPage();
            }
        });
        backPageBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                backPage();
            }
        });
        lastPageBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lastPage();
            }
        });
        jumpButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jumpPage();
            }
        });
        deleteBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                delete();
            }
        });
        addBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                add();
            }
        });
    }

    public abstract void jumpPage();
    public abstract void homePage();
    public abstract void nextPage();
    public abstract void backPage();
    public abstract void lastPage();
    public abstract void delete();
    public abstract void add();
}
