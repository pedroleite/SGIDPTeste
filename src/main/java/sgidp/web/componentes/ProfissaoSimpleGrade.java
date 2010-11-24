package sgidp.web.componentes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.pw.sgidp.negocio.ProfissaoBO;
import br.com.pw.sgidp.negocio.entidade.Profissao;

public class ProfissaoSimpleGrade implements Serializable {

	private static final long serialVersionUID = 7408391532596130458L;

	private static List<Profissao> listaProfissao = new ArrayList<Profissao>();

	public List<Profissao> find(int first, int count) {
		List<Profissao> sublist = listaProfissao.subList(first, first + count);
		return sublist;
	}

	public int getTamanho() {
		return listaProfissao.size();
	}

	public Profissao get(Long id) {
		for (Profissao profissao : listaProfissao) {
			if (profissao.getId().equals(id)) {
				return profissao;
			}
		}
		return null;
	}

	protected void add(final Profissao profissao) {
		listaProfissao.add(profissao);
	}

	public void criaLista(String parametro) {
		if (parametro != null && !parametro.equals("")) {
			listaProfissao = (List<Profissao>) new ProfissaoBO()
					.getPorFiltro(parametro);
		} else {
			listaProfissao = (List<Profissao>) new ProfissaoBO().getTodos();
		}
	}

	public void criaLista(Long idParlamentar) {
		ProfissaoBO profissaoBO = new ProfissaoBO();
		Profissao profissao = profissaoBO.obterPorId(idParlamentar);
		List<Profissao> listaAuxiliar = new ArrayList<Profissao>();
		listaProfissao = profissaoBO.getTodos();
		listaAuxiliar.add(profissao);
		listaProfissao.remove(profissao);
		listaAuxiliar.addAll(listaProfissao);
		listaProfissao = listaAuxiliar;
	}
}
