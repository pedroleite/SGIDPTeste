package sgidp.web.componentes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.pw.sgidp.negocio.UsuarioBO;
import br.com.pw.sgidp.negocio.entidade.Usuario;

public class UsuarioSimpleGrade implements Serializable {

	private static final long serialVersionUID = 7408391532596130458L;

	private static List<Usuario> listaUsuario = new ArrayList<Usuario>();

	public List<Usuario> find(int first, int count) {
		List<Usuario> sublist = listaUsuario.subList(first, first + count);
		return sublist;
	}

	public int getTamanho() {
		return listaUsuario.size();
	}

	public Usuario get(Long id) {
		Usuario usuarioRet = null;
		for (Usuario usuario : listaUsuario) {
			if (usuario.getId().equals(id)) {
				return usuario;
			}
		}
		return usuarioRet;
	}

	protected void add(final Usuario usuario) {
		listaUsuario.add(usuario);
	}

	public void criaLista(String tipoFiltro, String parametro) {
		if (tipoFiltro!=null && parametro != null && !tipoFiltro.equals("")
				&& !tipoFiltro.equals("Escolha")) {
			listaUsuario = (List<Usuario>) new UsuarioBO().getUsuarioPorFiltro(
					tipoFiltro.toLowerCase(), parametro);
		} else {
			listaUsuario = (List<Usuario>) new UsuarioBO().getTodosUsuarios();
		}
	}
}
