package br.com.eniac.escola.dao;

import java.util.List;

import br.com.eniac.escola.model.Usuario;

public interface UsuarioDAO extends DaoGenerico<Usuario, Integer> {

	
	public Usuario validaLogin(String login, String senha);
	
	public List<Usuario> buscarTodos();
}
