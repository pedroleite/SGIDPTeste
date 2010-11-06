package sgidp.web.parlamentar;

import java.util.Arrays;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

import br.com.pw.sgidp.negocio.ParlamentarBO;
import br.com.pw.sgidp.negocio.entidade.Parlamentar;

public class CadastroParlamentarPage extends WebPage {

	final long serialVersionUID = 1L;
	Parlamentar cadastroParlamentar = new Parlamentar();
	private DropDownChoice DropDownChoice;

	@SuppressWarnings( { "serial", "unchecked" })
	public CadastroParlamentarPage(final PageParameters parameters) {

		Form<Object> form = new Form<Object>("form");
		add(form);

		form.add(new TextField<String>("nomeParlamentar",
				new PropertyModel<String>(this,
						"cadastroParlamentar.nomeParlamentar")));

		form.add(new TextField<String>("estado", new PropertyModel<String>(
				this, "cadastroParlamentar.estado")));

		DropDownChoice estado = new DropDownChoice("estado", Arrays
				.asList(new String[] { "BA", "DF", "GO" }));

		form.add(new Button("btnConfirmar") {
			@Override
			public void onSubmit() {
				ParlamentarBO parlamentarBO = new ParlamentarBO();
				parlamentarBO.salvar(cadastroParlamentar);
				// setResponsePage(CadastroClienteRespostaPage.class);
			}
		});
		form.add(new Button("btnCancelar"));

	}
}
