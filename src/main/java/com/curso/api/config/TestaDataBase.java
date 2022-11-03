package com.curso.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.curso.api.entities.Curso;
import com.curso.api.repositories.CursoRepository;

@Component
@Profile(value = "test")
public class TestaDataBase implements CommandLineRunner {

	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public void run(String... args) throws Exception {
		Curso curso1 = new Curso("Graduação em Ti", "Exatas");
		Curso curso2 = new Curso("Graduação em Economia", "Humanas");
		Curso curso3 = new Curso("Graduação em Administracao", "Humanas");
		Curso curso4 = new Curso("Graduação em Educação Fisica", "Humanas");
		Curso curso5 = new Curso("Graduação em Educação Continuada", "Humanas");
		Curso curso6 = new Curso("Graduação em Fisica", "Exatas");

		// INSERT OU *UPDATE (SOMENTE SE FOR UM OBJETO INSTANCIADO?)
		cursoRepository.save(curso1);
		cursoRepository.save(curso2);
		cursoRepository.save(curso3);
		cursoRepository.save(curso4);
		cursoRepository.save(curso5);
		cursoRepository.save(curso6);

	}
}