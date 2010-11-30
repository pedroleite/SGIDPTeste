package br.com.pw.sgidp.negocio;

import java.util.List;

import br.com.pw.sgidp.negocio.entidade.Partido;
import br.com.pw.sgidp.persitencia.dao.PartidoDAO;

public class PartidoBO {
	private PartidoDAO partidoDAO;

	private PartidoDAO getPartidoDAO() {
		if (partidoDAO == null) {
			partidoDAO = new PartidoDAO();
		}

		return partidoDAO;
	}

	public void incluir(Partido partido) {
		getPartidoDAO().iniciarTransacao();
		getPartidoDAO().inserir(partido);
		getPartidoDAO().finalizarTransacao();
	}

	public void excluir(Partido partido) {
		getPartidoDAO().iniciarTransacao();
		getPartidoDAO().excluir(partido);
		getPartidoDAO().finalizarTransacao();
	}

	public List<Partido> getTodos() {
		return getPartidoDAO().consultarTodos();
	}

	public List<Partido> getPorFiltro(String parametro) {
		return getPartidoDAO().buscaPorFiltro(parametro);
	}

	public Partido obterPorId(Long id) {
		return getPartidoDAO().obterPorId(id);
	}

	public boolean isPartidoExiste(Partido partido) {
		if(getPartidoDAO().obterPorSigla(partido).size()>0){
			return true;
		}
		return false;
		
	}
}
