package sgidp.web.parlamentar;

import java.util.Arrays;
import java.util.Date;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.validation.validator.EmailAddressPatternValidator;

import sgidp.web.template.BasePage;
import sgidp.web.usuario.ListarUsuarioPage;
import br.com.pw.sgidp.negocio.ParlamentarBO;
import br.com.pw.sgidp.negocio.entidade.Parlamentar;

public class EditarParlamentarPage extends BasePage {
	private Parlamentar parlamentar;

	@SuppressWarnings( { "serial", "unchecked" })
	public EditarParlamentarPage(final PageParameters parameters) {
		super(parameters, "Parlamentar", "Cadastrar parlamentar");
		Form<Object> form = new Form<Object>("form");
		add(form);
		form.add(new FeedbackPanel("mensagem"));
		TextField<String> textFieldNome = new TextField<String>("nome",
				new PropertyModel<String>(parlamentar, "nomeParlamentar"));
		TextField<String> textFieldTratamento = new TextField<String>(
				"tratamento", new PropertyModel<String>(parlamentar,
						"tratamento"));

		form.add(textFieldNome);
		textFieldNome.setRequired(true);
		form.add(textFieldTratamento);

		TextField<String> textFieldNomeCompleto = new TextField<String>(
				"nomeCompleto", new PropertyModel<String>(parlamentar,
						"nomeCompleto"));
		form.add(textFieldNomeCompleto);
		textFieldNomeCompleto.setRequired(true);
		TextField<Date> textFieldDataNascimento = new TextField<Date>(
				"dataNascimento", new PropertyModel<Date>(parlamentar,
						"dataNascimento"));
		form.add(textFieldDataNascimento);
		textFieldDataNascimento.setRequired(true);
		TextField<String> textFieldCargo = new TextField<String>("cargo",
				new PropertyModel<String>(parlamentar, "cargo"));
		form.add(textFieldCargo);
		textFieldCargo.setRequired(true);
		TextField<String> textFieldPartido = new TextField<String>("partido",
				new PropertyModel<String>(parlamentar, "partido"));
		form.add(textFieldPartido);
		textFieldPartido.setRequired(true);

		DropDownChoice estado = new DropDownChoice("estado", new PropertyModel(
				this, "parlamentar.estado"), Arrays.asList(new String[] { "BA",
				"DF", "GO", "MA", "PB", "CE", "RS", }));
		estado.setRequired(true);
		form.add(estado);
		TextField<String> textFieldProfissao = new TextField<String>(
				"profissao",
				new PropertyModel<String>(parlamentar, "profissao"));
		form.add(textFieldProfissao);
		textFieldProfissao.setRequired(true);
		TextField<String> textFieldEmail = new TextField<String>("email",
				new PropertyModel<String>(parlamentar, "email"));
		form.add(textFieldEmail);
		textFieldEmail.setRequired(true);
		TextField<String> textFieldEscolaridade = new TextField<String>(
				"escolaridade", new PropertyModel<String>(parlamentar,
						"escolaridade"));
		form.add(textFieldEscolaridade);
		textFieldEscolaridade.setRequired(true);
		TextField<String> textFieldEmailParticular = new TextField<String>(
				"emailParticular", new PropertyModel<String>(parlamentar,
						"emailParticular"));
		form.add(textFieldEmailParticular);
		textFieldEmail.add(EmailAddressPatternValidator.getInstance());
		textFieldEmailParticular.setRequired(true);
		form.add(new TextField<String>("site", new PropertyModel<String>(
				parlamentar, "site")));

		form.add(new Button("btnSalvar") {
			@Override
			public void onSubmit() {
				// Verifica se o login já foi cadastrado
				ParlamentarBO parlamentarBO = new ParlamentarBO();

				// usuario.setLogin(usuario.getLogin().toLowerCase());
				//
				// if (!parlamentarBO.isLoginCadastrado(parlamentar)) {
				// @SuppressWarnings("unchecked")
				// ListModel<Permissao> modelPermissao = (ListModel<Permissao>)
				// palette
				// .getDefaultModel();
				// usuario.setListaPermissao(modelPermissao.getObject());
				// usuarioBO.atualizar(usuario);
				//
				// setResponsePage(new ListarUsuarioPage(usuario.getId()));
				// } else {
				// error("Login já cadastrado.");
				// }

			}

		});

		Button btnVoltar = new Button("btnVoltar") {
			@Override
			public void onSubmit() {
				setResponsePage(ListarUsuarioPage.class);
			}
		};

		btnVoltar.setDefaultFormProcessing(false);

		form.add(btnVoltar);
	}

}
