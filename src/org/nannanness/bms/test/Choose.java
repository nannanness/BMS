package org.nannanness.bms.test;

import javax.swing.*;
import java.awt.*;

public class Choose extends JFrame {

    private JLabel lable = new JLabel("选择水果");
    private JComboBox cb = new JComboBox();
    private JButton button = new JButton("OK");
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();


    public Choose() {
        String[] fruit = {"水果","苹果","葡萄","香蕉","橘子","水果","苹果","葡萄","香蕉","橘子"};
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,300);
        GridLayout grid = new GridLayout(2, 1);
        setLayout(grid);

//        FlowLayout flow = new FlowLayout();
//        panel1.setLayout(flow);
//        panel1.add(lable);
//        add(panel1);

        FlowLayout flow2 = new FlowLayout();
        panel2.setLayout(flow2);
        panel2.add(cb);
        panel2.add(button);
        cb.addItem(fruit[0]);
        cb.addItem(fruit[1]);
        cb.addItem(fruit[2]);
        cb.addItem(fruit[3]);
        cb.addItem(fruit[4]);
        cb.addItem(fruit[5]);
        cb.addItem(fruit[6]);
        cb.addItem(fruit[7]);
        cb.addItem(fruit[8]);

        add(panel2);

        setVisible(true);
    }
    public static void main(String[] args) {
        Choose frame = new Choose();
    }

}