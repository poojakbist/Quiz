<%@page import="lti.quiz.entity.Answer"%>
<%@page import="lti.quiz.entity.Quiz"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Quiz</title>
</head>
<body>
	<jsp:include page="banner.jsp" />
	<div class="container">
		<h3 style="text-align: center">Take this quiz.</h3>
		<form action="quiz.quiz?choice" method="get">
			<h4>${Question.question}</h4>
			<c:forEach items="${Question.options}" var="option">
				<input type="radio" name="choice" value="${option.pattern}">${option.option}<br>
			</c:forEach>
			<input type="submit" value="Submit Answer" class="btn btn-success">
		</form>
	</div>

	<%@ include file="footer.html"%>
</body>
</html>