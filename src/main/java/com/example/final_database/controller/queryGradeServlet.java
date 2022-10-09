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

@WebServlet(name = "queryGradeServlet", value = "/queryGradeServlet")
public class queryGradeServlet extends HttpServlet {
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
        teacherDao dao =new teacherDao();
        if(kind.equals("学生")){
            Student stu=(Student)session.getAttribute("user");
            String Cterm = request.getParameter("Cterm");
            ArrayList<Grade> list =dao.queryGrade(stu.getSno(),Cterm,"");
            session.setAttribute("gralist",list);
            dispatcher = request.getRequestDispatcher("VIEW/student.jsp");
            dispatcher.forward(request, response);
        }
        else if(kind.equals("老师")) {
            Teacher tea=(Teacher)session.getAttribute("user");
            if(tea.getTauthority()>=2){
                String sno = request.getParameter("Sno");
                ArrayList<Grade> list =dao.queryGrade(sno,"","");
                session.setAttribute("gralist",list);
                dispatcher = request.getRequestDispatcher("VIEW/admin4.jsp");
                dispatcher.forward(request, response);
            }
            else{

                String coursename = request.getParameter("coursename");
                String cterm = request.getParameter("cterm");
                ArrayList<Grade> list =dao.t_queryGrade(coursename,cterm,tea.getTno());
                session.setAttribute("gralist",list);
                int nine =Grade.getNine();
                int eight =Grade.getEight();
                int seven =Grade.getSeven();
                int six =Grade.getSix();
                int down =Grade.getDown();
                session.setAttribute("nine",nine);
                session.setAttribute("eight",eight);
                session.setAttribute("seven",seven);
                session.setAttribute("six",six);
                session.setAttribute("down",down);
                dispatcher = request.getRequestDispatcher("VIEW/teacher1.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
}
