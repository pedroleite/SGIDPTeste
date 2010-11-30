package sgidp.web.componentes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.pw.sgidp.negocio.PartidoBO;
import br.com.pw.sgidp.negocio.entidade.Partido;

public class PartidoSimpleGrade implements Serializable {

	private static final long serialVersionUID = 7408391532596130458L;

	private static List<Partido> listaPartido = new ArrayList<Partido>();

	public List<Partido> find(int first, int count) {
		List<Partido> sublist = listaPartido.subList(first, first + count);
		return sublist;
	}

	public int getTamanho() {
		return listaPartido.size();
	}

	public Partido get(Long id) {
		for (Partido partido : listaPartido) {
			if (partido.getId().equals(id)) {
				return partido;
			}
		}
		return null;
	}

	protected void add(final Partido partido) {
		listaPartido.add(partido);
	}

	public void criaLista(String parametro) {
		if (parametro != null && !parametro.equals("")) {
			listaPartido = (List<Partido>) new PartidoBO()
					.getPorFiltro(parametro);
		} else {
			listaPartido = (List<Partido>) new PartidoBO().getTodos();
		}
	}

	public void criaLista(Long idParlamentar) {
		PartidoBO partidoBO = new PartidoBO();
		Partido partido = partidoBO.obterPorId(idParlamentar);
		List<Partido> listaAuxiliar = new ArrayList<Partido>();
		listaPartido = partidoBO.getTodos();
		listaAuxiliar.add(partido);
		listaPartido.remove(partido);
		listaAuxiliar.addAll(listaPartido);
		listaPartido = listaAuxiliar;
	}
}
