package br.com.eniac.escola.dao.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.eniac.escola.dao.UsuarioDAO;
import br.com.eniac.escola.model.Usuario;

public class UsuarioDAOImp extends DaoGenericoImp<Usuario,Integer> implements UsuarioDAO{

	@Override
	public Usuario validaLogin(String login, String senha) {
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("login", login);
		params.put("senha", senha);
		return pesqParam("from Usuario u where u.login = :login and u.senha = :senha", params);
	}
	
	@Override
	public List<Usuario> buscarTodos() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = super.listPesq("from Usuario order by nome");
		return usuarios;
	}

}
