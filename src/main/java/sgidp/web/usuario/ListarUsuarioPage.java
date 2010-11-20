package sgidp.web.usuario;

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

import sgidp.web.componentes.UsuarioDataProvider;
import sgidp.web.template.BasePage;
import br.com.pw.sgidp.negocio.UsuarioBO;
import br.com.pw.sgidp.negocio.entidade.Usuario;

public class ListarUsuarioPage extends BasePage {
	private UsuarioDataProvider usuarioProvider;
	private String filtro = "";
	private String tipoFiltro = "";

	public ListarUsuarioPage(final PageParameters parameters) {
		super(parameters, "Usuário", "Cadastrar usuário");
		usuarioProvider = new UsuarioDataProvider();
		montaFormulario();
	}

	public ListarUsuarioPage(Long idUsuario) {
		super("Usuário", "Cadastrar usuário");
		usuarioProvider = new UsuarioDataProvider(idUsuario);
		montaFormulario();
	}

	@SuppressWarnings({ "serial", "unchecked" })
	private void montaFormulario() {
		Form<Object> form = new Form<Object>("form");
		add(form);

		@SuppressWarnings("rawtypes")
		DropDownChoice tipoFiltro = new DropDownChoice("tipoFiltro",
				new PropertyModel(this, "tipoFiltro"),
				Arrays.asList(new String[] { "Nome", "Login" }));

		form.add(tipoFiltro);

		form.add(new TextField<String>("filtro", new PropertyModel<String>(
				this, "filtro")));

		form.add(new Button("btnLocalizar") {
			@Override
			public void onSubmit() {
				usuarioProvider = new UsuarioDataProvider(getTipoFiltro(),
						getFiltro());
			}
		});

		form.add(new Button("btnNovoUsuario") {
			@Override
			public void onSubmit() {
				setResponsePage(IncluirUsuarioPage.class);
			}
		});

		DataView<Usuario> dataView = montaDataView();

		dataView.setItemsPerPage(15);
		add(dataView);

		add(new PagingNavigator("navigator", dataView));

		add(new FeedbackPanel("mensagem"));
	}

	private DataView<Usuario> montaDataView() {
		@SuppressWarnings("serial")
		DataView<Usuario> dataView = new DataView<Usuario>("listaUsuario",
				usuarioProvider) {
			@Override
			protected void populateItem(final Item<Usuario> item) {

				Usuario usuario = item.getModelObject();
				item.add(new ActionPanel("acao", item.getModel()));

				item.add(new Label("nome", usuario.getNome()));
				item.add(new Label("login", usuario.getLogin()));
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
		public ActionPanel(String id, IModel<Usuario> model) {
			super(id, model);
			add(new Link("editar") {
				@Override
				public void onClick() {

					EditarUsuarioPage editarUsuario = new EditarUsuarioPage(
							((Usuario) getParent().getDefaultModelObject())
									.getId());
					setResponsePage(editarUsuario);
				}
			});

			add(new Link("visualizar") {
				@Override
				public void onClick() {

					VisualizarUsuarioPage visualizarUsuario = new VisualizarUsuarioPage(
							((Usuario) getParent().getDefaultModelObject())
									.getId());
					setResponsePage(visualizarUsuario);

				}
			});

			add(new Link("trocarSenha") {
				@Override
				public void onClick() {
					TrocarSenhaPage trocarSenha = new TrocarSenhaPage(
							((Usuario) getParent().getDefaultModelObject())
									.getId());
					setResponsePage(trocarSenha);
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