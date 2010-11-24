package sgidp.web.componentes;

import java.util.Iterator;

import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

import br.com.pw.sgidp.negocio.entidade.Profissao;

@SuppressWarnings("serial")
public class ProfissaoDataProvider implements IDataProvider<Profissao> {

	private ProfissaoSimpleGrade profissaoSimpleGrade;

	public ProfissaoSimpleGrade getProfissaoSimpleGrade() {
		if (profissaoSimpleGrade == null) {
			profissaoSimpleGrade = new ProfissaoSimpleGrade();
		}
		return profissaoSimpleGrade;
	}

	public ProfissaoDataProvider(String parametro) {
		getProfissaoSimpleGrade().criaLista(parametro);
	}

	public ProfissaoDataProvider() {
		getProfissaoSimpleGrade().criaLista("");
	}

	public ProfissaoDataProvider(Long idUsuario) {
		getProfissaoSimpleGrade().criaLista(idUsuario);
	}

	public Iterator<? extends Profissao> iterator(int primeiro, int contador) {
		return getProfissaoSimpleGrade().find(primeiro, contador).iterator();
	}

	public int size() {
		return getProfissaoSimpleGrade().getTamanho();
	}

	public void detach() {
		// TODO Auto-generated method stub
	}

	public IModel<Profissao> model(final Profissao profissao) {
		return new LoadableDetachableModel<Profissao>() {
			@Override
			protected Profissao load() {
				return profissao;
			}
		};
	}
}
