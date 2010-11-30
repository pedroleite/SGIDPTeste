package br.com.pw.sgidp.negocio;

import java.util.List;

import br.com.pw.sgidp.negocio.entidade.Cargo;
import br.com.pw.sgidp.persitencia.dao.CargoDAO;

public class CargoBO {
	private CargoDAO cargoDAO;

	private CargoDAO getCargoDAO() {
		if (cargoDAO == null) {
			cargoDAO = new CargoDAO();
		}

		return cargoDAO;
	}

	public void incluir(Cargo cargo) {
		getCargoDAO().iniciarTransacao();
		getCargoDAO().inserir(cargo);
		getCargoDAO().finalizarTransacao();
	}

	public void excluir(Cargo cargo) {
		getCargoDAO().iniciarTransacao();
		getCargoDAO().excluir(cargo);
		getCargoDAO().finalizarTransacao();
	}

	public List<Cargo> getTodos() {
		return getCargoDAO().consultarTodos();
	}

	public List<Cargo> getPorFiltro(String parametro) {
		return getCargoDAO().buscaPorFiltro(parametro);
	}

	public Cargo obterPorId(Long id) {
		return getCargoDAO().obterPorId(id);
	}

	public boolean isCargoExiste(Cargo cargo) {
		if(getCargoDAO().obterPorNome(cargo).size()>0){
			return true;
		}
		return false;
		
	}
}
