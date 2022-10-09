package com.example.final_database.controller;

import com.example.final_database.dao.teacherDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addCollegeServlet", value = "/addCollegeServlet")
public class addCollegeServlet extends HttpServlet {
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
        String Collegeno =request.getParameter("Collegeno");
        String Collegename = request.getParameter("Collegename");
        teacherDao dao =new teacherDao();
        boolean flag=dao.addCollege(Collegeno,Collegename);
        if(flag){
            message = "添加成功!";
            session.setAttribute("message", message);
        }
        else{
            message = "添加失败!";
            session.setAttribute("message", message);
        }
        dispatcher = request.getRequestDispatcher("VIEW/admin5.jsp");
        dispatcher.forward(request, response);
    }
}
