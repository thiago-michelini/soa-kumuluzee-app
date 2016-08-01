package org.kumuluzee.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.persistence.TypedQuery;

import org.kumuluzee.models.Usuario;

@RequestScoped
public class UsuarioService extends RepositoryBase {
	
	public Usuario gravar(Usuario entidade) throws Exception {
		return super.gravar(entidade);
	}
	
	public List<Usuario> buscar(Long id, String login, String cpf) throws Exception {
		String hql = "FROM Usuario u WHERE 1 = 1 ";
		Map<String, Object> params = new HashMap<String, Object>();
		
		if (null != id) {
			hql += "AND u.id = :p_id ";
			params.put("p_id", id);
		}
		if (null != login && !login.trim().isEmpty()) {
			hql += "AND u.login = :p_login ";
			params.put("p_login", login);
		}
		if (null != cpf && !cpf.trim().isEmpty()) {
			hql += "AND u.cpf = :p_cpf ";
			params.put("p_cpf", cpf);
		}
		
		TypedQuery<Usuario> q = getEm().createQuery(hql, Usuario.class);
		setParams(q, params);
		return q.getResultList();
	}

	private void setParams(TypedQuery<Usuario> q, Map<String, Object> params) {
		params.forEach((key, item) -> {
			q.setParameter(key, item);
		});
	}
	
}
