package com.dao;

import com.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public record StudentDao(Connection connection) {

    public List<Student> displayAll() {
        List<Student> students = new ArrayList<>();
        Student student;

        try {
            String sql = "SELECT * FROM STUDENT ORDER BY S_ID ASC";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                student = new Student();
                student.setS_ID(resultSet.getInt("S_ID"));
                student.setS_FNAME(resultSet.getString("S_FNAME"));
                student.setS_LNAME(resultSet.getString("S_LNAME"));
                student.setS_AGE(resultSet.getInt("S_AGE"));
                student.setS_GENDER(resultSet.getString("S_GENDER"));
                student.setS_BRANCH(resultSet.getString("S_BRANCH"));
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public boolean addStudent(Student student) {
        boolean flag = false;
        try {
            String sql = "INSERT INTO STUDENT(S_FNAME, S_LNAME, S_AGE, S_GENDER, S_BRANCH) VALUES (?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getS_FNAME());
            preparedStatement.setString(2, student.getS_LNAME());
            preparedStatement.setInt(3, student.getS_AGE());
            preparedStatement.setString(4, student.getS_GENDER());
            preparedStatement.setString(5, student.getS_BRANCH());

            int i = preparedStatement.executeUpdate();

            if (i == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }
}
