package br.com.pw.sgidp.persitencia.dao;

import java.util.Collection;

import javax.persistence.Query;

import br.com.pw.sgidp.negocio.entidade.Usuario;
import br.com.pw.sgidp.persitencia.DAOAbstrato;

public class UsuarioDAO extends DAOAbstrato<Usuario> {

	public void inserir(Usuario entidade) {
		getSession().persist(entidade);
	}

	public void atualizar(Usuario entidade) {
		getSession().persist(entidade);
	}

	public void excluir(Usuario entidade) {
		getSession().remove(entidade);
	}

	public Usuario obterPorId(Long id) {
		return getSession().find(Usuario.class, id);
	}

	@SuppressWarnings("unchecked")
	public Collection<Usuario> consultarTodos() {
		Query query = getSession().createQuery("from Usuario");
		return query.getResultList();
	}

	public Usuario buscaUsuarioPorLoginESenha(Usuario usuario) {
		Query query = getSession()
				.createQuery(
						"from Usuario usuario where usuario.login=:login and usuario.senha=:senha");
		query.setParameter("login", usuario.getLogin());
		query.setParameter("senha", usuario.getSenha());
		try {
			return (Usuario) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
}
