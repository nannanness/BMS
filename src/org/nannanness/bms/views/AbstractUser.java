package org.nannanness.bms.views;

import org.nannanness.bms.controller.MyPanel;
import org.nannanness.bms.controller.UserPanel;
import org.nannanness.bms.domain.User;
import org.nannanness.bms.tools.GUITools;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class AbstractUser extends JFrame{
    private final int frameWidth = 620;
    private final int frameHeight = 480;
    // 父容器
    private final JPanel fatherPanel = new UserPanel();
    // 三大块，首部、左部、下部
    private final JPanel navPanel = new JPanel();
    protected final JPanel leftPanel = new JPanel();
    protected final JPanel bigPanel = new JPanel();
    // 首部的四个模块
    protected final JButton books = new JButton();
    protected final JButton record = new JButton();
    protected final JButton my = new JButton();
    protected final JButton intro = new JButton();
    // 卡片相关
    protected final CardLayout card = new CardLayout();
    protected final String cardName[] = {"labelBook","labelRecord","labelMy","labelIntro"};
    protected final CardLayout card2 = new CardLayout();
    protected final String cardName2[] = {"labelBook","labelRecord","labelMy","labelIntro"};
    protected final CardLayout card3 = new CardLayout();
    protected final String cardName3[] = {"0","1"};
    // 左部四个模块
    protected final JPanel leftPanel_0 = new JPanel();
    protected final JPanel leftPanel_1 = new JPanel();
    protected final JPanel leftPanel_2 = new JPanel();
    protected final JPanel leftPanel_3 = new JPanel();
    // 左部第一个模块的内容
    protected final JComboBox box_0_0 = new JComboBox();
    protected final JComboBox box_0_1 = new JComboBox();
    protected final JButton leftPanel_0_find = new JButton();
    protected final JTextField leftPanel_0_in = new JTextField();
    protected final JButton borrowButton = new JButton();
    protected final JButton collectButton = new JButton();
    // 左部第二个模块的内容
    protected final JComboBox box_1_0 = new JComboBox();
    protected final JComboBox box_1_1 = new JComboBox();
    protected final JButton leftPanel_1_find = new JButton();
    protected final JTextField leftPanel_1_in = new JTextField();
    protected final JButton borrowButton1 = new JButton();

    // 左部三个模块的内容
    protected JButton updateInfo = new JButton();
    protected JButton collectInfo = new JButton();
    // 左部第四个模块的内容
    protected JComboBox libararynotify = new JComboBox();
    protected JButton centainBtn = new JButton("确定");
    protected JButton editBtn = new JButton("编辑");

    // 下部四个模块
    protected final JPanel bigPanel_0 = new JPanel();
    protected final JPanel bigPanel_1 = new JPanel();
    protected final JPanel bigPanel_2 = new JPanel();
    protected final JPanel bigPanel_3 = new JPanel();
    // 下部第一个模块的内容
    protected JTable tableBook = null;
    protected String[] colName = {"书名","作者","出版社","类型","余数"};
    protected JButton homePage = new JButton();
    protected JButton prePage = new JButton();
    protected JButton lastPage = new JButton();
    protected JButton nextPage = new JButton();
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
    // 下部第二个模块的内容
    protected String[] colName2 = {"书名","作者","类型","借书时间","状态"};
    protected JTable tableRecord = null;
    protected JButton homePage1 = new JButton();
    protected JButton prePage1 = new JButton();
    protected JButton lastPage1 = new JButton();
    protected JButton nextPage1 = new JButton();
    protected JLabel jumpHead1 = new JLabel();
    protected JLabel jumpTail1 = new JLabel();
    protected JTextField jumpNumber1 = new JTextField();
    protected JButton jumpButton1 = new JButton();
    protected JLabel atPre1 = new JLabel();
    protected JLabel atPreNum1 = new JLabel();
    protected JLabel atPreTail1 = new JLabel();
    protected JLabel sumHead1 = new JLabel();
    protected JLabel sumHeadNum1 = new JLabel();
    protected JLabel sumTail1 = new JLabel();
    // 下部第三个模块的内容
    protected JLabel myNameLabel = new JLabel("用户名：");
    protected JLabel myNameContent = new JLabel();
    protected JLabel myIDLabel = new JLabel("ID：");
    protected JLabel myIDContent = new JLabel();
    protected JLabel myEmailLabel = new JLabel("邮箱：");
    protected JLabel myEmailContent= new JLabel();
    protected JLabel myAdressLabel = new JLabel("住址：");
    protected JLabel myAdressContent = new JLabel();
    protected JTable collectTable = null;
    protected JPanel infoPanel = new JPanel();
    protected JPanel collectPanel = new JPanel();
    protected String[] colNameCollectTable = {"书名","作者","出版社","类型"};

    // 下部第四个模块的内容
    protected JTable libararyTable = null;
    protected String[] tableLibarary = {"名称","地点","服务","开放时间"};

    // 弹窗
    protected JFrame littleFrame = null;

    // 登录的对象
    protected User user;

    protected int userID;

    public void getUser(User user){
        this.user = user;
    }

    public AbstractUser(){

        initUser();
        navHeadLoading();
        leftPanelHeadLoading();
        leftPanel_0_Loading();
        leftPanel_1_Loading();
        leftPanel_2_Loading();
        leftPanel_3_Loading();
        leftPanelTailLoading();
    }

    public void loadOneMoreTime(){
        bigPanelHeadLoading();
        bigPanel_0_Loading();
        bigPanel_1_Loading();
        bigPanel_2_Loading();
        bigPanel_3_Loading();
        bigPanelTailLoading();
        navTailLoading();
        userID = user.getID();
        event();
    }
    // frame的设置
    public void initUser(){
        this.setLayout(null);
        this.setBounds(0,0,frameWidth,frameHeight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("市立图书馆");
        Image logo = Toolkit.getDefaultToolkit().getImage("img/logo.png");
        this.setIconImage(logo);
        GUITools.center(this);
        this.setResizable(false);
    }

    // 全局的父panel和上部导航panel的设置
    public void navHeadLoading(){
        // 父panel
        fatherPanel.setLayout(null);
        fatherPanel.setBounds(0,0,620,480);
        // 导航栏panel
        navPanel.setBounds(5,5,605,160);
        navPanel.setBackground(new Color(255, 255, 238,200));
        navPanel.setBorder(BorderFactory.createEtchedBorder());
        navPanel.setLayout(null);
        // navPanel中的内容
        // logo
        ImageIcon navIcon = new ImageIcon("img/userLogo.png");
        navIcon.setImage(navIcon.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT));
        JLabel navIconLabel = new JLabel(navIcon);
        navIconLabel.setBounds(10,10,150,150);
        // button
        Font navfont = new Font("华文楷体",Font.BOLD,18);
        books.setFont(navfont);
        record.setFont(navfont);
        my.setFont(navfont);
        intro.setFont(navfont);
        books.setBorder(BorderFactory.createEtchedBorder());
        record.setBorder(BorderFactory.createEtchedBorder());
        my.setBorder(BorderFactory.createEtchedBorder());
        intro.setBorder(BorderFactory.createEtchedBorder());
        books.setBounds(190,100,102,50);
        record.setBounds(293,100,102,50);
        my.setBounds(396,100,102,50);
        intro.setBounds(499,100,102,50);
        books.setText("图书检索");
        record.setText("借书记录");
        my.setText("我的信息");
        intro.setText("馆记");
        books.setBackground(new Color(255, 255, 238,230));
        record.setBackground(new Color(255, 255, 238,230));
        my.setBackground(new Color(255, 255, 238,230));
        intro.setBackground(new Color(255, 255, 238,230));
        books.setFocusPainted(false);
        record.setFocusPainted(false);
        my.setFocusPainted(false);
        intro.setFocusPainted(false);
        // image
        JLabel bgImage = new JLabel();
        ImageIcon bgIcon = new ImageIcon("img/userImage.png");
        bgIcon.setImage(bgIcon.getImage().getScaledInstance(410,99,Image.SCALE_DEFAULT));
        bgImage.setBounds(170,5,410,99);
        bgImage.setIcon(bgIcon);
        // navPanel添加组件
        navPanel.add(navIconLabel);
        navPanel.add(books);
        navPanel.add(record);
        navPanel.add(my);
        navPanel.add(intro);
        navPanel.add(bgImage);
    }

    // 左边四个pannel的父页面的头设置
    public void leftPanelHeadLoading(){
        // leftPanel
        leftPanel.setBounds(5,166,184,275);
        leftPanel.setBackground(new Color(255, 255, 238,200));
        leftPanel.setBorder(BorderFactory.createEtchedBorder());
        leftPanel.setLayout(card);
    }

    // 左边第一个页面的设置
    public void leftPanel_0_Loading(){
        // 第一个页面的设置，对应“图书检索”
        leftPanel_0.setLayout(null);
        String[] item = {"-请选择-" , "图书" , "作者" , "类别"};
        String[] item1 = {"-请选择-","科幻小说","成功励志","经济管理","文学艺术","职场提升","心灵治愈","互联网","心理课堂","名人传记","历史小说"};
        for(String str : item){
            box_0_0.addItem(str);
        }
        for(String str1 : item1){
            box_0_1.addItem(str1);
        }
        box_0_0.setBounds(10,10,164,30);
        box_0_1.setBounds(10,50,164,30);
        box_0_0.setBackground(new Color(255, 255, 238,180));
        box_0_1.setBackground(new Color(255, 255, 238,180));
        leftPanel_0_in.setBounds(10,90,164,30);
        leftPanel_0_find.setBounds(10,130,164,30);
        leftPanel_0_find.setText("检索图书");
        leftPanel_0_find.setFocusPainted(false);
        leftPanel_0_find.setBackground(new Color(255, 255, 238,180));
        collectButton.setBounds(10,170,164,30);
        collectButton.setFocusPainted(false);
        collectButton.setBackground(new Color(255, 255, 238,180));
        collectButton.setText("收藏此书");
        borrowButton.setBounds(10,210,164,30);
        borrowButton.setFocusPainted(false);
        borrowButton.setBackground(new Color(255, 255, 238,180));
        borrowButton.setText("预约此书");
        // 左第一页面添加组件
        leftPanel_0.add(collectButton);
        leftPanel_0.add(borrowButton);
        leftPanel_0.add(box_0_0);
        leftPanel_0.add(box_0_1);
        leftPanel_0.add(leftPanel_0_in);
        leftPanel_0.add(leftPanel_0_find);
    }

    // 左第二页面设置
    public void leftPanel_1_Loading(){
        // 左第二页面设置
        leftPanel_1.setLayout(null);
        String[] item1_0 = {"-请选择-" , "图书" , "作者" , "类别"};
        String[] item1_1 = {"-请选择-","科幻小说","成功励志","经济管理","文学艺术","职场提升","心灵治愈","互联网","心理课堂","名人传记","历史小说"};
        for(String str : item1_0){
            box_1_0.addItem(str);
        }
        for(String str1 : item1_1){
            box_1_1.addItem(str1);
        }
        box_1_0.setBounds(10,10,164,30);
        box_1_1.setBounds(10,50,164,30);
        box_1_0.setBackground(new Color(255, 255, 238,180));
        box_1_1.setBackground(new Color(255, 255, 238,180));
        leftPanel_1_in.setBounds(10,90,164,30);
        leftPanel_1_find.setBounds(10,130,164,30);
        leftPanel_1_find.setText("检索记录");
        leftPanel_1_find.setFocusPainted(false);
        leftPanel_1_find.setBackground(new Color(255, 255, 238,180));
        borrowButton1.setBounds(10,170,164,30);
        borrowButton1.setFocusPainted(false);
        borrowButton1.setBackground(new Color(255, 255, 238,180));
        borrowButton1.setText("申请续借");
        leftPanel_1.add(box_1_0);
        leftPanel_1.add(box_1_1);
//        leftPanel_1.add(borrowButton1);
        leftPanel_1.add(leftPanel_1_in);
        leftPanel_1.add(leftPanel_1_find);
    }

    // 左第三页面设置
    public void leftPanel_2_Loading(){
        // 左第三页面设置
        leftPanel_2.setLayout(null);
        updateInfo.setText("查看信息");
        updateInfo.setFocusPainted(false);
        updateInfo.setBackground(new Color(255, 255, 238,180));
        updateInfo.setBounds(10,10,164,30);
        collectInfo.setText("我的藏书");
        collectInfo.setFocusPainted(false);
        collectInfo.setBackground(new Color(255, 255, 238,180));
        collectInfo.setBounds(10,50,164,30);
        leftPanel_2.add(updateInfo);
        leftPanel_2.add(collectInfo);
    }

    // 左第四页面设置
    public void leftPanel_3_Loading(){
        // 左第四页面设置
        leftPanel_3.setLayout(null);
        libararynotify.setModel(new DefaultComboBoxModel(new Object[]{"-请选择-","开放时间"}));
        Font font = new Font("幼圆",Font.BOLD,14);
        libararynotify.setFont(font);
        libararynotify.setBounds(10,45,164,30); // 10,10,164,30
        libararynotify.setBackground(new Color(255,255,230,190));
        centainBtn.setFocusPainted(false);
        centainBtn.setBackground(new Color(255,255,230,190));
        centainBtn.setBounds(10,95,164,30);
        centainBtn.setFont(font);
        editBtn.setBounds(10,145,110,28);
        editBtn.setFocusPainted(false);
        editBtn.setBackground(new Color(255,255,230,190));
        leftPanel_3.add(centainBtn);
        leftPanel_3.add(libararynotify);
    }

    // 左边父页面的统一尾设置
    public void leftPanelTailLoading(){
        // 左四个页面的统一设置
        leftPanel_0.setBackground(new Color(255, 255, 238,230));
        leftPanel_1.setBackground(new Color(255, 255, 238,230));
        leftPanel_2.setBackground(new Color(255, 255, 238,230));
        leftPanel_3.setBackground(new Color(255, 255, 238,230));

        leftPanel.add(cardName[0],leftPanel_0);
        leftPanel.add(cardName[1],leftPanel_1);
        leftPanel.add(cardName[2],leftPanel_2);
        leftPanel.add(cardName[3],leftPanel_3);
    }

    // 下部四个页面的父页面的头设置
    public void bigPanelHeadLoading(){
        // bigPanel
        bigPanel.setBounds(191,166,418,275);
        bigPanel.setBackground(new Color(255, 255, 238,190));
        bigPanel.setBorder(BorderFactory.createEtchedBorder());
        bigPanel.setLayout(card2);
    }

    // 下部第一个页面的设置
    public void bigPanel_0_Loading(){
        // 下第一页面
        bigPanel_0.setLayout(null);

        Object[][] data ={};
        JScrollPane scrollPanel = new JScrollPane();
        scrollPanel.setBounds(10,10,400,183);
        tableBook = new JTable(data,colName);
        tableBook.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单选
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        tableBook.setDefaultRenderer(Object.class, r);
        tableBook.getTableHeader().setReorderingAllowed(false);//列不能移动
        scrollPanel.setViewportView(tableBook);
        // 按钮设置
        homePage.setBounds(10,210,96,20);
        prePage.setBounds(111,210,96,20);
        nextPage.setBounds(212,210,96,20);
        lastPage.setBounds(313,210,96,20);
        homePage.setText("首页");
        prePage.setText("上一页");
        nextPage.setText("下一页");
        lastPage.setText("末页");
        homePage.setFocusPainted(false);
        homePage.setBackground(new Color(255, 255, 238,200));
        prePage.setFocusPainted(false);
        prePage.setBackground(new Color(255, 255, 238,200));
        nextPage.setFocusPainted(false);
        nextPage.setBackground(new Color(255, 255, 238,200));
        lastPage.setFocusPainted(false);
        lastPage.setBackground(new Color(255, 255, 238,200));
        atPre.setText("当前:");
        atPre.setBounds(10,240,35,20);
        atPreNum.setText("1");
        atPreNum.setBounds(46,240,30,20);
        atPreTail.setText("页");
        atPreTail.setBounds(77,240,15,20);
        sumHead.setText("总数:");
        sumHead.setBounds(325,240,35,20);
        sumHeadNum.setText("10");
        sumHeadNum.setBounds(361,240,30,20);
        sumTail.setText("页");
        sumTail.setBounds(392,240,15,20);
        jumpHead.setText("跳至：");
        jumpHead.setBounds(111,240,40,20);
        jumpNumber.setBounds(146,240,35,20);
        jumpTail.setText("页");
        jumpTail.setBounds(186,240,15,20);
        jumpButton.setText("跳转");
        jumpButton.setBounds(212,240,96,20);
        jumpButton.setFocusPainted(false);
        jumpButton.setBackground(new Color(255, 255, 238,200));
        bigPanel_0.add(atPre);
        bigPanel_0.add(atPreNum);
        bigPanel_0.add(atPreTail);
        bigPanel_0.add(sumHead);
        bigPanel_0.add(sumHeadNum);
        bigPanel_0.add(sumTail);
        bigPanel_0.add(jumpHead);
        bigPanel_0.add(jumpTail);
        bigPanel_0.add(jumpNumber);
        bigPanel_0.add(jumpButton);
        bigPanel_0.add(homePage);
        bigPanel_0.add(prePage);
        bigPanel_0.add(nextPage);
        bigPanel_0.add(lastPage);
        bigPanel_0.add(scrollPanel);
    }

    // 下部第二个页面的设置
    public void bigPanel_1_Loading(){
        // 下二页面
        bigPanel_1.setLayout(null);

        Object[][] data2 ={};
        tableRecord = new JTable(data2,colName2);
        JScrollPane scrollPanel1 = new JScrollPane();
        scrollPanel1.setBounds(10,10,400,183);
        tableRecord.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单选
        DefaultTableCellRenderer r1 = new DefaultTableCellRenderer();
        r1.setHorizontalAlignment(JLabel.CENTER);
        tableRecord.setDefaultRenderer(Object.class, r1);
        tableRecord.getTableHeader().setReorderingAllowed(false);//列不能移动
        scrollPanel1.setViewportView(tableRecord);

        // 按钮设置
        homePage1.setBounds(10,210,96,20);
        prePage1.setBounds(111,210,96,20);
        nextPage1.setBounds(212,210,96,20);
        lastPage1.setBounds(313,210,96,20);
        homePage1.setText("首页");
        prePage1.setText("上一页");
        nextPage1.setText("下一页");
        lastPage1.setText("末页");
        homePage1.setFocusPainted(false);
        homePage1.setBackground(new Color(255, 255, 238,200));
        prePage1.setFocusPainted(false);
        prePage1.setBackground(new Color(255, 255, 238,200));
        nextPage1.setFocusPainted(false);
        nextPage1.setBackground(new Color(255, 255, 238,200));
        lastPage1.setFocusPainted(false);
        lastPage1.setBackground(new Color(255, 255, 238,200));
        atPre1.setText("当前:");
        atPre1.setBounds(10,240,35,20);
        atPreNum1.setText("1");
        atPreNum1.setBounds(46,240,30,20);
        atPreTail1.setText("页");
        atPreTail1.setBounds(77,240,15,20);
        sumHead1.setText("总数:");
        sumHead1.setBounds(325,240,35,20);
        sumHeadNum1.setText("10");
        sumHeadNum1.setBounds(361,240,30,20);
        sumTail1.setText("页");
        sumTail1.setBounds(392,240,15,20);
        jumpHead1.setText("跳至：");
        jumpHead1.setBounds(111,240,40,20);
        jumpNumber1.setBounds(146,240,35,20);
        jumpTail1.setText("页");
        jumpTail1.setBounds(186,240,15,20);
        jumpButton1.setText("跳转");
        jumpButton1.setBounds(212,240,96,20);
        jumpButton1.setFocusPainted(false);
        jumpButton1.setBackground(new Color(255, 255, 238,200));
        bigPanel_1.add(atPre1);
        bigPanel_1.add(atPreNum1);
        bigPanel_1.add(atPreTail1);
        bigPanel_1.add(sumHead1);
        bigPanel_1.add(sumHeadNum1);
        bigPanel_1.add(sumTail1);
        bigPanel_1.add(jumpHead1);
        bigPanel_1.add(jumpTail1);
        bigPanel_1.add(jumpNumber1);
        bigPanel_1.add(jumpButton1);
        bigPanel_1.add(homePage1);
        bigPanel_1.add(prePage1);
        bigPanel_1.add(nextPage1);
        bigPanel_1.add(lastPage1);
        bigPanel_1.add(scrollPanel1);
    }

    // 下部第三个页面的设置
    public void bigPanel_2_Loading(){
        // 下三页面
        bigPanel_2.setLayout(card3);
        // infoPanel的设置
        infoPanel.setLayout(null);
        myNameLabel.setBounds(20,20,60,30);
        myNameContent.setText(user.getUsername());
        myNameContent.setBounds(90,20,110,30);
        myIDLabel.setBounds(20,60,60,30);
        myIDContent.setText(String.valueOf(user.getID()));
        myIDContent.setBounds(90,60,110,30);;
        myEmailLabel.setBounds(20,110,60,30);
        myEmailContent.setText(user.getEmail());
        myEmailContent.setBounds(90,110,110,30);
        myAdressLabel.setBounds(20,160,60,30);
        myAdressContent.setText(user.getAddress());
        myAdressContent.setBounds(90,160,110,30);
        infoPanel.setBackground(new Color(255, 255, 238,245));
        infoPanel.add(myNameLabel);
        infoPanel.add(myNameContent);
        infoPanel.add(myIDLabel);
        infoPanel.add(myIDContent);
        infoPanel.add(myEmailLabel);
        infoPanel.add(myEmailContent);
        infoPanel.add(myAdressLabel);
        infoPanel.add(myAdressContent);
        // collectPanel的设置
        collectPanel.setLayout(null);

        Object[][] data ={};
        collectTable = new JTable(data,colName);
        JScrollPane scrollPanel = new JScrollPane();
        scrollPanel.setBounds(10,10,400,183);
        collectTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单选
        DefaultTableCellRenderer r1 = new DefaultTableCellRenderer();
        r1.setHorizontalAlignment(JLabel.CENTER);
        collectTable.setDefaultRenderer(Object.class, r1);
        collectTable.getTableHeader().setReorderingAllowed(false);//列不能移动
        scrollPanel.setViewportView(collectTable);
        // 按钮设置
        collectPanel.add(scrollPanel);
        bigPanel_2.add(cardName3[0],infoPanel);
        bigPanel_2.add(cardName3[1],collectPanel);
    }

    // 下部第四个页面的设置
    public void bigPanel_3_Loading(){
         /*
        馆记
         */
        bigPanel_3.setLayout(null);
        Font contentFont = new Font("微软雅黑",Font.BOLD,18);
        Object[][] libararyData ={};
        JScrollPane scrollPanel3 = new JScrollPane();
        scrollPanel3.setBounds(10,10,400,255);
        libararyTable = new JTable(libararyData,tableLibarary);
        libararyTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单选
        DefaultTableCellRenderer deli = new DefaultTableCellRenderer();
        deli.setHorizontalAlignment(JLabel.CENTER);
        libararyTable.setDefaultRenderer(Object.class, deli);
        libararyTable.getTableHeader().setReorderingAllowed(false);//列不能移动
        scrollPanel3.setViewportView(libararyTable);
        bigPanel_3.add(scrollPanel3);
    }

    // 下部第四个页面的父页面的尾设置
    public void bigPanelTailLoading(){
        // 下四个页面的统一设置
        bigPanel_0.setBackground(new Color(255, 255, 238,230));
        bigPanel_1.setBackground(new Color(255, 255, 238,230));
        bigPanel_2.setBackground(new Color(255, 255, 238,230));
        bigPanel_3.setBackground(new Color(255, 255, 238,230));
        bigPanel.add(cardName2[0],bigPanel_0);
        bigPanel.add(cardName2[1],bigPanel_1);
        bigPanel.add(cardName2[2],bigPanel_2);
        bigPanel.add(cardName2[3],bigPanel_3);
    }

    //  全局父panel尾设置
    public void navTailLoading(){
        // 父panel添加组件
        fatherPanel.add(bigPanel);
        fatherPanel.add(leftPanel);
        fatherPanel.add(navPanel);
        this.add(fatherPanel);
    }

    // 事件
    public void event(){
        books.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showBook();
            }
        });
        record.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showRecord();
            }
        });
        my.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showMy();
            }
        });
        intro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showIntro();
            }
        });
        leftPanel_0_find.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                querySome();
            }
        });
        leftPanel_1_find.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                queryRecordTable();
            }
        });
        updateInfo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showInfo();
            }
        });
        collectInfo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showCollect();
            }
        });
        collectButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                collectBookToCollectTable();
            }
        });
        borrowButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                borrowBookToRecordTable();
            }
        });
        homePage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                toHomePage();
            }
        });
        lastPage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                toLastPage();
            }
        });
        prePage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                toPrePage();
            }
        });
        nextPage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                toNextPage();
            }
        });
        jumpButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jumpPage();
            }
        });
        homePage1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                toHomePage1();
            }
        });
        lastPage1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                toLastPage1();
            }
        });
        prePage1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                toPrePage1();
            }
        });
        nextPage1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                toNextPage1();
            }
        });
        jumpButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jumpPage1();
            }
        });
        //给馆记中的确定按钮添加一个事件
        centainBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                watch();
            }
        });
    }

    public abstract void watch();

    public abstract void jumpPage1();

    public abstract void toHomePage1();

    public abstract void toLastPage1();

    public abstract void toPrePage1();

    public abstract void toNextPage1();

    public abstract void jumpPage();

    public abstract void toHomePage();

    public abstract void toLastPage();

    public abstract void toPrePage();

    public abstract void toNextPage();

    public abstract void borrowBookToRecordTable();

    public abstract void collectBookToCollectTable();

    public abstract void showBook();

    public abstract void showRecord();

    public abstract void showMy();

    public abstract void showIntro();

    public abstract void querySome();

    public abstract void queryRecordTable();

    public abstract void updateFrame();

    public abstract void showCollect();

    public abstract void showInfo();
}
