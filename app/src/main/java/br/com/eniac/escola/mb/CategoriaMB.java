package br.com.eniac.escola.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ArrayDataModel;

import org.primefaces.event.CloseEvent;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.eniac.escola.dao.CategoriaDAO;
import br.com.eniac.escola.model.Categoria;

@ManagedBean
@ViewScoped
public class CategoriaMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Categoria categoria;
	private ArrayDataModel categorias;
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@PostConstruct
	public void iniciar(){
		try{
			categoria = new Categoria();
		} catch (Exception e) {
			FacesUtils.mensErro(e.getMessage());
		}	
	}
	
	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
		
	public void novo(){
		categoria = new Categoria();
	}
	
	public void editar(){
		categoria = (Categoria) categorias.getRowData();
	}
	
	public String salvar(){
				
		try {
			if (categoria.getId()==null){			
				categoriaDAO.salvar(getCategoria());
			} else {
				categoriaDAO.atualizar(getCategoria());
			}
			iniciar();
			return "/admin/pages/categoria.jsf?faces-redirect=true";
		} catch (Exception e) {
			FacesUtils.mensErro(e.getMessage());
			return "";
		}
	}
	
	
	public String excluir(){
		try {
			editar();
			categoriaDAO.excluir(getCategoria());
			iniciar();
			return "/admin/pages/categoria.jsf?faces-redirect=true";
		} catch (Exception e) {
			FacesUtils.mensErro(e.getMessage());
			return "";
		}
	}
	
	public ArrayDataModel getCategorias() {
		categorias = new ArrayDataModel(categoriaDAO.buscarTodos().toArray());
		return categorias;
	}

	public void setCategorias(ArrayDataModel categorias) {
		this.categorias = categorias;
	}
	
	public void fecharModal(CloseEvent event){
		categoria = new Categoria();
	}
		
	public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
		this.categoriaDAO = categoriaDAO;
	}
}
