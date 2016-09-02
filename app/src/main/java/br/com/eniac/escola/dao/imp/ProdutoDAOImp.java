package br.com.eniac.escola.dao.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import br.com.eniac.escola.dao.ProdutoDAO;
import br.com.eniac.escola.model.Produto;

public class ProdutoDAOImp extends DaoGenericoImp<Produto,Integer> implements ProdutoDAO{

	@Override
	public List<String> autoComplete(String nomePesquisa) {
		List<String> retorno = new ArrayList<String>();
		List<Produto> produtos = new ArrayList<Produto>();
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("nomePesquisa", "%"+nomePesquisa+"%");
		produtos = super.listPesqParam("from Produto p where p.descKeys like :nomePesquisa", params);
		for (Produto produto : produtos) {
			retorno.add(produto.getNome());
		}		
		return retorno;
	}
	
	@Override
	 public List<Produto> ProdutosBusca() { 
		List<Produto> produtos = new ArrayList<Produto>();		
	 	String cat = (String) FacesContext.getCurrentInstance().getExternalContext().
	 			     getRequestParameterMap().get("s");
		 	
   	if(cat==null){
   		cat = "0";
   	}
   	
		Map<String, Object> params = new HashMap<String,Object>();  	    	
		params.put("Pesquisa", "%"+cat+"%");	
		produtos = super.listPesqParam("from Produto p where p.descKeys like :Pesquisa", params);
		return produtos;	
	}
	
	
	@Override
	 public List<Produto> ProdutosCategoria() { 
		List<Produto> produtosCategoria = new ArrayList<Produto>();		
	 	String cat = (String) FacesContext.getCurrentInstance().getExternalContext().
	 			     getRequestParameterMap().get("categoria");
		 	
    	if(cat==null){
    		cat = "0";
    	}
    	
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("id", Integer.parseInt(cat));    	    	
		produtosCategoria = super.listPesqParam("SELECT p FROM Produto p WHERE p.cat.id=:id", params);			
		return produtosCategoria;	
	}


	
	@Override
	public List<Produto> buscarDestaques() {
		List<Produto> produtos = new ArrayList<Produto>();
		produtos = super.listPesq("from Produto p where p.destaque='S' ORDER BY rand()");
		return produtos;
	}

}
