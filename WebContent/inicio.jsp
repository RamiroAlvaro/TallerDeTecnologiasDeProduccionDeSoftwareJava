<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
	<%@include file="head.jsp" %> 
</head>
<body>
	 <%@include file="menu.jsp" %> 
	 <h2>Bienvenido/a, <s:property value="#session['nombre']"/> <s:property value="#session['apellido']"/></h2>
	 <img alt="InfoPool" src="frontend/img/carp.png">
</body>
</html>