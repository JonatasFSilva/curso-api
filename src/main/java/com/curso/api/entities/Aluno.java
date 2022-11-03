package com.curso.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String nome;

	// MUITOS ALUNOS PARA UM CURSO
	@ManyToOne
	@JoinColumn(name = "curso_id") // COLUNA DA CHAVE ESTRANGEIRA DA ENTITY CURSO
	private Curso curso;

	public Aluno(String nome, Curso curso) {
		super();
		this.nome = nome;
		this.curso = curso;
	}

	// GETTERS E SETTERS CRIADOS AUTOMATICAMENTE PELO LOMBOK COM O @Data

}
