package br.com.pw.sgidp.persitencia.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.pw.sgidp.negocio.entidade.Partido;
import br.com.pw.sgidp.persitencia.DAOAbstrato;

public class PartidoDAO extends DAOAbstrato<Partido> {

	public void inserir(Partido entidade) {
		getSession().persist(entidade);
	}

	public void atualizar(Partido entidade) {
		//
	}

	@SuppressWarnings("unchecked")
	public List<Partido> consultarTodos() {
		Query query = getSession().createQuery("from Partido");
		return query.getResultList();
	}

	public void excluir(Partido entidade) {
		getSession().remove(getSession().merge(entidade));
	}

	public Partido obterPorId(Long id) {
		return getSession().find(Partido.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Partido> buscaPorFiltro(String parametro) {
		Query query = getSession().createQuery(
				"from Partido partido where partido.nome like :nome");
		query.setParameter("nome", "%" + parametro + "%");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Partido> obterPorSigla(Partido partido) {
		Query query = getSession().createQuery(
				"from Partido partido where partido.sigla = :sigla");
		query.setParameter("sigla", partido.getNome());
		return query.getResultList();
	}
}
