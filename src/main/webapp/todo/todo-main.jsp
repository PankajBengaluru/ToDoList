<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
 rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>TODO List</title>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>
<div class="row">
	<div class="container">
		<a href="<%= request.getContextPath()%>/add?username=<c:out value='${username}'/>" class="btn btn-primary">Add Item</a>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Title</th>
					<th>Date</th>
					<th>Done</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="todoItem" items="${todoList}">
					<tr>
						<td><c:out value="${todoItem.title}"></c:out></td>
						<td><c:out value="${todoItem.targetDate}"></c:out></td>
						<td><c:out value="${todoItem.isDone}"></c:out></td>
						<td><a href="delete?id=<c:out value='${todoItem.id}'/>&username=<c:out value='${username}'/>">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>