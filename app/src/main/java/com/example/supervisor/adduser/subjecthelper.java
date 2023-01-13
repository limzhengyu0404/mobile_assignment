package com.example.supervisor.adduser;

public class subjecthelper{
    String comment,remark,deadline,status,upload,submission;

    public subjecthelper(){}

    public subjecthelper(String comment, String remark, String deadline, String status, String upload, String submission) {
        this.comment = comment;
        this.remark = remark;
        this.deadline = deadline;
        this.status = status;
        this.upload = upload;
        this.submission = submission;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpload() {
        return upload;
    }

    public void setUpload(String upload) {
        this.upload = upload;
    }

    public String getSubmission() {
        return submission;
    }

    public void setSubmission(String submission) {
        this.submission = submission;
    }
}
