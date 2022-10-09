package com.example.final_database.model;

public class Course {
    private String courseno;
    private String coursename;
    private String collegeno;
    private double ccredit;
    private int chour;
    private String cassessment;

//    扩展字段
    private String cterm;
    private String tno;
    private String tname;
    private String collegename;
//
    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    public String getCourseno() {
        return courseno;
    }

    public void setCourseno(String courseno) {
        this.courseno = courseno;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCollegeno() {
        return collegeno;
    }

    public void setCollegeno(String collegeno) {
        this.collegeno = collegeno;
    }

    public double getCcredit() {
        return ccredit;
    }

    public void setCcredit(double ccredit) {
        this.ccredit = ccredit;
    }

    public int getChour() {
        return chour;
    }

    public void setChour(int chour) {
        this.chour = chour;
    }

    public String getCterm() {
        return cterm;
    }

    public void setCterm(String cterm) {
        this.cterm = cterm;
    }

    public String getCassessment() {
        return cassessment;
    }

    public void setCassessment(String cassessment) {
        this.cassessment = cassessment;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public Course(){}
}
