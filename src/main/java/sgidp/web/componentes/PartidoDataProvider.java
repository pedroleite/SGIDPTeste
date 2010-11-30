package sgidp.web.componentes;

import java.util.Iterator;

import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

import br.com.pw.sgidp.negocio.entidade.Partido;

@SuppressWarnings("serial")
public class PartidoDataProvider implements IDataProvider<Partido> {

	private PartidoSimpleGrade partidoSimpleGrade;

	public PartidoSimpleGrade getPartidoSimpleGrade() {
		if (partidoSimpleGrade == null) {
			partidoSimpleGrade = new PartidoSimpleGrade();
		}
		return partidoSimpleGrade;
	}

	public PartidoDataProvider(String parametro) {
		getPartidoSimpleGrade().criaLista(parametro);
	}

	public PartidoDataProvider() {
		getPartidoSimpleGrade().criaLista("");
	}

	public PartidoDataProvider(Long idUsuario) {
		getPartidoSimpleGrade().criaLista(idUsuario);
	}

	public Iterator<? extends Partido> iterator(int primeiro, int contador) {
		return getPartidoSimpleGrade().find(primeiro, contador).iterator();
	}

	public int size() {
		return getPartidoSimpleGrade().getTamanho();
	}

	public void detach() {
		// TODO Auto-generated method stub
	}


	public IModel<Partido> model(final Partido partido) {
		return new LoadableDetachableModel<Partido>() {
			@Override
			protected Partido load() {
				return partido;
			}
		};
	}
}
