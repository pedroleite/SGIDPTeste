package br.com.pw.sgidp.negocio;

import java.util.Collection;

import br.com.pw.sgidp.negocio.entidade.Permissao;
import br.com.pw.sgidp.persitencia.dao.PermissaoDAO;

public class PermissaoBO {
	private PermissaoDAO permissaoDAO;

	public PermissaoDAO getPermissaoDAO() {
		if (permissaoDAO == null) {
			permissaoDAO = new PermissaoDAO();

		}

		return permissaoDAO;
	}

	public void incluir(Permissao permissao) {
		getPermissaoDAO().iniciarTransacao();
		getPermissaoDAO().inserir(permissao);
		getPermissaoDAO().finalizarTransacao();
	}

	public void alterar(Permissao permissao) {
		getPermissaoDAO().iniciarTransacao();
		getPermissaoDAO().atualizar(permissao);
		getPermissaoDAO().finalizarTransacao();
	}

	public Permissao getPermissao(Long id) {
		return getPermissaoDAO().obterPorId(id);
	}

	public Collection<Permissao> getListaTodasPermissoes() {
		return getPermissaoDAO().consultarTodos();	
	}

}
