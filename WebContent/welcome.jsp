<%@page import="java.sql.*"%>
<%@page import="utils.DatabaseConnUtils"%>
<%@page import="com.mysql.cj.jdbc.*"%>
<%@page import="com.mysql.cj.jdbc.PreparedStatement"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

Connection con = DatabaseConnUtils.getConnection();
PreparedStatement ps=(PreparedStatement)con.prepareStatement("SELECT * from users");
ResultSet rs= ps.executeQuery();
while(rs.next()){
	String username=rs.getString("user_login");
	out.println("Username "+username+"<hr>");
}
%>
</body>
</html>