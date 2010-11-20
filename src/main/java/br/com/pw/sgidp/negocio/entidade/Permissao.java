package br.com.pw.sgidp.negocio.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PERMISSAO")
public class Permissao extends Entidade implements Serializable {
	private static final long serialVersionUID = 4861725819555568799L;
	private String codigo;
	private String descricao;

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

}
