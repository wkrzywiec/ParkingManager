<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<title>Parking Manager - login page</title>
</head>
<body>

<div class="container">
	<div class="col-md-3"></div>
	<div class="col-md-6 padded" style="background-color: LightGoldenRodYellow;">
		<h1>Parking Manager</h1>
	</div>
	<div class="col-md-3"></div>
</div>
<div></div>
<div class="container">
	<div class="col-md-3"></div>
	<div class="col-md-6 padded" style="background-color: LightGoldenRodYellow;" >
		<form action="/ParkingManager/home" method="post">
			<div class="form-group">
				<div><label style="color: red;">${errorMessage}</label></div>
	      		<label for="login">Login:</label>
	      		<input type="text" class="form-control" id="login" placeholder="Enter login" name="inputLogin">
	    	</div>
	    	<div class="form-group">
	      		<label for="pwd">Password:</label>
	      		<input type="password" class="form-control" id="pwd" placeholder="Enter password" name="inputPassword">
	    	</div>
	    	<div class="form-group col-sm-6">
	   		<button type="submit" class="btn btn-success btn-block">Log in</button>
	   		</div>
	   		<div class="form-group col-sm-6">
	   		<a href="${request.contextPath}/ParkingManager/registration" class="btn btn-info btn-block" role="button">Sign up</a>
	   		</div>
		</form>
</div>
<div class="col-md-3"></div>
</div>
</body>
</html>