package org.kumuluzee.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class RepositoryHSQLDB extends GenericRepository {
	
	@PersistenceContext(unitName = "hsql-PU")
	private EntityManager em;

	@Override
	protected EntityManager getEm() {
		return em;
	}
	
}
