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

@WebServlet("/Form6SecServlet")
public class Form6SecServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String tfgEmail = req.getParameter("tfg_email");
		TFGDAO dao = TFGDAOImplementation.getInstance();
		
		TFG tfg = dao.readTFG(tfgEmail);
		tfg.setStatus(6);
		dao.updateTFG(tfg);
		
		resp.sendRedirect(req.getContextPath() + "/LoginSecretaria.jsp");
		
		
	}

}
