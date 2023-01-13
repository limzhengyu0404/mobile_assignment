package com.example.coordinator.adduser;

public class titlehelper {
    String approvetitle,deadline,remark,status,submission;

    public titlehelper(){}

    public titlehelper(String approvetitle, String deadline, String remark, String status, String submission) {
        this.approvetitle = approvetitle;
        this.deadline = deadline;
        this.remark = remark;
        this.status = status;
        this.submission = submission;
    }

    public String getApprovetitle() {
        return approvetitle;
    }

    public void setApprovetitle(String approvetitle) {
        this.approvetitle = approvetitle;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubmission() {
        return submission;
    }

    public void setSubmission(String submission) {
        this.submission = submission;
    }
}
