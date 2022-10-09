package com.example.final_database.controller;

import com.example.final_database.dao.teacherDao;
import com.example.final_database.model.College;
import com.example.final_database.model.Major;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "queryMajorServlet", value = "/queryMajorServlet")
public class queryMajorServlet extends HttpServlet {
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
        ArrayList<Major> list= dao.queryMajor();
        session.setAttribute("majlist",list);
        dispatcher = request.getRequestDispatcher("VIEW/admin6.jsp");
        dispatcher.forward(request, response);
    }
}
