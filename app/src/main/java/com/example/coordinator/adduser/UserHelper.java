package com.example.coordinator.adduser;

public class UserHelper {

    String name,studentID,password,batch;

    public UserHelper(){}

    public UserHelper(String name, String studentID, String password, String batch) {
        this.name = name;
        this.studentID = studentID;
        this.password = password;
        this.batch = batch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
}
