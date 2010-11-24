package com.pw;

import org.apache.wicket.Request;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;

import br.com.pw.sgidp.negocio.entidade.Usuario;

public final class SessaoWeb extends WebSession {
	private static final long serialVersionUID = -8319340285947063441L;
	private Usuario usuarioLogado;

	public SessaoWeb(Request request) {
		super(request);
	}

	public final Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public final void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public static SessaoWeb get() {
		return (SessaoWeb) Session.get();
	}
}
