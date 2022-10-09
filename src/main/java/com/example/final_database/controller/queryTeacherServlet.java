package com.example.final_database.controller;

import com.example.final_database.dao.teacherDao;
import com.example.final_database.model.Student;
import com.example.final_database.model.Teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "queryTeacherServlet", value = "/queryTeacherServlet")
public class queryTeacherServlet extends HttpServlet {
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
        String Tno =request.getParameter("Tno");
        String College =request.getParameter("College");
        String profess =request.getParameter("profess");
        teacherDao dao =new teacherDao();
        ArrayList<Teacher> list= dao.queryTeacher(Tno,College,profess);
        session.setAttribute("tealist",list);
        dispatcher = request.getRequestDispatcher("VIEW/admin1.jsp");
        dispatcher.forward(request, response);
    }
}
