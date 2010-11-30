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

import sgidp.web.componentes.PartidoDataProvider;
import sgidp.web.template.BasePage;
import br.com.pw.sgidp.negocio.PartidoBO;
import br.com.pw.sgidp.negocio.entidade.Partido;

public class ListarPartidoPage extends BasePage {
	private PartidoDataProvider partidoProvider;
	private String filtro = "";

	public ListarPartidoPage(final PageParameters parameters) {
		super(parameters, "Tabelas de apoio", "Cadastrar partido");
		partidoProvider = new PartidoDataProvider();
		montaFormulario();
	}

	public ListarPartidoPage(Long idPartido) {
		super("Tabelas de apoio", "Cadastrar partido");
		partidoProvider = new PartidoDataProvider(idPartido);
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
				partidoProvider = new PartidoDataProvider(getFiltro());
			}
		});

		form.add(new Button("btnNovoPartido") {
			@Override
			public void onSubmit() {
				setResponsePage(IncluirPartidoPage.class);
			}
		});

		DataView<Partido> dataView = montaDataView();

		dataView.setItemsPerPage(15);
		add(dataView);

		add(new PagingNavigator("navigator", dataView));

		add(new FeedbackPanel("mensagem"));
	}

	private DataView<Partido> montaDataView() {
		@SuppressWarnings("serial")
		DataView<Partido> dataView = new DataView<Partido>("listaPartido",
				partidoProvider) {
			@Override
			protected void populateItem(final Item<Partido> item) {

				Partido partido = item.getModelObject();
				item.add(new ActionPanel("acao", item.getModel()));
				item.add(new Label("sigla", partido.getSigla()));
				item.add(new Label("nome", partido.getNome()));
			

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
		public ActionPanel(String id, IModel<Partido> model) {
			super(id, model);

			add(new Link("excluir") {
				@Override
				public void onClick() {

					new PartidoBO().excluir(((Partido) getParent()
							.getDefaultModelObject()));
					setResponsePage(ListarPartidoPage.class);

				}
			});
		}
	}
}