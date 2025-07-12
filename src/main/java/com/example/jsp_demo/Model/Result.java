package com.example.jsp_demo.Model;

public class Result {
    String status;
    String message;
    int userid;
    public Result(String status, String message, int userid) {
        this.status = status;
        this.message = message;
        this.userid = userid;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
}
