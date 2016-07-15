package org.kumuluzee.services;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.kumuluzee.models.Cliente;

@RequestScoped
public class ClientePGService extends ServiceBase {
	
	@PersistenceContext(unitName = "pg-PU")
	private EntityManager em;
	
	public Cliente gravar(Cliente c) throws Exception {
		c = super.gravar(c);
		List<Cliente> lista = getEm().createNamedQuery("Cliente.todos", Cliente.class).getResultList();
		lista.forEach((item) -> {
			System.out.println("PostgreSQL--->"+item.getId() + " | "  + item.getNome() + " | " + item.getNascimento());
		});
		return c;
	}

	@Override
	protected EntityManager getEm() {
		return em;
	}
	
}
