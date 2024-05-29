package com.postgre.api.servico;

import java.util.List;

import com.postgre.api.dto.CategoriaDto;

public interface ServicoCategoria {
	CategoriaDto criarCategoria(CategoriaDto categoriadto);
	List<CategoriaDto> lerCategoria();
	CategoriaDto lerCategoriaId(Long Id);
	
}
