package br.com.pw.sgidp.persistencia;

import java.util.Collection;

import org.junit.Test;

import junit.framework.Assert;
import br.com.pw.sgidp.negocio.entidade.Permissao;
import br.com.pw.sgidp.persitencia.dao.PermissaoDAO;

public class TestPermissaoDAO {
	private PermissaoDAO permissaoDAO;

	public PermissaoDAO getPermissaoDAO() {
		if (permissaoDAO == null) {
			permissaoDAO = new PermissaoDAO();
		}
		return permissaoDAO;
	}

	@Test
	public void incluirPermissao() throws Exception {
		Permissao permissao = new Permissao();
		permissao.setCodigo("01");
		permissao.setDescricao("cadastrarUsuario");
		getPermissaoDAO().iniciarTransacao();
		getPermissaoDAO().inserir(permissao);
		getPermissaoDAO().finalizarTransacao();

		Long id = new Long(1);
		Permissao permissaoInserida = getPermissaoDAO().obterPorId(id);
		Assert.assertNotNull(permissaoInserida);
		Assert.assertEquals("01", permissaoInserida.getCodigo());
	}

	@Test
	public void alterarPermissao() {
		Long id = new Long(1);
		Permissao permissao = getPermissaoDAO().obterPorId(id);

		permissao.setDescricao("manterUsuario");
		getPermissaoDAO().iniciarTransacao();
		getPermissaoDAO().atualizar(permissao);
		getPermissaoDAO().finalizarTransacao();

		Permissao permissaoAlerada = getPermissaoDAO().obterPorId(id);
		Assert.assertNotNull(permissaoAlerada);
		Assert.assertEquals("manterUsuario", permissaoAlerada.getDescricao());

		Assert.assertNotNull(permissaoAlerada);
		Assert.assertEquals("01", permissaoAlerada.getCodigo());
	}

	@Test
	public void excluirPermissao() {
		Long id = new Long(1);
		Permissao permissao = getPermissaoDAO().obterPorId(id);
		getPermissaoDAO().iniciarTransacao();
		getPermissaoDAO().excluir(permissao);
		getPermissaoDAO().finalizarTransacao();

		Permissao permissaoExcluida = getPermissaoDAO().obterPorId(id);
		Assert.assertNull(permissaoExcluida);

	}

	@Test
	public void incluirDuasPermissoes() throws Exception {
		Permissao permissao1 = new Permissao();
		permissao1.setCodigo("01");
		permissao1.setDescricao("manterUsuario");
		getPermissaoDAO().iniciarTransacao();
		getPermissaoDAO().inserir(permissao1);
		getPermissaoDAO().finalizarTransacao();

		Permissao permissao2 = new Permissao();
		permissao2.setCodigo("02");
		permissao2.setDescricao("manterParlamentar");
		getPermissaoDAO().iniciarTransacao();
		getPermissaoDAO().inserir(permissao2);
		getPermissaoDAO().finalizarTransacao();

		Collection<Permissao> todos = getPermissaoDAO().consultarTodos();
		Assert.assertNotNull(todos);
	}

}
