<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vista del estudiante</title>
</head>
<body>
<h2>Vista del estudiante</h2>
<p>Nombre: ${tfg.name }</p>
<p>Email: ${tfg.email }</p>
<p>Estado: ${tfg.status }</p>

<c:if test="${ tfg.status == 8}">
	<p>Su nota final es: ${tfg.grade }</p>	
</c:if>

<c:if test="${ tfg.status == 3}">
	<%@ include file = "Form4Estudiante.jsp" %>
</c:if>

<c:if test="${ tfg.status >= 4}">
	<a href = "ServeFileServlet">Descargar </a>
</c:if>
</body>
</html>