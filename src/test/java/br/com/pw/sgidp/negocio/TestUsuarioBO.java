package br.com.pw.sgidp.negocio;

import org.junit.Test;

import br.com.pw.sgidp.negocio.entidade.Usuario;

public class TestUsuarioBO {
	@Test
	public void testCriarUsuario() throws Exception {
		Usuario usuario = new Usuario();

		usuario.setNome("Welington Antonio Gomides");
		usuario.setLogin("welington");
		usuario.setSenha("123");

		UsuarioBO usuarioBO = new UsuarioBO();

		usuarioBO.inserir(usuario);

		usuarioBO.obterPorId(new Long(1));

	}
}
