package sgidp.web.tabelaapoio;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;

import sgidp.web.template.BasePage;
import br.com.pw.sgidp.negocio.CargoBO;
import br.com.pw.sgidp.negocio.entidade.Cargo;

public class IncluirCargoPage extends BasePage {
	private Cargo cargo;

	@SuppressWarnings("serial")
	public IncluirCargoPage(final PageParameters parameters) {
		super(parameters, "Tabelas de apoio", "Incluir cargo");
		@SuppressWarnings("rawtypes")
		Form form = new Form("form");
		add(form);

		form.add(new FeedbackPanel("mensagem"));

		TextField<String> textFieldNome = new TextField<String>("nome",
				new PropertyModel<String>(this, "cargo.nome"));
		textFieldNome.setRequired(true);

		form.add(textFieldNome);

		form.add(new Button("btnSalvar") {

			@Override
			public void onSubmit() {
				CargoBO cargoBO = new CargoBO();

				if (!cargoBO.isCargoExiste(cargo)) {
					cargoBO.incluir(cargo);
					ListarCargoPage listarCargoPage = new ListarCargoPage(
							cargo.getId());
					setResponsePage(listarCargoPage);
				} else {

					error("Cargo já cadastrado.");
				}
			}
		});

		Button btnVoltar = new Button("btnVoltar") {
			@Override
			public void onSubmit() {
				setResponsePage(ListarCargoPage.class);
			}
		};

		btnVoltar.setDefaultFormProcessing(false);

		form.add(btnVoltar);
	}

}