package org.nannanness.bms.domain;

import java.util.Objects;

/*
注册用户信息表
 */
public class RegisterUser {
    private String  userId;
    private String  userName;
    private String userEmail;
    private String userAddress;


    public RegisterUser() {
    }

    public RegisterUser(String userId, String userName, String userEmail, String userAddress) {
        this.userId = userId;
        this.userName = userName;

        this.userEmail = userEmail;
        this.userAddress = userAddress;

    }

    public String  getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterUser that = (RegisterUser) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userEmail, that.userEmail) &&
                Objects.equals(userAddress, that.userAddress);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, userName, userEmail, userAddress);
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +

                ", userEmail='" + userEmail + '\'' +
                ", userAddress='" + userAddress + '\'' +

                '}';
    }
}
