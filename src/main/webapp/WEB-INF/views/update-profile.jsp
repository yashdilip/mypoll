<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Update Profile</title>

	<link rel="stylesheet"	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">

     <form:form method="POST" modelAttribute="pollUser" class="form-signin">
        <h2 class="form-signin-heading">Update Profile</h2>
        <spring:bind path="userName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:label path="userName" class="form-control" value="${ userName } }"></form:label>
                <form:errors path="username"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="fullName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="fullName" class="form-control" placeholder="Full Name"></form:input>
                <form:errors path="fullName"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="mobileNumber">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="mobileNumber" class="form-control"
                            placeholder="Mobile Number"></form:input>
                <form:errors path="mobileNumber"></form:errors>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Update Profile</button>
    </form:form> 

</div>
</body>
</html>
