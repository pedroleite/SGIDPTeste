package sgidp.web.parlamentar;

import java.util.Date;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;

import sgidp.web.template.BasePage;
import br.com.pw.sgidp.negocio.ParlamentarBO;
import br.com.pw.sgidp.negocio.entidade.Parlamentar;

public class IncluirParlamentarPage extends BasePage {

	final long serialVersionUID = 1L;
	Parlamentar parlamentar = new Parlamentar();

	@SuppressWarnings("serial")
	public IncluirParlamentarPage(final PageParameters parameters) {
		super(parameters, "Parlamentar", "Cadastrar parlamentar");
		Form<Object> form = new Form<Object>("form");
		add(form);
		form.add(new FeedbackPanel("mensagem"));
		form.add(new TextField<String>("nome", new PropertyModel<String>(
				parlamentar, "nomeParlamentar")));
		form.add(new TextField<String>("tratamento", new PropertyModel<String>(
				parlamentar, "tratamento")));
		form.add(new TextField<String>("nomeCompleto",
				new PropertyModel<String>(parlamentar, "nomeCompleto")));
		form.add(new TextField<Date>("dataNascimento", new PropertyModel<Date>(
				parlamentar, "dataNascimento")));
		form.add(new TextField<String>("cargo", new PropertyModel<String>(
				parlamentar, "cargo")));
		form.add(new TextField<String>("partido", new PropertyModel<String>(
				parlamentar, "partido")));
		form.add(new TextField<String>("estado", new PropertyModel<String>(
				parlamentar, "estado")));
		form.add(new TextField<String>("profissao", new PropertyModel<String>(
				parlamentar, "profissao")));
		form.add(new TextField<String>("email", new PropertyModel<String>(
				parlamentar, "email")));
		form.add(new TextField<String>("escolaridade",
				new PropertyModel<String>(parlamentar, "escolaridade")));
		form.add(new TextField<String>("emailParticular",
				new PropertyModel<String>(parlamentar, "emailParticular")));
		form.add(new TextField<String>("site", new PropertyModel<String>(
				parlamentar, "site")));

		form.add(new Button("btnSalvar") {
			@Override
			public void onSubmit() {
				ParlamentarBO parlamentarBO = new ParlamentarBO();
				parlamentarBO.salvar(parlamentar);

				ListarParlamentarPage listarParlamentar = new ListarParlamentarPage(
						parlamentar.getId());
				setResponsePage(listarParlamentar);
			}
		});
		Button btnVoltar = new Button("btnVoltar") {
			@Override
			public void onSubmit() {
				setResponsePage(ListarParlamentarPage.class);
			}
		};

		btnVoltar.setDefaultFormProcessing(false);

		form.add(btnVoltar);

	}

}
