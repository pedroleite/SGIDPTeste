package br.com.pw.sgidp.negocio;

import java.util.Collection;

import br.com.pw.sgidp.negocio.entidade.Usuario;
import br.com.pw.sgidp.persitencia.dao.UsuarioDAO;

public class UsuarioBO {
	private UsuarioDAO usuarioDAO;

	private UsuarioDAO getUsuarioDAO() {
		if (usuarioDAO == null) {
			usuarioDAO = new UsuarioDAO();

		}

		return usuarioDAO;
	}

	private Usuario usuarioLogado;

	public boolean isLoginESenhaValidos(Usuario usuario) {

		usuarioLogado = getUsuarioDAO().buscaUsuarioPorLoginESenha(usuario);
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
			usuario.setId(new Long(0));
			usuario.setListaPermissao(new PermissaoBO()
					.getListaTodasPermissoes());

			usuarioLogado = usuario;

			return true;
		}
		return false;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void inserir(Usuario usuario) {
		getUsuarioDAO().iniciarTransacao();
		getUsuarioDAO().inserir(usuario);
		getUsuarioDAO().finalizarTransacao();
	}

	public void atualizar(Usuario usuario) {
		getUsuarioDAO().iniciarTransacao();
		getUsuarioDAO().atualizar(usuario);
		getUsuarioDAO().finalizarTransacao();
	}

	public void trocarSenha(Usuario usuario) {
		Usuario usuarioParaTrocaSenha = getUsuarioDAO().obterPorId(
				usuario.getId());
		usuarioParaTrocaSenha.setSenha(usuario.getSenha());
		getUsuarioDAO().iniciarTransacao();
		getUsuarioDAO().atualizar(usuarioParaTrocaSenha);
		getUsuarioDAO().finalizarTransacao();
	}

	public Usuario obterPorId(Long id) {
		return getUsuarioDAO().obterPorId(id);
	}

	public Collection<Usuario> getTodosUsuarios() {
		return getUsuarioDAO().consultarTodos();
	}

	public Collection<Usuario> getUsuarioPorFiltro(String tipoFiltro,
			String parametro) {
		return getUsuarioDAO().buscaUsuarioPorFiltro(tipoFiltro, parametro);
	}

	public boolean isLoginCadastrado(Usuario usuario) {
		if (getUsuarioDAO().buscaUsuarioPorLogin(usuario).size() > 0) {
			return true;
		}
		return false;
	}

	public void excluir(Usuario usuario) {

		getUsuarioDAO().iniciarTransacao();
		getUsuarioDAO().excluir(usuario);
		getUsuarioDAO().finalizarTransacao();

	}
}
