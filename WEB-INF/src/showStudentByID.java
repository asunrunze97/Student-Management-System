package com.StuentManagerSys;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/showStudentByID")
public class showStudentByID extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String htmlPart =
        """
            <table style="border: double; border-collapse: collapse; width: 50%; margin: auto;">
                <thead>
                    <tr>
                        <th scope="col" style="border: double;">ID</th>
                        <th scope="col" style="border: double; ">Name</th>
                        <th scope="col" style="border: double;">Email</th>
                    </tr>
                </thead>
            <tbody>
        """;

        StudentDAO studentDAO = new StudentDAO();
        // get student by id
        // only one student will be returned
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        // getStudentById will return null if the student is not found
        // otherwise it will return the student
        Student student = studentDAO.getStudentById(studentId);
        if (student != null) {
            out.println(htmlPart);
            out.println("<tr>");
            out.println("<th scope=row style='border: double;'>" + student.getId() + "</th>");
            out.println("<td style='border: double;'>" + student.getName() + "</td>");
            out.println("<td style='border: double;'>" + student.getEmail() + "</td>");
            out.println("</tr>");
            out.println("</tbody></table>");
        } else {
            out.println("<h2>" + "Student not found" + "</h2>");
        }
        studentDAO.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
