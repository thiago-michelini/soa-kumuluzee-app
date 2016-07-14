package org.kumuluzee.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.kumuluzee.datatypeadapter.LocalDateAdapter;
import org.kumuluzee.datatypeadapter.LocalDateTimeAdapter;

@XmlRootElement
public class Cliente {
	
	@XmlElement(type = String.class)
	@XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
	private LocalDateTime dataHoraRequisicao;

	private Long id;
	
	private String nome;
	
	@XmlElement(type = String.class)
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	private LocalDate nascimento;
	
	private Integer idade;
	
	private Double renda;

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

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Double getRenda() {
		return renda;
	}

	public void setRenda(Double renda) {
		this.renda = renda;
	}

	public LocalDateTime getDataHoraRequisicao() {
		return dataHoraRequisicao;
	}

	public void setDataHoraRequisicao(LocalDateTime dataHoraRequisicao) {
		this.dataHoraRequisicao = dataHoraRequisicao;
	}
	
}
