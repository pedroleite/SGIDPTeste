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

import sgidp.web.componentes.CargoDataProvider;
import sgidp.web.template.BasePage;
import br.com.pw.sgidp.negocio.CargoBO;
import br.com.pw.sgidp.negocio.entidade.Cargo;

public class ListarCargoPage extends BasePage {
	private CargoDataProvider profissaoProvider;
	private String filtro = "";

	public ListarCargoPage(final PageParameters parameters) {
		super(parameters, "Tabelas de apoio", "Cadastrar cargo");
		profissaoProvider = new CargoDataProvider();
		montaFormulario();
	}

	public ListarCargoPage(Long idCargo) {
		super("Tabelas de apoio", "Cadastrar profissão");
		profissaoProvider = new CargoDataProvider(idCargo);
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
				profissaoProvider = new CargoDataProvider(getFiltro());
			}
		});

		form.add(new Button("btnNovoCargo") {
			@Override
			public void onSubmit() {
				setResponsePage(IncluirCargoPage.class);
			}
		});

		DataView<Cargo> dataView = montaDataView();

		dataView.setItemsPerPage(15);
		add(dataView);

		add(new PagingNavigator("navigator", dataView));

		add(new FeedbackPanel("mensagem"));
	}

	private DataView<Cargo> montaDataView() {
		@SuppressWarnings("serial")
		DataView<Cargo> dataView = new DataView<Cargo>(
				"listaCargo", profissaoProvider) {
			@Override
			protected void populateItem(final Item<Cargo> item) {

				Cargo profissao = item.getModelObject();
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
		public ActionPanel(String id, IModel<Cargo> model) {
			super(id, model);

			add(new Link("excluir") {
				@Override
				public void onClick() {

					new CargoBO().excluir(((Cargo) getParent()
							.getDefaultModelObject()));
					setResponsePage(ListarCargoPage.class);

				}
			});
		}
	}
}