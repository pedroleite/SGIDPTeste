package br.com.pw.sgidp.persitencia.dao;

import java.util.Collection;

import javax.persistence.Query;

import br.com.pw.sgidp.negocio.entidade.Funcionario;
import br.com.pw.sgidp.persitencia.DAOAbstrato;

public class FuncionarioDAO extends DAOAbstrato<Funcionario> {

	public void inserir(Funcionario entidade) {
		getSession().persist(entidade);
	}

	public void atualizar(Funcionario entidade) {
		getSession().persist(getSession().merge(entidade));
	}

	public void excluir(Funcionario entidade) {

		getSession().remove(getSession().merge(entidade));
	}

	public Funcionario obterPorId(Long id) {
		return getSession().find(Funcionario.class, id);
	}

	@SuppressWarnings("unchecked")
	public Collection<Funcionario> consultarTodos() {
		Query query = getSession().createQuery("from Funcionario");
		return query.getResultList();
	}

	

	@SuppressWarnings("unchecked")
	public Collection<Funcionario> buscaFuncionarioPorFiltro(String tipoFiltro,
			String parametro) {

		Query query = getSession().createQuery(
				"from Funcionario funcionario where funcionario." + tipoFiltro
						+ " like :parametro");
		query.setParameter("parametro", "%" + parametro + "%");
		return query.getResultList();
	}
}
