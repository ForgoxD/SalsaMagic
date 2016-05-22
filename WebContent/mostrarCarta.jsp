<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>resultado</title>
	</head>
	<body>
		<div class="header">
		</div>
		<div class="leftBar">
		</div>
		<div class="center">
			<% if(request.getAttribute("card") != null){ %>
			<p><% request.getParameter("card"); %></p><br>
			<% }else{ %>
			<p><% request.getParameter("consultaNombre");%></p>
			<% } %>
		</div>
		<div class="rightBar">
		</div>
		<div class="footer">
		</div>
	</body>
</html>