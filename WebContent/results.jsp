<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="resultsPresident.css"/>
		<title>President</title>
	</head>
<body>



	<p>
		<a href="choiceServlet?answerParameter=presidentsList"> Presidential photo list </a>
	</p>


    <p>
		<a href="choiceServlet?answerParameter=test1"> Scroll through Presidents</a>
	</p>




    <h3> This is the president you selected last: ${choosenPresident.name} ${choosenPresident.party} ${choosenPresident.term}</h3>
    <div id="photo">
    <img class="photo" src="${choosenPresident.photo}"/>
    </div><!-- <div id="frame">
    	<img src="https://s-media-cache-ak0.pinimg.com/736x/47/95/db/4795dba31d3c4e58d48c541fe91ee500.jpg" />
    	
    </div> -->
    <h6></h6>

    
	<c:forEach var="thisPresident" items="${sessionPresidents}">

	<%-- 	<p>This is the president number: ${thisPresident.number}</p> --%>




		<table>
			<tr>
				<th>Number</th>
				<th>Name</th>
				<th>Date</th>
				<th>Party</th>
				<th>Photo</th>
			</tr>
			<tr>



				<td>${thisPresident.number}</td>
				<td>${thisPresident.name}</td>
				<td>${thisPresident.term}</td>
				<td>${thisPresident.party}</td>
				<td><img src="${thisPresident.photo}"></td>
			</tr>
		</table>


	</c:forEach>











</body>
</html>