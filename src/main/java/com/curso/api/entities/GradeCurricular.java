package com.curso.api.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "grade")
@NoArgsConstructor
public class GradeCurricular implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = true)
	private String objetivo;

	// UMA GRADE PRA UM ALUNO, USANDO O ID DO ALUNO COMO CHAVE ESTRANGEIRA
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aluno_id", referencedColumnName = "id")
	private Aluno aluno;

	// MUITAS MATERIAS PARA MUITAS GRADES
	@ManyToMany(mappedBy = "grades")
	private Set<Materia> materias = new HashSet<>();

	public GradeCurricular(String objetivo, Aluno aluno) {
		super();
		this.objetivo = objetivo;
		this.aluno = aluno;
	}

}
