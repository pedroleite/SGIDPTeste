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

	@OneToMany(cascade = CascadeType.ALL, targetEntity = Endereco.class, fetch = FetchType.EAGER)
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

}
