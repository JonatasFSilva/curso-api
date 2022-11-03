package com.curso.api.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "materia")
@NoArgsConstructor
public class Materia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = true)
	private String nome;

	// MUITAS GRADES PARA MUITAS MATERIAS
	@ManyToMany
	@JoinTable(name = "grade_materia", joinColumns = {
			@JoinColumn(name = "materia_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "grade_id", referencedColumnName = "id") })
	private Set<GradeCurricular> grades = new HashSet<>();

	public Materia(String nome, Set<GradeCurricular> grades) {
		super();
		this.nome = nome;
		this.grades = grades;
	}

}
