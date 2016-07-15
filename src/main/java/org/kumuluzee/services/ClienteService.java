package org.kumuluzee.services;

import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import org.kumuluzee.models.Cliente;

@RequestScoped
public class ClienteService extends ServiceBase {
	
	public Cliente gravar() {
		Cliente c = new Cliente();
		c.setNome("Thiago Michelini");
		c.setIdade(31);
		c.setNascimento(LocalDate.now());
		
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		
		List<Cliente> lista = em.createQuery("FROM Cliente c", Cliente.class).getResultList();
		lista.forEach((item) -> {
			System.out.println(item.getId() + " | "  + item.getNome() + " | " + item.getNascimento());
		});
		return c;
	}
	
}
