package br.com.eniac.escola.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.eniac.escola.dao.UsuarioDAO;
import br.com.eniac.escola.model.Usuario;

@ManagedBean
@ViewScoped
public class LoginMB implements Serializable{

	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	public String logar(){
		
		if (getUsuario().getLogin().equals("") || getUsuario().getSenha().equals("")) {
			FacesUtils.mensErro("Login e/ou senha não podem ser vazios");
			return "/login.jsf";
		} else {
			usuario = usuarioDAO.validaLogin(getUsuario().getLogin(), MD5.gerarMD5(getUsuario().getSenha()));
			if (usuario == null){
				usuario = new Usuario();
				FacesUtils.mensErro("Usuário e senha inválidos");
				return "/login.jsf";
			}else{
				try {
					HttpSession session = (HttpSession) FacesContext.getCurrentInstance().
							getExternalContext().getSession(false);
					session.setAttribute("usuario", usuario);
					//verifica administrador
					if(usuario.getAdmin().equals("N") || usuario.getAdmin().equals("")){  
						return "/index.jsf?faces-redirect=true";
					}else
						return "/admin/pages/home.jsf?faces-redirect=true";
				} catch (Exception e) {
					return "/index.jsp";
				}
			}
		}	
	}
	
	public String menu(){
		return "/pages/bemvindo.jsf?faces-redirect=true";
	}
	
	public String logout(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().
				getExternalContext().getSession(false);
		usuario = new Usuario();
		session.removeAttribute("usuario");
		session.invalidate();
		return "/admin/pages/home.jsf?faces-redirect=true";
	}
	
	//Getters e Setters
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO){
		this.usuarioDAO = usuarioDAO;
	}
	
}
