package sgidp.web.usuario;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.PageParameters;
import org.apache.wicket.extensions.markup.html.form.palette.Palette;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.util.CollectionModel;
import org.apache.wicket.model.util.ListModel;

import sgidp.web.template.BasePage;
import br.com.pw.sgidp.negocio.PermissaoBO;
import br.com.pw.sgidp.negocio.entidade.Permissao;

public class IncluirUsuario extends BasePage {

	public IncluirUsuario(final PageParameters parameters) {
		super(parameters, "Usuário", "Incluir usuário");
		Form f = new Form("form");
		add(f);

		List<Permissao> permissoes = (List<Permissao>) new PermissaoBO()
				.getListaTodasPermissoes();

		IChoiceRenderer renderer = new ChoiceRenderer("descricao", "codigo");

		final Palette palette = new Palette("palette",
				new ListModel<Permissao>(new ArrayList<Permissao>()),
				new CollectionModel<Permissao>(permissoes), renderer, 10, true);

		f.add(palette);

	}

}