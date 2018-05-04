package es.upm.dit.isst.webLab.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import es.upm.dit.isst.webLab.dao.TFGDAOImplementation;
import es.upm.dit.isst.webLab.dao.model.TFG;

@WebServlet("/Form4EstudianteServlet")
@MultipartConfig
public class Form4EstudianteServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Part filePart = req.getPart("file");
		InputStream fileContent = filePart.getInputStream();
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		byte[] buffer = new byte[10240];
		
		/*int length = fileContent.read(buffer);
		do {
			output.write(buffer, 0, length);
			length = fileContent.read(buffer);
		} while (length > 0);
		*/
		for (int length = 0; (length = fileContent.read(buffer)) > 0;) 
			output.write(buffer, 0, length);

		TFG tfg = (TFG) req.getSession().getAttribute("tfg");
		
		tfg.setDocument(output.toByteArray());
		tfg.setStatus(4);
		TFGDAOImplementation.getInstance().updateTFG(tfg);
		
		resp.sendRedirect(req.getContextPath() + "/LoginEstudiante.jsp");
	}
	

}
