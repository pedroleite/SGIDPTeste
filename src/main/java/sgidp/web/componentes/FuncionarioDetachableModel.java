package sgidp.web.componentes;

import org.apache.wicket.model.LoadableDetachableModel;

import br.com.pw.sgidp.negocio.entidade.Funcionario;

public class FuncionarioDetachableModel extends LoadableDetachableModel<Funcionario> {

	private static final long serialVersionUID = -6819913598206646902L;
	private final long id;

	public FuncionarioDetachableModel(Funcionario funcionario) {
		this(funcionario.getId());
	}

	public FuncionarioDetachableModel(long id) {
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
		} else if (obj instanceof FuncionarioDetachableModel) {
			FuncionarioDetachableModel outro = (FuncionarioDetachableModel) obj;
			return outro.id == id;
		}
		return false;
	}

	@Override
	protected Funcionario load() {
		return new FuncionarioSimpleGrade().get(id);
	}
}