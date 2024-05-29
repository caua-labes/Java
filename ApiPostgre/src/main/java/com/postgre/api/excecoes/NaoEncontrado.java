package com.postgre.api.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NaoEncontrado extends RuntimeException{

	public NaoEncontrado(String mensagem) {
		super(mensagem);
	}

}
