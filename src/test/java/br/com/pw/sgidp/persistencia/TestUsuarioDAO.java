package br.com.pw.sgidp.persistencia;

import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;

import br.com.pw.sgidp.negocio.entidade.Permissao;
import br.com.pw.sgidp.negocio.entidade.Usuario;
import br.com.pw.sgidp.persitencia.dao.PermissaoDAO;
import br.com.pw.sgidp.persitencia.dao.UsuarioDAO;

public class TestUsuarioDAO {
	private UsuarioDAO usuarioDAO;

	public UsuarioDAO getUsuarioDAO() {
		if (usuarioDAO == null) {
			usuarioDAO = new UsuarioDAO();

		}

		return usuarioDAO;
	}

	@Test
	public void testCriarUsuario() throws Exception {
		TestPermissaoDAO testPermissaoDAO = new TestPermissaoDAO();
		testPermissaoDAO.incluirDuasPermissoes();
		Collection<Permissao> listaPermissao = new PermissaoDAO()
				.consultarTodos();

		Assert.assertEquals(2, listaPermissao.size());
		Usuario usuario = new Usuario();
		usuario.setNome("Welington Antonio Gomides");
		usuario.setLogin("welington");
		usuario.setSenha("123");
		usuario.setListaPermissao(listaPermissao);

		getUsuarioDAO().iniciarTransacao();
		getUsuarioDAO().inserir(usuario);
		getUsuarioDAO().finalizarTransacao();
		Long id = new Long(1);
		Usuario usuarioAdicionado = getUsuarioDAO().obterPorId(id);
		Assert.assertEquals(id, usuarioAdicionado.getId());
		Assert.assertEquals(2, usuarioAdicionado.getListaPermissao().size());
	}

	@Test
	public void testConsulta() throws Exception {
		Usuario usuario = new Usuario();
		usuario.setNome("Welington Antonio Gomides");
		usuario.setLogin("welington");
		usuario.setSenha("123");
		getUsuarioDAO().buscaUsuarioPorLoginESenha(usuario);

	}

}
