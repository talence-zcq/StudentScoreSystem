package com.example.final_database.controller;

import com.example.final_database.dao.teacherDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addCourseServlet", value = "/addCourseServlet")
public class addCourseServlet extends HttpServlet {
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
        String Courseno =request.getParameter("Courseno");
        String Coursename = request.getParameter("Coursename");
        String Collegeno = request.getParameter("Collegeno");
        String Ccredit =request.getParameter("Ccredit");
        String Chours = request.getParameter("Chours");
        String Cassessment = request.getParameter("Cassessment");
        teacherDao dao =new teacherDao();
        boolean flag=dao.addCourse(Courseno,Coursename,Collegeno,Ccredit,Chours,Cassessment);
        if(flag){
            message = "添加成功!";
            session.setAttribute("message", message);
        }
        else{
            message = "添加失败!";
            session.setAttribute("message", message);
        }
        dispatcher = request.getRequestDispatcher("VIEW/admin2.jsp");
        dispatcher.forward(request, response);
    }
}
