package sgidp.web.tabelaapoio;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
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

import sgidp.web.componentes.ProfissaoDataProvider;
import sgidp.web.template.BasePage;
import br.com.pw.sgidp.negocio.ProfissaoBO;
import br.com.pw.sgidp.negocio.entidade.Profissao;

public class ListarProfissaoPage extends BasePage {
	private ProfissaoDataProvider profissaoProvider;
	private String filtro = "";

	public ListarProfissaoPage(final PageParameters parameters) {
		super(parameters, "Tabelas de apoio", "Cadastrar profissão");
		profissaoProvider = new ProfissaoDataProvider();
		montaFormulario();
	}

	public ListarProfissaoPage(Long idProfissao) {
		super("Tabelas de apoio", "Cadastrar profissão");
		profissaoProvider = new ProfissaoDataProvider(idProfissao);
		montaFormulario();
	}

	@SuppressWarnings({ "serial" })
	private void montaFormulario() {
		Form<Object> form = new Form<Object>("form");
		add(form);

		form.add(new TextField<String>("filtro", new PropertyModel<String>(
				this, "filtro")));

		form.add(new Button("btnLocalizar") {
			@Override
			public void onSubmit() {
				profissaoProvider = new ProfissaoDataProvider(getFiltro());
			}
		});

		form.add(new Button("btnNovaProfissao") {
			@Override
			public void onSubmit() {
				setResponsePage(IncluirProfissaoPage.class);
			}
		});

		DataView<Profissao> dataView = montaDataView();

		dataView.setItemsPerPage(15);
		add(dataView);

		add(new PagingNavigator("navigator", dataView));

		add(new FeedbackPanel("mensagem"));
	}

	private DataView<Profissao> montaDataView() {
		@SuppressWarnings("serial")
		DataView<Profissao> dataView = new DataView<Profissao>(
				"listaProfissao", profissaoProvider) {
			@Override
			protected void populateItem(final Item<Profissao> item) {

				Profissao profissao = item.getModelObject();
				item.add(new ActionPanel("acao", item.getModel()));

				item.add(new Label("nome", profissao.getNome()));

			}

		};
		return dataView;
	}

	public String getFiltro() {
		return filtro;
	}

	@SuppressWarnings("serial")
	class ActionPanel extends Panel {
		@SuppressWarnings("rawtypes")
		public ActionPanel(String id, IModel<Profissao> model) {
			super(id, model);

			add(new Link("excluir") {
				@Override
				public void onClick() {

					new ProfissaoBO().excluir(((Profissao) getParent()
							.getDefaultModelObject()));
					setResponsePage(ListarProfissaoPage.class);

				}
			});
		}
	}
}