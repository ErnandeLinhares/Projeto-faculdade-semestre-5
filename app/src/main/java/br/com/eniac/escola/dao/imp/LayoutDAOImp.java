package br.com.eniac.escola.dao.imp;

import java.util.ArrayList;
import java.util.List;

import br.com.eniac.escola.dao.LayoutDAO;
import br.com.eniac.escola.model.Layout;


public class LayoutDAOImp extends DaoGenericoImp<Layout,Integer> implements LayoutDAO{	
	
	@Override
	public List<Layout> buscarTodosDESC() {
		List<Layout> layouts = new ArrayList<Layout>();
		layouts = super.listPesq("from Layout ORDER BY id desc");
		return layouts;
	}
}
