package org.kumuluzee.services;

import javax.persistence.EntityManager;

import org.kumuluzee.models.EntidadeBase;

public abstract class GenericRepository {

	protected abstract EntityManager getEm();
	
	protected <T extends EntidadeBase> T gravar(T entidade) throws Exception {
		getEm().getTransaction().begin();
		if (null == entidade.getId())
			getEm().persist(entidade);
		else
			getEm().merge(entidade);
		getEm().getTransaction().commit();
		
		return entidade;
	}
	
	protected <T extends EntidadeBase> void excluir(T entidade) throws Exception {
		getEm().getTransaction().begin();
		getEm().remove(entidade);
		getEm().getTransaction().commit();
	}
	
	protected <T> T buscarPorId(Class<T> clazz, Long id) {
		return getEm().find(clazz, id);
	}
	
}
