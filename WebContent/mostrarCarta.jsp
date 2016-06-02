<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.salsa.card.Card" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
		<script src="./Scripts/MostrarCapa.js"></script>
		<link rel="stylesheet" type="text/css" href="./Style/Flotante.css">
		<title>resultado</title>
	</head>
	<body>
		<div id="flotante"></div>
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
				<table>
					<tr>
						<td>imagen</td>
						<td>nombre</td>
						<td>set</td>
						<td>precio avg</td>
						<td>precio low</td>
						<td>enlace a pagina</td>
					</tr>
					<% for(Card carta: cartas){ %>
					<tr>
						<td><img src="./Style/Img/img.png" onMouseOver="showdiv(event,'<%=carta.getImg()%>')" onMouseOut="hiddenDiv()"/></td>
						<td><%=carta.getNombreCarta()%></td>
						<td><%=carta.getExpansion()%></td>
						<td><%=carta.getAvgValue()%>$</td>
						<td><%=carta.getLowValue()%>$</td>
						<td><a href="<%=carta.getUrl()%>">comprar</a></td>
					</tr>
					<% } %>
				</table>
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