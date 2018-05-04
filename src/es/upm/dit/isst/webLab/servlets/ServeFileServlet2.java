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

@WebServlet("/ServeFileServlet2")
public class ServeFileServlet2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		TFGDAO dao = TFGDAOImplementation.getInstance();

		TFG tfg = dao.readTFG(req.getParameter("tfg_email"));
		dao.updateTFG(tfg);
		
		resp.setContentLength(tfg.getDocument().length);
		resp.getOutputStream().write(tfg.getDocument());
		
		
		
		
		
	}
}
