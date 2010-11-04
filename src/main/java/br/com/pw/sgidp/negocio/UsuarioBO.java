package br.com.pw.sgidp.negocio;

import br.com.pw.sgidp.negocio.entidade.Usuario;
import br.com.pw.sgidp.persitencia.dao.UsuarioDAO;

public class UsuarioBO {

	public boolean isLoginESenhaValidos(Usuario usuario) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if (usuarioDAO.buscaUsuarioPorLoginESenha(usuario) != null) {
			return true;
		} else if (isUsuarioPadrao(usuario)) {
			return true;
		}
		return false;
	}

	private boolean isUsuarioPadrao(Usuario usuario) {
		if (usuario.getLogin().equals("sgidp")
				&& usuario.getSenha().equals("123")) {
			return true;
		}
		return false;
	}
}
