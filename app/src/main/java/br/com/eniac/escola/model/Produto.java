package br.com.eniac.escola.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Produto")
public class Produto  implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idproduto")
	private Integer id;

	
	@Column(name="prod_nome")
	private String nome;
	
	@Column(name="preco")
	private Double preco;
	
	
	@Column(name="desconto")
	private Double desconto;
	
	@Column(name="desc_keys")
	private String descKeys;
	
	@Column(name="desc_pq")
	private String descPq;
	
	@Column(name="desc_gd")
	@Lob
	private String descGd;
	
	@Column(name="imagem")
	private String imagem;
	
	
	@ManyToOne
	@JoinColumn(name="cat_id", referencedColumnName = "id")
	private Categoria cat;
	
	@NotNull
	@Column(name="destaque")
	private String destaque;
	
	
	@Column(name="rank")
	private Integer rank;
	
	
	
	public Produto(){
	}
	

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

	
	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}


	public String getDescKeys() {
		return descKeys;
	}

	public void setDescKeys(String descKeys) {
		this.descKeys = descKeys;
	}

	

	public String getDescPq() {
		return descPq;
	}


	public void setDescPq(String descPq) {
		this.descPq = descPq;
	}



	public String getDescGd() {
		return descGd;
	}


	public void setDescGd(String descGd) {
		this.descGd = descGd;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
		

	public String getDestaque() {
		return destaque;
	}



	public void setDestaque(String destaque) {
		this.destaque = destaque;
	}
	
		
	public Categoria getCat() {
		return cat;
	}

	public void setCat(Categoria cat) {
		this.cat = cat;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}


	@Override
	public String toString() {
		return getId()+"-"+getNome();
	}
}
