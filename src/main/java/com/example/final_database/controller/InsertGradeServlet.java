package com.example.final_database.controller;

import com.example.final_database.dao.teacherDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "InsertGradeServlet", value = "/InsertGradeServlet")
public class InsertGradeServlet extends HttpServlet {
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
        String sno=request.getParameter("sno");
        String tno=request.getParameter("tno");
        String cno=request.getParameter("cno");
        String cterm=request.getParameter("cterm");
        String grade=request.getParameter("grade");
        teacherDao dao =new teacherDao();
        boolean flag = dao.modify_grade(sno,tno,cno,cterm,grade);
        if(flag) {
            message = "成绩输入成功!";
            session.setAttribute("message", message);
        }
        else{
            message = "成绩输入失败!";
            session.setAttribute("message", message);
        }
        dispatcher = request.getRequestDispatcher("VIEW/teacher.jsp");
        dispatcher.forward(request, response);
    }
}
