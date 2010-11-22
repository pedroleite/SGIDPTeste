package br.com.pw.sgidp.negocio;

import java.util.List;

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

	public List<Parlamentar> getTodos() {
		return getParlamentarDAO().consultarTodos();
	}

	public List<Parlamentar> getPorFiltro(String filtro, String parametro) {
		return getParlamentarDAO().buscaPorFiltro(filtro, parametro);
	}

	public Parlamentar obterPorId(Long id) {
		return getParlamentarDAO().obterPorId(id);
	}
}
