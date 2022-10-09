package com.example.final_database.model;

public class Grade {
    private String sno;
    private String courseno;
    private int grade;
    private String tno;
    private String cterm;
//扩展模块
    private String cno;
    private String sname;
    private String coursename;
    private String tname;
    private int chour;
    private double credit;
    private String assessment;
    private String classname;
//
    private static int nine;
    private static int eight;
    private static int seven;
    private static int six;
    private static int down;

    public static int getNine() {
        return nine;
    }

    public static void setNine(int nine) {
        Grade.nine = nine;
    }

    public static int getEight() {
        return eight;
    }

    public static void setEight(int eight) {
        Grade.eight = eight;
    }

    public static int getSeven() {
        return seven;
    }

    public static void setSeven(int seven) {
        Grade.seven = seven;
    }

    public static int getSix() {
        return six;
    }

    public static void setSix(int six) {
        Grade.six = six;
    }

    public static int getDown() {
        return down;
    }

    public static void setDown(int down) {
        Grade.down = down;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public int getChour() {
        return chour;
    }

    public void setChour(int chour) {
        this.chour = chour;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getAssessment() {
        return assessment;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getCourseno() {
        return courseno;
    }

    public void setCourseno(String courseno) {
        this.courseno = courseno;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getCterm() {
        return cterm;
    }

    public void setCterm(String cterm) {
        this.cterm = cterm;
    }

    public Grade(){}
}
