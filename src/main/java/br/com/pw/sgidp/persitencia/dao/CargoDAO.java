package br.com.pw.sgidp.persitencia.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.pw.sgidp.negocio.entidade.Cargo;
import br.com.pw.sgidp.persitencia.DAOAbstrato;

public class CargoDAO extends DAOAbstrato<Cargo> {

	public void inserir(Cargo entidade) {
		getSession().persist(entidade);
	}

	public void atualizar(Cargo entidade) {
		//
	}

	@SuppressWarnings("unchecked")
	public List<Cargo> consultarTodos() {
		Query query = getSession().createQuery("from Cargo");
		return query.getResultList();
	}

	public void excluir(Cargo entidade) {
		getSession().remove(getSession().merge(entidade));
	}

	public Cargo obterPorId(Long id) {
		return getSession().find(Cargo.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Cargo> buscaPorFiltro(String parametro) {
		Query query = getSession().createQuery(
				"from Cargo cargo where cargo.nome like :nome");
		query.setParameter("nome", "%" + parametro + "%");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Cargo> obterPorNome(Cargo cargo) {
		Query query = getSession().createQuery(
				"from Cargo cargo where cargo.nome = :nome");
		query.setParameter("nome", cargo.getNome());
		return query.getResultList();
	}
}
