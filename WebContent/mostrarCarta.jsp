<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.salsa.card.Card" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
		<title>resultado</title>
	</head>
	<body>
		<div class="header">
		</div>
		<div class="leftBar">
		</div>
		<div class="center">
			<div class="buscaNombre">
				<form action="/salsamagic" method="post">
					<p>Introduzca el nombre de la carta:</p><br/>
					<input type="text" name="consultaNombre"/><br/>
					<input type="submit" value="buscar"/>
				</form>
			</div>
			<div class="muestraCarta">
				<% if(request.getAttribute("cards") != null){ %>
				<% ArrayList<Card> cartas = (ArrayList<Card>)request.getAttribute("cards");%>
				<% for(Card carta: cartas){ %>
				<p><%=carta.getNombreCarta()%><br/>
					<%=carta.getExpansion()%></p><br/>
				<%=carta.getImg()%><br/>
				<p>el valor medio de la carta es de <%=carta.getAvgValue()%>$</p><br/>
				<p>el valor a la baja de la carta es de <%=carta.getLowValue()%>$</p><br/>
				<% } %>
				<% }else{ %>
				<p><%=request.getAttribute("error")%></p>
				<% } %>
			</div>
		</div>
		<div class="rightBar">
		</div>
		<div class="footer">
		</div>
	</body>
</html>