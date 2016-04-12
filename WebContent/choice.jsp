<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="choice.css">
		<title>Presidents</title>
	</head>
	<body>

		
     	<h1> ${onePresident.name} </h1>




	<%-- 	<div><p>This is president number: ${onePresident.number}</p></div> --%>
		<br>
		<img src="${onePresident.photo}">
		<br>


		<form action="choiceServlet" method="GET">




			<input type="submit" name="choice" value="Next" />

		</form>



		<form action="choiceServlet" method="GET">

			<input type="submit" name="choice" value="Prev" />

		</form>

		<form action="choiceServlet" method="POST">


			<input type="hidden" name="number" value="${onePresident.number}" />
			<input type="submit" value="Submit" /> <br>
			<!-- <input type="submit" value="Submit" /> -->

		</form>












</body>
</html>