package org.kumuluzee.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class RepositoryPG extends GenericRepository {
	
	@PersistenceContext(unitName = "pg-PU")
	private EntityManager em;

	@Override
	protected EntityManager getEm() {
		return em;
	}
	
}
