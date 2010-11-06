package br.com.pw.sgidp.negocio.entidade;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario extends Entidade implements Serializable {

	private static final long serialVersionUID = 8480230745620630387L;
	private String nome;
	private String login;
	private String senha;

	@ManyToMany(cascade = CascadeType.DETACH)
	@JoinTable(name = "USUARIO_PERMISSAO", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "permissao_id"))
	private Collection<Permissao> listaPermissao;

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setListaPermissao(Collection<Permissao> listaPermissao) {
		this.listaPermissao = listaPermissao;
	}

	public Collection<Permissao> getListaPermissao() {
		return listaPermissao;
	}

}
