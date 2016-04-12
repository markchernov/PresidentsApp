<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="selectPresident.css"/>
		<title>Presidents</title>
	</head>
	<body>

	
		<form action="choiceServlet" method="POST">
			<c:forEach var="thisPresident" items="${allPresidents}">
				<img src=${thisPresident.photo}>
				<input type="radio" name="number" value=" ${thisPresident.number}"/> 
				
			</c:forEach>

			<br> <div class="wrapper"></div><input class="submit" type="submit" value="Submit" /></div>

		</form>


	</body>
</html>