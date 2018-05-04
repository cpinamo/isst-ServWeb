package es.upm.dit.isst.webLab.dao;

import java.util.List;
import es.upm.dit.isst.webLab.dao.model.Professor;

public interface ProfessorDAO {
	
	public Professor loginProfessor( String email, String password );

	public List<Professor> readAllProfessor();

	public void createProfessor( Professor professor );
	
	public Professor readProfessor( String email );
	
	public void updateProfessor( Professor professor );
	
	public void deleteProfessor( Professor professor );
}

