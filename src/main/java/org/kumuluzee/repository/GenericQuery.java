package org.kumuluzee.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract class GenericQuery {
	
	protected abstract EntityManager getEm();
	
	@SuppressWarnings("unchecked")
	public <T> List<T> getEntidades(JPAModel jpaModel, Class<T> persistentClass) throws IllegalStateException {
		Query q = executarConsulta(getEm(), jpaModel, persistentClass);
		return q.getResultList();
	}

	/**
	 * Consulta uma entidade no BD, correspondente ao id passado no parametro id
	 * 
	 * @param id - Id da entidade a ser localizada e retornada
	 * @return - Uma entidade localizada
	 * @throws IllegalStateException
	 */
	public <T> T getEntidadePorId(Class<T> persistentClass, Object id) throws IllegalStateException {
		return getEm().find(persistentClass, id);
	}
	
	/**
	 * Consulta uma entidade no BD, de acordo com as condicoes passadas no JPAModel
	 * 
	 * @param jpaModel
	 * @return - Uma entidade localizada
	 * @throws IllegalStateException
	 */
	@SuppressWarnings("unchecked")
	public <T> T getEntidade(JPAModel jpaModel, Class<T> persistentClass) throws IllegalStateException {
		Query q = executarConsulta(getEm(), jpaModel, persistentClass);
		return (T) q.getSingleResult();
	}

	private <T> Query executarConsulta(EntityManager em, JPAModel jpaModel, Class<T> persistentClass) throws IllegalStateException {
		Query q;
		if (jpaModel.getTipoQuery() == TipoQueryEnum.NAMED_QUERY) {
			if (jpaModel.isRetornoTipado()) {
				q = em.createNamedQuery(jpaModel.getSql(), persistentClass);
			} else {
				q = em.createNamedQuery(jpaModel.getSql());
			}
		} else if (jpaModel.getTipoQuery() == TipoQueryEnum.NATIVE_QUERY) {
			if (jpaModel.isRetornoTipado()) {
				q = em.createNativeQuery(jpaModel.getSql(), persistentClass);
			} else {
				q = em.createNativeQuery(jpaModel.getSql());
			}
		} else {
			if (jpaModel.isRetornoTipado()) {
				q = em.createQuery(jpaModel.getSql(), persistentClass);
			} else {
				q = em.createQuery(jpaModel.getSql());
			}
		}
		
		if (null != jpaModel.getQtdeRegistros()) {
			q.setMaxResults(jpaModel.getQtdeRegistros());
		}
		
		JPAModel.setParamsSQLMap(q, jpaModel.getParams());
		
		return q;
	}
	
}
