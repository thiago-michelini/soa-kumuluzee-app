package org.kumuluzee.repository;

import java.util.List;

import org.kumuluzee.models.Cliente;

public class ClientePGRepository extends RepositoryPG {

	public List<Cliente> buscarTodos() throws Exception {
		return getEm().createNamedQuery("Cliente.todos", Cliente.class).getResultList();
	}
	
}
