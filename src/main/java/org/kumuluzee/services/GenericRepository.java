package org.kumuluzee.services;

import javax.persistence.EntityManager;

import org.kumuluzee.models.EntidadeBase;

public abstract class GenericRepository {

	protected abstract EntityManager getEm();
	
	protected <T extends EntidadeBase> T gravar(T entidade) throws Exception {
		EntityManager em = getEm();
		em.getTransaction().begin();
		if (null == entidade.getId())
			em.persist(entidade);
		else
			em.merge(entidade);
		em.getTransaction().commit();
		
		return entidade;
	}
	
	protected <T extends EntidadeBase> void excluir(T entidade) throws Exception {
		EntityManager em = getEm();
		em.getTransaction().begin();
		em.remove(entidade);
		em.getTransaction().commit();
	}
	
	protected <T> T buscarPorId(Class<T> clazz, Long id) {
		return getEm().find(clazz, id);
	}
	
}
