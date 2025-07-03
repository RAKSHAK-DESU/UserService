package com.warrom.UserService.model;

public class User {
    private int uid;
    private String uname;
    private String addr;

    public User(int uid, String uname, String addr) {
        this.uid = uid;
        this.uname = uname;
        this.addr = addr;
    }

    public int getUid() {
        return uid;
    }

    public String getUname() {
        return uname;
    }



    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}