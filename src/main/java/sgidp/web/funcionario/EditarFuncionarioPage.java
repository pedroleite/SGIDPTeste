package sgidp.web.funcionario;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;

import sgidp.web.template.BasePage;
import br.com.pw.sgidp.negocio.FuncionarioBO;
import br.com.pw.sgidp.negocio.entidade.Funcionario;

public class EditarFuncionarioPage extends BasePage {
	private Funcionario funcionario;

	@SuppressWarnings("serial")
	public EditarFuncionarioPage(Long idFuncionario) {
		super("Usuário", "Editar usuário");

		funcionario = new FuncionarioBO().obterPorId(idFuncionario);

		@SuppressWarnings("rawtypes")
		Form form = new Form("form");
		add(form);

		form.add(new FeedbackPanel("mensagem"));

		TextField<String> textFieldNome = new TextField<String>("nome",
				new PropertyModel<String>(this, "funcionario.nome"));
		textFieldNome.setRequired(true);
		form.add(textFieldNome);

		TextField<String> textFieldDataNascimento = new TextField<String>(
				"dataNascimento", new PropertyModel<String>(this,
						"funcionario.dataNascimento"));
		textFieldDataNascimento.setRequired(true);
		form.add(textFieldDataNascimento);

		TextField<String> textFieldLotacao = new TextField<String>("lotacao",
				new PropertyModel<String>(this, "funcionario.lotacao"));
		textFieldLotacao.setRequired(true);
		form.add(textFieldLotacao);

		TextField<String> textFieldSexo = new TextField<String>("sexo",
				new PropertyModel<String>(this, "funcionario.sexo"));
		textFieldSexo.setRequired(true);
		form.add(textFieldSexo);

		form.add(new Button("btnSalvar") {
			@Override
			public void onSubmit() {
				// Verifica se o login já foi cadastrado
				FuncionarioBO funcionarioBO = new FuncionarioBO();

				funcionarioBO.atualizar(funcionario);

				setResponsePage(new ListarFuncionarioPage(funcionario.getId()));

			}

		});

		Button btnVoltar = new Button("btnVoltar") {
			@Override
			public void onSubmit() {
				setResponsePage(ListarFuncionarioPage.class);
			}
		};

		btnVoltar.setDefaultFormProcessing(false);

		form.add(btnVoltar);
	}

}