package br.com.eniac.escola.dao;

import java.util.List;

import br.com.eniac.escola.model.Produto;

public interface ProdutoDAO extends DaoGenerico<Produto, Integer> {

	public List<String> autoComplete(String nomePesquisa);

	public List<Produto> buscarDestaques();
	public List<Produto> ProdutosBusca();
	public List<Produto> ProdutosCategoria();

		
}
