package org.nannanness.bms.controller;

import org.nannanness.bms.domain.Book2;
import org.nannanness.bms.service.IBookService;
import org.nannanness.bms.service.serviceImpl.BookServiceImpl;
import org.nannanness.bms.views.AbstractBookAdd;
import javax.swing.*;
/*
  对于添加图书的那两个按钮
 */
public class AddBook extends AbstractBookAdd {
    private IBookService bookService = new BookServiceImpl();
    @Override
    public void edit() {
        //JOptionPane.showMessageDialog(this,"是否确定取消？","市立图书馆爱心提示",JOptionPane.QUESTION_MESSAGE);
        this.setVisible(false);
    }

    @Override
    public void add() {
        String name = nameField.getText();
        String author = authorField.getText();
        String des = descriptionField.getText();
        String type = (String) typeBook.getSelectedItem();
        bookService.add(name,author,des,type);
        nameField.setText("");
        authorField.setText("");
        descriptionField.setText("");;
        JOptionPane.showMessageDialog(this,"添加成功","市立图书馆爱心提示",JOptionPane.INFORMATION_MESSAGE);
        this.setVisible(false);
    }
}
