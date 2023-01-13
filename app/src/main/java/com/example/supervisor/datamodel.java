package com.example.supervisor;

public class datamodel
{
    String name,password;

    public datamodel(String name) {
        this.name = name;
    }

    public String getHeader() {
        return name;
    }

    public void setHeader(String name) {
        this.name = name;
    }

    public String getDesc() {
        return password;
    }

    public void setDesc(String password) {
        this.password = password;
    }
}