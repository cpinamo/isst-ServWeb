package es.upm.dit.isst.webLab.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import es.upm.dit.isst.webLab.dao.model.TFG;

public class TFGDAOImplementation implements TFGDAO {

	private static TFGDAOImplementation instance;
	private TFGDAOImplementation() {};
	public static TFGDAOImplementation getInstance() {
		if (null==instance){
			instance = new TFGDAOImplementation();
			
		}
		return instance;
	}
	
	@Override
	public TFG loginTFG(String email, String password) {
		Session session = SessionFactoryService.get().openSession();
		TFG tfg = null;
		try {
			session.beginTransaction();
			tfg = (TFG) session.createQuery("select t from TFG t where t.email= :email and t.password = :password")
					.setParameter("email", email)
					.setParameter("password", password).uniqueResult();
			session.getTransaction().commit();
		}
		catch(Exception e) {
			
		}
		finally {
			session.close();
		}
		return tfg;
	}


	public List<TFG> readAllTFG() {
		Session session = SessionFactoryService.get().openSession();
		List<TFG> tfgs = new ArrayList<>();
		try {
			session.beginTransaction();
			tfgs.addAll(session.createQuery("select t from TFG t").getResultList());
			session.getTransaction().commit();
		}
		catch(Exception e) {
		}
		finally {
			session.close();
		}
		return tfgs;
	}
	@Override
	public void createTFG(TFG tfg) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(tfg);
			session.getTransaction().commit();
		}
		catch(Exception e) {
			
		}
		finally {
			session.close();
		}
	}
	@Override
	public TFG readTFG(String email) {
		TFG tfg = null;
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			tfg = session.get(TFG.class, email);
			session.getTransaction().commit();
		}
		catch(Exception e) {
			
		}
		finally {
			session.close();
		}
		return tfg;
	}

	@Override
	public void updateTFG(TFG tfg) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(tfg);
			session.getTransaction().commit();
		}
		catch(Exception e) {
		}
		finally {
			session.close();
		}
	}

	@Override
	public void deleteTFG(TFG tfg) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(tfg);
			session.getTransaction().commit();
		}
		catch(Exception e) {
			
		}
		finally {
			session.close();
		}
	}

}
