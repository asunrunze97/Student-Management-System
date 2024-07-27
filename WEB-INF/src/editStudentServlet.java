package com.StuentManagerSys;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/editStudentServlet")
public class editStudentServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // get data from the form and set it to the Student object
        int id = Integer.parseInt(request.getParameter("studentId"));
        String name = request.getParameter("studentName");
        String email = request.getParameter("studentEmail");
        Student student = new Student(id, name, email);
        // make a new StdentDAO instance
        // it will connect to the database
        // and have all the CRUD methods
        StudentDAO studentDAO = new StudentDAO();

        // html part
        out.println("<html><body>");
        out.println("<h1>" + "addStudentServlet" + "</h1>");
        // update student
        if (studentDAO.updateStudent(student)) {
            out.println("<h2>" + "Student updated successfully" + "</h2>");
            // print student info
            out.println("<h3>" + "Student Info" + "</h3>");
            out.println("<p>" + "ID: " + student.getId() + "</p>");
            out.println("<p>" + "Name: " + student.getName() + "</p>");
            out.println("<p>" + "Email: " + student.getEmail() + "</p>");
        } else {
            out.println("<p> Failed to update student. </p>");
        }

        // go to home page and end of the html
        out.println("<br><a href=\"index.jsp\">GO TO HOME PAGE</a>");
        out.println("</body></html>");
        studentDAO.close();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
