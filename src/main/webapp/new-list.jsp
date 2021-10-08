<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new list</title>
</head>
<body>
	<form action="createNewListServlet" method="post">
		List Name: <input type="text" name="listName"><br />
		Raffle date: <input type="text" name="month" placeholder="mm" size="4">
		<input type="text" name="day" placeholder="dd" size="4">,
		<input type="text" name="year" placeholder="yyyy" size="4">
		Host Name: <input type="text" name="hostName"><br />
		Available Entries:<br /> <select name="allEntriesToAdd" multiple size="6">
			<c:forEach items="${requestScope.allEntries}" var="currentitem">
				<option value="${currentitem.id}">${currentitem.firstName}| ${currentitem.lastName}</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Create List and Add Entries">
	</form>
	<a href="index.html">Go add new entry instead.</a>
</body>
</html>