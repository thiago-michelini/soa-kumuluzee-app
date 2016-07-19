package org.kumuluzee.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class ServiceBase extends GenericRepository {
	
	@PersistenceContext(unitName = "hsql-PU")
	private EntityManager em;

	@Override
	protected EntityManager getEm() {
		return em;
	}
	
}