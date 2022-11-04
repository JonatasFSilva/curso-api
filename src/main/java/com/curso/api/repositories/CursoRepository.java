package com.curso.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.api.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

	Optional<Curso> findByNome(String nome);

	List<Curso> findByNomeContaining(String nome);

	List<Curso> findByAreaContaining(String area);



}
