package br.com.eniac.escola.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ArrayDataModel;

import org.primefaces.event.CloseEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.eniac.escola.dao.ProdutoDAO;
import br.com.eniac.escola.model.Categoria;
import br.com.eniac.escola.model.Produto;

@ManagedBean
@ViewScoped
public class ProdutoMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Produto produto;
	private String nomePesquisa;
	private ArrayDataModel produtos;
	private ArrayDataModel produtosDestaques;
	private ArrayDataModel produtosCategoria;
	private ArrayDataModel produtosBusca;
	

	@Autowired
	private ProdutoDAO produtoDAO;
	
	
	@PostConstruct
	public void iniciar(){
		try{
			produto = new Produto();
			nomePesquisa = "";
		} catch (Exception e) {
			FacesUtils.mensErro(e.getMessage());
		}	
	}
	
	
	
	public String pesquisar(){
		if ("".equals(getNomePesquisa())){
			FacesUtils.mensErro("Para efetuar uma pesquisa é necessário digitar um nome.");
		}
		return "/produto-pesquisa.jsf?s="+getNomePesquisa()+"&faces-redirect=true";
	}
	
	public List<String> complete(String nomePesquisa) {  
        return produtoDAO.autoComplete(nomePesquisa);  
    }  
	
	
	public void novo(){
		produto = new Produto();
		produto.setCat(new Categoria());
	}
	
	public void editar(){
		produto = (Produto) produtos.getRowData();
	}
	
	public String salvar(){
				
		try {
			if (produto.getId()==null){			
				produtoDAO.salvar(getProduto());
			} else {
				produtoDAO.atualizar(getProduto());
			}
			iniciar();
			return "/admin/pages/produto.jsf?faces-redirect=true";
		} catch (Exception e) {
			FacesUtils.mensErro(e.getMessage());
			return "";
		}
	}
	
	
	public String excluir(){
		try {
			editar();
			produtoDAO.excluir(getProduto());
			iniciar();
			return "/admin/pages/produto.jsf?faces-redirect=true";
		} catch (Exception e) {
			FacesUtils.mensErro(e.getMessage());
			return "";
		}
	}
	
	
	public ArrayDataModel getProdutos() {
		produtos = new ArrayDataModel(produtoDAO.todos().toArray());
		return produtos;
	}

	public void setProdutos(ArrayDataModel produtos) {
		this.produtos = produtos;
	}
	
	
	public ArrayDataModel getProdutosDestaques() {
		produtosDestaques = new ArrayDataModel(produtoDAO.buscarDestaques().toArray());
		return produtosDestaques;
	}
	
	public ArrayDataModel getProdutosCategoria() {
		produtosCategoria = new ArrayDataModel(produtoDAO.ProdutosCategoria().toArray());
		return produtosCategoria;
	}
	
	public ArrayDataModel getProdutosBusca() {
		produtosBusca = new ArrayDataModel(produtoDAO.ProdutosBusca().toArray());
		return produtosBusca;
	}
	
	
	public void setProdutosDestaques(ArrayDataModel produtosDestaques) {
		this.produtosDestaques = produtosDestaques;
	}

	public void fecharModal(CloseEvent event){
		produto = new Produto();
	}
	
	
	public Produto getDetalhes() {
	 	String id = 
	 		(String) FacesContext.getCurrentInstance().
	 			getExternalContext().
	 			getRequestParameterMap().get("produto");
	 	
    	if(id==null){
    		id = "0";
    	}		
		return produtoDAO.pesquisarPorId(Integer.parseInt(id));
	}
		
	
	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public String getNomePesquisa() {
		return nomePesquisa;
	}


	public void setNomePesquisa(String nomePesquisa) {
		this.nomePesquisa = nomePesquisa;
	}



	public void setProdutoDAO(ProdutoDAO produtoDAO) {
		this.produtoDAO = produtoDAO;
	}

}
