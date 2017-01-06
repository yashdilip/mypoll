<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
<title>Spring Data MongoDB MVC Crud</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet"	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<c:url value="/resources/text.txt" var="url" />
	<spring:url value="/resources/text.txt" htmlEscape="true"
		var="springUrl" />
	Spring URL: ${springUrl} at ${time}
	<br> JSTL URL: ${url}
	<br> Message: ${message} Hello this is tutorial for Spring Data
	MongoDB
	<a href="#" class="btn btn-primary">Primary</a>
	
</body>

</html>
