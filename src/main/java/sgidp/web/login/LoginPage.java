package sgidp.web.login;

import org.apache.wicket.PageParameters;
import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;

import sgidp.web.home.Home;
import br.com.pw.sgidp.negocio.UsuarioBO;
import br.com.pw.sgidp.negocio.entidade.Usuario;

import com.pw.SessaoWeb;

public class LoginPage extends WebPage {
	private Usuario usuario;

	@SuppressWarnings("serial")
	public LoginPage(final PageParameters parameters) {
		Form<Object> form = new Form<Object>("form");
		add(form);

		add(new FeedbackPanel("mensagem"));
		TextField<String> textFieldLogin = new TextField<String>("login",
				new PropertyModel<String>(this, "usuario.login"));
		textFieldLogin.setRequired(true);

		form.add(textFieldLogin);

		form.add(new PasswordTextField("senha", new PropertyModel<String>(this,
				"usuario.senha")));

		form.add(new Button("btnLogar") {
			@Override
			public void onSubmit() {

				MockCarregarUsuarioEPermissoes.criarUsuarioEPermissoes();

				UsuarioBO usuarioBO = new UsuarioBO();

				if (usuarioBO.isLoginESenhaValidos(getUsuario())) {
					// Coloca o usuário na sessão.
					((SessaoWeb) Session.get()).setUsuarioLogado(usuarioBO
							.getUsuarioLogado());
					setResponsePage(Home.class);
				} else {
					error("Login ou senha incorretos.");
				}
			}
		});

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
