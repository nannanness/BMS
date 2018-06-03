package org.nannanness.bms.controller;

import org.nannanness.bms.domain.*;
import org.nannanness.bms.service.*;
import org.nannanness.bms.service.serviceImpl.BookServiceImpl;
import org.nannanness.bms.service.serviceImpl.CollectBookServiceImpl;
import org.nannanness.bms.service.serviceImpl.LibararyServiceImpl;
import org.nannanness.bms.service.serviceImpl.RecordBookServiceImpl;
import org.nannanness.bms.tools.DateUtils;
import org.nannanness.bms.tools.ListTableModel;
import org.nannanness.bms.views.AbstractUser;
import org.nannanness.bms.views.LittleFrame;

import javax.swing.*;
import java.util.List;

public class UserController extends AbstractUser {

    private IBookService bookService = new BookServiceImpl();
    private ICollectBookService cBookService = new CollectBookServiceImpl();
    private IRecordBookService rBookService = new RecordBookServiceImpl();
    private String bookType = null;
    private String bookType1 = null;
    private String recordBookType = null;
    private String recordBookType1 = null;
    private List<Book2> books = null;
    private List<CollectBook> collectBooks = null;
    private List<BorrowReplay> recordBooks = null;
    private String[] bookBean = {"bookName" , "bookAuthor" , "bookIssueCommunity" , "bookType" , "bookTotal"};
    private String[] collectBookBean = {"bookName" , "author" , "press" , "bookType" , "userId"};
    private String[] recordBookBean = {"bookName" , "author" , "bookType" , "borrowDate" , "active" , "userId"};
    private ListTableModel<Book2> listTableModelmodel = null;
    private ListTableModel<BorrowReplay> listRecordTableModelmodel = null;
    private ListTableModel<CollectBook> listCollectTableModelmodel = null;
    private int bookSumCount;
    private int bookLastPageCount;
    private int bookCurrentPage;
    private int recordBookSumCount;
    private int recordBookLastPageCount;
    private int recordBookCurrentPage;
    // 左4 下4 的内容
    private ILibararyService libararyService = new LibararyServiceImpl();
    private List<Libarary> libList = null;
    private String[] libBean = {"name","where","service","opentime"};

    // 碰撞检测
    public boolean collisionDetection(BorrowReplay rBook){
        for(BorrowReplay book : recordBooks){
            if(book.equals(rBook)){
                return false;
            }
        }
        return true;
    }

    public boolean collisionDetection(CollectBook cBook){
        for(CollectBook book : collectBooks){
            if(book.equals(cBook)){
                return false;
            }
        }
        return true;
    }

