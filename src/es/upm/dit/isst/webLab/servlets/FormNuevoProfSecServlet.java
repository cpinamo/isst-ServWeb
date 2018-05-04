package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.ProfessorDAOImplementation;
import es.upm.dit.isst.webLab.dao.model.Professor;

@WebServlet("/FormNuevoProfSecServlet")
public class FormNuevoProfSecServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		
		Professor professor = new Professor();
		professor.setName(name);
		professor.setEmail(email);
		professor.setPassword(password);
		
		ProfessorDAOImplementation.getInstance().createProfessor(professor);
		
		resp.sendRedirect(req.getContextPath() + "/LoginSecretaria.jsp");
	}
}
