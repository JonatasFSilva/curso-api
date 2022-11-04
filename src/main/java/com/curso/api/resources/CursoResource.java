package com.curso.api.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.api.entities.Curso;
import com.curso.api.entities.dto.CursoDTO;
import com.curso.api.entities.mapper.CursoMapper;
import com.curso.api.services.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoResource {

	@Autowired
	private CursoService cursoService;

	@Autowired
	private CursoMapper mapper;

	// METODOS GETS

	@GetMapping // BUSCA UMA LISTA COM TODAS AS ENTIDADES
	public ResponseEntity<List<Curso>> getCursos() {
		// CRIA UMA LISTA COM TODAS AS ENTIDADES DA TABELA DO DB APONTADA
		List<Curso> listAllCursos = cursoService.getCursos();
		// RETORNA A LISTA COM O CONTEUDO E MENSAGEM HTTP 200
		return ResponseEntity.ok().body(listAllCursos);
	}

	@GetMapping("/{id}") // BUSCA PELO ID DA ENTIDADE
	public ResponseEntity<Curso> findCursoById(@PathVariable Integer id) {
		Curso findCurso = cursoService.findById(id);
		return ResponseEntity.ok().body(findCurso); // RETORNA A ENTIDADE COM O CONTEUDO E MENSAGEM HTTP 200
	}

	@GetMapping("/nome/{nome}") // BUSCA PELO NOME DA ENTIDADE
	public ResponseEntity<Curso> findCursoByNome(@PathVariable String nome) {
		Curso findCurso = cursoService.findByNome(nome);
		return ResponseEntity.ok().body(findCurso);// RETORNA A ENTIDADE COM O CONTEUDO E MENSAGEM HTTP 200
	}

	@GetMapping("/nome")
	public ResponseEntity<List<Curso>> findCursoByNomeContendo(@RequestParam String nome) {
		List<Curso> findCursos = cursoService.findByNomeContaining(nome);
		return ResponseEntity.ok().body(findCursos);
	}
	
	@GetMapping("/area/{area}")
	public ResponseEntity<List<Curso>> findCursoByAreaContendo(@PathVariable String area){
		List<Curso> findArea = cursoService.findByAreaContaining(area);
		return ResponseEntity.ok().body(findArea);
	}

	// METODOS POST

	@PostMapping // SALVA UM OBJETO DTO NO BANCO DE DADOS
	public ResponseEntity<Curso> saveCurso(@Valid @RequestBody CursoDTO dto) throws URISyntaxException {

		// CRIA UMA ENTIDADE QUE POSSUE OS CAMPOS DO BD, MAS RECEBENDO SOMENTE OS
		// PARAMETROS QUE O OBJETO DTO QUER MANDAR PRO BANCO
		// NECESSITANDO ASSIM REALIZAR UMA CONVERSAO DO OBJETO DTO PARA O TIPO ENTIDADE
		// PARA QUE A INFORMACAO POSSA IR PRO BANCO DE DADOS DE FORMA QUE O SISTEMA
		// ENTENDA COM UM DADO DO TIPO ENTIDADE
		Curso newCurso = cursoService.saveCurso(mapper.mapCursoDtoToCurso(dto));
		return ResponseEntity.created(new URI("/cursos/" + newCurso.getId())).body(newCurso);
	}
}
