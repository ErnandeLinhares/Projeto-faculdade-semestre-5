package br.com.eniac.escola.dao;

import java.util.List;

import br.com.eniac.escola.model.Categoria;

public interface CategoriaDAO extends DaoGenerico<Categoria, Integer> {
	
	public List<Categoria> buscarTodos();

}
