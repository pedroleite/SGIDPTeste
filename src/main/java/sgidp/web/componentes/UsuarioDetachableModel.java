package sgidp.web.componentes;

import org.apache.wicket.model.LoadableDetachableModel;

import br.com.pw.sgidp.negocio.entidade.Usuario;

public class UsuarioDetachableModel extends LoadableDetachableModel<Usuario> {

	private static final long serialVersionUID = -7163912425684763502L;
	private final long id;

	public UsuarioDetachableModel(Usuario usuario) {
		this(usuario.getId());
	}

	public UsuarioDetachableModel(long id) {
		if (id == 0) {
			throw new IllegalArgumentException();
		}
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Long.valueOf(id).hashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj == this) {
			return true;
		} else if (obj == null) {
			return false;
		} else if (obj instanceof UsuarioDetachableModel) {
			UsuarioDetachableModel outro = (UsuarioDetachableModel) obj;
			return outro.id == id;
		}
		return false;
	}

	@Override
	protected Usuario load() {
		return new UsuarioSimpleGrade().get(id);
	}
}