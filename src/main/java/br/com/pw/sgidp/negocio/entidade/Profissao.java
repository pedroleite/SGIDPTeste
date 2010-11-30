package br.com.pw.sgidp.negocio.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PROFISSAO")
public class Profissao extends Entidade implements Serializable {
	private static final long serialVersionUID = -3232936669764818384L;
	private String nome;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
