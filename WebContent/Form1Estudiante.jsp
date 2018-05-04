<form action = "Form1EstudianteServlet">

<input type = "text" name= "email" placeholder = "Email"/>
<input type = "text" name= "name" placeholder = "Nombre completo"/>
<input type = "text" name= "title" placeholder = "Título"/>
<input type = "password" name= "password" placeholder = "Contraseña"/>

<select name="advisor">
	<option value="" disabled selected>Elija un tutor</option>
	<c:forEach items = "${professor_list}" var="professori">
		<option value = ${ professori.email}>${professori.name}-${professori.email}</option>
	</c:forEach>
</select>


<input type = "submit">Crear nuevo trabajo</input>

</form>