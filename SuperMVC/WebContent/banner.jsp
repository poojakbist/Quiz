<%@page import="lti.quiz.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="bootstrap.min.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body style="background-color: teal;">
<div style="padding-left:150px"><h1> SuperQuiz.com >> Invoke your inner hero.</h1></div>
<div style="padding-left:350px">
<% User user = (User) session.getAttribute("USER");
	if(user != null){ %>
		<div> Welcome <%= user.getEmail() %> | <a href="logout.quiz" class="btn btn-success">Logout</a></div>
<%	} else{ %>
	<div>Welcome Guest</div>
<% }%>
</div>
</body>
</html>