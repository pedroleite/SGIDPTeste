package sgidp.web.template;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.PageParameters;
import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import sgidp.web.home.Home;
import sgidp.web.parlamentar.CadastroParlamentarPage;
import br.com.pw.sgidp.negocio.entidade.Permissao;
import br.com.pw.sgidp.negocio.entidade.Usuario;

import com.pw.SessaoWeb;

public class WebSite extends WebPage {

	private static final String ABERTO = "aberto";
	private static final String FECHADO = "fechado";
	private String modulo = "";
	private String pagina = "";
	private static String moduloSelecionado = "";

	public WebSite(final PageParameters parameters) {
		if (!parameters.getString("link", "").equals("")) {
			moduloSelecionado = parameters.getString("link", "");
		}
		add(new Label("migalha", "Onde estou: " + modulo + " -> " + pagina));
		Usuario usuario = ((SessaoWeb) Session.get()).getUsuarioLogado();
		String[] arrayNome = usuario.getNome().split(" ");
		add(new Label("usuarioLogado", arrayNome[0]));

		Map<String, String> mapaPermissoes = getMapaPermissoes(usuario
				.getListaPermissao());
		boolean isTemPermissao = false;
		// Usuario

		isTemPermissao = mapaPermissoes.containsKey("01") ? true : false;
		add(markupContainerManterUsuario(ABERTO, isTemPermissao));
		add(markupContainerManterUsuario(FECHADO, isTemPermissao));

		isTemPermissao = mapaPermissoes.containsKey("02") ? true : false;
		add(markupContainerManterParlamentar(ABERTO, isTemPermissao));
		add(markupContainerManterParlamentar(FECHADO, isTemPermissao));

	}

	private Map<String, String> getMapaPermissoes(
			Collection<Permissao> listaPermissao) {

		Map<String, String> mapaPermissao = new HashMap<String, String>();

		for (Permissao permissao : listaPermissao) {
			mapaPermissao.put(permissao.getCodigo(), permissao.getCodigo());
		}

		return mapaPermissao;
	}

	private WebMarkupContainer markupContainerManterUsuario(
			String descricaoDiv, boolean isTemPermissao) {
		WebMarkupContainer webMarkupContainer = new WebMarkupContainer(
				"div_manter_usuario_" + descricaoDiv);
		webMarkupContainer.add(new BookmarkablePageLink("manterUsuarioLink",
				Home.class).setParameter("link", "01"));

		verificaMarkup("01", descricaoDiv, isTemPermissao, webMarkupContainer);

		return webMarkupContainer;
	}

	private WebMarkupContainer markupContainerManterParlamentar(
			String descricaoDiv, boolean isTemPermissao) {
		WebMarkupContainer webMarkupContainer = new WebMarkupContainer(
				"div_manter_parlamentar_" + descricaoDiv);
		webMarkupContainer.add(new BookmarkablePageLink(
				"manterParlamentarLink", CadastroParlamentarPage.class)
				.setParameter("link", "02"));
		verificaMarkup("02", descricaoDiv, isTemPermissao, webMarkupContainer);
		return webMarkupContainer;
	}

	private void verificaMarkup(String modulo, String descricaoDiv,
			boolean isTemPermissao, WebMarkupContainer webMarkupContainer) {
		if (isTemPermissao) {
			if (moduloSelecionado.equals(modulo)) {
				if (descricaoDiv.equals(FECHADO)) {
					webMarkupContainer.setVisible(false);
				}
			} else {
				if (descricaoDiv.equals(ABERTO)) {
					webMarkupContainer.setVisible(false);
				}
			}
		} else {
			webMarkupContainer.setVisible(false);
		}
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	public String getModulo() {
		return modulo;
	}

	public String getPagina() {
		return pagina;
	}

}
