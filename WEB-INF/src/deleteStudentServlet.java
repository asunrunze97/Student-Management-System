package com.StuentManagerSys;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteStudentServlet")
public class deleteStudentServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // get data from the form
        int id = Integer.parseInt(request.getParameter("studentId_delete"));
        StudentDAO studentDAO = new StudentDAO();
        if (studentDAO.deleteStudentById(id) > 0) {
            // go to home page and end of the html
            out.println("<html><body>");
            out.println("<h1>" + "deleteStudentServlet" + "</h1>");
            out.println("<h2>" + "Student ID: " + id + " deleted successfully" + "</h2>");
            out.println("<br><a href=\"index.jsp\">GO TO HOME PAGE</a>");
            out.println("</body></html>");
        } else {
            // go to home page and end of the html
            out.println("<html><body>");
            out.println("<h1>" + "deleteStudentServlet" + "</h1>");
            out.println("<h2>" + "Student not deleted" + "</h2>");
            out.println("<br><a href=\"index.jsp\">GO TO HOME PAGE</a>");
            out.println("</body></html>");
        }

        studentDAO.close();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
