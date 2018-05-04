package es.upm.dit.isst.webLab.dao;

import java.util.List;
import es.upm.dit.isst.webLab.dao.model.TFG;

public interface TFGDAO {

	public TFG loginTFG(String email, String password);
	public List<TFG> readAllTFG();
	public void createTFG( TFG tfg );
	public TFG readTFG( String email );
	public void updateTFG( TFG tfg );
	public void deleteTFG( TFG tfg );
}
