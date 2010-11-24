package br.com.pw.sgidp.negocio.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PARTIDO")
public class Partido extends Entidade implements Serializable {

	private static final long serialVersionUID = 7860886607032965048L;

	private String nome;

	private String sigla;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getSigla() {
		return sigla;
	}

}
