package br.com.eniac.escola.dao;

import java.util.List;

import br.com.eniac.escola.model.Aluno;

public interface AlunoDAO extends DaoGenerico<Aluno, Integer> {

	public List<String> autoComplete(String nomePesquisa);
	
	public List<Aluno> buscarTodos();
		
}
