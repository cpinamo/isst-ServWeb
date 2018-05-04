package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.ProfessorDAOImplementation;
import es.upm.dit.isst.webLab.dao.TFGDAOImplementation;
import es.upm.dit.isst.webLab.dao.model.Professor;
import es.upm.dit.isst.webLab.dao.model.TFG;

@WebServlet("/Form1EstudianteServlet")
public class Form1EstudianteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String title = req.getParameter("title");
		
		String professorEmail = req.getParameter("advisor");
		Professor advisor = ProfessorDAOImplementation.getInstance().readProfessor(professorEmail);
		
		TFG tfg = new TFG();
		tfg.setEmail(email);
		tfg.setName(name);
		tfg.setPassword(password);
		tfg.setTitle(title);
		tfg.setAdvisor(advisor);
		tfg.setStatus(1);
		
		TFGDAOImplementation.getInstance().createTFG(tfg);
		resp.sendRedirect(req.getContextPath() + "/FormLogin.jsp");
	}
	
}
