package sgidp.web.funcionario;

import java.util.Arrays;

import org.apache.wicket.PageParameters;
import org.apache.wicket.Session;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import com.pw.SessaoWeb;

import sgidp.web.componentes.FuncionarioDataProvider;
import sgidp.web.template.BasePage;
import br.com.pw.sgidp.negocio.FuncionarioBO;
import br.com.pw.sgidp.negocio.entidade.Funcionario;

public class ListarFuncionarioPage extends BasePage {
	private FuncionarioDataProvider funcionarioProvider;
	private String filtro = "";
	private String tipoFiltro = "";

	public ListarFuncionarioPage(final PageParameters parameters) {
		super(parameters, "Funcionário", "Cadastrar funcionário");
		funcionarioProvider = new FuncionarioDataProvider();
		montaFormulario();
	}

	public ListarFuncionarioPage(Long idFuncionario) {
		super("Funcionário", "Cadastrar funcionário");
		funcionarioProvider = new FuncionarioDataProvider(idFuncionario);
		montaFormulario();
	}

	@SuppressWarnings({ "serial", "unchecked" })
	private void montaFormulario() {
		Form<Object> form = new Form<Object>("form");
		add(form);

		@SuppressWarnings("rawtypes")
		DropDownChoice tipoFiltro = new DropDownChoice("tipoFiltro",
				new PropertyModel(this, "tipoFiltro"),
				Arrays.asList(new String[] { "Nome", "Lotação" }));

		form.add(tipoFiltro);

		form.add(new TextField<String>("filtro", new PropertyModel<String>(
				this, "filtro")));

		form.add(new Button("btnLocalizar") {
			@Override
			public void onSubmit() {
				funcionarioProvider = new FuncionarioDataProvider(
						getTipoFiltro(), getFiltro());
			}
		});

		form.add(new Button("btnNovoFuncionario") {
			@Override
			public void onSubmit() {
				setResponsePage(IncluirFuncionarioPage.class);
			}
		});

		DataView<Funcionario> dataView = montaDataView();

		dataView.setItemsPerPage(15);
		add(dataView);

		add(new PagingNavigator("navigator", dataView));

		add(new FeedbackPanel("mensagem"));
	}

	private DataView<Funcionario> montaDataView() {
		@SuppressWarnings("serial")
		DataView<Funcionario> dataView = new DataView<Funcionario>(
				"listaFuncionario", funcionarioProvider) {
			@Override
			protected void populateItem(final Item<Funcionario> item) {

				Funcionario funcionario = item.getModelObject();
				item.add(new ActionPanel("acao", item.getModel()));

				item.add(new Label("nome", funcionario.getNome()));
				item.add(new Label("lotacao", funcionario.getLotacao()));
			}

		};
		return dataView;
	}

	public String getFiltro() {
		return filtro;
	}

	public String getTipoFiltro() {
		return tipoFiltro;
	}

	@SuppressWarnings("serial")
	class ActionPanel extends Panel {
		@SuppressWarnings("rawtypes")
		public ActionPanel(String id, IModel<Funcionario> model) {
			super(id, model);
			add(new Link("editar") {
				@Override
				public void onClick() {

					EditarFuncionarioPage editarFuncionario = new EditarFuncionarioPage(
							((Funcionario) getParent().getDefaultModelObject())
									.getId());
					setResponsePage(editarFuncionario);
				}
			});

			add(new Link("visualizar") {
				@Override
				public void onClick() {

					VisualizarFuncionarioPage visualizarFuncionario = new VisualizarFuncionarioPage(
							((Funcionario) getParent().getDefaultModelObject())
									.getId());
					setResponsePage(visualizarFuncionario);

				}
			});

			add(new Link("excluir") {
				@Override
				public void onClick() {
					new FuncionarioBO().excluir(((Funcionario) getParent()
							.getDefaultModelObject()));
					setResponsePage(ListarFuncionarioPage.class);
				}
			});
		}
	}
}