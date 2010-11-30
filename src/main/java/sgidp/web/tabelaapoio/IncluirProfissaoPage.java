package sgidp.web.tabelaapoio;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;

import sgidp.web.template.BasePage;
import br.com.pw.sgidp.negocio.ProfissaoBO;
import br.com.pw.sgidp.negocio.entidade.Profissao;

public class IncluirProfissaoPage extends BasePage {
	private Profissao profissao;

	@SuppressWarnings("serial")
	public IncluirProfissaoPage(final PageParameters parameters) {
		super(parameters, "Tabelas de apoio", "Incluir profissão");
		@SuppressWarnings("rawtypes")
		Form form = new Form("form");
		add(form);

		form.add(new FeedbackPanel("mensagem"));

		TextField<String> textFieldNome = new TextField<String>("nome",
				new PropertyModel<String>(this, "profissao.nome"));
		textFieldNome.setRequired(true);

		form.add(textFieldNome);

		form.add(new Button("btnSalvar") {

			@Override
			public void onSubmit() {
				ProfissaoBO profissaoBO = new ProfissaoBO();

				if (!profissaoBO.isProfissaoExiste(profissao)) {
					profissaoBO.incluir(profissao);
					ListarProfissaoPage listarProfissaoPage = new ListarProfissaoPage(
							profissao.getId());
					setResponsePage(listarProfissaoPage);
				} else {

					error("Profissão já cadastrada.");
				}
			}
		});

		Button btnVoltar = new Button("btnVoltar") {
			@Override
			public void onSubmit() {
				setResponsePage(ListarProfissaoPage.class);
			}
		};

		btnVoltar.setDefaultFormProcessing(false);

		form.add(btnVoltar);
	}

}