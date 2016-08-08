package org.kumuluzee.services;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import org.kumuluzee.models.Cliente;
import org.kumuluzee.repository.ClientePGRepository;

@RequestScoped
public class ClientePGService extends ClientePGRepository {
	
	public Cliente gravar(Cliente c) throws Exception {
		c = super.gravar(c);
		List<Cliente> lista = buscarTodos();
		lista.forEach((item) -> {
			System.out.println("PostgreSQL--->"+item.getId() + " | "  + item.getNome() + " | " + item.getNascimento());
		});
		return c;
	}
	
}
