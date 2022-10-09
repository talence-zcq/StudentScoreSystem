package com.example.final_database.controller;

import com.example.final_database.dao.loginDao;
import com.example.final_database.model.Student;
import com.example.final_database.model.Teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8"); //1
        response.setContentType("text/html;charset=utf-8");  //2
        response.setCharacterEncoding("utf-8");  //3
        String kind =request.getParameter("kind");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session=request.getSession();
        String message=null;
        RequestDispatcher dispatcher=null;
        loginDao userdao=new loginDao();
        if(kind.equals("student")){

            Student user=userdao.StudentLogin(username,password);
            if(user==null){
                message="用户名或密码错误";
                dispatcher=request.getRequestDispatcher("./VIEW/index.jsp");
            }
            else{
                message="登录成功！欢迎!";
                session.setAttribute("user",user);
                dispatcher=request.getRequestDispatcher("./VIEW/student.jsp");
            }
            session.setAttribute("message",message);
            session.setAttribute("kind","学生");
            dispatcher.forward(request,response);
        }
        else if(kind.equals("teacher")){
            Teacher user=userdao.TeacherLogin(username,password);
            if(user==null){
                message="用户名或密码错误";
                dispatcher=request.getRequestDispatcher("./VIEW/index.jsp");
            }
            else{
                message="登录成功！欢迎!";
                session.setAttribute("user",user);
                if(user.getTauthority()<2) {
                    dispatcher = request.getRequestDispatcher("./VIEW/teacher.jsp");
                }
                else{
                    dispatcher = request.getRequestDispatcher("./VIEW/admin.jsp");
                }
            }
            session.setAttribute("message",message);
            session.setAttribute("kind","老师");
            dispatcher.forward(request,response);
        }
    }
}
