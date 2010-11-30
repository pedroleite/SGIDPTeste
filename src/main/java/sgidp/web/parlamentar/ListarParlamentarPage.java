package sgidp.web.parlamentar;

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
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import sgidp.web.componentes.ParlamentarDataProvider;
import sgidp.web.template.BasePage;
import sgidp.web.usuario.EditarUsuarioPage;
import sgidp.web.usuario.ListarUsuarioPage;
import sgidp.web.usuario.VisualizarUsuarioPage;
import br.com.pw.sgidp.negocio.UsuarioBO;
import br.com.pw.sgidp.negocio.entidade.Parlamentar;
import br.com.pw.sgidp.negocio.entidade.Usuario;

import com.pw.SessaoWeb;

public class ListarParlamentarPage extends BasePage {
	private IDataProvider<Parlamentar> parlamentarProvider;
	private String filtro = "";
	private String tipoFiltro = "";

	public ListarParlamentarPage(final PageParameters parameters) {
		super(parameters, "Parlamentar", "Cadastrar parlamentar");
		parlamentarProvider = new ParlamentarDataProvider();
		montaFormulario();
	}

	public ListarParlamentarPage(Long idParlamentar) {
		super("Parlamentar", "Cadastrar parlamentar");
		parlamentarProvider = new ParlamentarDataProvider(idParlamentar);
		montaFormulario();
	}

	@SuppressWarnings({ "serial", "unchecked" })
	private void montaFormulario() {
		Form<Object> form = new Form<Object>("form");
		add(form);

		@SuppressWarnings("rawtypes")
		DropDownChoice tipoFiltro = new DropDownChoice("tipoFiltro",
				new PropertyModel(this, "tipoFiltro"),
				Arrays.asList(new String[] { "Nome" }));

		form.add(tipoFiltro);

		form.add(new TextField<String>("filtro", new PropertyModel<String>(
				this, "filtro")));

		form.add(new Button("btnLocalizar") {
			@Override
			public void onSubmit() {
				parlamentarProvider = new ParlamentarDataProvider(getTipoFiltro(),
						getFiltro());
			}
		});

		form.add(new Button("btnNovoParlamentar") {
			@Override
			public void onSubmit() {
				setResponsePage(IncluirParlamentarPage.class);
			}
		});

		DataView<Parlamentar> dataView = montaDataView();

		dataView.setItemsPerPage(15);
		add(dataView);

		add(new PagingNavigator("navigator", dataView));

		add(new FeedbackPanel("mensagem"));
	}

	private DataView<Parlamentar> montaDataView() {
		@SuppressWarnings("serial")
		DataView<Parlamentar> dataView = new DataView<Parlamentar>("listaParlamentar",
				parlamentarProvider) {
			@Override
	        protected void populateItem(final Item<Parlamentar> item) {

				Parlamentar parlamentar = item.getModelObject();
				
				item.add(new ActionPanel("acao", item.getModel()));
				item.add(new Label("nome", parlamentar.getNomeParlamentar()));
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
		public ActionPanel(String id, IModel<Parlamentar> model) {
			super(id, model);
			add(new Link("editar") {
				@Override
				public void onClick() {

					EditarParlamentarPage editarParlamentar = new EditarParlamentarPage(
							((Parlamentar) getParent().getDefaultModelObject())
									.getId());
					setResponsePage(editarParlamentar);
				}
			});

			add(new Link("visualizar") {
				@Override
				public void onClick() {

					VisualizarParlamentarPage visualizarParlamentar = new VisualizarParlamentarPage(
							((Parlamentar) getParent().getDefaultModelObject())
									.getId());
					setResponsePage(visualizarParlamentar);

				}
			});

			add(new Link("excluir") {
				@Override
				public void onClick() {
					Usuario usuarioLogado = ((SessaoWeb) Session.get())
							.getUsuarioLogado();
					if (usuarioLogado.getId().equals(
							((Usuario) getParent().getDefaultModelObject())
									.getId())) {
						error("O usuário logado não pode ser excluido.");
					} else {
						new UsuarioBO().excluir(((Usuario) getParent()
								.getDefaultModelObject()));
						setResponsePage(ListarUsuarioPage.class);
					}
				}
			});
		}
	}
	
}