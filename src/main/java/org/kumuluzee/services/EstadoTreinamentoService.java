package org.kumuluzee.services;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.kumuluzee.models.EstadoTreinamento;
import org.kumuluzee.repository.RepositoryHSQLDB;

@RequestScoped
public class EstadoTreinamentoService extends RepositoryHSQLDB {
	
	@PersistenceContext(unitName = "sgr-PU")
	private EntityManager em;

	@Override
	protected EntityManager getEm() {
		return em;
	}
	
	public EstadoTreinamento gravar(EstadoTreinamento entidade) throws Exception {
		return super.gravar(entidade);
	}
	
	public void excluir(EstadoTreinamento entidade) throws Exception {
		super.excluir(EstadoTreinamento.class, entidade);
	}
		
}
