package sgidp.web.usuario;

import org.apache.wicket.PageParameters;

import sgidp.web.template.WebSite;

public class ManterUsuario extends WebSite{
    public ManterUsuario(final PageParameters parameters){
    	super(parameters);
     setModulo("usuario");
       setPagina("Inicio");
    }
}