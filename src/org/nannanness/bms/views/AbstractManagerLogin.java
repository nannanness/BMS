package org.nannanness.bms.views;

import org.nannanness.bms.tools.GUITools;
import org.nannanness.bms.controller.UserPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
管理员界面
 */
public abstract class AbstractManagerLogin extends JFrame {
    private final int frameWidth = 620;
    private final int frameHeight = 480;
    // 父面板
    private final JPanel fatherPanel = new UserPanel();
    // 首部，左部 中部
    private final JPanel navPanel = new JPanel();
    protected final JPanel leftPanel = new JPanel();
    protected final JPanel bigPanel = new JPanel();
    // 图书库 用户库 信息库 馆记
    protected final JButton bookInfo = new JButton();
    protected final JButton userInfo = new JButton();
    protected final JButton borrowInfo = new JButton();
    protected final JButton libararyInfo = new JButton();
    // 使用卡片布局，将其分为左半部分和中下部分
    protected final CardLayout card = new CardLayout();
    protected final String cardName[] = {"labelBook","labelUser","labelInfo","labelMy"};
    protected final CardLayout card2 = new CardLayout();
    protected final String cardName2[] = {"labelBook","labelUser","labelInfo","labelMy"};
    // 左边分为四个面板
    protected final JPanel leftPanel_0 = new JPanel();
    protected final JPanel leftPanel_1 = new JPanel();
    protected final JPanel leftPanel_2 = new JPanel();
    protected final JPanel leftPanel_3 = new JPanel();

    //左1 --图书库的信息
    protected final JComboBox typeSpecific = new JComboBox();
    protected final JButton specificInfo = new JButton();

    // 左2 --用户库的信息
    protected final JTextField userSearchText = new JTextField();
    protected final JComboBox searchUserChoice = new JComboBox();
    protected final JButton beginBtn = new JButton("开始检索");
    protected JButton addBtnUser = new JButton("添加");
    protected JButton deleteBtn1User = new JButton("删除");

    // 左3 —— 信息库
    protected final JComboBox bookSearch = new JComboBox();
    protected  final JButton yesBtn = new JButton("确定");
    protected final JButton editBtn1 = new JButton("编辑");

    // 左4 —— 馆记
    protected JComboBox libararynotify = new JComboBox();
    protected JButton centainBtn = new JButton("确定");
    protected JButton editBtn = new JButton("编辑");

    //下方 —— bigPanel
    protected final JPanel bigPanel_0 = new JPanel();
    protected final JPanel bigPanel_1 = new JPanel();
    protected final JPanel bigPanel_2 = new JPanel();
    protected final JPanel bigPanel_3 = new JPanel();
    protected String[] book2ColName = {"图书类别名称","图书类别描述","图书库存"};

    // 下1 —— 图书库
    protected JTable tableBook = null;

    // 下2 —— 用户库
    protected JTable tableUser = null;
    protected String[] usercolName = {"用户id","用户昵称","用户邮箱","用户住址"};
    protected JButton homePageBtn = new JButton("首页");
    protected JButton nextPageBtn = new JButton("上一页");
    protected JButton backPageBtn = new JButton("下一页");
    protected JButton lastPageBtn = new JButton("末页");
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

    // 下3 —— 信息库
    protected JTable borrowTable = null;
    protected String[] tableInfo = {"用户ID","借阅图书名称","借书日期","归还状态"};
    // 下4 —— 馆记
    protected JTable libararyTable = null;
    protected String[] tableLibarary = {"名称","地点","服务","开放时间"};

    // 详细书单的弹窗
    protected AbstractSpecificInfo specificInfoFrame = null;

    public AbstractManagerLogin(){
        initManager();
        fatherPanelHeadLoad();
        navPanelLoad();
        leftPanelHeadLoad();
        leftPanel_0_Load();
        leftPanel_1_Load();
        leftPanel_2_Load();
        leftPanel_3_Load();
        leftPanelTailLoad();
        bigPanelHeadLoad();
        bigPanel_0_Load();
        bigPanel_1_Load();
        bigPanel_2_Load();
        bigPanel_3_Load();
        bigPanelTailLoad();
        fatherPanelTailLoad();
        addListener();
    }

    public void initManager(){
        this.setLayout(null);
        this.setSize(frameWidth,frameHeight);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("市立图书馆");
        Image logo = Toolkit.getDefaultToolkit().getImage("img/logo.png");;
        this.setIconImage(logo);
        GUITools.center(this);
    }

