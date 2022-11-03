package com.curso.api.entities.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	// VERIFICA SE O CAMPO E NULO
	@NotNull(message = "nao pode ser nulo")
	// VERIFICA SE O CAMPO E VAZIO, ESPACO CONTA COMO CARACTER
	@NotEmpty(message = "nao pode ser vazio")
	@NotBlank(message = "nao pode estar em branco, vazio ou nulo")
	@Size(min = 5, max = 20, message = "o tamanho deve ser entre 5 e 20")
	private String nome;
	// VERIFICA SE E NULO, BRANCO, OU SE TEM SOMENTE ESPACOS
	@NotBlank(message = "nao pode estar em branco, vazio ou nulo")
	private String area;

}
