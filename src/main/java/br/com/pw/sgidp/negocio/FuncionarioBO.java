package br.com.pw.sgidp.negocio;

import java.util.Collection;

import br.com.pw.sgidp.negocio.entidade.Funcionario;
import br.com.pw.sgidp.persitencia.dao.FuncionarioDAO;

public class FuncionarioBO {
	private FuncionarioDAO funcionarioDAO;

	private FuncionarioDAO getFuncionarioDAO() {
		if (funcionarioDAO == null) {
			funcionarioDAO = new FuncionarioDAO();

		}

		return funcionarioDAO;
	}

	public void inserir(Funcionario funcionario) {
		getFuncionarioDAO().iniciarTransacao();
		getFuncionarioDAO().inserir(funcionario);
		getFuncionarioDAO().finalizarTransacao();
	}

	public void atualizar(Funcionario funcionario) {
		getFuncionarioDAO().iniciarTransacao();
		getFuncionarioDAO().atualizar(funcionario);
		getFuncionarioDAO().finalizarTransacao();
	}

	public Funcionario obterPorId(Long id) {
		return getFuncionarioDAO().obterPorId(id);
	}

	public Collection<Funcionario> getTodosFuncionarios() {
		return getFuncionarioDAO().consultarTodos();
	}

	public Collection<Funcionario> getFuncionarioPorFiltro(String tipoFiltro,
			String parametro) {
		return getFuncionarioDAO().buscaFuncionarioPorFiltro(tipoFiltro,
				parametro);
	}

	public void excluir(Funcionario funcionario) {
		getFuncionarioDAO().iniciarTransacao();
		getFuncionarioDAO().excluir(funcionario);
		getFuncionarioDAO().finalizarTransacao();
	}
}
