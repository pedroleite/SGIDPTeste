package sgidp.web.componentes;

import java.util.Iterator;

import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

import br.com.pw.sgidp.negocio.entidade.Parlamentar;
import br.com.pw.sgidp.negocio.entidade.Usuario;

public class ParlamentarDataProvider implements IDataProvider<Parlamentar> {

	private ParlamentarSimpleGrade parlamentarSimpleGrade;

	public ParlamentarSimpleGrade getParlamentarSimpleGrade() {
		if (parlamentarSimpleGrade == null) {
			parlamentarSimpleGrade = new ParlamentarSimpleGrade();
		}
		return parlamentarSimpleGrade;
	}

	public ParlamentarDataProvider(String tipoFiltro, String parametro) {
		getParlamentarSimpleGrade().criaLista(tipoFiltro, parametro);
	}

	public ParlamentarDataProvider() {
		getParlamentarSimpleGrade().criaLista("", "");
	}
	
	public ParlamentarDataProvider(Long idUsuario) {
		getParlamentarSimpleGrade().criaLista(idUsuario);
	}

	public Iterator<? extends Parlamentar> iterator(int primeiro, int contador) {
		return getParlamentarSimpleGrade().find(primeiro, contador).iterator();
	}

	public IModel<Usuario> model(Usuario object) {
		return new UsuarioDetachableModel(object);
	}

	public int size() {
		return getParlamentarSimpleGrade().getTamanho();
	}

	public void detach() { 
		// TODO Auto-generated method stub
	}

	public IModel<Parlamentar> model(final Parlamentar parlamentar) {
		return new LoadableDetachableModel<Parlamentar>() {
			@Override
			protected Parlamentar load() {
				return parlamentar;
			}
		};
	}
}
