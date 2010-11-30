package sgidp.web.tabelaapoio;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;

import sgidp.web.template.BasePage;
import br.com.pw.sgidp.negocio.PartidoBO;
import br.com.pw.sgidp.negocio.entidade.Partido;

public class IncluirPartidoPage extends BasePage {
	private Partido partido;

	@SuppressWarnings("serial")
	public IncluirPartidoPage(final PageParameters parameters) {
		super(parameters, "Tabelas de apoio", "Incluir partido");
		@SuppressWarnings("rawtypes")
		Form form = new Form("form");
		add(form);

		form.add(new FeedbackPanel("mensagem"));

		TextField<String> textFieldSigla = new TextField<String>("sigla",
				new PropertyModel<String>(this, "partido.sigla"));
		textFieldSigla.setRequired(true);

		form.add(textFieldSigla);
		
		TextField<String> textFieldNome = new TextField<String>("nome",
				new PropertyModel<String>(this, "partido.nome"));
		textFieldNome.setRequired(true);

		form.add(textFieldNome);

	

		form.add(new Button("btnSalvar") {

			@Override
			public void onSubmit() {
				PartidoBO partidoBO = new PartidoBO();

				if (!partidoBO.isPartidoExiste(partido)) {
					partidoBO.incluir(partido);
					ListarPartidoPage listarPartidoPage = new ListarPartidoPage(
							partido.getId());
					setResponsePage(listarPartidoPage);
				} else {

					error("Partido já cadastrado.");
				}
			}
		});

		Button btnVoltar = new Button("btnVoltar") {
			@Override
			public void onSubmit() {
				setResponsePage(ListarPartidoPage.class);
			}
		};

		btnVoltar.setDefaultFormProcessing(false);

		form.add(btnVoltar);
	}

}