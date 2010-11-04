package br.com.pw.sgidp.persitencia;

import java.util.Collection;

import br.com.pw.sgidp.negocio.entidade.Entidade;

public interface IDAOAbstrato<E extends Entidade> {
	public void iniciarTransacao();

	public void finalizarTransacao();

	public void inserir(E entidade);

	public void atualizar(E entidade);

	public void excluir(E entidade);

	public E obterPorId(Long id);

	public Collection<E> consultarTodos();

}
