package org.nannanness.bms.test;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JTabbedPane pane = new JTabbedPane();
        pane.setTabPlacement(JTabbedPane.BOTTOM);
        // JButton b = new JButton("分类");
        JPanel panel = new JPanel();
        panel.add(new JLabel("panel --> label"));
        pane.add(panel);
        pane.setTabComponentAt(0,new JLabel("分类"));
        pane.addTab("选择",new JLabel("12345"));

        frame.setSize(500,300);
        frame.add(pane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
