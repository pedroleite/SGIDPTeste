package sgidp.web.usuario;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.extensions.markup.html.form.palette.Palette;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.util.CollectionModel;
import org.apache.wicket.model.util.ListModel;

import sgidp.web.template.BasePage;
import br.com.pw.sgidp.negocio.PermissaoBO;
import br.com.pw.sgidp.negocio.UsuarioBO;
import br.com.pw.sgidp.negocio.entidade.Permissao;
import br.com.pw.sgidp.negocio.entidade.Usuario;

public class VisualizarUsuarioPage extends BasePage {
	private Usuario usuario;
	private String senhaConfirmada;

	@SuppressWarnings("serial")
	public VisualizarUsuarioPage(Long idUsuario) {
		super("Usu�rio", "Visualizar usu�rio");

		usuario = new UsuarioBO().obterPorId(idUsuario);

		@SuppressWarnings("rawtypes")
		Form form = new Form("form");
		add(form);

		form.add(new FeedbackPanel("mensagem"));

		TextField<String> textFieldNome = new TextField<String>("nome",
				new PropertyModel<String>(this, "usuario.nome"));
		textFieldNome.setRequired(true);

		form.add(textFieldNome);

		TextField<String> textFieldLogin = new TextField<String>("login",
				new PropertyModel<String>(this, "usuario.login"));
		textFieldLogin.setRequired(true);
		form.add(textFieldLogin);

		List<Permissao> permissoes = (List<Permissao>) new PermissaoBO()
				.getListaTodasPermissoes();

		@SuppressWarnings("rawtypes")
		IChoiceRenderer renderer = new ChoiceRenderer("descricao", "codigo");

		@SuppressWarnings({ "rawtypes", "unchecked" })
		final Palette palette = new Palette("palette",
				new ListModel<Permissao>((List<Permissao>) usuario
						.getListaPermissao()),
				new CollectionModel<Permissao>(permissoes), renderer, 10, true);

		palette.setEnabled(false);
		form.add(palette);

		
		Button btnVoltar = new Button("btnVoltar") {
			@Override
			public void onSubmit() {
				setResponsePage(ListarUsuarioPage.class);
			}
		};
		
		btnVoltar.setDefaultFormProcessing(false);
		
		form.add(btnVoltar);
	}

	private boolean isSenhaValida() {
		return usuario.getSenha().equals(senhaConfirmada);
	}

}