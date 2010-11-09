package sgidp.web.usuario;

import java.util.Arrays;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import sgidp.web.componentes.UsuarioDataProvider;
import sgidp.web.template.BasePage;
import br.com.pw.sgidp.negocio.entidade.Usuario;

public class ManterUsuario extends BasePage {

	private Usuario usuarioSelecionado;
	private String filtro = "";
	private String tipoFiltro = "";

	
	
	
	public String getFiltro() {
		return filtro;
	}

	public String getTipoFiltro() {
		return tipoFiltro;
	}

	private UsuarioDataProvider usuarioProvider = new UsuarioDataProvider("",
			"");

	@SuppressWarnings( { "serial", "unchecked" })
	public ManterUsuario(final PageParameters parameters) {
		super(parameters, "Usuário", "Cadastrar usuário");
		Form<Object> form = new Form<Object>("form");
		add(form);

		DropDownChoice tipoFiltro = new DropDownChoice(
				"tipoFiltro",
				new PropertyModel(this, "tipoFiltro"),Arrays
				.asList(new String[] { "Nome", "Login" }));

		form.add(tipoFiltro);

		form.add(new TextField<String>("filtro", new PropertyModel<String>(
				this, "filtro")));

		form.add(new Button("btnLocalizar") {
			@Override
			public void onSubmit() {
				usuarioProvider = new UsuarioDataProvider(
						getTipoFiltro(),
						getFiltro());
			}
		});
		
		form.add(new Button("btnNovoUsuario") {
			@Override
			public void onSubmit() {
				setResponsePage(IncluirUsuario.class);
			}
		});
		

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

		dataView.setItemsPerPage(15);
		add(dataView);

		add(new PagingNavigator("navigator", dataView));
	}

	@SuppressWarnings("serial")
	class ActionPanel extends Panel {
		public ActionPanel(String id, IModel<Usuario> model) {
			super(id, model);
			add(new Link("usuarioSelecionado") {
				@Override
				public void onClick() {

					usuarioSelecionado = (Usuario) getParent()
							.getDefaultModelObject();
					System.out.println(usuarioSelecionado.getId());
				}
			});
		}
	}
}