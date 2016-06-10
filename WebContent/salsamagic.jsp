<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Salsa Magic</title>
<link href="./Style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="topPan">
	<a href="#"><img src="Style/images/logo.png" alt="Salsa Magic" width="245" height="40" border="0"  class="logo" title="Salsa Magic"/></a>
  	<div id="topContactPan">
 	 	</div>
 	 	<div id="topMenuPan">
    <div id="topMenuLeftPan"></div>
    <div id="topMenuMiddlePan">
      	<ul>
        	<li class="home">Home</li>
        	<li><a href="#">About us</a></li>
        	<li><a href="#">Support</a></li>
        	<li><a href="#">books</a></li>
        	<li><a href="#">university</a></li>
        	<li><a href="#">Blog</a></li>
        	<li><a href="#">ideas</a></li>
        	<li class="contact"><a href="#" class="contact">Contact</a></li>
      	</ul>
    </div>
    <div id="topMenuRightPan">
    </div>
  </div>
</div>
<div id="bodyPan">
  <div id="bodyLeftPan">
    <form action="/salsamagic" method="post">
		<p>Introduzca el nombre de la carta:</p><br/>
		<input type="text" name="consultaNombre"/><br/>
		<input type="submit" value="buscar"/>
	</form>
  </div>
  <div id="bodyRightPan">
    <h2><span>few</span> tips</h2>
    <ul>
      <li><a href="#">lorem ipsum dolor sit</a> </li>
      <li><a href="#">Amet, consectetuer</a> </li>
      <li><a href="#">Amet, consectetuer</a> </li>
      <li><a href="#">Bibendum nunc. Lorem</a> </li>
      <li><a href="#">Ipsum dolor sit amet, </a> </li>
      <li><a href="#">Consectetuer adipiscinrt.</a> </li>
      <li><a href="#">Integer porta enim vel mi.</a> </li>
      <li><a href="#">Vivamus at mi.Ut</a> </li>
    </ul>
    <h3><span>latest</span> updates</h3>
    <p class="boldtext">on 03rd october 2006</p>
    <p>lorem ipsum dolor sit Ametert, consectetue Adipiscingelitedo mol Bibendum</p>
    <p class="more"><a href="#">more</a></p>
    <p class="boldtext">on 03rd october 2006</p>
    <p>lorem ipsum dolor sit Ametert, consectetue Adipiscingelitedo mol Bibendum</p>
    <p class="more"><a href="#">more</a></p>
  </div>
</div>
<div id="footermainPan">
  <div id="footerPan">
    <ul>
      <li><a href="#">Home</a>| </li>
      <li><a href="#">About us</a>| </li>
      <li><a href="#">Support</a>| </li>
      <li><a href="#">Books</a>| </li>
      <li><a href="#">University</a>| </li>
      <li><a href="#">Blog</a>| </li>
      <li><a href="#">Ideas</a>| </li>
      <li><a href="#">Contact</a> </li>
    </ul>
    <p class="copyright">©education zone. All right reserved.</p>
    <ul class="templateworld">
      <li>design by:</li>
      <li><a href="http://www.templateworld.com" target="_blank">Template World</a></li>
    </ul>
    <div id="footerPanhtml"><a href="http://validator.w3.org/check?uri=referer" target="_blank">HTML</a></div>
    <div id="footerPancss"><a href="http://jigsaw.w3.org/css-validator/check/referer" target="_blank">css</a></div>
  </div>
</div>
</body>
</html>

