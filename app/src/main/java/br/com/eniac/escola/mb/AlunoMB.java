package br.com.eniac.escola.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.ArrayDataModel;

import org.primefaces.event.CloseEvent;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.eniac.escola.dao.AlunoDAO;
import br.com.eniac.escola.model.Aluno;

@ManagedBean
@ViewScoped
public class AlunoMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Aluno aluno;
	private ArrayDataModel alunos;

	@Autowired
	private AlunoDAO alunoDAO;

	
	@PostConstruct
	public void iniciar(){
		try{
			aluno = new Aluno();
		} catch (Exception e) {
			FacesUtils.mensErro(e.getMessage());
		}	
	}
	
	
	public void novo(){
		aluno = new Aluno();
	}
	
	public void editar(){
		aluno = (Aluno) alunos.getRowData();
	}
	
	public String salvar(){
		try {
			if (aluno.getId()==null){
				alunoDAO.salvar(getAluno());
			} else {
				alunoDAO.atualizar(getAluno());
			}
			iniciar();
			return "/pages/aluno.jsf?faces-redirect=true";
		} catch (Exception e) {
			FacesUtils.mensErro(e.getMessage());
			return "";
		}
	}
	
	
	public String excluir(){
		try {
			editar();
			alunoDAO.excluir(getAluno());
			iniciar();
			return "/pages/aluno.jsf?faces-redirect=true";
		} catch (Exception e) {
			FacesUtils.mensErro(e.getMessage());
			return "";
		}
	}
	
	public void fecharModal(CloseEvent event){
		aluno = new Aluno();
	}
	
	
	public Aluno getAluno() {
		return aluno;
	}


	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void setAlunoDAO(AlunoDAO alunoDAO) {
		this.alunoDAO = alunoDAO;
	}

	public ArrayDataModel getAlunos() {
		alunos = new ArrayDataModel(alunoDAO.buscarTodos().toArray());
		return alunos;
	}

	public void setAlunos(ArrayDataModel alunos) {
		this.alunos = alunos;
	}

		
	
}
