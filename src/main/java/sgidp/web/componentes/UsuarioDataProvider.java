package sgidp.web.componentes;

import java.util.Iterator;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;
import br.com.pw.sgidp.negocio.entidade.Usuario;

public class UsuarioDataProvider implements IDataProvider<Usuario> {

	private static final long serialVersionUID = 8012026090071841878L;

	private UsuarioSimpleGrade usuarioSimpleGrade;

	public UsuarioSimpleGrade getUsuarioSimpleGrade() {
		if (usuarioSimpleGrade == null) {
			usuarioSimpleGrade = new UsuarioSimpleGrade();
		}
		return usuarioSimpleGrade;
	}
	
	public UsuarioDataProvider() {
		
	}
	
	public UsuarioDataProvider(String tipoFiltro, String parametro) {
		getUsuarioSimpleGrade().criaLista(tipoFiltro,parametro);
	}

	public Iterator<? extends Usuario> iterator(int primeiro, int contador) {
		return getUsuarioSimpleGrade().find(primeiro, contador).iterator();
	}

	public IModel<Usuario> model(Usuario object) {
		return new UsuarioDetachableModel(object);
	}

	public int size() {
		return getUsuarioSimpleGrade().getTamanho();
	}

	public void detach() {
		// TODO Auto-generated method stub
	}
}