package org.kumuluzee.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.kumuluzee.models.Cliente;

@RequestScoped
public class ClienteService extends ServiceBase {
	
	@Inject
	private ClientePGService clientePGService;
	
	public Cliente gravar() throws Exception {
		Cliente c = new Cliente();
		c.setNome("Thiago Michelini");
		c.setIdade(31);
		c.setNascimento(LocalDate.now());
		
		super.gravar(c);
		getEm().clear();
		
		c.setId(null);
		clientePGService.gravar(c);
		
		List<Cliente> lista = getEm().createNamedQuery("Cliente.todos", Cliente.class).getResultList();
		lista.forEach((item) -> {
			System.out.println("HSQLDB--->"+item.getId() + " | "  + item.getNome() + " | " + item.getNascimento());
		});
		return c;
	}
	
}
