package br.com.pw.sgidp.negocio;

import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;

import br.com.pw.sgidp.negocio.entidade.Permissao;

public class TestPermissaoBO {
	private PermissaoBO permissaoBO;

	public PermissaoBO getPermissaoBO() {
		if (permissaoBO == null) {
			permissaoBO = new PermissaoBO();

		}

		return permissaoBO;
	}

	@Test
	public void testCriarPermissao() throws Exception {
		Permissao permissao = new Permissao();
		permissao.setCodigo("01");
		permissao.setDescricao("manterUsuario");
		getPermissaoBO().incluir(permissao);
		Long id = new Long(1);
		Permissao permissaoInserida = getPermissaoBO().getPermissao(id);
		Assert.assertNotNull(permissaoInserida);
		Assert.assertEquals("01", permissaoInserida.getCodigo());
	}

	@Test
	public void inserirDuasPermissoes() {
		Permissao permissao1 = new Permissao();
		permissao1.setCodigo("01");
		permissao1.setDescricao("manterUsuario");
		getPermissaoBO().incluir(permissao1);

		Permissao permissao2 = new Permissao();
		permissao2.setCodigo("01");
		permissao2.setDescricao("manterUsuario");
		getPermissaoBO().incluir(permissao2);

		Collection<Permissao> listaTodasPermissoes = getPermissaoBO()
				.getListaTodasPermissoes();
		Assert.assertNotNull(listaTodasPermissoes);
		Assert.assertEquals(2, listaTodasPermissoes.size());

	}

}
