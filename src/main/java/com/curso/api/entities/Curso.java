package com.curso.api.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "curso")
@Data
@NoArgsConstructor
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nome_do_curso", nullable = false)
	private String nome;

	@Column(nullable = false)
	private String area;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@CreationTimestamp
	@Column(name = "data_de_criacao")
	private LocalDateTime datadeCriacao;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@UpdateTimestamp
	@Column(name = "data_de_atualizacao")
	private LocalDateTime dataDeAtualizacao;

	@NotNull(message = "nome do usuario nao pode ser nulo")
	@NotBlank(message = "nome do usuario nao pode estar vazio")
	private String usuario;

	// PROPRIEDADE NAO SERA PERSISTIDA NO BANCO DE DADOS (NAO VAI APARECER NO BANDO
	// DE DADOS)
	@Transient
	private BigDecimal valorDoCurso;

	// UM CURSO PARA MUITOS ALUNOS
	// UMA LISTA COM VARIOS ALUNOS POR CURSO
	@OneToMany(mappedBy = "curso") // NOME DA PROPRIEADE QUE IRA RECEBER O RELACIONAMENTO NA ENTITY ALUNO
	private List<Aluno> alunos = new ArrayList<>();

	// METODO UTILIZADO NO MOMDENTO DA CRIACAO DO OBJETO
	@PostPersist
	private void aposPersistirDados() {
		this.nome = this.nome + " POST";
	}

	// METODO UTILIZADO ANTES DA CRIACAO DO OBJETO
	@PrePersist
	private void antesDePersistirDados() {
		this.usuario = "Admin";
	}

	public Curso(String nome, String area) {
		super();
		this.nome = nome;
		this.area = area;
	}

	// GETTERS E SETTERS CRIADOS AUTOMATICAMENTE PELO LOMBOK COM O @Data

}
