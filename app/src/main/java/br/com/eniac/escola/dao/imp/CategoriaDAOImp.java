package br.com.eniac.escola.dao.imp;

import java.util.ArrayList;
import java.util.List;

import br.com.eniac.escola.dao.CategoriaDAO;
import br.com.eniac.escola.model.Categoria;


public class CategoriaDAOImp extends DaoGenericoImp<Categoria,Integer> implements CategoriaDAO{
	
	@Override
	public List<Categoria> buscarTodos() {
		List<Categoria> categorias = new ArrayList<Categoria>();
		categorias = super.listPesq("from Categoria order by catNome");
		return categorias;
	}
}
