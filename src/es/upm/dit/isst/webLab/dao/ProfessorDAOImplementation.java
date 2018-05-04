package es.upm.dit.isst.webLab.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import es.upm.dit.isst.webLab.dao.model.Professor;

public class ProfessorDAOImplementation implements ProfessorDAO {

	private static ProfessorDAOImplementation instance;
	private ProfessorDAOImplementation () {};
	public static ProfessorDAOImplementation getInstance() {
		if (null==instance){
			instance = new ProfessorDAOImplementation();
			
		}
		return instance;
	}
	
	@Override
	public Professor loginProfessor(String email, String password) {
		Session session = SessionFactoryService.get().openSession();
		Professor professor = null;
		try {
			session.beginTransaction();
			professor = (Professor) session
					.createQuery("select p from Professor p where p.email= :email and p.password = :password")
			        .setParameter("email", email)
			        .setParameter("password", password)
			        .uniqueResult();
			session.getTransaction().commit();
		}
		catch(Exception e) {
		}
		finally {
			session.close();
		}
		return professor;
	}

	public List<Professor> readAllProfessor() {
		Session session = SessionFactoryService.get().openSession();
		List<Professor> professors = new ArrayList<>();
		try {
			session.beginTransaction();
			professors.addAll(session.createQuery("select p from Professor p").getResultList());
			session.getTransaction().commit();
		}
		catch(Exception e) {
		}
		finally {
			session.close();
		}
		return professors;
	}
	@Override
	public void createProfessor(Professor professor) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(professor);
			session.getTransaction().commit();
		}
		catch(Exception e) {
			
		}
		finally {
			session.close();
		}
	}
	@Override
	public Professor readProfessor(String email) {
		Professor professor = null;
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			professor = session.get(Professor.class, email);
			session.getTransaction().commit();
		}
		catch(Exception e) {
			
		}
		finally {
			session.close();
		}
		return professor;
	}

	@Override
	public void updateProfessor(Professor professor) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(professor);
			session.getTransaction().commit();
		}
		catch(Exception e) {	
		}
		finally {
			session.close();
		}
	}

	@Override
	public void deleteProfessor(Professor professor) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(professor);
			session.getTransaction().commit();
		}
		catch(Exception e) {
			
		}
		finally {
			session.close();
		}
	}

}
