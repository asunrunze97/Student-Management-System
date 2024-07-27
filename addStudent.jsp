<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Student</title>
</head>
<body>
<jsp:include page="index.jsp"/>
<h2>Add Student JSP</h2>
<form action="addStudentServlet" method="get">
    <fieldset>
        <legend>Create New Student</legend>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>
        <label for="email">Email:</label>
        <%-- the input type "email" will give basic validation --%>
        <input type="email" id="email" name="email" required><br><br>
        <input type="submit" value="Add Student" />
        <input type="reset" value="CLEAR" />
    </fieldset>
</form>

<br><a href="index.jsp">GO TO HOME PAGE</a>
</body>
</html>
