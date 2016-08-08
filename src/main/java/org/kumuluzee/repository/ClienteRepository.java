package org.kumuluzee.repository;

import java.util.List;

import org.kumuluzee.models.Cliente;

public class ClienteRepository extends RepositoryHSQLDB {

	public List<Cliente> buscarTodos() throws Exception {
		JPAModel jpaModel = new JPAModel("Cliente.todos", TipoQueryEnum.NAMED_QUERY, true);
		return getEntidades(jpaModel, Cliente.class);
//		return getEm().createNamedQuery("Cliente.todos", Cliente.class).getResultList();
	}
	
}
