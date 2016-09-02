package br.com.eniac.escola.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Layout")
public class Layout implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idLayout")
	private Integer id;

	@Column(name="anuncioBG")
	private String anuncioBG;
	
	@Column(name="anuncioLink")
	private String anuncioLink;

	public Layout() {
	}	

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getAnuncioBG() {
		return anuncioBG;
	}

	public void setAnuncioBG(String anuncioBG) {
		this.anuncioBG = anuncioBG;
	}

	public String getAnuncioLink() {
		return anuncioLink;
	}

	public void setAnuncioLink(String anuncioLink) {
		this.anuncioLink = anuncioLink;
	}

	@Override
	public String toString() {
		return getId()+"-"+getAnuncioBG();
	}

}