package br.com.pw.sgidp.negocio;

import br.com.pw.sgidp.negocio.entidade.Parlamentar;
import br.com.pw.sgidp.persitencia.dao.ParlamentarDAO;

public class ParlamentarBO {
	private ParlamentarDAO parlamentarDAO;

	public ParlamentarDAO getParlamentarDAO() {
		if (parlamentarDAO == null) {
			parlamentarDAO = new ParlamentarDAO();

		}

		return parlamentarDAO;
	}

	public void salvar(Parlamentar parlamentar) {
		getParlamentarDAO().iniciarTransacao();
		getParlamentarDAO().inserir(parlamentar);
		getParlamentarDAO().finalizarTransacao();
	}

}
