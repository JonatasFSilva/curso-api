package com.curso.api.entities.mapper;

import org.springframework.stereotype.Service;

import com.curso.api.entities.Curso;
import com.curso.api.entities.dto.CursoDTO;

@Service
public class CursoMapper {
	
	public Curso mapCursoDtoToCurso(CursoDTO dto) {
		return new Curso(dto.getNome(),dto.getArea());		
	}
}
