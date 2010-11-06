package br.com.pw.sgidp.persitencia.dao;

import java.util.Collection;

import javax.persistence.Query;

import br.com.pw.sgidp.negocio.entidade.Parlamentar;
import br.com.pw.sgidp.persitencia.DAOAbstrato;

public class ParlamentarDAO extends DAOAbstrato<Parlamentar> {

	public void inserir(Parlamentar entidade) {
		getSession().persist(entidade);
	}

	public void atualizar(Parlamentar entidade) {
		getSession().persist(entidade);
	}

	@SuppressWarnings("unchecked")
	public Collection<Parlamentar> consultarTodos() {
		Query query = getSession().createQuery("from Parlamentar parlamentar");
		return query.getResultList();
	}

	public void excluir(Parlamentar entidade) {
		getSession().remove(entidade);
	}

	public Parlamentar obterPorId(Long id) {
		return getSession().find(Parlamentar.class, id);
	}
}
