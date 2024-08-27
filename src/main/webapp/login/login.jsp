<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login to TOTO List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
 rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
		<h1>Login Form</h1>
		<form action="<%= request.getContextPath()%>/login" method="post">
						
			<div class="form-group">
				<label for="uname">User Name: </label> <input type="text"
					class="form-control" id="username" placeholder="User Name" name="username" required>
			</div>
						
			<div class="form-group">
				<label for="password">Password: </label> <input type="password"
				class="form-control" id="password" name="password" required>
			</div>
			
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>	
		<a href="<%= request.getContextPath() %>/register/register.jsp">Register</a>
	</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>