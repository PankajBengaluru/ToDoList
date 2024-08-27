<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
 rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Todo List: Add new item</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="container col-md-5">
	<div class="card">
		<div class="card-body">
		<form action="insert" method="post">
			<fieldset class="form-group">
				<label>Title</label> <input type="text" class="form-control" name="title" required="required" minlength="7" />
			</fieldset>
			<input type="hidden" name="username" value="<c:out value='${username}'/>"/>
			<fieldset class="form-group">
				<label>Status</label> 
				<select class="form-control" name="isDone">
					<option value="false">Active</option>
					<option value="true">Finished</option>	
				</select>
			</fieldset>
			
			<fieldset class="form-group">
				<label>Date</label> 
				<input type="date" class="form-control" name="targetDate" required="required"/>
			</fieldset>
			
			<button type="submit" class="btn btn-primary">Add</button>
		</form>
		</div>
	</div>
	</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>