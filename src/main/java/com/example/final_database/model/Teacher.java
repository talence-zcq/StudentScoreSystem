package com.example.final_database.model;

public class Teacher {
    private String tno;
    private String tname;
    private String tsex;
    private String tprofess;
    private String tphone;
    private int tauthority;
    private String tpwd;
    private int tage;
    private String collegeno;
//扩展部分
    private String collegename;

//
    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public String getTprofess() {
        return tprofess;
    }

    public void setTprofess(String tprofess) {
        this.tprofess = tprofess;
    }

    public String getTphone() {
        return tphone;
    }

    public void setTphone(String tphone) {
        this.tphone = tphone;
    }

    public int getTauthority() {
        return tauthority;
    }

    public void setTauthority(int tauthority) {
        this.tauthority = tauthority;
    }

    public String getTpwd() {
        return tpwd;
    }

    public void setTpwd(String tpwd) {
        this.tpwd = tpwd;
    }

    public int getTage() {
        return tage;
    }

    public void setTage(int tage) {
        this.tage = tage;
    }

    public String getCollegeno() {
        return collegeno;
    }

    public void setCollegeno(String collegeno) {
        this.collegeno = collegeno;
    }

    public Teacher() {
    }


}
