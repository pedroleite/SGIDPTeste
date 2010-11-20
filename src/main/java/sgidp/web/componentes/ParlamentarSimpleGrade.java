package sgidp.web.componentes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.pw.sgidp.negocio.ParlamentarBO;
import br.com.pw.sgidp.negocio.entidade.Parlamentar;

public class ParlamentarSimpleGrade implements Serializable {

	private static final long serialVersionUID = 7408391532596130458L;

	private static List<Parlamentar> listaParlamentar = new ArrayList<Parlamentar>();

	public List<Parlamentar> find(int first, int count) {
		List<Parlamentar> sublist = listaParlamentar.subList(first, first
				+ count);
		return sublist;
	}

	public int getTamanho() {
		return listaParlamentar.size();
	}

	public Parlamentar get(Long id) {
		for (Parlamentar parlamentar : listaParlamentar) {
			if (parlamentar.getId().equals(id)) {
				return parlamentar;
			}
		}
		return null;
	}

	protected void add(final Parlamentar parlamentar) {
		listaParlamentar.add(parlamentar);
	}

	public void criaLista(String tipoFiltro, String parametro) {
		if (tipoFiltro != null && parametro != null && !tipoFiltro.equals("")
				&& !tipoFiltro.equals("Escolha")) {
			if (tipoFiltro.equals("Nome"))
				tipoFiltro = "nomeParlamentar";
			listaParlamentar = (List<Parlamentar>) new ParlamentarBO()
					.getPorFiltro(tipoFiltro, parametro);
		} else {
			listaParlamentar = (List<Parlamentar>) new ParlamentarBO()
					.getTodos();
		}
	}

	public void criaLista(Long idParlamentar) {
		ParlamentarBO parlamentarBO = new ParlamentarBO();
		Parlamentar parlamentar = parlamentarBO.obterPorId(idParlamentar);
		List<Parlamentar> listaAuxiliar = new ArrayList<Parlamentar>();
		listaParlamentar = parlamentarBO.getTodos();
		listaAuxiliar.add(parlamentar);
		listaParlamentar.remove(parlamentar);
		listaAuxiliar.addAll(listaParlamentar);
		listaParlamentar = listaAuxiliar;
	}
}
