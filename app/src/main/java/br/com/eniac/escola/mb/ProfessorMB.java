package br.com.eniac.escola.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.eniac.escola.dao.ProfessorDAO;
import br.com.eniac.escola.model.Professor;

@ManagedBean
@ViewScoped
public class ProfessorMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private Professor professor;
	
	@Autowired
	private ProfessorDAO professorDAO;


	public Professor getProfessor() {
		return professor;
	}


	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public void setProfessorDAO(ProfessorDAO professorDAO) {
		this.professorDAO = professorDAO;
	}
	
	
}
