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
	<title>Parking Manager - Driver</title>
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
		<h4>Hello <b><c:out value="${driver.driverName}" /> !</b>
		<br>Thank you for choosing our parking lot. You are a driving <b><c:out value="${driver.vehicleBrand}"/> <c:out value="${driver.vehicleModel}"/></b> registered under <b><c:out value="${driver.vehicleReg}"/></b>.</br> 
		<br>If you want to start/stop your parking meter please click appropriate button below.</br>
		</h4>
	</div>
	<div class="col-md-1"></div>
</div>
<div></div>
<form action="/ParkingManager/driver" method="post">
	<div class="container">
		<div class="col-md-1"></div>
		<div class="col-md-10 padded" style="background-color: LightGoldenRodYellow;" >
			<center><h1 id="stopwatchLabel">Timer: 00:00:00</h1>
			<h1 id="tollLabel">Toll: 0 PLN</h1></center>
			<p></p>
			<div class="form-group col-sm-6">
		   		<button type="button" class="btn btn-success btn-block" name="btn" value="start" id="startBtn" onclick="start()">Start</button>
		   	</div>
		   	<div class="form-group col-sm-6">
		   		<button type="button" class="btn btn-danger btn-block" name="btn" value="stop" onclick="stop()">Stop</button>
		   	</div>
		   	<div>
				<label>${tollMessage}</label>
			</div>
			<div>
			   <button type="button" class="btn btn-primary btn-block" name="btn">Log out</button>
			</div>
		</div> 
		<div class="col-md-1"></div>
	</div>
</form>
<script>
    var status = ${parkingTime == 0 ? 0 : 1}; //0:stop 1:running
    var time = ${parkingTime};
    window.onload = initialize;
    
    function initialize(){
    	
    	if(status == 1){
    		document.getElementById("startBtn").disabled = true;
    	} 
    	timer();
    	timerToll();
    	
    }
    
    function start(){
        status = 1;
        document.getElementById("startBtn").disabled = true;
        timer();
        timerToll();
    }
    function stop(){
        status = 0;
        time = 0;
        document.getElementById("startBtn").disabled = false;
        document.getElementById('stopwatchLabel').innerHTML = 'Timer: 00:00:00';
        document.getElementById('tollLabel').innerHTML = "Toll: 0 PLN";
    }
    
    function tollReg(hourCount){
    	if (hourCount == 0){
    		return 1;
    	} else if (hourCount == 1){
    		return 3;
    	} else {
    		return 2*tollReg(hourCount-1)
    	}
    }
    
    function tollVip(hourCount){
    	if (hourCount == 0){
    		return 0;
    	} else if (hourCount == 1){
    		return 2;
    	} else {
    		return 1.5*tollVip(hourCount-1)
    	}
    }

    function timer(){
        if(status == 1){
            setTimeout(function(){
                time++;
                var hour = Math.floor(time/60/60);
                var min = Math.floor(time/60);
                var sec = time;
                var toll = 0;
                
                if(sec >= 60){
                	sec = sec % 60;
                }      
                if(sec < 10) {
                    sec = "0" + sec;
                } 
                
                if(min < 10) {
                    min = "0" + min;
                }
                if(min >= 60) {
                    min = min % 60;
                }
                if(hour < 10){
                	hour = "0" + hour;
                }
                  
                document.getElementById('stopwatchLabel').innerHTML = "Timer: " + hour + ":" + min + ":" + sec;
                
                for (i = 0; i <= hour; i++){
                	if(${driver.driverType} == 1){	//regular customer
                    	toll = toll + tollReg(i);
                    } else {	//VIP customer
                    	toll = toll + tollVip(i);
                    }
                }
                document.getElementById('tollLabel').innerHTML = "Toll: " + toll + " PLN";
                
                timer();
            }, 1000);
            
        } else {
        	document.getElementById('stopwatchLabel').innerHTML = "Timer: 00:00:00";
        }
    }
    
    function timerToll(){
        if(status == 1){
            setTimeout(function(){
                var hour = Math.floor(time/60/60);
                
                for (i = 0; i <= hour; i++){
                	if(${driver.driverType} == 1){	//regular customer
                    	toll = toll + tollReg(i);
                    } else {	//VIP customer
                    	toll = toll + tollVip(i);
                    }
                }
                document.getElementById('tollLabel').innerHTML = "Toll: " + toll + " PLN";
                
                timerToll();
            }, 60000);   
        } 
    }
</script>
</body>
</html>