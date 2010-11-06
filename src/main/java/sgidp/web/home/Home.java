package sgidp.web.home;

import org.apache.wicket.PageParameters;

import sgidp.web.template.WebSite;


public class Home extends WebSite {

	public Home(final PageParameters parameters) {
		super(parameters);
		setModulo("Home");
		setPagina("Seja bem vindo!");
	}

}
