package com.controller;

import com.dao.StudentDao;
import com.db.DBConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DeleteStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int deleteStudent = Integer.parseInt(req.getParameter("id"));
        System.out.println(deleteStudent);
        StudentDao studentDao = new StudentDao(DBConnect.getConnection());
        boolean flag = studentDao.deleteStudent(deleteStudent);
        if(flag) {
            System.out.println("DELETED");
        } else {
            System.out.println("ISSUE");
        }
        resp.sendRedirect("displayStudents");
    }
}
