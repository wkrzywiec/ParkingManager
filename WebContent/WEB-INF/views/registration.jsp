<%@page import="java.sql.*"%>
<%@page import="utils.DatabaseConnUtils"%>
<%@page import="com.mysql.cj.jdbc.*"%>
<%@page import="com.mysql.cj.jdbc.PreparedStatement"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
	<title>Register new car driver</title>
</head>
<body>
<div class="container">
	<div class="col-md-3"></div>
	<div class="col-md-6 padded" style="background-color: LightGoldenRodYellow;">
		<h1>Parking Manager - Registration</h1>
	</div>
	<div class="col-md-3"></div>
</div>
<div></div>
<div class="container">
	<div class="col-md-3"></div>
	<div class="col-md-6 padded" style="background-color: LightGoldenRodYellow;" >
		<form action="/ParkingManager/registration" method="post">
			<div class="form-group">
				<div><label style="color: red;">${errorMessage}</label></div>
		    	<label for="inputLogin" class="control-label">Login*</label>
		    	<input type="text" class="form-control" id="inputLogin" name="inputLogin" value="${user.userLogin}" placeholder="Login" required>
		  	</div>
		  	
		  	<div class="form-group">
		    	<label for="inputPassword" class="control-label">Password*</label>
				<input type="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" class="form-control" id="inputPassword" name="inputPassword" placeholder="Password" required>
				<div class="help-block">Must contain at least one upper and lower case and one number, and at least 6 characters</div>
			</div>
		
			<div class="form-group">
		    	<label for="inputPasswordConfirm" class="control-label">Confirm Password*</label>
				<input type="password" class="form-control" id="inputPasswordConfirm" data-match="#inputPassword" name="inputConfirmPassword" data-match-error="Aye yai yai yai, passwords are not matching!" placeholder="Confirm password" required>
				<div class="help-block with-errors"></div>
			</div>
		  	
		  	<div class="form-group">
		    	<label for="inputName" class="control-label">Name*</label>
		    	<input type="text" class="form-control" id="inputName" name="inputName" placeholder="Name" value="${driver.driverName}" required>
		  	</div>
		  	
		  	<div class="form-group">
		    	<label for="inputBrand" class="control-label">Vehicle Brand*</label>
		    	<input type="text" class="form-control" id="inputBrand" name="inputBrand" placeholder="Vehicle Brand" value="${driver.vehicleBrand}" required>
		  	</div>
		  	
		  	<div class="form-group">
		    	<label for="inputModel" class="control-label">Vehicle Model</label>
		    	<input type="text" class="form-control" id="inputModel" name="inputModel" placeholder="Vehicle Model" value="${driver.vehicleModel}">
		  	</div>
		  	
		  	<div class="form-group">
		    	<label for="inputReg" class="control-label">Vehicle Registration No.*</label>
		    	<input type="text" class="form-control" id="inputReg" name="inputReg" placeholder="Vehicle Registration No." value="${driver.vehicleReg}" maxlength="15" required>
		  	</div>
		  	
		  	<div class="radio">
		  		<label class="radio-inline"><input type="radio" name="radioDriver" value="1" checked="">Regular driver</label>
				<label class="radio-inline"><input type="radio" name="radioDriver" value="2">VIP driver</label>
		  	</div>
			
			<div class="form-group col-sm-6">
		    	<button type="submit" class="btn btn-success btn-block">Register new car driver</button>
		  	</div>
		  	<div class="form-group col-sm-6">
		  		<a href="${request.contextPath}/ParkingManager/" class="btn btn-info btn-block" role="button">Go back to main page</a>
			</div>
		</form>
		
	</div>
	<div class="col-md-3"></div>
</div>
</body>
</html>

