package com.pw;

import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;

import sgidp.web.parlamentar.CadastroParlamentarPage;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see com.pw.Start#main(String[])
 */
public class WicketApplication extends WebApplication {
	/**
	 * Constructor
	 */
	public WicketApplication() {
	}

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	public Class<CadastroParlamentarPage> getHomePage() {
		return CadastroParlamentarPage.class;
	}

	@Override
	public Session newSession(Request request, Response response) {
		return new SessaoWeb(request);
	}

}
