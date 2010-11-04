package br.com.pw.sgidp.persitencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.pw.sgidp.negocio.entidade.Entidade;

public abstract class DAOAbstrato<E extends Entidade> implements
		IDAOAbstrato<E> {
	private static EntityManagerFactory sessionFactory;
	private EntityManager session;

	private static EntityManagerFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = Persistence
					.createEntityManagerFactory("sgidp");
		}
		return sessionFactory;
	}

	protected EntityManager getSession() {
		if (session == null) {
			session = getSessionFactory().createEntityManager();
		}
		return session;
	}

	private EntityTransaction getTransacao() {
		return getSession().getTransaction();
	}

	public void iniciarTransacao() {
		getTransacao().begin();
	}

	public void finalizarTransacao() {
		getTransacao().commit();
	}

	public static void inicializarSessionFactory() {
		getSessionFactory();
	}
}