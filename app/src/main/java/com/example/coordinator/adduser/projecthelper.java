package com.example.coordinator.adduser;

public class projecthelper {
    String currentstate,duedate,finalmark;

    public projecthelper(){}

    public projecthelper(String currentstate, String duedate, String finalmark) {
        this.currentstate = currentstate;
        this.duedate = duedate;
        this.finalmark = finalmark;
    }

    public String getCurrentstate() {
        return currentstate;
    }

    public void setCurrentstate(String currentstate) {
        this.currentstate = currentstate;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getFinalmark() {
        return finalmark;
    }

    public void setFinalmark(String finalmark) {
        this.finalmark = finalmark;
    }
}
