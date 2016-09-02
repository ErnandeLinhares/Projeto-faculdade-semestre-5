package br.com.eniac.escola.dao;

import java.util.List;

import br.com.eniac.escola.model.Layout;

public interface LayoutDAO extends DaoGenerico<Layout, Integer> {
	
	public List<Layout> buscarTodosDESC();

}
