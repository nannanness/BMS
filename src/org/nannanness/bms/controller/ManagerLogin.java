package org.nannanness.bms.controller;

import org.nannanness.bms.domain.*;
import org.nannanness.bms.service.IBookService;
import org.nannanness.bms.service.IBorrowReplayService;
import org.nannanness.bms.service.ILibararyService;
import org.nannanness.bms.service.IReturnUserService;
import org.nannanness.bms.service.serviceImpl.BookServiceImpl;
import org.nannanness.bms.service.serviceImpl.BorrowReplayServiceImpl;
import org.nannanness.bms.service.serviceImpl.LibararyServiceImpl;
import org.nannanness.bms.service.serviceImpl.ReturnUserServiceImpl;
import org.nannanness.bms.tools.ListTableModel;
import org.nannanness.bms.views.AbstractAddUser;
import org.nannanness.bms.views.AbstractManagerLogin;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

/*
管理员子类
 */
public class ManagerLogin extends AbstractManagerLogin {
    // 左1 下1 的内容
    private IBookService bookService = new BookServiceImpl();
    private List<Book2> book2List1 = null;
    private List<Book2> book2List2 = null;
    private String[] book2Bean1 = {"bookType","bookDescription","bookTotal"};
    private String[] book2Bean2 = {"bookName","bookType","bookDescription","bookIssueCommunity","bookAuthor","bookTotal"};

    // 左2 下2 的内容
    private IReturnUserService userService = new ReturnUserServiceImpl();
    private List<User> userList = null;
    private String[] userBean = {"ID","username","email","address"};
    private int pageSumCount;
    private int nowPage;

    // 左3 下3 的内容
    private IBorrowReplayService borrowService = new BorrowReplayServiceImpl();
    private List<BorrowReplay> borrowList = null;
    private String[] borrowBean = {"userId","bookName","borrowDate","active"};

    // 左4 下4 的内容
    private ILibararyService libararyService = new LibararyServiceImpl();
    private List<Libarary> libList = null;
    private String[] libBean = {"name","where","service","opentime"};
    @Override
    public void editInfo() {

    }

    @Override
    public void showBook() {
        card.show(leftPanel,cardName[0]);
        card2.show(bigPanel,cardName2[0]);
    }

    @Override
    public void showUser() {
        card.show(leftPanel,cardName[1]);
        card2.show(bigPanel,cardName2[1]);
    }

    @Override
    public void showInfo() {
        card.show(leftPanel,cardName[2]);
        card2.show(bigPanel,cardName2[2]);
    }

    @Override
    public void showMy() {
        card.show(leftPanel,cardName[3]);
        card2.show(bigPanel,cardName2[3]);
    }


