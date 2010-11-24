package br.com.pw.sgidp.persitencia.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.pw.sgidp.negocio.entidade.Profissao;
import br.com.pw.sgidp.persitencia.DAOAbstrato;

public class ProfissaoDAO extends DAOAbstrato<Profissao> {

	public void inserir(Profissao entidade) {
		getSession().persist(entidade);
	}

	public void atualizar(Profissao entidade) {
		//
	}

	@SuppressWarnings("unchecked")
	public List<Profissao> consultarTodos() {
		Query query = getSession().createQuery("from Profissao");
		return query.getResultList();
	}

	public void excluir(Profissao entidade) {
		getSession().remove(getSession().merge(entidade));
	}

	public Profissao obterPorId(Long id) {
		return getSession().find(Profissao.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Profissao> buscaPorFiltro(String parametro) {
		Query query = getSession().createQuery(
				"from Profissao profissao where profissao.nome like :nome");
		query.setParameter("nome", "%" + parametro + "%");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Profissao> obterPorNome(Profissao profissao) {
		Query query = getSession().createQuery(
				"from Profissao profissao where profissao.nome = :nome");
		query.setParameter("nome", profissao.getNome());
		return query.getResultList();
	}
}
