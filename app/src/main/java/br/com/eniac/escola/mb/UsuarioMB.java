package br.com.eniac.escola.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ArrayDataModel;

import org.primefaces.event.CloseEvent;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.eniac.escola.dao.UsuarioDAO;
import br.com.eniac.escola.model.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private Usuario usuario;
	private ArrayDataModel usuarios;

	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@PostConstruct
	public void iniciar(){
		try{
			usuario = new Usuario();
		} catch (Exception e) {
			FacesUtils.mensErro(e.getMessage());
		}	
	}
	
	public void novo(){
		usuario = new Usuario();		
	}
	
	public void editar(){
		usuario = (Usuario) usuarios.getRowData();
	}
	
	public String salvar(){
		try {
			if (usuario.getId()==null){
					if(usuario.getSituacao() == null){
						usuario.setAdmin("N");
						usuario.setSituacao("A");
					}
					if(usuario.getSexo() == null){
						usuario.setSexo("J");
					}
				usuario.setSenha(MD5.gerarMD5(usuario.getSenha()).toString());	
				usuarioDAO.salvar(getUsuario());				
			} else {
				usuario.setSenha(MD5.gerarMD5(usuario.getSenha()).toString());
				usuarioDAO.atualizar(getUsuario());
			}			
			iniciar();
			return "/admin/pages/usuario.jsf?faces-redirect=true";
		} catch (Exception e) {
			FacesUtils.mensErro(e.getMessage());
			return "";
		}
	}
	
	
	public String excluir(){
		try {
			editar();
			usuarioDAO.excluir(getUsuario());
			iniciar();
			return "/admin/pages/usuario.jsf?faces-redirect=true";
		} catch (Exception e) {
			FacesUtils.mensErro(e.getMessage());
			return "";
		}
	}

		
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public ArrayDataModel getUsuarios() {
		usuarios = new ArrayDataModel(usuarioDAO.buscarTodos().toArray());
		return usuarios;
	}
	
	public void fecharModal(CloseEvent event){
		usuario = new Usuario();
	}

	public void setUsuarios(ArrayDataModel usuarios) {
		this.usuarios = usuarios;
	}
	
}
