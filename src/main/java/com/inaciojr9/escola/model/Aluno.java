package com.inaciojr9.escola.model;

public class Aluno {

	private final Long id;
	private final String nome;
	
	public Aluno(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	
	
}
