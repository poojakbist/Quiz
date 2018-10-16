<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="style.css" />
<script type="text/javascript" src="bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<jsp:include page="banner.jsp" />
	<div class="wrapper">
		<div class="container">
			<form action="register.quiz" method="post" class="form-signin">
				<div class="alert-info">${Info}</div>
				<h1 class="form-signin-heading">Registration</h1>
				<table class="table table-striped" style="width: 50%">
					<tr>
						<td>Email ID:</td>
						<td><input type="email" name="email" required></td>
					</tr>
					<tr>
						<td>Favorite Superhero:</td>
						<td><input name="answer" required></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="password" name="password" required></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Register"
							class="btn btn-success"></td>
					</tr>
				</table>
				<hr>
				Already Registered? <a href="index.jsp">Go to Login</a>
			</form>
		</div>
		<%@ include file="footer.html"%>
	</div>
</body>
</html>