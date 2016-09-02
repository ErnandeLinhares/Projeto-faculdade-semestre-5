package br.com.eniac.escola.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Categoria")
public class Categoria implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name="cat_nome")
	private String catNome;

	public Categoria() {
	}	

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCatNome() {
		return this.catNome;
	}

	public void setCatNome(String catNome) {
		this.catNome = catNome;
	}
	
	@Override
	public String toString() {
		return getId()+"-"+getCatNome();
	}

}