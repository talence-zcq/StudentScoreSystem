package com.example.final_database.controller;

import com.example.final_database.dao.teacherDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addTeacherServlet", value = "/addTeacherServlet")
public class addTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8"); //1
        response.setContentType("text/html;charset=utf-8");  //2
        response.setCharacterEncoding("utf-8");  //3
        String message = null;
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;
        String tno =request.getParameter("tno");
        String tname = request.getParameter("tname");
        String tsex = request.getParameter("tsex");
        String tprofess =request.getParameter("tprofess");
        String tage = request.getParameter("tage");
        String tphone = request.getParameter("tphone");
        String tauthority = request.getParameter("tauthority");
        String tpwd = request.getParameter("tpwd");
        String collegeno =request.getParameter("collegeno");
        teacherDao dao =new teacherDao();
        boolean flag=dao.addTeacher(tno,tname,tsex,tprofess,tage,tphone,tauthority,tpwd,collegeno);
        if(flag){
            message = "添加成功!";
            session.setAttribute("message", message);
        }
        else{
            message = "添加失败!";
            session.setAttribute("message", message);
        }
        dispatcher = request.getRequestDispatcher("VIEW/admin1.jsp");
        dispatcher.forward(request, response);
    }
}
