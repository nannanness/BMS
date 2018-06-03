package org.nannanness.bms.views;

import oracle.jrockit.jfr.JFR;

import org.nannanness.bms.controller.SecondBackPanel;
import org.nannanness.bms.domain.User;
import org.nannanness.bms.service.IUserService;
import org.nannanness.bms.service.serviceImpl.UserServiceImpl;
import org.nannanness.bms.tools.GUITools;
import org.nannanness.bms.tools.Validator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 用户注册界面
 */
public class AbstractRegister extends JFrame{
    private Font font = new Font("幼圆",Font.BOLD,16);
    private JLabel userName = new JLabel("用户  名:");
    public JTextField  nameText = new JTextField();
    private JLabel usePassword = new JLabel("密    码:");
    public JPasswordField passwordText = new JPasswordField();
    private JLabel centainPassword = new JLabel("确认密码:");
    protected JPasswordField passwordText1 = new JPasswordField();
    private JLabel userTel = new JLabel("电话号  :");
    protected JTextField telText = new JTextField();
    private JLabel userEmail = new JLabel("邮    箱:");
    protected JTextField emailText = new JTextField();
    private JLabel userAddress = new JLabel("用户住址:");
    protected JTextField  addressText = new JTextField();
    private String username;
    private String password;
    private String phone;
    private String email;
    private String address;
    private User user;
    private IUserService service = new UserServiceImpl();
    private JPanel panel = new JPanel();
    private JFrame fram = new JFrame();
    private boolean b;
    private boolean bb;

    //注册按钮
    private JButton regeistBtn = new JButton("注册");
    private JButton resetBtn = new JButton("重置");
    public AbstractRegister(){
        this.init();
        this.addComponents();
        this.addListener();

    }
    private void init(){
        this.setTitle("用户注册");
        this.setSize(400,585);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("img/注册.png"));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        GUITools.center(this);
    }
    private void addComponents(){

        panel = new SecondBackPanel("img/secondback.jpg");
        panel.setLayout(null);
        userName.setBounds(75,100,80,28);
        nameText.setBounds(165,100,130,28);
        usePassword.setBounds(75,160,80,28);
        passwordText.setBounds(165,160,130,28);
        centainPassword.setBounds(75,220,80,28);
        passwordText1.setBounds(165,220,130,28);
        userTel.setBounds(75,280,80,28);
        telText.setBounds(165,280,130,28);
        userTel.setFont(font);
        telText.setFont(font);
        userEmail.setBounds(75,340,80,28);
        emailText.setBounds(165,340,130,28);
        userEmail.setFont(font);
        emailText.setFont(font);
        userAddress.setBounds(75,400,80,28);
        addressText.setBounds(165,400,130,28);
        userAddress.setFont(font);
        emailText.setFont(font);
        centainPassword.setFont(font);
        userName.setFont(font);
        nameText.setFont(font);
        usePassword.setFont(font);
        passwordText.setFont(font);
        passwordText1.setFont(font);
        regeistBtn.setBounds(55,470,80,28);
        regeistBtn.setFont(font);
        regeistBtn.setFocusPainted(false);
        regeistBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        regeistBtn.setIcon(new ImageIcon("img/reset.png"));
        regeistBtn.setBackground(new Color(255,255,230,180));
        resetBtn.setFont(font);
        resetBtn.setBackground(new Color(255,255,230,180));
        resetBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        resetBtn.setBounds(250,470,80,28);
        resetBtn.setFocusPainted(false);
        resetBtn.setIcon(new ImageIcon("img/user.png"));

        panel.add(userName);
        panel.add(nameText);
        panel.add(usePassword);
        panel.add(passwordText);
        panel.add(centainPassword);
        panel.add(passwordText1);
        panel.add(userTel);
        panel.add(userAddress);
        panel.add(telText);
        panel.add(addressText);
        panel.add(userEmail);
        panel.add(emailText);
        panel.add(regeistBtn);
        panel.add(resetBtn);
        this.add(panel);
    }

    public void over(){
        this.setVisible(false);
    }
    protected void addListener() {
        resetBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               nameText.setText("");
               passwordText.setText("");
               passwordText1.setText("");
               telText.setText("");
               emailText.setText("");
               addressText.setText("");
            }
        });
        regeistBtn.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked (MouseEvent e){
            if(!"".equals(nameText.getText())  &&  !"".equals(passwordText.getPassword())  && !"".equals(passwordText1.getPassword())  &&   !"".equals(telText.getText())  &&  !"".equals(emailText.getText())  &&  !"".equals(addressText.getText())){
                username = nameText.getText();
                password = new String(passwordText.getPassword());
                address = addressText.getText();
                email = emailText.getText();
                phone = telText.getText();
                user = new User(username  ,password , phone , email , address);
                service.insertDemo(user);
                JOptionPane.showMessageDialog(panel,"恭喜你，注册成功","温馨提示",JOptionPane.INFORMATION_MESSAGE);
                over();
            }else {
                JOptionPane.showMessageDialog(panel,"请填写完整","温馨提示",JOptionPane.WARNING_MESSAGE);
            }


        }
        });
        passwordText1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String psd = new String(passwordText.getPassword());
                String psd1 = new String(passwordText1.getPassword());
                if(!psd.equals(psd1)){
                    JOptionPane.showMessageDialog(panel,"两次密码请保持一致","温馨提示",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        telText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                b = Validator.isMobile(telText.getText());
                if(!b){
                    JOptionPane.showMessageDialog(panel,"电话输入有误，请重新输入","温馨提示",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        emailText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                bb = Validator.isEmail(emailText.getText());
                if(!bb){
                    JOptionPane.showMessageDialog(panel,"邮箱格式有误，请重新输入","温馨提示",JOptionPane.WARNING_MESSAGE);
                }
                }
        });
    }
//    public static void main(String[] args){
//        AbstractRegister res = new AbstractRegister();
//        res.setVisible(true);
//    }
}
