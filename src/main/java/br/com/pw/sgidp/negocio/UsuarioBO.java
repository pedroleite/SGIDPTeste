package br.com.pw.sgidp.negocio;

import br.com.pw.sgidp.negocio.entidade.Usuario;
import br.com.pw.sgidp.persitencia.dao.UsuarioDAO;

public class UsuarioBO {
	private Usuario usuarioLogado;
	public boolean isLoginESenhaValidos(Usuario usuario) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioLogado = usuarioDAO.buscaUsuarioPorLoginESenha(usuario);
		if (usuarioLogado != null) {
			return true;
		} else if (isUsuarioPadrao(usuario)) {
			return true;
		}
		return false;
	}

	private boolean isUsuarioPadrao(Usuario usuario) {
		if (usuario.getLogin().equals("sgidp")
				&& usuario.getSenha().equals("123")) {
			usuario.setNome("Usuario padrão");
			usuarioLogado = usuario;
			return true;
		}
		return false;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void inserir(Usuario usuario) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.iniciarTransacao();
		usuarioDAO.inserir(usuario);
		usuarioDAO.finalizarTransacao();
	}

	public void buscaUsuarioPorId(Long long1) {
		// TODO Auto-generated method stub
		
	}
}
