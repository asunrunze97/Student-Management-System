<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Management System</title>
</head>
<body>
<h1>Student Management System</h1>
<h2>View Student JSP</h2>
<form>
    <fieldset>
        <legend>Look Up Student By ID</legend>
        <label for="studentId">Student ID:</label>
        <input type="number" id="studentId" name="studentId" required><br><br>
        <button type="button" onclick="showStudentByID()">Show Student by ID</button>
        <br><br>
        <button type="button" onclick="showStudent()">Show all Students</button><br>
    </fieldset>
</form>

<%-- placeholder for showing the result --%>
<div id="txtHint">Student Info...</div>

<script>
    function showStudent() {
        var xhttp;
        xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("txtHint").innerHTML = this.responseText;
            }
        };
        xhttp.open("GET", "showAllStudent", true);
        xhttp.send();
    }

    function showStudentByID() {
        var xhttp;
        xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("txtHint").innerHTML = this.responseText;
            }
        };
        var id = document.getElementById("studentId").value;
        <%-- put id in the url ?studentId=id and call the servlet --%>
        xhttp.open("GET", "showStudentByID" + "?studentId=" + id, true);
        xhttp.send();
    }
</script>


<br><a href="index.jsp">GO TO HOME PAGE</a>
</body>
</html>