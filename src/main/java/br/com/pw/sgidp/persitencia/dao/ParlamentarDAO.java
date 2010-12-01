package br.com.pw.sgidp.persitencia.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.pw.sgidp.negocio.entidade.Parlamentar;
import br.com.pw.sgidp.persitencia.DAOAbstrato;

public class ParlamentarDAO extends DAOAbstrato<Parlamentar> {

	public void inserir(Parlamentar entidade) {
		getSession().persist(entidade);
	}

	public void atualizar(Parlamentar entidade) {
		getSession().persist(getSession().merge(entidade));
	}
	

	public List<Parlamentar> consultarTodos() {
		Query query = getSession().createQuery("from Parlamentar parlamentar");
		return query.getResultList();
	}

	public void excluir(Parlamentar entidade) {
		getSession().remove(getSession().merge(entidade));
	}

	public Parlamentar obterPorId(Long id) {
		return getSession().find(Parlamentar.class, id);
	}

	public List<Parlamentar> buscaPorFiltro(String filtro, String parametro) {
		Query query = getSession().createQuery(
				"from Parlamentar parlamentar where parlamentar." + filtro
						+ " like :parametro");
		query.setParameter("parametro", "%" + parametro + "%");
		return query.getResultList();
	}
}
