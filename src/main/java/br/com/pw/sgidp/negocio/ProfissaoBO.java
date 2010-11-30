package br.com.pw.sgidp.negocio;

import java.util.List;

import br.com.pw.sgidp.negocio.entidade.Profissao;
import br.com.pw.sgidp.persitencia.dao.ProfissaoDAO;

public class ProfissaoBO {
	private ProfissaoDAO profissaoDAO;

	private ProfissaoDAO getProfissaoDAO() {
		if (profissaoDAO == null) {
			profissaoDAO = new ProfissaoDAO();
		}

		return profissaoDAO;
	}

	public void incluir(Profissao profissao) {
		getProfissaoDAO().iniciarTransacao();
		getProfissaoDAO().inserir(profissao);
		getProfissaoDAO().finalizarTransacao();
	}

	public void excluir(Profissao profissao) {
		getProfissaoDAO().iniciarTransacao();
		getProfissaoDAO().excluir(profissao);
		getProfissaoDAO().finalizarTransacao();
	}

	public List<Profissao> getTodos() {
		return getProfissaoDAO().consultarTodos();
	}

	public List<Profissao> getPorFiltro(String parametro) {
		return getProfissaoDAO().buscaPorFiltro(parametro);
	}

	public Profissao obterPorId(Long id) {
		return getProfissaoDAO().obterPorId(id);
	}

	public boolean isProfissaoExiste(Profissao profissao) {
		if(getProfissaoDAO().obterPorNome(profissao).size()>0){
			return true;
		}
		return false;
		
	}
}
