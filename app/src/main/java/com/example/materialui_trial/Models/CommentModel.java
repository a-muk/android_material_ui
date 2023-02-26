package com.example.materialui_trial.Models;

public class CommentModel {

    public String ip,comment;

    public CommentModel(String ip,String comment){
        this.ip=ip;
        this.comment=comment;
    }



    public String getIp() {
        return ip;
    }

    public String getComment() {
        return comment;
    }


    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
