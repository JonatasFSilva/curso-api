package com.curso.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.curso.api.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

	List<Curso> findCursoByNome(String nome);

	List<Curso> findCursoByNomeContaining(String valor);

	List<Curso> findCursoByNomeLike(String valor);

	List<Curso> findCursoByNomeLikeIgnoreCase(String valor);

	@Query(value = "Select c From Curso c")
	List<Curso> findByQueryNome();

	@Query(value = "Select nome_do_curso From Curso where area = 'Exatas'", nativeQuery = true)
	List<String> findByQueryNomePorArea();

	@Query(value = "Select nome_do_curso From Curso where area = :area", nativeQuery = true)
	List<String> findByQueryNomePorAreaInformada(@Param("area") String area);

	@Query(value = "Select nome_do_curso From Curso where area = :area AND nome_do_curso = :nome", nativeQuery = true)
	List<String> findByQueryNomePorAreaInformadaCurso(@Param("area") String are, @Param("nome") String nome);

	@Query(value = "Select nome_do_curso From Curso where area = ?1 AND nome_do_curso = ?2", nativeQuery = true)
	List<String> findByQueryPorParamentros(String area, String curso);

}
