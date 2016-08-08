package org.kumuluzee.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

public class JPAModel {
	
	private String sql;
	private TipoQueryEnum tipoQuery;
	private boolean retornoTipado;
	private Integer qtdeRegistros;
	
	@SuppressWarnings("rawtypes")
	private List paramsSQL;
	
	private Map<String, Object> params;
	
	@SuppressWarnings("unused")
	private JPAModel() {
		super();
	}
	
	/**
	 * Classe para otimizar consultas as entidades via JPA
	 * @param sql - NamedQuery ou NativeQuery a ser executada
	 * @param namedQuery - true define que serah NamedQuery, false define que serah NativeQuery
	 * @param retornoTipado - Define se serah retornado na consulta objeto(s) de um tipo especifico
	 */
	public JPAModel(String sql, TipoQueryEnum tipoQuery, boolean retornoTipado) {
		this.sql = sql;
		this.tipoQuery = tipoQuery;
		this.retornoTipado = retornoTipado;
	}
	
	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	@SuppressWarnings("rawtypes")
	public List getParamsSQL() {
		checarEstadoParamsSQL();
		return paramsSQL;
	}

	@SuppressWarnings("unchecked")
	public void setParamSQL(Object paramSQL) {
		checarEstadoParamsSQL();
		this.paramsSQL.add(paramSQL);
	}
	
	private void checarEstadoParamsSQL() {
		//if (null == this.paramsSQL)
			//this.paramsSQL = new ArrayList();
		
		if (null == this.params)
		this.params = new HashMap<String, Object>();
		
	}
	
	public void limparParams() {
		checarEstadoParamsSQL();
		//this.paramsSQL.clear();
		this.params.clear();
	}

	public boolean isRetornoTipado() {
		return retornoTipado;
	}

	public void setRetornoTipado(boolean retornoTipado) {
		this.retornoTipado = retornoTipado;
	}
	
	@SuppressWarnings("rawtypes")
	public static void setParamsSQLQuery(Query q, List params) {
		for (int i = 0; i < params.size(); i++) {
			q.setParameter("p" + i, params.get(i));
		}
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public static void setParamsSQLMap(Query q, Map<String, Object> params) {
		if (params != null && params.size() > 0) {
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				q.setParameter(entry.getKey(), entry.getValue());
			}			
		}
	}

	public TipoQueryEnum getTipoQuery() {
		return tipoQuery;
	}

	public void setTipoQuery(TipoQueryEnum tipoQuery) {
		this.tipoQuery = tipoQuery;
	}

	public Integer getQtdeRegistros() {
		return qtdeRegistros;
	}

	public void setQtdeRegistros(Integer qtdeRegistros) {
		this.qtdeRegistros = qtdeRegistros;
	}
	
}
