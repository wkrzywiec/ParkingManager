<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
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
	<title>Parking Manager - Owner</title>
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
<form action="/ParkingManager/owner" method="post">
<div class="container">
	<div class="col-md-1"></div>
	<div class="col-md-10 padded" style="background-color: LightGoldenRodYellow;">
		<h4>Hello owner of this beautiful parking loot!
		<br>Pick the date to check how much do you earn this day.</br>
		</h4>
	
		<div class="form-group col-sm-3">
	        <input class="form-control" id="date" name="date" placeholder="YYYY-MM-DD" type="text" value="${date}" required="true"/>
	   	</div>
	   	<div class="form-group col-sm-3">
	   		<button class="btn btn-primary" name="btn" type="submit" value="submit">Submit</button>
	   	</div>
		
	</div>
	<div class="col-md-1"></div>
</div>
<div></div>
<div class="container">
	<div class="col-md-1"></div>
	<div class="col-md-10 padded" style="background-color: LightGoldenRodYellow;" >
	<h3 align="center">On picked day you have earned:</h2>
	<h2 align="center"><b><fmt:formatNumber pattern="#,###.##" value = "${sum}" /> PLN</b></h2>
	</div>
<div class="col-md-1"></div>
</div>
<div class="container">
	<div class="col-md-1"></div>
	<div class="col-md-10 padded" style="background-color: LightGoldenRodYellow;">
		<button type="submit" class="btn btn-primary btn-block" name="btn" value="logout">Log out</button>
	</div>
	<div class="col-md-1"></div>
</div>
</form>
<script>
    $(document).ready(function(){
        var date_input=$('input[name="date"]'); 
        var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
        date_input.datepicker({
            format: 'yyyy-mm-dd',
            container: container,
            todayHighlight: true,
            autoclose: true,
        })
    })
</script>
</body>
</html>