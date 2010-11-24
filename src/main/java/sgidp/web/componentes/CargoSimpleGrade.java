package sgidp.web.componentes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.pw.sgidp.negocio.CargoBO;
import br.com.pw.sgidp.negocio.entidade.Cargo;

public class CargoSimpleGrade implements Serializable {

	private static final long serialVersionUID = 7408391532596130458L;

	private static List<Cargo> listaCargo = new ArrayList<Cargo>();

	public List<Cargo> find(int first, int count) {
		List<Cargo> sublist = listaCargo.subList(first, first + count);
		return sublist;
	}

	public int getTamanho() {
		return listaCargo.size();
	}

	public Cargo get(Long id) {
		for (Cargo cargo : listaCargo) {
			if (cargo.getId().equals(id)) {
				return cargo;
			}
		}
		return null;
	}

	protected void add(final Cargo cargo) {
		listaCargo.add(cargo);
	}

	public void criaLista(String parametro) {
		if (parametro != null && !parametro.equals("")) {
			listaCargo = (List<Cargo>) new CargoBO()
					.getPorFiltro(parametro);
		} else {
			listaCargo = (List<Cargo>) new CargoBO().getTodos();
		}
	}

	public void criaLista(Long idParlamentar) {
		CargoBO cargoBO = new CargoBO();
		Cargo cargo = cargoBO.obterPorId(idParlamentar);
		List<Cargo> listaAuxiliar = new ArrayList<Cargo>();
		listaCargo = cargoBO.getTodos();
		listaAuxiliar.add(cargo);
		listaCargo.remove(cargo);
		listaAuxiliar.addAll(listaCargo);
		listaCargo = listaAuxiliar;
	}
}
