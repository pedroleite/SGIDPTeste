package br.com.pw.sgidp.negocio.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PARLAMENTAR")
public class Parlamentar extends Entidade implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nomeParlamentar;
	private String estado;
	private String tratamento;
	private String dataNascimento;
	private String cargo;
	private String partido;
	private String profissao;
	private String email;
	private String escolaridade;
	private String emailParticular;
	private String site;
	private String nomeCompleto;
	
	
	
	
	
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Endereco.class, fetch = FetchType.EAGER)
	private List<Endereco> enderecos;

	@Column(name = "NOMEPARLAMENTAR")
	public String getNomeParlamentar() {
		return nomeParlamentar;
	}

	public void setNomeParlamentar(String nomeParlamentar) {
		this.nomeParlamentar = nomeParlamentar;
	}

	@Column(name = "ESTADO")
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	@Column(name = "TRATAMENTO")
	public String getTratamento() {
		return tratamento;
	}

	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}

	@Column(name = "DATANASCIMENTO")
	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Column(name = "CARGO")
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Column(name = "PARTIDO")
	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	@Column(name = "PROFISSAO")
	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "ESCOLARIDADE")
	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	@Column(name = "EMAILPARTICULAR")
	public String getEmailParticular() {
		return emailParticular;
	}

	public void setEmailParticular(String emailParticular) {
		this.emailParticular = emailParticular;
	}

	@Column(name = "SITE")
	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	@Column(name = "NOMECOMPLETO")
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	

}
