package org.nannanness.bms.controller;

import org.nannanness.bms.domain.Book;
import org.nannanness.bms.domain.Book2;
import org.nannanness.bms.service.IBookService;
import org.nannanness.bms.service.serviceImpl.BookServiceImpl;
import org.nannanness.bms.tools.ListTableModel;
import org.nannanness.bms.views.AbstractBookAdd;
import org.nannanness.bms.views.AbstractSpecificInfo;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.List;

public class SpecificInfo extends AbstractSpecificInfo {
    private List<Book2> list;
    private ListTableModel<Book2> listTableModel;
    private IBookService bookService = new BookServiceImpl();
    private String[] book2Bean = {"bookName","bookType","bookDescription","bookIssueCommunity","bookAuthor","bookTotal"};
    private String bookType = null;
    private int bookLastPageCount;
    private int sumPageCount;
    private int nowPage;

    @Override
    public void jumpPage() {
        int num = Integer.valueOf(jumpNumber.getText());
        if(num <= sumPageCount && num >= 1){
            list = bookService.getPageByBook2(bookType,num,20);
            if(list != null){
                try {
                    specificTable.setModel(new ListTableModel<Book2>(list,Book2.class,colNames,book2Bean));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                nowPage = num;
                atPreNum.setText(String.valueOf(nowPage));
            }
        }
    }

    @Override
    public void homePage() {
        bookType = (String) specificTable.getValueAt(1,1);
        sumPageCount = bookService.getSumCountByBook2(bookType);
        if(sumPageCount%20 == 0){
            bookLastPageCount = sumPageCount/20;
        }else{
            bookLastPageCount = sumPageCount/20 + 1;
        }
        sumHeadNum.setText(String.valueOf(bookLastPageCount));
        list = bookService.getPageByBook2(bookType,1,20);
        if(list != null){
            try {
                specificTable.setModel(new ListTableModel<Book2>(list,Book2.class,colNames,book2Bean));
            } catch (Exception e) {
                e.printStackTrace();
            }
            nowPage = 1;
            atPreNum.setText(String.valueOf(nowPage));
        }
    }

    @Override
    public void nextPage() {
        if(nowPage < 2){
            return;
        }
        list = bookService.getPageByBook2(bookType,nowPage - 1,20);
        if(list != null) {
            try {
                specificTable.setModel(new ListTableModel<Book2>(list, Book2.class, colNames, book2Bean));
            } catch (Exception e) {
                e.printStackTrace();
            }
            nowPage = nowPage - 1;
            atPreNum.setText(String.valueOf(nowPage));
        }
    }

    @Override
    public void backPage() {
        if(nowPage > (sumPageCount - 1)){
            return;
        }
        list = bookService.getPageByBook2(bookType,nowPage + 1,20);
        if(list != null) {
            try {
                specificTable.setModel(new ListTableModel<Book2>(list, Book2.class, colNames, book2Bean));
            } catch (Exception e) {
                e.printStackTrace();
            }
            nowPage = nowPage + 1;
            atPreNum.setText(String.valueOf(nowPage));
        }
    }

    @Override
    public void lastPage() {
        list = bookService.getPageByBook2(bookType,sumPageCount / 20 + 1,20);
        if(list != null) {
            try {
                specificTable.setModel(new ListTableModel<Book2>(list, Book2.class, colNames, book2Bean));
            } catch (Exception e) {
                e.printStackTrace();
            }
            nowPage = sumPageCount / 20 + 1;
            atPreNum.setText(String.valueOf(nowPage));
        }
    }

    @Override
    public void delete() {
        int index = specificTable.getSelectedRow();
        String bookname = (String) specificTable.getValueAt(index,0);
        bookService.delete(bookname);
        JOptionPane.showMessageDialog(this,"删除成功","市立图书馆爱心提示",JOptionPane.INFORMATION_MESSAGE);
    }
    @Override
    public void add() {
        AbstractBookAdd addBook = new AddBook();
        addBook.setVisible(true);
    }

}
