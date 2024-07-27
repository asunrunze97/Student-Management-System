package com.StuentManagerSys;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addStudentServlet")
public class addStudentServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // get data from the form and set it to the Student object
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        Student student = new Student(name, email);
        // make a new StdentDAO instance
        // it will connect to the database
        // and have all the CRUD methods
        StudentDAO studentDAO = new StudentDAO();
        // one and only one student will be added and information will be returned
        // failed to add student will return null
        student = studentDAO.addStudent(student);

        // html part
        out.println("<html><body>");
        out.println("<h1>" + "addStudentServlet" + "</h1>");
        if (student != null) {
            out.println("<h2>" + "Student added successfully" + "</h2>");
            // print student info
            out.println("<h3>" + "Student Info" + "</h3>");
            out.println("<p>" + "ID: " + student.getId() + "</p>");
            out.println("<p>" + "Name: " + student.getName() + "</p>");
            out.println("<p>" + "Email: " + student.getEmail() + "</p>");
        } else {
            out.println("<h2>" + "Student not added" + "</h2>");
        }
        // go to home page and end of the html
        out.println("<br><a href=\"index.jsp\">GO TO HOME PAGE</a>");
        out.println("</body></html>");
        // close database connection
        studentDAO.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}