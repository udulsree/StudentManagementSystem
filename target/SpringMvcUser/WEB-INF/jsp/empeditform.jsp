<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Student</title>
</head>
<body>
<h1><center>Edit Student</center></h1>
<form:form method="POST" action="/CRUD/editsave"><center>
    <table >
        <tr>
            <td></td>
            <td><form:hidden  path="id" /></td>
        </tr>
        <tr>
            <td>Name : </td>
            <td><form:input path="name"  /></td>
        </tr>
        <tr>
            <td>Age :</td>
            <td><form:input path="age" /></td>
        </tr>
        <tr>
            <td>School :</td>
            <td><form:input path="school" /></td>
        </tr>

        <tr>
            <td> </td>
            <td><input type="submit" value="Save Changes" /></td>
        </tr>
    </table>
</center>
</form:form>
</body>
</html>

