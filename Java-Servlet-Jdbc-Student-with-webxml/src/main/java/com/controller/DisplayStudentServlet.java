package com.controller;

import com.dao.StudentDao;
import com.db.DBConnect;
import com.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class DisplayStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter =resp.getWriter();

        StudentDao studentDao = new StudentDao(DBConnect.getConnection());
        List<Student> students = studentDao.displayAll();
        int id = 0;

        printWriter.println("<html><body>");
        printWriter.println("<a href = \"add.html\"> ADD STUDENT </a><hr>");
        printWriter.println("<table border=1 width=50% height=50%>");
        printWriter.println("<tr><th>STUDENT_ID</th>");
        printWriter.println("<th>STUDENT_FNAME</th>");
        printWriter.println("<th>STUDENT_LNAME</th>");
        printWriter.println("<th>STUDENT_AGE</th>");
        printWriter.println("<th>STUDENT_GENDER</th>");
        printWriter.println("<th>STUDENT_BRANCH</th>");
        printWriter.println("<th>STUDENT_UPDATE</th>");
        printWriter.println("<th>STUDENT_DELETE</th></tr>");

        for (Student student : students) {
            printWriter.println("<tr><td>"+student.getS_ID()+"</td>");
            printWriter.println("<td>"+student.getS_FNAME()+"</td>");
            printWriter.println("<td>"+student.getS_LNAME()+"</td>");
            printWriter.println("<td>"+student.getS_AGE()+"</td>");
            printWriter.println("<td>"+student.getS_GENDER()+"</td>");
            printWriter.println("<td>"+student.getS_BRANCH()+"</td>");
            printWriter.println("<td><a href = \"update.html?id="+student.getS_ID()+"\"> UPDATE </a></td>");
            printWriter.println("<td><a href = \"deleteStudent?id="+student.getS_ID()+"\"> DELETE </a></td></tr>");

            req.setAttribute("id", student.getS_ID());
        }

        printWriter.println("</table></body></html>");
    }
}
