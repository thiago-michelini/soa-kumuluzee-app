package org.kumuluzee.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ESTADO_TREINAMENTO")
@SequenceGenerator(name = "ESTADO_TREINAMENTO_SEQ_ID", sequenceName = "ESTADO_TREINAMENTO_SEQ_ID", allocationSize = 1)
@XmlRootElement
public class EstadoTreinamento extends EntidadeBase {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ESTADO_TREINAMENTO_SEQ_ID")
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String sigla;
	
	@Version
	@Column(name = "VERSAO_REGISTRO")
	private Integer versaoRegistro;
	
	@Column(name = "USUARIO_ACAO")
	private Long usuarioAcao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Integer getVersaoRegistro() {
		return versaoRegistro;
	}

	public void setVersaoRegistro(Integer versaoRegistro) {
		this.versaoRegistro = versaoRegistro;
	}

	public Long getUsuarioAcao() {
		return usuarioAcao;
	}

	public void setUsuarioAcao(Long usuarioAcao) {
		this.usuarioAcao = usuarioAcao;
	}
	
}
