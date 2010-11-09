package sgidp.web.parlamentar;

import java.util.Date;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

import sgidp.web.template.BasePage;
import br.com.pw.sgidp.negocio.ParlamentarBO;
import br.com.pw.sgidp.negocio.entidade.Parlamentar;

public class CadastroParlamentarPage extends BasePage {

	final long serialVersionUID = 1L;
	Parlamentar cadastroParlamentar = new Parlamentar();

	@SuppressWarnings("serial")
	public CadastroParlamentarPage(final PageParameters parameters) {
		super(parameters,"Parlamentar","Cadastrar parlamentar");
		Form<Object> form = new Form<Object>("form");
		add(form);

		form.add(new TextField<String>("nome", new PropertyModel<String>(this,
				"cadastroParlamentar.nomeParlamentar")));
		form.add(new TextField<String>("tratamento", new PropertyModel<String>(
				this, "cadastroParlamentar.tratamento")));
		form.add(new TextField<String>("nomeCompleto",
				new PropertyModel<String>(this,
						"cadastroParlamentar.nomeCompleto")));
		form.add(new TextField<Date>("dataNascimento", new PropertyModel<Date>(
				this, "cadastroParlamentar.dataNascimento")));
		form.add(new TextField<String>("cargo", new PropertyModel<String>(this,
				"cadastroParlamentar.cargo")));
		form.add(new TextField<String>("partido", new PropertyModel<String>(
				this, "cadastroParlamentar.partido")));
		form.add(new TextField<String>("estado", new PropertyModel<String>(
				this, "cadastroParlamentar.estado")));
		form.add(new TextField<String>("profissao", new PropertyModel<String>(
				this, "cadastroParlamentar.profissao")));
		form.add(new TextField<String>("email", new PropertyModel<String>(this,
				"cadastroParlamentar.email")));
		form.add(new TextField<String>("escolaridade",
				new PropertyModel<String>(this,
						"cadastroParlamentar.escolaridade")));
		form.add(new TextField<String>("emailParticular",
				new PropertyModel<String>(this,
						"cadastroParlamentar.emailParticular")));
		form.add(new TextField<String>("site", new PropertyModel<String>(this,
				"cadastroParlamentar.site")));

		form.add(new Button("btnConfirmar") {
			@Override
			public void onSubmit() {
				ParlamentarBO parlamentarBO = new ParlamentarBO();
				parlamentarBO.salvar(cadastroParlamentar);
				setResponsePage(CadastroClienteRespostaPage.class);
			}
		});
		form.add(new Button("btnCancelar"));

	}

}
