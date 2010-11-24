package sgidp.web.componentes;

import java.util.Iterator;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;
import br.com.pw.sgidp.negocio.entidade.Funcionario;

public class FuncionarioDataProvider implements IDataProvider<Funcionario> {

	private static final long serialVersionUID = 8012026090071841878L;

	private FuncionarioSimpleGrade funcionarioSimpleGrade;

	public FuncionarioSimpleGrade getFuncionarioSimpleGrade() {
		if (funcionarioSimpleGrade == null) {
			funcionarioSimpleGrade = new FuncionarioSimpleGrade();
		}
		return funcionarioSimpleGrade;
	}

	public FuncionarioDataProvider(String tipoFiltro, String parametro) {
		getFuncionarioSimpleGrade().criaLista(tipoFiltro, parametro);
	}

	public FuncionarioDataProvider() {
		getFuncionarioSimpleGrade().criaLista("", "");
	}
	
	public FuncionarioDataProvider(Long idFuncionario) {
		getFuncionarioSimpleGrade().criaLista(idFuncionario);
	}

	public Iterator<? extends Funcionario> iterator(int primeiro, int contador) {
		return getFuncionarioSimpleGrade().find(primeiro, contador).iterator();
	}

	public IModel<Funcionario> model(Funcionario object) {
		return new FuncionarioDetachableModel(object);
	}

	public int size() {
		return getFuncionarioSimpleGrade().getTamanho();
	}

	public void detach() {
		// TODO Auto-generated method stub
	}
}