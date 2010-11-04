package com.pw;

import org.apache.wicket.protocol.http.WebApplication;

import sgidp.web.login.Login;

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
	public Class<Login> getHomePage() {
		return Login.class;
	}

}
