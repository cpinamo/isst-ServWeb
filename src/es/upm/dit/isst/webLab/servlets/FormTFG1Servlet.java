package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.ProfessorDAOImplementation;
import es.upm.dit.isst.webLab.dao.model.Professor;

@WebServlet("/FormTFG1Servlet")
public class FormTFG1Servlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		List<Professor> professor_list = ProfessorDAOImplementation.getInstance().readAllProfessor();
		req.getSession().setAttribute("professor_list", professor_list);
		resp.sendRedirect(req.getContextPath() + "/FormTFG1.jsp");
	}
	
}
