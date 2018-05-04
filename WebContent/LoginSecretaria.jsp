<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vista de administración</title>
</head>
<body>

<h2>Vista de secretaría</h2>

<h3>Formulario de creación de profesores</h3>
<%@ include file = "FormNuevoProfSec.jsp" %>

<h4>Listado de proyectos</h4>

<table border = 1>
<tr>
<th>Título</th>
<th>Autor</th>
<th>Email</th>
<th>Tutor</th>
<th>Email tutor</th>
<th>Estado</th>
<th>Acción necesaria</th>
<th>Memoria</th>
<th>NOTA</th>
</tr>

<c:forEach items = "${tfg_list}" var="tfgi">
<tr>
<td>${tfgi.title}</td>
<td>${tfgi.name}</td>
<td>${tfgi.email}</td>
<td>${tfgi.advisor.name}</td>
<td>${tfgi.advisor.email}</td>
<td>${tfgi.status}</td>
<td>
<c:if test="${tfgi.status == 2}">
	<%@ include file = "Form3Sec.jsp" %>
</c:if>
<c:if test="${ tfgi.status == 5}">
	<%@ include file = "Form6Sec.jsp" %>
</c:if>
</td>
<td>
<c:if test="${ tfgi.status >= 4}">
		<%@ include file = "FormPeticion.jsp"%>
</c:if>
</td>
<td>
<c:if test="${ tfgi.status == 7}">
	${tfgi.grade}
	<%@ include file = "Form8Sec.jsp" %>
</c:if>
</td>

</tr>
</c:forEach>

</table>


</body>
</html>