package com.controller;

import com.dao.StudentDao;
import com.db.DBConnect;
import com.model.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        int age = Integer.parseInt(req.getParameter("age"));
        String gender = req.getParameter("gender");
        String branch = req.getParameter("branch");

        Student student = new Student(fname, lname, age, gender, branch);
        StudentDao studentDao = new StudentDao(DBConnect.getConnection());
        boolean add = studentDao.addStudent(student);
        if (add) {
            System.out.println("STUDENT ADDED");
        } else {
            System.out.println("ERROR IN ADDING STUDENT");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("displayStudents");
        requestDispatcher.forward(req, resp);
    }
}
