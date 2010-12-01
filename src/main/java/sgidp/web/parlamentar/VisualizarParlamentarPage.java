package sgidp.web.parlamentar;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

import br.com.pw.sgidp.negocio.ParlamentarBO;
import br.com.pw.sgidp.negocio.UsuarioBO;
import br.com.pw.sgidp.negocio.entidade.Parlamentar;
import br.com.pw.sgidp.negocio.entidade.Usuario;

import sgidp.web.template.BasePage;
import sgidp.web.usuario.ListarUsuarioPage;

public class VisualizarParlamentarPage extends BasePage {

	private Parlamentar parlamentar;
	
	public VisualizarParlamentarPage(Long idParlamentar) {
		super("Parlamentar", "Visualizar parlamentar");

		parlamentar = new ParlamentarBO().obterPorId(idParlamentar);
		Form form = new Form("form");
		add(form);
		
		
		TextField<String> textFieldNome = new TextField<String>("nome",
				new PropertyModel<String>(parlamentar, "nomeParlamentar"));
		textFieldNome.setEnabled(false);
		form.add(textFieldNome);
		
		TextField<String> textFieldTratamento = new TextField<String>("tratamento",
				new PropertyModel<String>(parlamentar, "tratamento"));
		textFieldTratamento.setEnabled(false);
		form.add(textFieldTratamento);
		
		TextField<String> textFieldNomeCompleto = new TextField<String>("nomeCompleto",
				new PropertyModel<String>(parlamentar, "nomeCompleto"));
		textFieldNomeCompleto.setEnabled(false);
		form.add(textFieldNomeCompleto);
		
		TextField<String> textFieldDataNascimento = new TextField<String>("dataNascimento",
				new PropertyModel<String>(parlamentar, "dataNascimento"));
		textFieldDataNascimento.setEnabled(false);
		form.add(textFieldDataNascimento);
		
		TextField<String> textFieldCargo = new TextField<String>("cargo",
				new PropertyModel<String>(parlamentar, "cargo"));
		textFieldCargo.setEnabled(false);
		form.add(textFieldCargo);
		
		TextField<String> textFieldPartido = new TextField<String>("partido",
				new PropertyModel<String>(parlamentar, "partido"));
		textFieldPartido.setEnabled(false);
		form.add(textFieldPartido);
		
		TextField<String> textFieldEstado = new TextField<String>("estado",
				new PropertyModel<String>(parlamentar, "estado"));
		textFieldEstado.setEnabled(false);
		form.add(textFieldEstado);
		
		TextField<String> textFieldProfissao = new TextField<String>("profissao",
				new PropertyModel<String>(parlamentar, "profissao"));
		textFieldProfissao.setEnabled(false);
		form.add(textFieldProfissao);
		
		TextField<String> textFieldEmail = new TextField<String>("email",
				new PropertyModel<String>(parlamentar, "email"));
		textFieldEmail.setEnabled(false);
		form.add(textFieldEmail);
		
		TextField<String> textFieldEmailParticular = new TextField<String>("emailParticular",
				new PropertyModel<String>(parlamentar, "emailParticular"));
		textFieldEmailParticular.setEnabled(false);
		form.add(textFieldEmailParticular);
		
		TextField<String> textFieldEscolaridade = new TextField<String>("escolaridade",
				new PropertyModel<String>(parlamentar, "escolaridade"));
		textFieldEscolaridade.setEnabled(false);
		form.add(textFieldEscolaridade);
		
		TextField<String> textFieldSite = new TextField<String>("site",
				new PropertyModel<String>(parlamentar, "site"));
		textFieldSite.setEnabled(false);
		form.add(textFieldSite);
		
		
		
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
