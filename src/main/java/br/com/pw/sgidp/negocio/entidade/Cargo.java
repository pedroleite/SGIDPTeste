package br.com.pw.sgidp.negocio.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CARGO")
public class Cargo extends Entidade implements Serializable {
	
	private static final long serialVersionUID = 3790682683438302998L;
	private String nome;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
