package sgidp.web.componentes;

import java.util.Iterator;

import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

import br.com.pw.sgidp.negocio.entidade.Cargo;

@SuppressWarnings("serial")
public class CargoDataProvider implements IDataProvider<Cargo> {

	private CargoSimpleGrade cargoSimpleGrade;

	public CargoSimpleGrade getCargoSimpleGrade() {
		if (cargoSimpleGrade == null) {
			cargoSimpleGrade = new CargoSimpleGrade();
		}
		return cargoSimpleGrade;
	}

	public CargoDataProvider(String parametro) {
		getCargoSimpleGrade().criaLista(parametro);
	}

	public CargoDataProvider() {
		getCargoSimpleGrade().criaLista("");
	}

	public CargoDataProvider(Long idUsuario) {
		getCargoSimpleGrade().criaLista(idUsuario);
	}

	public Iterator<? extends Cargo> iterator(int primeiro, int contador) {
		return getCargoSimpleGrade().find(primeiro, contador).iterator();
	}

	public int size() {
		return getCargoSimpleGrade().getTamanho();
	}

	public void detach() {
		// TODO Auto-generated method stub
	}


	public IModel<Cargo> model(final Cargo cargo) {
		return new LoadableDetachableModel<Cargo>() {
			@Override
			protected Cargo load() {
				return cargo;
			}
		};
	}
}
