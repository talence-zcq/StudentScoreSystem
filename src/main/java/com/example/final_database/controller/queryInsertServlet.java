package com.example.final_database.controller;

import com.example.final_database.dao.teacherDao;
import com.example.final_database.model.Grade;
import com.example.final_database.model.Student;
import com.example.final_database.model.Teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "queryInsertServlet", value = "/queryInsertServlet")
public class queryInsertServlet extends HttpServlet {
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
        teacherDao dao =new teacherDao();
        Teacher tea=(Teacher)session.getAttribute("user");
        String coursename = request.getParameter("coursename");
        String classname = request.getParameter("classname");
        ArrayList<Grade> list =dao.insertGrade1(tea.getTno(),coursename,classname);
        session.setAttribute("gralist",list);
        dispatcher = request.getRequestDispatcher("VIEW/teacher.jsp");
        dispatcher.forward(request, response);


    }
}
