<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit an Entry</title>
</head>
<body>
<form action="editEntryServlet" method="post">
First Name: <input type="text" name="firstName" value="${entryToEdit.firstName}">
Last Name: <input type="text" name="lastName" value="${entryToEdit.lastName}">
<input type="hidden" name="id" value="${entryToEdit.id}">
<input type="submit" value="Save Edited Entry">
</form>
</body>
</html>