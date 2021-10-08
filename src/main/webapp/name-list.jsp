 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action ="navigationServlet">
	<table>
		<c:forEach items="${requestScope.allNames}" var="currententry">
			<tr>
				<td><input type="radio" name="id" value="${currententry.id}"></td>
				<td>${currententry.firstName}</td>
				<td>${currententry.lastName}</td>
			</tr>
		</c:forEach>
	</table>
	<input type="submit" value="edit" name="doThisToEntry">
  <input type="submit" value="delete" name="doThisToEntry">
  <input type="submit" value="add" name="doThisToEntry">
</form>
</body>
</html>