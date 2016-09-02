package br.com.eniac.escola.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ArrayDataModel;

import org.primefaces.event.CloseEvent;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.eniac.escola.dao.LayoutDAO;
import br.com.eniac.escola.model.Layout;

@ManagedBean
@ViewScoped
public class LayoutMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private Layout layout;
	private ArrayDataModel layouts;
	
	@Autowired
	private LayoutDAO layoutDAO;
	
	@PostConstruct
	public void iniciar(){
		try{
			layout = new Layout();
		} catch (Exception e) {
			FacesUtils.mensErro(e.getMessage());
		}	
	}
	
	public void novo(){
		layout = new Layout();
	}


	public Layout getLayout() {
		return layout;
	}
	
	
	public void editar(){
		layout = (Layout) layouts.getRowData();
	}
	
	public String salvar(){
		
		try {
			if (layout.getId()==null){			
				layoutDAO.salvar(getLayout());
			} else {
				layoutDAO.atualizar(getLayout());
			}
			iniciar();
			return "/admin/pages/layout.jsf?faces-redirect=true";
		} catch (Exception e) {
			FacesUtils.mensErro(e.getMessage());
			return "";
		}
	}
	
	
	public String excluir(){
		try {
			editar();
			layoutDAO.excluir(getLayout());
			iniciar();
			return "/admin/pages/layout.jsf?faces-redirect=true";
		} catch (Exception e) {
			FacesUtils.mensErro(e.getMessage());
			return "";
		}
	}
	
	public ArrayDataModel getLayouts() {
		layouts = new ArrayDataModel(layoutDAO.buscarTodosDESC().toArray());
		return layouts;
	}

	public void setLayouts(ArrayDataModel layouts) {
		this.layouts = layouts;
	}
	
	public void fecharModal(CloseEvent event){
		layout = new Layout();
	}
	
	
	
	
	


	public void setLayout(Layout layout) {
		this.layout = layout;
	}

	public void setLayoutDAO(LayoutDAO layoutDAO) {
		this.layoutDAO = layoutDAO;
	}
	
	
}
