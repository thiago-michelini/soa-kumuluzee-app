package org.kumuluzee.services;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import org.kumuluzee.models.Usuario;
import org.kumuluzee.repository.JPAModel;
import org.kumuluzee.repository.RepositoryHSQLDB;
import org.kumuluzee.repository.TipoQueryEnum;

@RequestScoped
public class UsuarioService extends RepositoryHSQLDB {
	
	public Usuario gravar(Usuario entidade) throws Exception {
		return super.gravar(entidade);
	}
	
	public void excluir(Usuario entidade) throws Exception {
		super.excluir(Usuario.class, entidade);
	}
	
	public List<Usuario> buscar(Long id, String login, String cpf) throws Exception {
		JPAModel jpaModel = new JPAModel(null, TipoQueryEnum.QUERY, true);
		jpaModel.limparParams();
		
		String hql = "FROM Usuario u WHERE 1 = 1 ";
		
		if (null != id) {
			hql += "AND u.id = :p_id ";
			jpaModel.getParams().put("p_id", id);
		}
		if (null != login && !login.trim().isEmpty()) {
			hql += "AND u.login = :p_login ";
			jpaModel.getParams().put("p_login", login);
		}
		if (null != cpf && !cpf.trim().isEmpty()) {
			hql += "AND u.cpf = :p_cpf ";
			jpaModel.getParams().put("p_cpf", cpf);
		}
		
		jpaModel.setSql(hql);
		return getEntidades(jpaModel, Usuario.class);
	}
	
}
