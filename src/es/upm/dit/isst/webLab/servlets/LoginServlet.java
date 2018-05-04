package es.upm.dit.isst.webLab.servlets;

import es.upm.dit.isst.webLab.dao.model.TFG;
import es.upm.dit.isst.webLab.dao.TFGDAOImplementation;
import es.upm.dit.isst.webLab.dao.model.Professor;
import es.upm.dit.isst.webLab.dao.ProfessorDAOImplementation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{

	private final String USER_SECRETARIA = "root";
	private final String PASS_SECRETARIA = "root";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		TFG tfg = TFGDAOImplementation.getInstance().loginTFG(email, password);
		Professor professor = ProfessorDAOImplementation.getInstance().loginProfessor(email, password);
		
		if(USER_SECRETARIA.equals(email) && PASS_SECRETARIA.equals(password)) {
			req.getSession().setAttribute("tfg_list", TFGDAOImplementation.getInstance().readAllTFG());
			resp.sendRedirect(req.getContextPath() +  "/LoginSecretaria.jsp");
		} else if(null != professor) {
			req.getSession().setAttribute("professor", professor);
			resp.sendRedirect(req.getContextPath() +  "/LoginTutor.jsp");
		} else if(null != tfg) {
			req.getSession().setAttribute("tfg", tfg);
			resp.sendRedirect(req.getContextPath() +  "/LoginEstudiante.jsp");
		} else {
			resp.sendRedirect(req.getContextPath() +  "/FormLogin.jsp");
		}
	}
	
}