    // 父panel头设置
    public void fatherPanelHeadLoad(){
        // 父panel
        fatherPanel.setLayout(null);
        fatherPanel.setBounds(0,0,620,480);
    }

    // navPanel设置
    public void navPanelLoad(){
        // 导航栏panel
        navPanel.setBounds(5,5,605,160);
        navPanel.setBackground(new Color(255, 255, 238,200));
        navPanel.setBorder(BorderFactory.createEtchedBorder());
        navPanel.setLayout(null);
        // navPanel中的内容
        // logo
        ImageIcon navIcon = new ImageIcon("img/managerLogo.png");
        navIcon.setImage(navIcon.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT));
        JLabel navIconLabel = new JLabel(navIcon);
        navIconLabel.setBounds(10,10,150,150);
        // 首部button的设置
        Font navfont = new Font("华文楷体",Font.BOLD,18);
        bookInfo.setFont(navfont);
        bookInfo.setFocusPainted(false);
        bookInfo.setBackground(new Color(255,255,230,200));
        userInfo.setBackground(new Color(255,255,230,200));
        borrowInfo.setBackground(new Color(255,255,230,200));
        libararyInfo.setBackground(new Color(255,255,230,200));
        userInfo.setFont(navfont);
        borrowInfo.setFont(navfont);
        libararyInfo.setFont(navfont);
        bookInfo.setBorder(BorderFactory.createEtchedBorder());
        userInfo.setBorder(BorderFactory.createEtchedBorder());
        borrowInfo.setBorder(BorderFactory.createEtchedBorder());
        libararyInfo.setBorder(BorderFactory.createEtchedBorder());
        bookInfo.setBounds(190,100,102,50);
        userInfo.setBounds(293,100,102,50);
        borrowInfo.setBounds(396,100,102,50);
        libararyInfo.setBounds(499,100,102,50);
        bookInfo.setText("图书库");
        userInfo.setText("用户库");
        borrowInfo.setText("信息库");
        libararyInfo.setText("馆记");
        //设置绘制边框
        bookInfo.setFocusPainted(false);
        userInfo.setFocusPainted(false);
        borrowInfo.setFocusPainted(false);
        libararyInfo.setFocusPainted(false);
        // 字体image
        JLabel bgImage = new JLabel();
        ImageIcon bgIcon = new ImageIcon("img/userImage.png");
        bgIcon.setImage(bgIcon.getImage().getScaledInstance(410,99,Image.SCALE_DEFAULT));
        bgImage.setBounds(170,5,410,99);
        bgImage.setIcon(bgIcon);
        // 首部添加按钮组件
        navPanel.add(navIconLabel);
        navPanel.add(bookInfo);
        navPanel.add(userInfo);
        navPanel.add(borrowInfo);
        navPanel.add(libararyInfo);
        navPanel.add(bgImage);
    }

    // 左边设置
    public void leftPanelHeadLoad(){
        // 左边设置为卡片布局
        leftPanel.setBounds(5,166,184,275);
        leftPanel.setBackground(new Color(255, 255, 238,200));
        leftPanel.setBorder(BorderFactory.createEtchedBorder());
        leftPanel.setLayout(card);
    }

    // 左1 —— 图书库设置
    public void leftPanel_0_Load(){
        /*
         图书库--详细信息
          */
        leftPanel_0.setLayout(null);
        specificInfo.setText("详询");
        specificInfo.setBackground(new Color(255,255,235,200));
        typeSpecific.setBounds(10,45,164,30);//10,10,164,30
        specificInfo.setFocusPainted(false);
        specificInfo.setBounds(10,85,164,30);
        typeSpecific.setModel(new DefaultComboBoxModel(new Object[]{"-请选择-","全部","科幻小说","成功励志","经济管理","文学艺术","职场提升","心灵治愈","互联网","心理课堂","名人传记","历史小说"}));
        leftPanel_0.add(typeSpecific);
        leftPanel_0.add(specificInfo);
    }

    // 左2 —— 用户库设置
    public void leftPanel_1_Load(){
        /*
         用户库 文本框 下拉列表 开始检索 添加 删除
          */
        leftPanel_1.setLayout(null);
        userSearchText.setBounds(10,35,164,30);
        searchUserChoice.setModel(new DefaultComboBoxModel(new String[]{"-请选择-","用户id","用户昵称","全部信息"}));
        searchUserChoice.setBounds(10,75,164,30);
        beginBtn.setBounds(10,115,164,30);
        beginBtn.setFocusPainted(false);
        beginBtn.setBackground(new Color(255,255,238,200));
        addBtnUser.setBounds(10,155,164,30);
        addBtnUser.setBackground(new Color(255,255,235,200));
        deleteBtn1User.setBounds(10,195,164,30);
        deleteBtn1User.setBackground(new Color(255,255,235,200));
        leftPanel_1.add(userSearchText);
        leftPanel_1.add(searchUserChoice);
        leftPanel_1.add(beginBtn);
//        leftPanel_1.add(addBtnUser);
        leftPanel_1.add(deleteBtn1User);
    }

    // 左3 —— 信息库设置
    public void leftPanel_2_Load(){
        /*
        信息库
         */
        //检索图书文本框
        leftPanel_2.setLayout(null);
        bookSearch.setBounds(10,45,164,30);
        bookSearch.setModel(new DefaultComboBoxModel(new Object[]{"-请选择图书归还状态-","已归还","未归还","预借"}));
        yesBtn.setBounds(10,95,164,30);
        yesBtn.setBackground(new Color(255,255,238,200));
        yesBtn.setFocusPainted(false);
        editBtn1.setBounds(10,145,164,30);
        editBtn1.setFocusPainted(false);
        editBtn1.setBackground(new Color(255,255,230,200));
        leftPanel_2.add(yesBtn);
        leftPanel_2.add(bookSearch);
        //leftPanel_2.add(editBtn1);
    }

    // 左4 —— 馆记设置
    public void leftPanel_3_Load(){
        // 左第四页面设置
        leftPanel_3.setLayout(null);
        libararynotify.setModel(new DefaultComboBoxModel(new Object[]{"-请选择-","开放时间"}));
        Font font = new Font("幼圆",Font.BOLD,14);
        libararynotify.setFont(font);
        libararynotify.setBounds(10,45,164,30);
        centainBtn.setFocusPainted(false);
        centainBtn.setBackground(new Color(255,255,230,200));
        centainBtn.setBounds(10,95,164,30);
        centainBtn.setFont(font);
        editBtn.setBounds(10,145,164,30);
        editBtn.setFocusPainted(false);
        editBtn.setBackground(new Color(255,255,230,200));
        leftPanel_3.add(centainBtn);
        leftPanel_3.add(libararynotify);
        //leftPanel_3.add(editBtn);
    }

    // 左边尾设置
    public void leftPanelTailLoad(){
        //对左边四个面板的统一设置
        leftPanel_0.setBackground(new Color(255, 255, 238,230));
        leftPanel_1.setBackground(new Color(255, 255, 238,230));
        leftPanel_2.setBackground(new Color(255, 255, 238,230));
        leftPanel_3.setBackground(new Color(255, 255, 238,230));
        //将左边布局面板依次设置为卡片布局
        leftPanel.add(cardName[0],leftPanel_0);
        leftPanel.add(cardName[1],leftPanel_1);
        leftPanel.add(cardName[2],leftPanel_2);
        leftPanel.add(cardName[3],leftPanel_3);
    }

    // 下方Panel设置
    public void bigPanelHeadLoad(){
        // 中下方的布局
        bigPanel.setBounds(191,166,418,275);
        bigPanel.setBackground(new Color(255, 255, 238,190));
        bigPanel.setBorder(BorderFactory.createEtchedBorder());
        //布局格式是卡片布局
        bigPanel.setLayout(card2);
    }

    // 下1 —— 图书库
    public void bigPanel_0_Load(){
         /*
         图书库
         */
        bigPanel_0.setLayout(null);

        Object[][] data = {};
        //添加一个滚动条
        JScrollPane scrollPanel = new JScrollPane();
        scrollPanel.setBounds(10,10,400,255);
        //将数据和列名添加进去
        tableBook = new JTable(data,book2ColName);
        //设置单选按钮
        tableBook.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //单元格的标准类
        DefaultTableCellRenderer defa = new DefaultTableCellRenderer();
        defa.setHorizontalAlignment(JLabel.CENTER);
        tableBook.setDefaultRenderer(Object.class,defa);
        //设置列不能移动
        tableBook.getTableHeader().setReorderingAllowed(false);
        //自动添加表头
        scrollPanel.setViewportView(tableBook);
        //tableBook.setPreferredScrollableViewportSize(new Dimension(300, 80))
        bigPanel_0.add(scrollPanel);
    }

    // 下2 —— 用户库
    public void bigPanel_1_Load(){
        /*
        用户库
         */
        bigPanel_1.setLayout(null);

        Object[][] userdata ={};
        JScrollPane scrollPanel1 = new JScrollPane();
        scrollPanel1.setBounds(10,10,400,180);
        tableUser = new JTable(userdata,usercolName);
        tableUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单选
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        tableUser.setDefaultRenderer(Object.class, r);
        tableUser.getTableHeader().setReorderingAllowed(false);//列不能移动
        scrollPanel1.setViewportView(tableUser);
        //首页 下一页 上一页 末页 设置位置 文本域 绘制焦点 背景
        homePageBtn.setBounds(10,210,96,20);
        nextPageBtn.setBounds(111,210,96,20);
        backPageBtn.setBounds(212,210,96,20);
        lastPageBtn.setBounds(313,210,96,20);
        homePageBtn.setFocusPainted(false);
        homePageBtn.setBackground(new Color(255, 255, 238,200));
        backPageBtn.setFocusPainted(false);
        backPageBtn.setBackground(new Color(255, 255, 238,200));
        nextPageBtn.setFocusPainted(false);
        nextPageBtn.setBackground(new Color(255, 255, 238,200));
        lastPageBtn.setFocusPainted(false);
        lastPageBtn.setBackground(new Color(255, 255, 238,200));
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
        bigPanel_1.add(scrollPanel1);
    }

    // 下3 —— 信息库
    public void bigPanel_2_Load(){
        /*
        信息库
         */
        bigPanel_2.setLayout(null);

        Object[][] Infodata ={};
        JScrollPane scrollPanel2 = new JScrollPane();
        scrollPanel2.setBounds(10,10,400,255);
        borrowTable = new JTable(Infodata,tableInfo);
        borrowTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单选
        DefaultTableCellRenderer defau = new DefaultTableCellRenderer();
        defau.setHorizontalAlignment(JLabel.CENTER);
        borrowTable.setDefaultRenderer(Object.class, defau);
        borrowTable.getTableHeader().setReorderingAllowed(false);//列不能移动
        scrollPanel2.setViewportView(borrowTable);
        bigPanel_2.add(scrollPanel2);
    }

    // 下4 —— 馆记
    public void bigPanel_3_Load(){
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

    // 下方结尾
    public void bigPanelTailLoad(){
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

    // 父panel尾设置
    public void fatherPanelTailLoad(){
        fatherPanel.add(navPanel);
        fatherPanel.add(leftPanel);
        fatherPanel.add(bigPanel);
        this.add(fatherPanel);
    }

    public void addListener(){
        //给图书库绑定一个事件，弹出面板
        bookInfo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showBook();
            }
        });
        //用户库对应的面板
        userInfo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showUser();
            }
        });
        //信息库对应的面板
        borrowInfo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showInfo();
            }
        });
        //馆记对应的面板
        libararyInfo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showMy();
            }
        });
        //详细信息绑定事件
        specificInfo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    specific();
            }
        });
        //开始检索用户绑定事件
        beginBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                search();
            }
        });
        //添加按钮绑定事件
        addBtnUser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                add();
            }
        });
        //确定按钮绑定事件
        yesBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                active();
            }
        });

        editBtn1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                editInfo();
            }
        });

        //给馆记中的确定按钮添加一个事件
        centainBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                watch();
            }
        });

        deleteBtn1User.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                deleteUser();
            }
        });

        jumpButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jumpPage();
            }
        });

        homePageBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                goHomePage();
            }
        });

        lastPageBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                goLastPage();
            }
        });

        nextPageBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                goNextPage();
            }
        });

        backPageBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                goBackPage();
            }
        });
    }

    public abstract void editInfo();
    public abstract void showBook();
    public abstract void showUser();
    public abstract void showInfo();
    public abstract void showMy();
    public abstract void specific();
    public abstract void add();
    public abstract void search();
    public abstract void active();
    public abstract void watch();
    public abstract void deleteUser();
    public abstract void goHomePage();
    public abstract void goLastPage();
    public abstract void goNextPage();
    public abstract void goBackPage();
    public abstract void jumpPage();
}
