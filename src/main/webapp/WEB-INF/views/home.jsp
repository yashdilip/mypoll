<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>

<html lang="en">

<head>
<title>Spring Data MongoDB MVC Crud</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet"	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container">
		<h1>Example of CRUD Operation using Spring MVC and Spring Data
		MongoDB.</h1>
		<div class="row">
    		<div class="col-sm-4">
    			<h4>Add New Car</h4>
    			<form action="/addCar" method="post">
    				<label for="make">Make</label> <input type="text" id="make" name="make" placeholder="Make" /> <br />
    				<label for="model">Model</label> <input type="text" id="model" name="model" placeholder="Model" /> <br />
    				<label for="make">Desc</label> <input type="text" id="description" name="description" placeholder="Desc" /> <br />
    				<label for="make">Year</label> <input type="text" id="year" name="year" placeholder="Year" /> <br />
    				
    				<input type="submit" value="Submit" />
    				
    			</form>
      		</div>
    		<div class="col-sm-8">
          		<table class="table">
  					<thead class="thead-inverse">
    					<tr>
      						<th>Make</th>
      						<th>Model</th>
      						<th>Description</th>
      						<th>Year</th>
      						<th>Operations</th>
					    </tr>
  					</thead>
  					<tbody>
  						<c:forEach var="car" items="${carList}">
  							<tr>
  								<td>${car.make}</td>
  								<td>${car.model}</td>
  								<td>${car.description}</td>
  								<td>${car.year}</td>
  								<td><a href="/delete/${car.id}" >Delete</a></td>
  								<td></td>
  							</tr>
  						</c:forEach>
    				</tbody>
					</table>
    		</div>
  		</div>
  		<div class="row">
  		<div class="col-sm-4">
    			<h4>Search for Cars</h4>
    			<form action="/search" method="post">
    				<input type="text" id="search" name="search" placeholder="Search" value=""/> <br />  				
    				<input type="submit" value="Search" />
    				
    			</form>
      		</div>
      		<div class="col-sm-8">
    			
      		</div>
  		</div>
	</div>
</body>

</html>
