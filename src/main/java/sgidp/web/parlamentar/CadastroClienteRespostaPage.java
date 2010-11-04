package sgidp.web.parlamentar;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

/**
 * Cadastro clients
 */
public class CadastroClienteRespostaPage extends WebPage {

	private static final long serialVersionUID = 1L;

	public CadastroClienteRespostaPage(final PageParameters parameters) {
		add(new FeedbackPanel("message"));
		info("Cliente inserido com sucesso");
	}

}