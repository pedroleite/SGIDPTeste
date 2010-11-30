package sgidp.web.componentes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.pw.sgidp.negocio.FuncionarioBO;
import br.com.pw.sgidp.negocio.entidade.Funcionario;

public class FuncionarioSimpleGrade implements Serializable {

	private static final long serialVersionUID = 3777103833019397294L;
	private static List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();

	public List<Funcionario> find(int first, int count) {
		List<Funcionario> sublist = listaFuncionario.subList(first, first
				+ count);
		return sublist;
	}

	public int getTamanho() {
		return listaFuncionario.size();
	}

	public Funcionario get(Long id) {
		Funcionario funcionarioRet = null;
		for (Funcionario funcionario : listaFuncionario) {
			if (funcionario.getId().equals(id)) {
				return funcionario;
			}
		}
		return funcionarioRet;
	}

	protected void add(final Funcionario funcionario) {
		listaFuncionario.add(funcionario);
	}

	public void criaLista(String tipoFiltro, String parametro) {
		if (tipoFiltro != null && parametro != null && !tipoFiltro.equals("")
				&& !tipoFiltro.equals("Escolha")) {
			if (tipoFiltro.equals("Lotação")) {
				tipoFiltro = "lotacao";
			}
			listaFuncionario = (List<Funcionario>) new FuncionarioBO()
					.getFuncionarioPorFiltro(tipoFiltro.toLowerCase(),
							parametro);
		} else {
			listaFuncionario = (List<Funcionario>) new FuncionarioBO()
					.getTodosFuncionarios();
		}
	}

	public void criaLista(Long idFuncionario) {
		List<Funcionario> listaFuncionarioEmFoco = new ArrayList<Funcionario>();

		FuncionarioBO funcionarioBO = new FuncionarioBO();

		Funcionario funcionarioEmFoco = funcionarioBO.obterPorId(idFuncionario);
		listaFuncionarioEmFoco.add(funcionarioEmFoco);

		Collection<Funcionario> todosFuncionarios = funcionarioBO
				.getTodosFuncionarios();
		todosFuncionarios.remove(funcionarioEmFoco);
		listaFuncionarioEmFoco.addAll(todosFuncionarios);

		listaFuncionario = listaFuncionarioEmFoco;
	}
}
