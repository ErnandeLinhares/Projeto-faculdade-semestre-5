package br.com.eniac.escola.dao.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.eniac.escola.dao.AlunoDAO;
import br.com.eniac.escola.model.Aluno;

public class AlunoDAOImp extends DaoGenericoImp<Aluno,Integer> implements AlunoDAO{

	@Override
	public List<String> autoComplete(String nomePesquisa) {
		List<String> retorno = new ArrayList<String>();
		List<Aluno> alunos = new ArrayList<Aluno>();
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("nomePesquisa", "%"+nomePesquisa+"%");
		alunos = super.listPesqParam("from Aluno a where a.nome like :nomePesquisa", params);
		for (Aluno aluno : alunos) {
			retorno.add(aluno.getNome());
		}
		return retorno;
	}

	
	@Override
	public List<Aluno> buscarTodos() {
		List<Aluno> alunos = new ArrayList<Aluno>();
		alunos = super.listPesq("from Aluno order by nome");
		return alunos;
	}
	
	
}
