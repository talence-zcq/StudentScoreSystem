package com.example.final_database.model;

public class Student {
   private String sno;
   private String mno;
   private String sname;
   private String ssex;
   private int sage;
   private double savggpa;
   private double scredit;
   private String sphone;
   private String shometown;
   private String spwd;
   private String classno;
//扩容部分
    private String major;
    private String banji;

//

    public String getBanji() {
        return banji;
    }

    public void setBanji(String banji) {
        this.banji = banji;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getMno() {
        return mno;
    }

    public void setMno(String mno) {
        this.mno = mno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public double getSavggpa() {
        return savggpa;
    }

    public void setSavggpa(double savggpa) {
        this.savggpa = savggpa;
    }

    public double getScredit() {
        return scredit;
    }

    public void setScredit(double scredit) {
        this.scredit = scredit;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public String getShometown() {
        return shometown;
    }

    public void setShometown(String shometown) {
        this.shometown = shometown;
    }

    public String getSpwd() {
        return spwd;
    }

    public void setSpwd(String spwd) {
        this.spwd = spwd;
    }

    public String getClassno() {
        return classno;
    }

    public void setClassno(String classno) {
        this.classno = classno;
    }

    public Student(){}
}
