package com.example.final_database.dao;

import com.example.final_database.model.Banji;
import com.example.final_database.model.Grade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class studentDao extends Basedao{
    public boolean modify_pwd(String new_pwd,String sno) {
        String sql = "UPDATE zhangcq_students15 SET zcq_Spwd15 = ? WHERE zcq_Sno15 = ?";
        try (Connection conn = dataSource.getConnection(); PreparedStatement psmt = conn.prepareStatement(sql)) {
            psmt.setString(1,new_pwd);
            psmt.setString(2,sno);
            psmt.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
    public ArrayList<Grade> queryWork(String sno,String cterm){
        String sql="select * from zhangcq_workinfo15 WHERE 1=1";
        if(!sno.equals("")){
            sql=sql+" and zcq_Sno15='"+sno+"'";
        }
        if(!cterm.equals("")){
            sql=sql+" and zcq_Cterm15='"+cterm+"'";
        }
        ArrayList<Grade> list=new ArrayList<Grade>();
        try(Connection conn=dataSource.getConnection();PreparedStatement psmt=conn.prepareStatement(sql)){
            try(ResultSet rst = psmt.executeQuery()){
                while(rst.next()){
                    Grade grade = new Grade();
                    grade.setCterm(rst.getString(4));
                    grade.setCoursename(rst.getString(5));
                    grade.setCredit(rst.getDouble(6));
                    grade.setTname(rst.getString(3));
                    grade.setAssessment(rst.getString(8));
                    list.add(grade);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
