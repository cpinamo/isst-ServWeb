package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.TFGDAO;
import es.upm.dit.isst.webLab.dao.TFGDAOImplementation;
import es.upm.dit.isst.webLab.dao.model.TFG;

@WebServlet("/Form7TutorServlet")
public class Form7TutorServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String tfgEmail = req.getParameter("tfg_email");
		String tfgGrade = req.getParameter("tfg_grade");
		TFGDAO dao = TFGDAOImplementation.getInstance();
		
		TFG tfg = dao.readTFG(tfgEmail);
		tfg.setGrade(Double.parseDouble(tfgGrade));
		tfg.setStatus(7);
		dao.updateTFG(tfg);
		
		resp.sendRedirect(req.getContextPath() + "/LoginTutor.jsp");
	
	}
}
