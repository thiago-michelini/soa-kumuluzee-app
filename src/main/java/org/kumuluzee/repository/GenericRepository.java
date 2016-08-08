package org.kumuluzee.repository;

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
	
	protected <T extends EntidadeBase> void excluir(Class<T> clazz, T entidade) throws Exception {
		EntityManager em = getEm();
		em.getTransaction().begin();
		em.remove(buscarPorId(clazz, entidade.getId()));
		em.getTransaction().commit();
	}
	
	protected <T> T buscarPorId(Class<T> clazz, Long id) {
		return getEm().find(clazz, id);
	}
	
}
