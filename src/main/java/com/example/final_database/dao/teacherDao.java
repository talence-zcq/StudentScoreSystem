package com.example.final_database.dao;

import com.example.final_database.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class teacherDao extends Basedao{
    public boolean addStudennt(String Sno,String Mno ,String Sname,String Ssex,String Sage,String Savggpa,String Scredit,String Sphone,String Shometown,String Spwd,String Classno) {
        String sql = "INSERT INTO zhangcq_students15 VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = dataSource.getConnection(); PreparedStatement psmt = conn.prepareStatement(sql)) {
            psmt.setString(1,Sno);
            psmt.setString(2,Mno);
            psmt.setString(3,Sname);
            psmt.setString(4,Ssex);
            psmt.setInt(5,Integer.parseInt(Sage));
            psmt.setDouble(6,Double.parseDouble(Savggpa));
            psmt.setDouble(7,Double.parseDouble(Scredit));
            psmt.setString(8,Sphone);
            psmt.setString(9,Shometown);
            psmt.setString(10,Spwd);
            psmt.setString(11,Classno);
            psmt.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean addTeacher(String tno,String tname ,String tsex,String tprofess,String tage,String tphone,String tauthority,String tpwd,String collegeno) {
        String sql = "INSERT INTO zhangcq_teachers15 VALUES(?,?,?,?,?,?,?,?,?)";
        try (Connection conn = dataSource.getConnection(); PreparedStatement psmt = conn.prepareStatement(sql)) {
            psmt.setString(1,tno);
            psmt.setString(2,tname);
            psmt.setString(3,tsex);
            psmt.setString(4,tprofess);
            psmt.setInt(5,Integer.parseInt(tage));
            psmt.setString(6,tphone);
            psmt.setInt(7,Integer.parseInt(tauthority));
            psmt.setString(8,tpwd);
            psmt.setString(9,collegeno);
            psmt.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean addCourse(String Courseno,String Coursename ,String Collegeno,String Ccredit,String Chours,String Cassessment) {
        String sql = "INSERT INTO zhangcq_courses15 VALUES(?,?,?,?,?,?)";
        try (Connection conn = dataSource.getConnection(); PreparedStatement psmt = conn.prepareStatement(sql)) {
            psmt.setString(1,Courseno);
            psmt.setString(2,Coursename);
            psmt.setString(3,Collegeno);
            psmt.setDouble(4,Double.parseDouble(Ccredit));
            psmt.setInt(5,Integer.parseInt(Chours));
            psmt.setString(6,Cassessment);
            psmt.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean addSetupinfo(String Courseno,String Classno,String Tno,String Cterm) {
        String sql = "INSERT INTO zhangcq_setupinfo15 VALUES(?,?)";
        try (Connection conn = dataSource.getConnection(); PreparedStatement psmt = conn.prepareStatement(sql)) {
            psmt.setString(1,Courseno);
            psmt.setString(2,Classno);
            psmt.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
    public boolean addSetupinfo1(String Courseno,String Classno,String Tno,String Cterm) {
        String sql = "CALL zcq_insertStu15(?,?,?,?);";
        try (Connection conn = dataSource.getConnection(); PreparedStatement psmt = conn.prepareStatement(sql)) {
            psmt.setString(1,Courseno);
            psmt.setString(2,Classno);
            psmt.setString(3,Tno);
            psmt.setString(4,Cterm);
            psmt.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
    public boolean addCollege(String Collegeno,String Collegename) {
        String sql = "INSERT INTO zhangcq_colleges15 VALUES(?,?)";
        try (Connection conn = dataSource.getConnection(); PreparedStatement psmt = conn.prepareStatement(sql)) {
            psmt.setString(1,Collegeno);
            psmt.setString(2,Collegename);
            psmt.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean addMajor(String Mno,String Mname,String Collegeno) {
        String sql = "INSERT INTO zhangcq_majors15 VALUES(?,?,?)";
        try (Connection conn = dataSource.getConnection(); PreparedStatement psmt = conn.prepareStatement(sql)) {
            psmt.setString(1,Mno);
            psmt.setString(2,Mname);
            psmt.setString(3,Collegeno);
            psmt.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean addClass(String Classno,String Classname) {
        String sql = "INSERT INTO zhangcq_class15 VALUES(?,?)";
        try (Connection conn = dataSource.getConnection(); PreparedStatement psmt = conn.prepareStatement(sql)) {
            psmt.setString(1,Classno);
            psmt.setString(2,Classname);
            psmt.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
    public ArrayList<Student> queryStudent(String Sno, String Mno, String Classname) {
            String sql="select *  from zhangcq_stuinfo15 WHERE 1=1";
            if(!Sno.equals("")){
                sql=sql+" and zcq_Sno15='"+Sno+"'";
            }
            if(!Mno.equals("")){
                sql=sql+" and zcq_Mname15='"+Mno+"'";
            }
            if(!Classname.equals("")){
                sql=sql+" and zcq_Classname15='"+Classname+"'";
            }
            ArrayList<Student> list=new ArrayList<Student>();
            try(Connection conn=dataSource.getConnection();PreparedStatement psmt=conn.prepareStatement(sql)){
                try(ResultSet rst = psmt.executeQuery()){
                    while(rst.next()){
                        Student student=new Student();
                        student.setSno(rst.getString(1));
                        student.setMajor(rst.getString(2));
                        student.setSname(rst.getString(3));
                        student.setSsex(rst.getString(4));
                        student.setBanji(rst.getString(5));
                        student.setSphone(rst.getString(6));
                        student.setShometown(rst.getString(7));
                        list.add(student);
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return list;
    }

    public ArrayList<Teacher> queryTeacher(String Tno, String College, String profess) {
        String sql="select *  from zhangcq_teainfo15 WHERE 1=1";
        if(!Tno.equals("")){
            sql=sql+" and zcq_Tno15='"+Tno+"'";
        }
        if(!College.equals("")){
            sql=sql+" and zcq_Collegename15='"+College+"'";
        }
        if(!profess.equals("")){
            sql=sql+" and zcq_Tprofess15='"+profess+"'";
        }
        ArrayList<Teacher> list=new ArrayList<Teacher>();
        try(Connection conn=dataSource.getConnection();PreparedStatement psmt=conn.prepareStatement(sql)){
            try(ResultSet rst = psmt.executeQuery()){
                while(rst.next()){
                    Teacher teacher=new Teacher();
                    teacher.setTno(rst.getString(1));
                    teacher.setTname(rst.getString(2));
                    teacher.setTsex(rst.getString(3));
                    teacher.setTprofess(rst.getString(4));
                    teacher.setTphone(rst.getString(5));
                    teacher.setTage(rst.getInt(6));
                    teacher.setCollegename(rst.getString(7));
                    list.add(teacher);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public ArrayList<Course> queryCourse(String Courseno, String Collegename, String Cterm) {
        String sql="select distinct *  from zhangcq_couinfo15 WHERE 1=1";
        if(!Courseno.equals("")){
            sql=sql+" and zcq_Courseno15='"+Courseno+"'";
        }
        if(!Collegename.equals("")){
            sql=sql+" and zcq_Collegename15='"+Collegename+"'";
        }
        if(!Cterm.equals("")){
            sql=sql+" and zcq_Cterm15='"+Cterm+"'";
        }
        ArrayList<Course> list=new ArrayList<Course>();
        try(Connection conn=dataSource.getConnection();PreparedStatement psmt=conn.prepareStatement(sql)){
            try(ResultSet rst = psmt.executeQuery()){
                while(rst.next()){
                    Course course=new Course();
                    course.setCourseno(rst.getString(1));
                    course.setCoursename(rst.getString(2));
                    course.setCcredit(rst.getDouble(3));
                    course.setCterm(rst.getString(4));
                    course.setTname(rst.getString(5));
                    course.setCollegename(rst.getString(6));
                    course.setCassessment(rst.getString(7));
                    list.add(course);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public ArrayList<Setupinfo> querySetup(String Coursename, String Classname) {
        String sql="select distinct *  from zhangcq_setinfo15 WHERE 1=1";
        if(!Coursename.equals("")){
            sql=sql+" and zcq_Coursename15='"+Coursename+"'";
        }
        if(!Classname.equals("")){
            sql=sql+" and zcq_Classname15='"+Classname+"'";
        }
        ArrayList<Setupinfo> list=new ArrayList<Setupinfo>();
        try(Connection conn=dataSource.getConnection();PreparedStatement psmt=conn.prepareStatement(sql)){
            try(ResultSet rst = psmt.executeQuery()){
                while(rst.next()){
                    Setupinfo setupinfo=new Setupinfo();
                    setupinfo.setCoursename(rst.getString(1));
                    setupinfo.setClassname(rst.getString(2));
                    list.add(setupinfo);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public ArrayList<Grade> queryGrade(String sno,String cterm,String tno) {
        String sql="select distinct *  from zhangcq_grainfo15 WHERE 1=1";
        if(!sno.equals("")){
            sql=sql+" and zcq_Sno15='"+sno+"'";
        }
        if(!cterm.equals("")){
            sql=sql+" and zcq_Cterm15='"+cterm+"'";
        }
        if(!tno.equals("")){
            sql=sql+" and zcq_Tno15='"+tno+"'";
        }
        ArrayList<Grade> list=new ArrayList<Grade>();
        try(Connection conn=dataSource.getConnection();PreparedStatement psmt=conn.prepareStatement(sql)){
            try(ResultSet rst = psmt.executeQuery()){
                while(rst.next()){
                    Grade grade=new Grade();
                    grade.setSno(rst.getString(1));
                    grade.setSname(rst.getString(2));
                    grade.setCoursename(rst.getString(3));
                    grade.setGrade(rst.getInt(4));
                    grade.setTno(rst.getString(5));
                    grade.setTname(rst.getString(6));
                    grade.setCterm(rst.getString(7));
                    list.add(grade);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public ArrayList<College> queryCollege(){
        String sql="select * from zhangcq_colleges15";
        ArrayList<College> list=new ArrayList<College>();
        try(Connection conn=dataSource.getConnection();PreparedStatement psmt=conn.prepareStatement(sql)){
            try(ResultSet rst = psmt.executeQuery()){
                while(rst.next()){
                    College college = new College();
                    college.setCollegeno(rst.getString(1));
                    college.setCollegename(rst.getString(2));
                    list.add(college);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public ArrayList<Major> queryMajor(){
        String sql="select * from zhangcq_majors15";
        ArrayList<Major> list=new ArrayList<Major>();
        try(Connection conn=dataSource.getConnection();PreparedStatement psmt=conn.prepareStatement(sql)){
            try(ResultSet rst = psmt.executeQuery()){
                while(rst.next()){
                    Major major = new Major();
                    major.setMno(rst.getString(1));
                    major.setMname(rst.getString(2));
                    major.setCollegeno(rst.getString(3));
                    list.add(major);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public ArrayList<Banji> queryClass(){
        String sql="select * from zhangcq_class15";
        ArrayList<Banji> list=new ArrayList<Banji>();
        try(Connection conn=dataSource.getConnection();PreparedStatement psmt=conn.prepareStatement(sql)){
            try(ResultSet rst = psmt.executeQuery()){
                while(rst.next()){
                    Banji banji = new Banji();
                    banji.setClassno(rst.getString(1));
                    banji.setClassname(rst.getString(2));
                    list.add(banji);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public boolean modify_pwd(String new_pwd,String tno) {
        String sql = "UPDATE zhangcq_teachers15 SET zcq_Tpwd15 = ? WHERE zcq_Tno15 = ?";
        try (Connection conn = dataSource.getConnection(); PreparedStatement psmt = conn.prepareStatement(sql)) {
            psmt.setString(1,new_pwd);
            psmt.setString(2,tno);
            psmt.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public ArrayList<Grade> queryWork(String tno,String cterm){
        String sql="select distinct zcq_Cterm15, zcq_Coursename15, zcq_Chours15, zcq_Cassessment15 from zhangcq_workinfo15 WHERE 1=1";
        if(!tno.equals("")){
            sql=sql+" and zcq_Tno15='"+tno+"'";
        }
        if(!cterm.equals("")){
            sql=sql+" and zcq_Cterm15='"+cterm+"'";
        }
        ArrayList<Grade> list=new ArrayList<Grade>();
        try(Connection conn=dataSource.getConnection();PreparedStatement psmt=conn.prepareStatement(sql)){
            try(ResultSet rst = psmt.executeQuery()){
                while(rst.next()){
                    Grade grade = new Grade();
                    grade.setCterm(rst.getString(1));
                    grade.setCoursename(rst.getString(2));
                    grade.setChour(rst.getInt(3));
                    grade.setAssessment(rst.getString(4));
                    list.add(grade);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public ArrayList<Grade> insertGrade1(String tno,String coursename,String banji) {
        String sql="select distinct *  from zhangcq_grainfo15 WHERE 1=1";
        if(!coursename.equals("")){
            sql=sql+" and zcq_Coursename15='"+coursename+"'";
        }
        if(!banji.equals("")){
            sql=sql+" and zcq_Classname15='"+banji+"'";
        }
        if(!tno.equals("")){
            sql=sql+" and zcq_Tno15='"+tno+"'";
        }
        ArrayList<Grade> list=new ArrayList<Grade>();
        try(Connection conn=dataSource.getConnection();PreparedStatement psmt=conn.prepareStatement(sql)){
            try(ResultSet rst = psmt.executeQuery()){
                while(rst.next()){
                    Grade grade=new Grade();
                    grade.setSno(rst.getString(1));
                    grade.setSname(rst.getString(2));
                    grade.setCoursename(rst.getString(3));
                    grade.setGrade(rst.getInt(4));
                    grade.setTno(rst.getString(5));
                    grade.setTname(rst.getString(6));
                    grade.setCterm(rst.getString(7));
                    grade.setClassname(rst.getString(8));
                    grade.setCno(rst.getString(9));
                    list.add(grade);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public boolean modify_grade(String sno,String tno,String cno,String cterm,String grade) {
        String sql = "UPDATE zhangcq_grade15 SET zcq_Grade15 = ? WHERE zcq_Sno15 = ? and zcq_Tno15 = ? and zcq_Courseno15 = ? and zcq_Cterm15 = ?";
        try (Connection conn = dataSource.getConnection(); PreparedStatement psmt = conn.prepareStatement(sql)) {
            psmt.setInt(1,Integer.parseInt(grade));
            psmt.setString(2,sno);
            psmt.setString(3,tno);
            psmt.setString(4,cno);
            psmt.setString(5,cterm);
            psmt.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public ArrayList<Grade> t_queryGrade(String coursename,String cterm,String tno) {
        String sql="select distinct *  from zhangcq_grainfo15 WHERE 1=1";
        if(!coursename.equals("")){
            sql=sql+" and zcq_Coursename15='"+coursename+"'";
        }
        if(!cterm.equals("")){
            sql=sql+" and zcq_Cterm15='"+cterm+"'";
        }
        if(!tno.equals("")){
            sql=sql+" and zcq_Tno15='"+tno+"'";
        }
        ArrayList<Grade> list=new ArrayList<Grade>();
        Grade.setNine(0);
        Grade.setEight(0);
        Grade.setSeven(0);
        Grade.setSix(0);
        Grade.setDown(0);
        try(Connection conn=dataSource.getConnection();PreparedStatement psmt=conn.prepareStatement(sql)){
            try(ResultSet rst = psmt.executeQuery()){
                while(rst.next()){
                    Grade grade=new Grade();
                    grade.setSno(rst.getString(1));
                    grade.setSname(rst.getString(2));
                    grade.setCoursename(rst.getString(3));
                    grade.setGrade(rst.getInt(4));
                    grade.setTno(rst.getString(5));
                    grade.setTname(rst.getString(6));
                    grade.setCterm(rst.getString(7));
                    if(grade.getGrade()>90){
                        Grade.setNine(Grade.getNine()+1);
                    }
                    else if(grade.getGrade()>80){
                        Grade.setEight(Grade.getEight()+1);
                    }
                    else if(grade.getGrade()>70){
                        Grade.setSeven(Grade.getSeven()+1);
                    }
                    else if(grade.getGrade()>60){
                        Grade.setSix(Grade.getSix()+1);
                    }
                    else if(grade.getGrade()<60 && grade.getGrade()>0){
                        Grade.setDown(Grade.getDown()+1);
                    }
                    list.add(grade);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

}
