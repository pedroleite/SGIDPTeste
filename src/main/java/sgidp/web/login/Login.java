package sgidp.web.login;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

import sgidp.web.home.Home;
import sgidp.web.parlamentar.CadastroClienteRespostaPage;
import sgidp.web.parlamentar.CadastroParlamentarPage;

import br.com.pw.sgidp.negocio.UsuarioBO;
import br.com.pw.sgidp.negocio.entidade.Usuario;

public class Login extends WebPage {
	private Usuario usuario;

	@SuppressWarnings("serial")
	public Login(final PageParameters parameters) {

		Form<Object> form = new Form<Object>("form");
		add(form);

		form.add(new TextField<String>("login", new PropertyModel<String>(this,
				"usuario.login")));

		form.add(new TextField<String>("senha", new PropertyModel<String>(this,
				"usuario.senha")));

		form.add(new Button("btnLogar") {
			@Override
			public void onSubmit() {
				UsuarioBO usuarioBO = new UsuarioBO();
				if (usuarioBO.isLoginESenhaValidos(getUsuario())) {
					setResponsePage(Home.class);
				} else {
					setResponsePage(Login.class);
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
