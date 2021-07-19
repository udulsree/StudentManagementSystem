<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student table</title>
</head>
<body>
<h1>Student List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Id</th><th>Name</th><th>Age</th><th>School</th><th>Actions</th></tr>
    <c:forEach var="student" items="${list}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.school}</td>
            <td><a href="editemp/${student.id}">Edit</a> &nbsp&nbsp&nbsp&nbsp <a href="deleteemp/${student.id}">Remove</a></td>

        </tr>
    </c:forEach>
</table>
<br/>
<a href="empform">Add New Student</a>
</body>
</html>
