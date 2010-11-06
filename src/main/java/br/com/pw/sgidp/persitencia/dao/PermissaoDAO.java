package br.com.pw.sgidp.persitencia.dao;

import java.util.Collection;

import javax.persistence.Query;

import br.com.pw.sgidp.negocio.entidade.Permissao;
import br.com.pw.sgidp.persitencia.DAOAbstrato;

public class PermissaoDAO extends DAOAbstrato<Permissao> {

	public void inserir(Permissao entidade) {
		getSession().persist(entidade);
	}

	public void atualizar(Permissao entidade) {
		getSession().persist(entidade);
	}

	public void excluir(Permissao entidade) {
		getSession().remove(entidade);
	}

	public Permissao obterPorId(Long id) {
		return getSession().find(Permissao.class, id);
	}

	@SuppressWarnings("unchecked")
	public Collection<Permissao> consultarTodos() {
		Query query = getSession().createQuery("from Permissao");
		return query.getResultList();
	}

}