    @Override
    public void watch() {
        String type = (String) libararynotify.getSelectedItem();
        if("-请选择-".equals(type)){
            return;
        }else {
            libList = libararyService.getAll();
        }
        try {
            libararyTable.setModel(new ListTableModel<Libarary>(libList,Libarary.class,tableLibarary,libBean));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void jumpPage1() {
        catchRecordBookType();
        dropDownBoxOperation(recordBookType,recordBookType1,leftPanel_1_in.getText(),null,rBookService,4);
        showRecordBooks();
    }

    @Override
    public void toHomePage1() {
        catchRecordBookType();
        dropDownBoxOperation(recordBookType,recordBookType1,leftPanel_1_in.getText(),null,rBookService,0);
        showRecordBooks();
    }

    @Override
    public void toLastPage1() {
        catchRecordBookType();
        dropDownBoxOperation(recordBookType,recordBookType1,leftPanel_1_in.getText(),null,rBookService,3);
        showRecordBooks();
    }

    @Override
    public void toPrePage1() {
        catchRecordBookType();
        dropDownBoxOperation(recordBookType,recordBookType1,leftPanel_1_in.getText(),null,rBookService,1);
        showRecordBooks();
    }

    @Override
    public void toNextPage1() {
        catchRecordBookType();
        dropDownBoxOperation(recordBookType,recordBookType1,leftPanel_1_in.getText(),null,rBookService,2);
        showRecordBooks();
    }

    @Override
    public void jumpPage() {
        catchBookType();
        dropDownBoxOperation(bookType,bookType1,leftPanel_0_in.getText(),bookService,null,4);
        showBooks();
    }

    @Override
    public void toHomePage() {
        catchBookType();
        dropDownBoxOperation(bookType,bookType1,leftPanel_0_in.getText(),bookService,null,0);
        showBooks();
    }

    public void showRecordBooks(){
        if(recordBooks != null){
            try {
                listRecordTableModelmodel = new ListTableModel<BorrowReplay>(recordBooks,BorrowReplay.class,colName2,recordBookBean);
                tableRecord.setModel(listRecordTableModelmodel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void showBooks(){
        if(books != null){
            try {
                listTableModelmodel = new ListTableModel<Book2>(books,Book2.class,colName,bookBean);
                tableBook.setModel(listTableModelmodel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void toLastPage() {
        catchBookType();
        dropDownBoxOperation(bookType,bookType1,leftPanel_0_in.getText(),bookService,null,3);
        showBooks();
    }

    @Override
    public void toPrePage() {
        catchBookType();
        dropDownBoxOperation(bookType,bookType1,leftPanel_0_in.getText(),bookService,null,1);
        showBooks();
    }

    @Override
    public void toNextPage() {
        catchBookType();
        dropDownBoxOperation(bookType,bookType1,leftPanel_0_in.getText(),bookService,null,2);
        showBooks();
    }

    @Override
    public void borrowBookToRecordTable() {
        int rowCount = tableBook.getSelectedRow();
        if(listTableModelmodel != null){
            Book2 book = listTableModelmodel.getInstance(rowCount);
            BorrowReplay rBook = new BorrowReplay(userID,book.getBookName(),DateUtils.today(),book.getBookAuthor(),book.getBookType(),"预借");
            if(collisionDetection(rBook)){
                // 插入借书表中
                rBookService.borrowBookToRecordTable(rBook);
            }
        }
    }

    @Override
    public void collectBookToCollectTable() {
        int rowCount = tableBook.getSelectedRow();
        if(listTableModelmodel != null){
            Book2 book =  listTableModelmodel.getInstance(rowCount);
            CollectBook cBook = new CollectBook(book.getBookName(),book.getBookAuthor(),book.getBookIssueCommunity(),book.getBookType(),userID);
//            System.out.println(cBook);
            if(collisionDetection(cBook)){
                cBookService.insertCollectBook(cBook);
            }
        }
    }

    @Override
    public void showBook() {
        card.show(leftPanel,cardName[0]);
        card2.show(bigPanel,cardName2[0]);
    }

    @Override
    public void showRecord() {
        recordBooks = rBookService.queryRecordTable(userID);
        if(recordBooks != null){
            try {
                tableRecord.setModel(new ListTableModel<BorrowReplay>(recordBooks,BorrowReplay.class,colName2,recordBookBean));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        card.show(leftPanel,cardName[1]);
        card2.show(bigPanel,cardName2[1]);
    }

    @Override
    public void showMy() {
        card.show(leftPanel,cardName[2]);
        card2.show(bigPanel,cardName2[2]);
    }

    @Override
    public void showIntro() {
        card.show(leftPanel,cardName[3]);
        card2.show(bigPanel,cardName2[3]);
    }

    public void catchBookType(){
        bookType = (String) box_0_0.getSelectedItem();
        bookType1 = (String) box_0_1.getSelectedItem();
    }

    public void catchRecordBookType(){
        recordBookType = (String) box_1_0.getSelectedItem();
        recordBookType1 = (String) box_1_1.getSelectedItem();
    }

    @Override
    public void querySome() {
        toHomePage();
    }

    public void pageQuery(String bookName , String author , String bookType , int nowPage , int pageSize , int state){
        if(state == 0){ // 0 -- 首页
            nowPage = 1;
            makingPage(bookName,author,bookType,nowPage,pageSize);
        }else if(state == 1){ // 1 -- 上一页
            if (bookCurrentPage <= 1) {
                JOptionPane.showMessageDialog(this, "已经是第一页", "馆长提醒", JOptionPane.WARNING_MESSAGE);
            }else{
                nowPage = bookCurrentPage - 1;
                makingPage(bookName,author,bookType,nowPage,pageSize);
            }
        }else if(state == 2){ // 2 -- 下一页
            if (bookCurrentPage >= bookLastPageCount) {
                JOptionPane.showMessageDialog(this, "已经是最后一页", "馆长提醒", JOptionPane.WARNING_MESSAGE);
            }else{
                nowPage = bookCurrentPage + 1;
                makingPage(bookName,author,bookType,nowPage,pageSize);
            }
        }else if(state == 3){ // 3 -- 最后一页
            if(listTableModelmodel != null){
                nowPage = bookLastPageCount;
                makingPage(bookName,author,bookType,nowPage,pageSize);
            }
        }else if(state == 4){ // 4 -- 跳转
            int targetPageCount = Integer.valueOf(jumpNumber.getText());
            if(1<= targetPageCount && targetPageCount <= bookLastPageCount){
                if(listTableModelmodel != null) {
                    nowPage = targetPageCount;
                    makingPage(bookName,author,bookType,nowPage,pageSize);
                }
            }else {
                JOptionPane.showMessageDialog(this, "页码超出范围", "馆长提醒",JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public void makingPage(String bookName,String author,String bookType,int nowPage,int pageSize){
        books = bookService.getPage(bookName,author,bookType,nowPage,pageSize);
        bookSumCount = bookService.getSumCount(bookName,author,bookType);
        if((bookSumCount % pageSize) == 0){
            bookLastPageCount = bookSumCount / pageSize;
        }else {
            bookLastPageCount = bookSumCount / pageSize + 1;
        }
        bookCurrentPage = nowPage;
        atPreNum.setText(String.valueOf(bookCurrentPage));
        sumHeadNum.setText(String.valueOf(bookLastPageCount));
    }

    public void dropDownBoxOperation(String bookType, String bookType1, String in, IBookService bookService, IRecordBookService recordBookService , int state){
        if("-请选择-".equals(bookType)){
            JOptionPane.showMessageDialog(this, "请进行选择", "馆长提醒",JOptionPane.WARNING_MESSAGE);
        }else if("图书".equals(bookType)){
            if("-请选择-".equals(bookType1)){
                JOptionPane.showMessageDialog(this, "请选择图书类型", "馆长提醒",JOptionPane.WARNING_MESSAGE);
            }else{
                if(bookService != null){
                    pageQuery(in,null,bookType1,state,10,state);
                }else if(recordBookService != null){
                    pageQueryBorrowReplay(in,null,bookType1,state,10,state);
                }
            }
        }else if("作者".equals(bookType)){
            if("-请选择-".equals(bookType1)){
                JOptionPane.showMessageDialog(this, "请选择图书类型", "馆长提醒",JOptionPane.WARNING_MESSAGE);
            }else{
                if(bookService != null) {
                    pageQuery(null, in, bookType1 , state ,10 , state);
                }else if(recordBookService != null){
                    pageQueryBorrowReplay(null, in, bookType1,state,10,state);
                }
            }
        }else if("类别".equals(bookType)){
            if("-请选择-".equals(bookType1)){
                JOptionPane.showMessageDialog(this, "请选择图书类型", "馆长提醒",JOptionPane.WARNING_MESSAGE);
            }else{
                if(bookService != null) {
                    pageQuery(null,null,bookType1 , state ,10,state);
                }else if(recordBookService != null){
                    pageQueryBorrowReplay(null,null,bookType1,state,10,state);
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "请进行选择", "馆长提醒",JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public void queryRecordTable() {
        toHomePage1();
    }

    public void pageQueryBorrowReplay(String bookName , String author , String bookType , int nowPage , int pageSize , int state){
        if(state == 0){ // 0 -- 首页
            nowPage = 1;
            makingPageBorrowReplay(bookName,author,bookType,nowPage,pageSize);
        }else if(state == 1){ // 1 -- 上一页
            if (recordBookCurrentPage <= 1) {
                JOptionPane.showMessageDialog(this, "已经是第一页", "馆长提醒", JOptionPane.WARNING_MESSAGE);
            }else{
                nowPage = recordBookCurrentPage - 1;
                makingPageBorrowReplay(bookName,author,bookType,nowPage,pageSize);
            }
        }else if(state == 2){ // 2 -- 下一页
            if (recordBookCurrentPage >= recordBookLastPageCount) {
                JOptionPane.showMessageDialog(this, "已经是最后一页", "馆长提醒", JOptionPane.WARNING_MESSAGE);
            }else{
                nowPage = recordBookCurrentPage + 1;
                makingPageBorrowReplay(bookName,author,bookType,nowPage,pageSize);
            }
        }else if(state == 3){ // 3 -- 最后一页
            if(listRecordTableModelmodel != null){
                nowPage = recordBookLastPageCount;
                makingPageBorrowReplay(bookName,author,bookType,nowPage,pageSize);
            }
        }else if(state == 4){ // 4 -- 跳转
            int targetPageCount = Integer.valueOf(jumpNumber1.getText());
            if(1<= targetPageCount && targetPageCount <= recordBookLastPageCount){
                if(listRecordTableModelmodel != null) {
                    nowPage = targetPageCount;
                    makingPageBorrowReplay(bookName,author,bookType,nowPage,pageSize);
                }
            }else {
                JOptionPane.showMessageDialog(this, "页码超出范围", "馆长提醒",JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public void makingPageBorrowReplay(String bookName,String author,String bookType,int nowPage,int pageSize){
        recordBooks = rBookService.getPage(bookName,author,bookType,userID,nowPage,pageSize);
        recordBookSumCount = rBookService.getSumCount(bookName,author,bookType,userID);
        if((recordBookSumCount % pageSize) == 0){
            recordBookLastPageCount = recordBookSumCount / pageSize;
        }else {
            recordBookLastPageCount = recordBookSumCount / pageSize + 1;
        }
        recordBookCurrentPage = nowPage;
        atPreNum1.setText(String.valueOf(recordBookCurrentPage));
        sumHeadNum1.setText(String.valueOf(recordBookLastPageCount));
    }

    @Override
    public void updateFrame() {
        littleFrame = new LittleFrame();
        littleFrame.setVisible(true);
    }

    @Override
    public void showCollect() {
        collectBooks = cBookService.queryCollectBooks(userID);
        if(collectBooks != null){
            try {
                listCollectTableModelmodel = new ListTableModel<CollectBook>(collectBooks,CollectBook.class,colNameCollectTable,collectBookBean);
                collectTable.setModel(listCollectTableModelmodel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        card3.show(bigPanel_2,cardName3[1]);
    }

    @Override
    public void showInfo() {

        card3.show(bigPanel_2,cardName3[0]);
    }
}
