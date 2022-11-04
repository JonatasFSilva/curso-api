package com.curso.api.services;

import java.util.List;

import com.curso.api.entities.Curso;

public interface CursoService {

	public List<Curso> getCursos();

	public Curso saveCurso(Curso curso);

	public Curso findById(Integer id);

	public Curso findByNome(String nome);

	public List<Curso> findByNomeContaining(String nome);

	public List<Curso> findByAreaContaining(String area);
}
