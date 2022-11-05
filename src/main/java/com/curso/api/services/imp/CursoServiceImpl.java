package com.curso.api.services.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.api.entities.Curso;
import com.curso.api.repositories.CursoRepository;
import com.curso.api.services.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public List<Curso> getCursos() {

		return cursoRepository.findAll();
	}

	@Override
	public Curso saveCurso(Curso curso) {
		curso.setId(null);
		return cursoRepository.save(curso);
	}

	@Override
	public Curso findById(Integer id) {
		Optional<Curso> result = cursoRepository.findById(id);
		return result.orElse(null);
	}

	@Override
	public Curso findByNome(String nome) {
		Optional<Curso> result = cursoRepository.findByNome(nome);
		return result.orElse(null);
	}

	@Override
	public List<Curso> findByNomeContaining(String nome) {
		return cursoRepository.findByNomeContaining(nome);
	}

	@Override
	public List<Curso> findByAreaContaining(String area) {
		return cursoRepository.findByAreaContaining(area);
	}

	@Override
	public void updateCurso(Curso curso) {

		Curso atual = this.findById(curso.getId());

		atual.setNome(curso.getNome());
		atual.setArea(curso.getArea());

		cursoRepository.save(atual);
	}

	@Override
	public void deleteCurso(Integer id) {
		cursoRepository.deleteById(id);
	}

}
