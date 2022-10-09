package com.example.final_database.controller;

import com.example.final_database.dao.teacherDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addSetupinfoServlet", value = "/addSetupinfoServlet")
public class addSetupinfoServlet extends HttpServlet {
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
        String Classno = request.getParameter("Classno");
        String Tno = request.getParameter("Tno");
        String cterm = request.getParameter("Cterm");
        teacherDao dao =new teacherDao();
        boolean flag1=dao.addSetupinfo(Courseno,Classno,Tno,cterm);
        boolean flag2=dao.addSetupinfo1(Courseno,Classno,Tno,cterm);
        if(flag1 && flag2){
            message = "添加成功!";
            session.setAttribute("message", message);
        }
        else{
            message = "添加失败!";
            session.setAttribute("message", message);
        }
        dispatcher = request.getRequestDispatcher("VIEW/admin3.jsp");
        dispatcher.forward(request, response);
    }
}
