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

public class TrocarSenhaPage extends BasePage {
	private Usuario usuario;
	private String senhaConfirmada;

	@SuppressWarnings("serial")
	public TrocarSenhaPage(Long idUsuario) {
		super("Usuário", "Trocar senha");

		usuario = new UsuarioBO().obterPorId(idUsuario);
		@SuppressWarnings("rawtypes")
		Form form = new Form("form");
		add(form);

		form.add(new FeedbackPanel("mensagem"));

		form.add(new TextField<String>("nome", new PropertyModel<String>(this,
				"usuario.nome")));

		form.add(new TextField<String>("login", new PropertyModel<String>(this,
				"usuario.login")));

		form.add(new PasswordTextField("senha", new PropertyModel<String>(this,
				"usuario.senha")));

		form.add(new PasswordTextField("confirmarSenha",
				new PropertyModel<String>(this, "senhaConfirmada")));

		form.add(new Button("btnSalvar") {

			@Override
			public void onSubmit() {
				// Verifica se o login já foi cadastrado
				UsuarioBO usuarioBO = new UsuarioBO();
				if (isSenhaValida()) {	
					usuarioBO.trocarSenha(usuario);				
					setResponsePage(new ListarUsuarioPage(usuario.getId()));
				} else {
					usuario = new UsuarioBO().obterPorId(usuario.getId());
					error("A Senha confirmada é diferente da Senha informada.");
				}
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

	private boolean isSenhaValida() {
		return usuario.getSenha().equals(senhaConfirmada);
	}

}