package com.StuentManagerSys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO {
    private Connection connection = null;

    public StudentDAO(){
        try {
            connection = DatabaseUtil.getConnection();
            // make sure the connection is not null
            if (connection == null){
                throw new SQLException("Failed to connect to the database");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TODO: Implement the logic of CURD operations

    // create student/insert student
    public Student addStudent(Student student) {
        try {
            // TODO: Implement the logic to insert the student
            // student id will be auto-generated
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO students (name, email) VALUES (?, ?);",Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            int rowsAffected =preparedStatement.executeUpdate();
            // get the generated id
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            // only one row should be returned
            if (generatedKeys.next()) {
                // set student object
                Student newStudent = new Student(generatedKeys.getInt(1), student.getName(), student.getEmail());
                preparedStatement.close();
                return newStudent;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // update student
    public boolean updateStudent(Student student) {
        try {
            // TODO: Implement the logic to update the student
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE students SET name = ?, email = ? WHERE id = ?;");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // read student
    public Student getStudentById(int id) {
        try {
            // TODO: Implement the logic to get the student by id
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students WHERE id = ?;");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            // since id is unique, only one row will be returned
            if (resultSet.next()) {
                Student student = new Student(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"));
                preparedStatement.close();
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // view all Students
    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> studentList = new ArrayList<>();
        try {
            // TODO: Implement the logic to get all the students
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students;");
            ResultSet resultSet = preparedStatement.executeQuery();
            // loop through the result set and store the students in the list
            while (resultSet.next()) {
                studentList.add(new Student(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email")));
            }
            preparedStatement.close();
            return studentList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    // delete student
    public int deleteStudentById(int id) {
        try {
            // TODO: Implement the logic to delete the student
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM students WHERE id = ?;");
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();
            return rowsAffected;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
