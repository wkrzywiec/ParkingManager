<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<style>
		body{
			margin-top: 100px;
			background: #A1FFCE;  /* fallback for old browsers */
			background: -webkit-linear-gradient(to left, #FAFFD1, #A1FFCE);  /* Chrome 10-25, Safari 5.1-6 */
			background: linear-gradient(to left, #FAFFD1, #A1FFCE); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
		}
		
		div.padded {  
	      padding-top: 30px;  
	      padding-right: 30px;  
	      padding-bottom: 30px;  
	      padding-left:	30px;  
    	}
    	
    	.container {
    	margin-bottom: 20px;
    	} 

	</style>
	<title>Parking Manager - Operator</title>
</head>
<body>
<div class="container">
	<div class="col-md-1"></div>
	<div class="col-md-10 padded" style="background-color: LightGoldenRodYellow;">
		<h1>Parking Manager</h1>
	</div>
	<div class="col-md-1"></div>
</div>
<div></div>
<div class="container">
	<div class="col-md-1"></div>
	<div class="col-md-10 padded" style="background-color: LightGoldenRodYellow;">
		<h4>Hello operator, below there is a list of all cars that are on parking and have started their parking meter:</h4>
	</div>
	<div class="col-md-1"></div>
</div>
<div></div>
<div class="container">
	<div class="col-md-1"></div>
	<div class="col-md-10 padded" style="background-color: LightGoldenRodYellow;" >
		<h2 align="center"><b>Cars on parking loot</b></h2>
		<table class="table table-striped" align="center">
    		<thead>
     	 	<tr>
        		<th>Driver name</th>
        		<th>Vehicle Brand</th>
        		<th>Vehicle model</th>
        		<th>Registration No.</th>
        		<th>Starting date</th>
      		</tr>
    		</thead>
   			<tbody>
		<c:forEach items="${visitList}" var="visit">
			<tr>
			<td>${visit.driver.driverName}</td>
			<td>${visit.driver.vehicleBrand}</td>
			<td>${visit.driver.vehicleModel}</td>
			<td>${visit.driver.vehicleReg}</td>
			<td>${visit.dateStart}</div>
			</tr>
		</c:forEach>
			</tbody>
		</table>
	</div>
<div class="col-md-1"></div>
</div>
<form action="/ParkingManager/operator" method="post">
<div class="container">
	<div class="col-md-1"></div>
	<div class="col-md-10 padded" style="background-color: LightGoldenRodYellow;">
		<button type="submit" class="btn btn-primary btn-block" name="btn" value="logout">Log out</button>
	</div>
	<div class="col-md-1"></div>
</div>
</form>
</body>
</html>