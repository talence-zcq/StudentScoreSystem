package com.example.final_database.controller;

import com.example.final_database.dao.studentDao;
import com.example.final_database.dao.teacherDao;
import com.example.final_database.model.Grade;
import com.example.final_database.model.Student;
import com.example.final_database.model.Teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "queryWorkServlet", value = "/queryWorkServlet")
public class queryWorkServlet extends HttpServlet {
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
        String kind=(String)session.getAttribute("kind");
        if(kind.equals("学生")){
            Student stu=(Student)session.getAttribute("user");
            String Cterm = request.getParameter("Cterm");
            studentDao dao=new studentDao();
            ArrayList<Grade> list =dao.queryWork(stu.getSno(),Cterm);
            session.setAttribute("worlist",list);
            dispatcher = request.getRequestDispatcher("VIEW/student1.jsp");
            dispatcher.forward(request, response);
        }
        else if(kind.equals("老师")) {
            Teacher tea=(Teacher)session.getAttribute("user");
            String Cterm = request.getParameter("Cterm");
            teacherDao dao=new teacherDao();
            ArrayList<Grade> list =dao.queryWork(tea.getTno(),Cterm);
            session.setAttribute("worlist",list);
            dispatcher = request.getRequestDispatcher("VIEW/teacher2.jsp");
            dispatcher.forward(request, response);

        }
    }
}
