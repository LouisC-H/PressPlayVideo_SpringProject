package com.example.pressplayvideo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue
    private Integer userID;
    private String userName;
    private String userPassword;
    private String userAddress;
    private String userHomeStore;
    private String userRole;
    private Integer userEnabled;

    public UserEntity() {
    }

    public UserEntity(String userName, String userPassword,String userAddress,String userHomeStore, String userRole, Integer userEnabled) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userAddress = userAddress;
        this.userHomeStore = userHomeStore;
        this.userRole = userRole;
        this.userEnabled = userEnabled;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserHomeStore() {
        return userHomeStore;
    }

    public void setUserHomeStore(String userHomeStore) {
        this.userHomeStore = userHomeStore;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Integer getUserEnabled() {
        return userEnabled;
    }

    public void setUserEnabled(Integer userEnabled) {
        this.userEnabled = userEnabled;
    }
}
