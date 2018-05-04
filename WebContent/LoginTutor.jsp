<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vista del tutor</title>
</head>
<body>
<h2>Vista del tutor</h2>

<p>Nombre: ${professor.name }</p>
<p>Email: ${professor.email }</p>



<table border = "1">
<tr>
<th>Nombre</th>
<th>Email</th>
<th>Título</th>
<th>Estado</th>
<th>Acción necesaria</th>
<th>Memoria</th>
</tr>

<c:forEach items = "${professor.advisedTFGs }" var = "tfgi">
<tr>
<td>${tfgi.name }</td>
<td>${tfgi.email }</td>
<td>${tfgi.title }</td>
<td>${tfgi.status }</td>
<td>
<c:if test="${tfgi.status == 1}">
	<%@ include file = "Form2Tutor.jsp"%>
</c:if>
<c:if test="${ tfgi.status == 4}">
	<%@ include file = "Form5Tutor.jsp"%>
</c:if>
<c:if test="${ tfgi.status == 6}">
	<%@ include file = "Form7Tutor.jsp"%>
</c:if>
</td>
<td>
<c:if test="${ tfgi.status >= 4}">
	<%@ include file = "FormPeticion.jsp"%>
</c:if>
</td>
</tr>
</c:forEach>

</table>
</body>
</html>