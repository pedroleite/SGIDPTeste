package br.com.pw.sgidp.persistencia;

import junit.framework.Assert;

import org.junit.Test;

import br.com.pw.sgidp.negocio.entidade.Parlamentar;
import br.com.pw.sgidp.persitencia.dao.ParlamentarDAO;

public class TestParlamentarDAO {

	private ParlamentarDAO parlamentarDAO;

	public ParlamentarDAO getParlamentarDAO() {
		if (parlamentarDAO == null) {
			parlamentarDAO = new ParlamentarDAO();

		}

		return parlamentarDAO;
	}

	@Test
	public void cadastrarParlamentar() {

		Parlamentar parlamentar = new Parlamentar();

		parlamentar.setNome("Pedro");

		parlamentar.setTratamento("");
		parlamentar.setNomeCompleto("");
		parlamentar.setDataNascimento("");
		parlamentar.setCargo("");
		parlamentar.setPartido("");
		parlamentar.setEstado("");
		parlamentar.setProfissao("");
		parlamentar.setEmail("");
		parlamentar.setEmailParticular("");
		parlamentar.setEscolaridade("");
		parlamentar.setSite("");

		getParlamentarDAO().iniciarTransacao();
		getParlamentarDAO().inserir(parlamentar);
		getParlamentarDAO().finalizarTransacao();

		Long id = new Long(1);
		Parlamentar parlamentarInserido = getParlamentarDAO().obterPorId(id);

		Assert.assertEquals("Pedro", parlamentarInserido.getNome());

	}
}
