package org.nannanness.bms.views;

import org.nannanness.bms.controller.MyPanel;
import org.nannanness.bms.domain.User;
import org.nannanness.bms.tools.GUITools;
import org.nannanness.bms.tools.VerifiCodeUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class AbstractLogin extends JFrame{
    private final int frameWidth = 600;
    private final int frameHeight = 480;
    protected final int logoWidth = 120;
    protected final int logoHeight =100;
    private final int logoX = 420;
    private final int logoY = 10;
    private final int titleX = 50;
    private final int titleY = 50;
    private final int titleWidth = 350;
    private final int titleHeight = 100;
    protected final int globalHeight = 30;
    private final int col_1_X = 420;
    private final int row_1_Y = 120;
    private final int row_2_Y = 155;
    private final int row_3_Y = 190;
    private final int row_4_Y = 225;
    private final int row_5_Y = 260;
    private final int row_6_Y = 295;
    private final int row_7_Y = 335;
    private final int row_8_Y = 370;
    protected final int col_1_width = 120;

    private final int titleFont = 20;
    private final int loginFont = 18;
    private final int tipsFont = 14;
    private final int regX = 380;
    private final int loginX = 500;
    private final int reg_login_Y = 410;
    private final int reg_login_width = 80;
    protected JLabel title = new JLabel();
    private JLabel userName = new JLabel();
    protected JTextField userText = new JTextField();
    private JLabel password = new JLabel();
    protected JPasswordField pswText = new JPasswordField();
    private JLabel verCode = new JLabel();
    protected JTextField codText= new JTextField();
    protected JLabel code = new JLabel();
    protected JLabel codeTips = new JLabel();
    protected JButton reg = new JButton();
    protected JButton login = new JButton();
    protected JPanel panel = new MyPanel();
    protected boolean boolCode = false;
    protected boolean userCut = false;
    protected AbstractUser userView = null;
    protected AbstractManagerLogin manager = null;
    protected JLabel loginLogo = null;
    protected ImageIcon img = null;
    protected User user;
    protected AbstractRegister res;

    public AbstractLogin(){
        init();
        loadComponents();
        event();
    }

    public void init(){
        this.setSize(frameWidth,frameHeight);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("市立图书馆");
        Image logo = Toolkit.getDefaultToolkit().getImage("img/logo.png");
        this.setIconImage(logo);
        GUITools.center(this);
    }

    public void loadComponents(){
        panel.setLayout(null);
        // 登录页面的字体
        Font font = new Font("宋体",Font.BOLD,loginFont);
        // login页面图标
        img = new ImageIcon("img/loginLogo.png");
        img.setImage(img.getImage().getScaledInstance(logoWidth,logoHeight,Image.SCALE_DEFAULT));
        loginLogo = new JLabel();
        loginLogo.setIcon(img);
        loginLogo.setBounds(logoX,logoY,logoWidth,logoHeight);
        // login页面标题
        Font titFont = new Font("仿宋",Font.BOLD,titleFont);
        title.setFont(titFont);
        title.setText("<html>馆长说：<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;爱读书的人<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;运气不会太差</html>");
        title.setBounds(titleX,titleY,titleWidth,titleHeight);
        // 用户名
        userName.setFont(font);
        userName.setText("用 户 名：");
        userName.setIcon(new ImageIcon("img/user.png"));
        userName.setBounds(col_1_X,row_1_Y,col_1_width,globalHeight);
        userText.setBounds(col_1_X,row_2_Y,col_1_width,globalHeight);
        // 密码
        password.setFont(font);
        password.setText("密    码：");
        password.setIcon(new ImageIcon("img/psd.png"));
        password.setBounds(col_1_X,row_3_Y,col_1_width,globalHeight);
        pswText.setBounds(col_1_X,row_4_Y,col_1_width,globalHeight);
        // 验证码
        verCode.setFont(font);
        verCode.setIcon(new ImageIcon("img/code.png"));
        verCode.setText("验 证 码：");
        verCode.setBounds(col_1_X,row_5_Y,col_1_width,globalHeight);
        codText.setBounds(col_1_X,row_6_Y,col_1_width,globalHeight);
        Font codeFont = new Font("华文楷体",Font.PLAIN,tipsFont);
        codeTips.setFont(codeFont);
        codeTips.setForeground(Color.red);
        codeTips.setBounds(col_1_X,row_8_Y,col_1_width,globalHeight);
        code.setIcon(new ImageIcon(VerifiCodeUtil.getBufferdImage(col_1_width,globalHeight)));
        code.setBounds(col_1_X,row_7_Y,col_1_width,globalHeight);
        // 登录和注册
        Font RLFont = new Font("华文楷体",Font.BOLD,loginFont);
        reg.setFont(RLFont);
        reg.setIcon(new ImageIcon("img/reset.png"));
        reg.setText("注册");
        reg.setBounds(regX,reg_login_Y,reg_login_width,globalHeight);
        login.setFont(RLFont);
        login.setIcon(new ImageIcon("img/login.png"));
        login.setText("登陆");
        login.setBounds(loginX,reg_login_Y,reg_login_width,globalHeight);
        // reg和login按钮的美化
        reg.setFocusPainted(false);
        login.setFocusPainted(false);
        reg.setBackground(new Color(170, 170, 187,200));
        login.setBackground(new Color(170, 170, 187,200));
        reg.setBorder(BorderFactory.createRaisedBevelBorder());
        login.setBorder(BorderFactory.createRaisedBevelBorder());
        // 面板添加组件
        panel.add(loginLogo);
        panel.add(title);
        panel.add(userName);
        panel.add(userText);
        panel.add(password);
        panel.add(pswText);
        panel.add(verCode);
        panel.add(codText);
        panel.add(codeTips);
        panel.add(code);
        panel.add(reg);
        panel.add(login);
        // 添加面板
        this.add(panel);
    }

    public void event(){
        code.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                code.setIcon(new ImageIcon(VerifiCodeUtil.getBufferdImage(col_1_width,globalHeight)));
            }
        });
        codText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                checkCode();
            }
        });
        reg.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                register();
            }
        });
        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                login();
            }
        });
        loginLogo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cut();
            }
        });
    }

    public abstract void checkCode();

    public abstract void register();

    public abstract void login();

    public abstract void cut();
}
