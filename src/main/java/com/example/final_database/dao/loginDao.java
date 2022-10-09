package com.example.final_database.dao;

import com.example.final_database.model.Student;
import com.example.final_database.model.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginDao extends Basedao{
    public Student StudentLogin(String name , String pass){
        Student user=null;
        String sql = "select * from zhangcq_students15 where zcq_Sno15 = ? and zcq_Spwd15= ?";
        try (Connection conn = dataSource.getConnection(); PreparedStatement psmt = conn.prepareStatement(sql)) {
            psmt.setString(1,name);
            psmt.setString(2,pass);
            try (ResultSet rst = psmt.executeQuery()) {
                if (rst.next()) {
                    user=new Student();
                    user.setSno(rst.getString(1));
                    user.setMno(rst.getString(2));
                    user.setSname(rst.getString(3));
                    user.setSsex(rst.getString(4));
                    user.setSage(rst.getInt(5));
                    user.setSavggpa(rst.getDouble(6));
                    user.setScredit(rst.getDouble(7));
                    user.setSphone(rst.getString(8));
                    user.setShometown(rst.getString(9));
                    user.setSpwd(rst.getString(10));
                    user.setClassno(rst.getString(11));

                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
    public Teacher TeacherLogin(String name , String pass){
        Teacher user=null;
        String sql = "select * from zhangcq_teachers15 where zcq_Tno15 = ? and zcq_Tpwd15 = ?";
        try (Connection conn = dataSource.getConnection(); PreparedStatement psmt = conn.prepareStatement(sql)) {
            psmt.setString(1,name);
            psmt.setString(2,pass);
            try (ResultSet rst = psmt.executeQuery()) {
                if (rst.next()) {
                    user=new Teacher();
                    user.setTno(rst.getString(1));
                    user.setTname(rst.getString(2));
                    user.setTsex(rst.getString(3));
                    user.setTprofess(rst.getString(4));
                    user.setTphone(rst.getString(5));
                    user.setTauthority(rst.getInt(6));
                    user.setTpwd(rst.getString(7));
                    user.setTage(rst.getInt(8));
                    user.setCollegeno(rst.getString(9));

                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;

    }
}
