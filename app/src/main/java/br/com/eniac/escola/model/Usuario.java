package br.com.eniac.escola.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Usuario")
public class Usuario  implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Integer id;
	
	@NotNull
	@Column(name="nome")
	private String nome;
	
	@Column(name="razaoSocial")
	private String razaoSocial;
	
	@Column(name="cpf_cnpj")
	private String cpfCnpj;
	
	@Column(name="sexo")
	private String sexo;
	
	@Column(name="cep")
	private String cep;
	@NotNull
	@Column(name="login")
	private String login;
	
	@NotNull
	@Column(name="email")
	private String email;
	
	@NotNull
	@Column(name="senha")
	private String senha;
	
	@NotNull
	@Column(name="situacao")
	private String situacao;
	
	@NotNull
	@Column(name="admin")
	private String admin;
	
	//Getters e Setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getAdmin() {
		return admin;
	}
	
	@Override
	public String toString() {
		return getEmail();
	}
}
