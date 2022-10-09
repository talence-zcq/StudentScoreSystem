package com.example.final_database.controller;

import com.example.final_database.dao.teacherDao;
import com.example.final_database.model.Course;
import com.example.final_database.model.Setupinfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "querySetupServlet", value = "/querySetupServlet")
public class querySetupServlet extends HttpServlet {
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
        String Coursename =request.getParameter("Coursename");
        String Classname =request.getParameter("Classname");
        teacherDao dao =new teacherDao();
        ArrayList<Setupinfo> list= dao.querySetup(Coursename,Classname);
        session.setAttribute("setlist",list);
        dispatcher = request.getRequestDispatcher("VIEW/admin3.jsp");
        dispatcher.forward(request, response);
    }
}
