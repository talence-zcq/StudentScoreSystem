package com.example.final_database.controller;

import com.example.final_database.dao.teacherDao;
import com.example.final_database.model.Course;
import com.example.final_database.model.Teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "queryCourseServlet", value = "/queryCourseServlet")
public class queryCourseServlet extends HttpServlet {
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
        String Collegename =request.getParameter("Collegename");
        String Cterm =request.getParameter("Cterm");
        teacherDao dao =new teacherDao();
        ArrayList<Course> list= dao.queryCourse(Courseno,Collegename,Cterm);
        session.setAttribute("coulist",list);
        dispatcher = request.getRequestDispatcher("VIEW/admin2.jsp");
        dispatcher.forward(request, response);
    }
}
