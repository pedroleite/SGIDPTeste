package br.com.pw.sgidp.persistencia;

import junit.framework.Assert;

import org.junit.Test;

import br.com.pw.sgidp.negocio.entidade.Usuario;
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
		Usuario usuario = new Usuario();
		usuario.setNome("Welington Antonio Gomides");
		usuario.setLogin("welington");
		usuario.setSenha("123");
		usuario.setPermissao("cadastrarUsuario");
		getUsuarioDAO().iniciarTransacao();
		getUsuarioDAO().inserir(usuario);
		getUsuarioDAO().finalizarTransacao();
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


