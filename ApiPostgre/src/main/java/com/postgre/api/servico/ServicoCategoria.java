package com.postgre.api.servico;

import java.util.List;

import com.postgre.api.dto.CategoriaDto;

public interface ServicoCategoria {
	CategoriaDto criarCategoria(CategoriaDto categoriadto);
	List<CategoriaDto> lerCategoria();
	CategoriaDto lerCategoriaId(Long Id);
	CategoriaDto alterarCategoria(Long id,CategoriaDto categoriaDto);
	void deletarCategoria(Long id);
	
}
