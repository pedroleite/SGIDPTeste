package sgidp.web.template;

import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import br.com.pw.sgidp.negocio.entidade.Usuario;

import com.pw.SessaoWeb;

public class WebSite extends WebPage {

	@SuppressWarnings("unchecked")
	public WebSite(String migalha) {
		add(new BookmarkablePageLink("homeLink", Home.class));
		add(new BookmarkablePageLink("servicesLink", Services.class));
		add(new BookmarkablePageLink("aboutUsLink", Parlamentar.class));
		add(new BookmarkablePageLink("contactLink", Contact.class));

		WebMarkupContainer webMarkupContainer = new WebMarkupContainer("div1");
		webMarkupContainer
				.add(new BookmarkablePageLink("homeLink2", Home.class));
		add(webMarkupContainer);
		webMarkupContainer.setVisible(false);

		WebMarkupContainer webMarkupContainer2 = new WebMarkupContainer("div2");
		webMarkupContainer2.add(new BookmarkablePageLink("homeLink2",
				Home.class));
		add(webMarkupContainer2);
		webMarkupContainer2.setVisible(true);

		add(new Label("migalha", "Onde estou: " + migalha));
		Usuario usuario = ((SessaoWeb) Session.get()).getUsuarioLogado();
		String[] arrayNome = usuario.getNome().split(" ");
		add(new Label("usuarioLogado", arrayNome[0]));
	}
}
