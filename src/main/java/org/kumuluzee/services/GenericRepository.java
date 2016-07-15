package org.kumuluzee.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericRepository {

	@PersistenceContext(unitName = "hsql-PU")
	protected EntityManager em;
	
}
