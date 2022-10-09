package com.example.final_database.controller;

import com.example.final_database.dao.teacherDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addStudentServlet", value = "/addStudentServlet")
public class addStudentServlet extends HttpServlet {
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
        String Sno =request.getParameter("Sno");
        String Mno = request.getParameter("Mno");
        String Sname = request.getParameter("Sname");
        String Ssex =request.getParameter("Ssex");
        String Sage = request.getParameter("Sage");
        String Savggpa = request.getParameter("Savggpa");
        String Scredit = request.getParameter("Scredit");
        String Sphone = request.getParameter("Sphone");
        String Shometown =request.getParameter("Shometown");
        String Spwd = request.getParameter("Spwd");
        String Classno = request.getParameter("Classno");
        teacherDao dao =new teacherDao();
        boolean flag=dao.addStudennt(Sno,Mno,Sname,Ssex,Sage,Savggpa,Scredit,Sphone,Shometown,Spwd,Classno);
        if(flag){
            message = "添加成功!";
            session.setAttribute("message", message);
        }
        else{
            message = "添加失败!";
            session.setAttribute("message", message);
        }
        dispatcher = request.getRequestDispatcher("VIEW/admin.jsp");
        dispatcher.forward(request, response);
    }
}