    //详细信息绑定的事件---specific通过下拉列表将其添加到面板上
    @Override
    public void specific() {
        String bookType = (String) typeSpecific.getSelectedItem();
        if("全部".equals(bookType)){
            book2List1 = bookService.getBookType();
            try {
                tableBook.setModel(new ListTableModel<Book2>(book2List1,Book2.class,book2ColName,book2Bean1));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            String[] colNames = new String[] {"图书姓名","图书类别","图书简介","图书出版社","图书作者","图书库存"};
            book2List2 = bookService.specificBook(bookType);
            specificInfoFrame = new SpecificInfo();
            try {
                specificInfoFrame.specificTable.setModel(new ListTableModel<Book2>(book2List2,Book2.class,colNames,book2Bean2));
            } catch (Exception e) {
                e.printStackTrace();
            }
            specificInfoFrame.setVisible(true);
        }
    }

    @Override
    public void add() {
        AbstractAddUser addUser = new AddUser();
        addUser.setVisible(true);
    }
    //通过用户昵称来查询用户
    @Override
    public void search() {
        String bookType = (String) searchUserChoice.getSelectedItem();
        if("全部信息".equals(bookType)){
            userList = userService.getRegisterUserByAll();
        }else if("用户昵称".equals(bookType)){
            userList = userService.getRegisterUserByUserName(userSearchText.getText());
        }else if("用户id".equals(bookType)){
            userList = userService.getRegisterUserByUserID(Integer.valueOf(userSearchText.getText()));
        }else{
            return;
        }
        try {
            tableUser.setModel(new ListTableModel<User>(userList,RegisterUser.class,usercolName,userBean));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void active() {
        String type = (String) bookSearch.getSelectedItem();
        if("-请选择图书归还状态-".equals(type)){
            return;
        }else {
            borrowList = borrowService.getAll(type);
        }
        try {
            borrowTable.setModel(new ListTableModel<BorrowReplay>(borrowList,BorrowReplay.class,tableInfo,borrowBean));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public void deleteUser() {
        int index = tableUser.getSelectedRow();
        ListTableModel userModel = (ListTableModel) tableUser.getModel();
        int id = (int) userModel.getValueAt(index,0);
        userService.deleteUser(id);
        JOptionPane.showMessageDialog(this, "成功删除用户", "馆长提醒",JOptionPane.INFORMATION_MESSAGE);
    }

    public void pageCut(int id,String name,int head,int tail){
        try {
            userList = userService.getPage(id,name,head,tail);
            tableUser.setModel(new ListTableModel<User>(userList,RegisterUser.class,usercolName,userBean));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getPageSumCount(int id,String name){
        try {
            pageSumCount = userService.getSumCount(id,name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void goHomePage() {
        String bookType = (String) searchUserChoice.getSelectedItem();
        if("全部信息".equals(bookType)){
            getPageSumCount(0,null);
            pageCut(0,null,1,10);
        }else if("用户昵称".equals(bookType)){
            getPageSumCount(0,userSearchText.getText());
            pageCut(0,userSearchText.getText(),1,10);
        }else if("用户id".equals(bookType)){
            getPageSumCount(Integer.valueOf(userSearchText.getText()),null);
            pageCut(Integer.valueOf(userSearchText.getText()),null,1,10);
        }else{
            return;
        }
        nowPage = 1;
        atPreNum.setText(String.valueOf(nowPage));
        sumHeadNum.setText(String.valueOf(pageSumCount / 10 + 1));
    }

    @Override
    public void goLastPage() {
        String bookType = (String) searchUserChoice.getSelectedItem();
        if("全部信息".equals(bookType)){
            pageCut(0,null,pageSumCount / 10 + 1,10);
        }else if("用户昵称".equals(bookType)){
            pageCut(0,userSearchText.getText(),pageSumCount / 10 + 1,10);
        }else if("用户id".equals(bookType)){
            pageCut(Integer.valueOf(userSearchText.getText()),null,pageSumCount / 10 + 1,10);
        }else{
            return;
        }
        nowPage = pageSumCount / 10 + 1;
        atPreNum.setText(String.valueOf(nowPage));
    }

    @Override
    public void goNextPage() {
        if(nowPage <= 1){
            JOptionPane.showMessageDialog(this, "已是第一页", "馆长提醒",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String bookType = (String) searchUserChoice.getSelectedItem();
        if("全部信息".equals(bookType)){
            pageCut(0,null,nowPage-1,10);
        }else if("用户昵称".equals(bookType)){
            pageCut(0,userSearchText.getText(),nowPage-1,10);
        }else if("用户id".equals(bookType)){
            pageCut(Integer.valueOf(userSearchText.getText()),null,nowPage-1,10);
        }else{
            return;
        }
        nowPage = nowPage-1;
        atPreNum.setText(String.valueOf(nowPage));
    }

    @Override
    public void goBackPage() {
        if(nowPage >= pageSumCount){
            JOptionPane.showMessageDialog(this, "已是最后一页", "馆长提醒",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String bookType = (String) searchUserChoice.getSelectedItem();
        if("全部信息".equals(bookType)){
            pageCut(0,null,nowPage+1,10);
        }else if("用户昵称".equals(bookType)){
            pageCut(0,userSearchText.getText(),nowPage+1,10);
        }else if("用户id".equals(bookType)){
            pageCut(Integer.valueOf(userSearchText.getText()),null,nowPage+1,10);
        }else{
            return;
        }
        nowPage = nowPage+1;
        atPreNum.setText(String.valueOf(nowPage));
    }

    @Override
    public void jumpPage() {
        int num = Integer.valueOf(jumpNumber.getText());
        if(num >= 1 && num <= pageSumCount){
            String bookType = (String) searchUserChoice.getSelectedItem();
            if("全部信息".equals(bookType)){
                pageCut(0,null,num,10);
            }else if("用户昵称".equals(bookType)){
                pageCut(0,userSearchText.getText(),num,10);
            }else if("用户id".equals(bookType)){
                pageCut(Integer.valueOf(userSearchText.getText()),null,num,10);
            }else{
                return;
            }
            nowPage = num;
            atPreNum.setText(String.valueOf(num));
        }
    }
}
