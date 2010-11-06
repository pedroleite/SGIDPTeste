package sgidp.web.login;

import java.util.Collection;

import br.com.pw.sgidp.negocio.PermissaoBO;
import br.com.pw.sgidp.negocio.UsuarioBO;
import br.com.pw.sgidp.negocio.entidade.Permissao;
import br.com.pw.sgidp.negocio.entidade.Usuario;

public class MockCarregarUsuarioEPermissoes {

	public static void criarUsuarioEPermissoes() {
		UsuarioBO usuarioBO = new UsuarioBO();

		if (usuarioBO.getTodosUsuarios().size() == 0) {
			Collection<Permissao> listaPermissao = criarPermissioes();
			criarUsauarios(listaPermissao);
		}
	}

	private static void criarUsauarios(Collection<Permissao> listaPermissao) {
		Usuario usuario1 = new Usuario();
		usuario1.setNome("Welington Gomides");
		usuario1.setLogin("welington");
		usuario1.setSenha("123");
		usuario1.setListaPermissao(listaPermissao);

		UsuarioBO usuarioBO = new UsuarioBO();

		Usuario usuario2 = new Usuario();
		usuario2.setNome("Pedro Leite");
		usuario2.setLogin("pedro");
		usuario2.setSenha("123");
		usuario2.setListaPermissao(listaPermissao);

		usuarioBO.inserir(usuario1);
		usuarioBO.inserir(usuario2);
	}

	private static Collection<Permissao> criarPermissioes() {
		PermissaoBO permissaoBO = new PermissaoBO();
		Permissao permissao1 = new Permissao();
		permissao1.setCodigo("01");
		permissao1.setDescricao("CadastrarUsuario");

		Permissao permissao2 = new Permissao();
		permissao2.setCodigo("02");
		permissao2.setDescricao("CadastrarParlamentar");

		permissaoBO.incluir(permissao1);
		permissaoBO.incluir(permissao2);
		return permissaoBO.getListaTodasPermissoes();
	}
}
