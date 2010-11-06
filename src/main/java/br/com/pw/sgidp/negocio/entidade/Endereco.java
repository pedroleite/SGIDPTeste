package br.com.pw.sgidp.negocio.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ENDERECO")
public class Endereco extends Entidade {

	private static final long serialVersionUID = 3L;

	private String lagradouro;
	private String bairro;
	private String uf;
	private String cidade;
	private String cep;
	private String tipo;

	public String getLagradouro() {
		return lagradouro;
	}

	public String getTipo() {
		return tipo;
	}

	public void setLagradouro(String lagradouro) {
		this.lagradouro = lagradouro;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setEndereco(String endereco) {
		this.lagradouro = endereco;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Column(name = "endereco")
	public String getEndereco() {
		return lagradouro;
	}

	@Column(name = "bairro")
	public String getBairro() {
		return bairro;
	}

	@Column(name = "uf")
	public String getUf() {
		return uf;
	}

	@Column(name = "cidade")
	public String getCidade() {
		return cidade;
	}

	@Column(name = "cep")
	public String getCep() {
		return cep;
	}

}
