package com.example.final_database.controller;

import com.example.final_database.dao.studentDao;
import com.example.final_database.dao.teacherDao;
import com.example.final_database.model.Student;
import com.example.final_database.model.Teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "modifyPwdServlet", value = "/modifyPwdServlet")
public class modifyPwdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8"); //1
        response.setContentType("text/html;charset=utf-8");  //2
        response.setCharacterEncoding("utf-8");  //3
        String old_pwd =request.getParameter("old_pwd");
        String new_pwd =request.getParameter("new_pwd");
        String message = null;
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;
        String kind=(String)session.getAttribute("kind");
        if(kind.equals("学生")){
            Student stu=(Student)session.getAttribute("user");
            studentDao dao=new studentDao();
            if(old_pwd.equals(stu.getSpwd())){
                boolean flag = dao.modify_pwd(new_pwd,stu.getSno());
                if(flag) {
                    message = "修改成功!";
                    session.setAttribute("message", message);
                }
                else{
                    message = "修改失败!";
                    session.setAttribute("message", message);
                }
            }
            else{
                message = "旧密码输入有误!";
                session.setAttribute("message", message);
            }
            dispatcher = request.getRequestDispatcher("VIEW/student3.jsp");
            dispatcher.forward(request, response);

        }
        else if(kind.equals("老师")){
            Teacher tea=(Teacher)session.getAttribute("user");
            teacherDao dao=new teacherDao();
            if(old_pwd.equals(tea.getTpwd())){
                boolean flag = dao.modify_pwd(new_pwd,tea.getTno());
                if(flag) {
                    message = "修改成功!";
                    session.setAttribute("message", message);
                }
                else{
                    message = "修改失败!";
                    session.setAttribute("message", message);
                }
            }
            else{
                message = "旧密码输入有误!";
                session.setAttribute("message", message);
            }
            dispatcher = request.getRequestDispatcher("VIEW/teacher3.jsp");
            dispatcher.forward(request, response);
        }
    }
}
