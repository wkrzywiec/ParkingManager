# Parking Manager (Web Application) 

## General info

Simple web application that can be used for parking lot managment. Customers can start their car parking using it and depending on the time that they left their car fee is calculated. Also the website can be used to monitor the income per day and basic information which car are currently on the parking. 

## Screenshots

<img src="https://github.com/wkrzywiec/ParkingManager/blob/master/pm_1.JPG" height="250"><img src="https://github.com/wkrzywiec/ParkingManager/blob/master/pm_2.JPG" height="250">
<img src="https://github.com/wkrzywiec/ParkingManager/blob/master/pm_3.JPG" height="250">
<img src="https://github.com/wkrzywiec/ParkingManager/blob/master/pm_4.JPG" height="250">
<img src="https://github.com/wkrzywiec/ParkingManager/blob/master/pm_5.JPG" height="250">

## Technical info

This is simple web application that use REST calls with servlets. Project is build using Gradle that runs on Tomcat server with MySQL database. Both server and database are initialized when you run Gradle build script (Flyway Gradle plugin). 
Connection between application and database is made via JDBC for all CRUD tasks (query and modifying the database). Frontend of the website is made with JSP and Bootrstrap.

## How to run application?

1. Make sure that you have installed MySQL database, more info <a href='https://www.mysql.com/why-mysql/windows/'>here</a>.
2. Make sure that you have installed Tomcat server on your PC, more information <a href='https://tomcat.apache.org/tomcat-7.0-doc/appdev/installation.html'>here</a>.
3. Import this Gradle project into Eclipse and run Gradle build script.
4. In order to enter the website type: http://localhost:8080/ParkingManager/
