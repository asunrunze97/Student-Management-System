<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Management System</title>
</head>
<body>
<h1>Student Management System</h1>
<h2>Edit Student JSP</h2>
    <%-- get a list of all students from showAllStudent servlet  --%>
    <jsp:include page="/showAllStudent" />
    <br>
    <%-- form to edit the selected student --%>
    <form action="editStudentServlet" method="get">
        <fieldset>
            <legend>Edit Student</legend>
            <label for="studentId">Student ID:</label>
            <input type="text" id="studentId" name="studentId" required><br><br>
            <label for="studentName">Student Name:</label>
            <input type="text" id="studentName" name="studentName" required><br><br>
            <label for="studentEmail">Student Email:</label>
            <input type="email" id="studentEmail" name="studentEmail" required><br><br>
            <input type="submit" value="Edit Student">
        </fieldset>
    </form>
    <br><br>

    <%-- form to delete the selected student --%>
    <form action="deleteStudentServlet" method="get">
        <fieldset>
            <legend>Delete Student</legend>
            <label for="studentId_delete">Student ID:</label>
            <input type="text" id="studentId_delete" name="studentId_delete" required><br><br>
            <input type="submit" value="delete Student">
        </fieldset>
    </form>


    <%-- go back to home page --%>
    <br><a href="index.jsp">GO TO HOME PAGE</a>
</body>
</html>
