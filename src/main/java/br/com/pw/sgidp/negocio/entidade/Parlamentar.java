package br.com.pw.sgidp.negocio.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PARLAMENTAR")
public class Parlamentar extends Entidade implements Serializable {

	private static final long serialVersionUID = 2152180341453106413L;
	private String nome;
	private String tratamento;
	private String nomeCompleto;
	private String dataNascimento;
	private String cargo;
	private String estado;
	private String profissao;
	private String email;
	private String emailParticular;
	private String escolaridade;
	private String site;
	private String partido;

	public String getPartido() {
		return partido;
	}

	public String getNome() {
		return nome;
	}

	public String getTratamento() {
		return tratamento;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getCargo() {
		return cargo;
	}

	public String getEstado() {
		return estado;
	}

	public String getProfissao() {
		return profissao;
	}

	public String getEmail() {
		return email;
	}

	public String getEmailParticular() {
		return emailParticular;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public String getSite() {
		return site;
	}

	public void setNome(String nomeParlamentar) {
		this.nome = nomeParlamentar;
	}

	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;

	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void setPartido(String cargo) {
		this.cargo = cargo;
	}

	public void setEstado(String estado) {
		this.estado = estado;

	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;

	}

	public void setEmail(String email) {
		this.email = email;

	}

	public void setEmailParticular(String emailParticular) {
		this.emailParticular = emailParticular;

	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;

	}

	public void setSite(String site) {
		this.site = site;

	}

}
