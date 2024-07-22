package com.postgre.api.mapeador;

import com.postgre.api.dto.CategoriaDto;
import com.postgre.api.entidades.Categoria;

public class CategoriaMapeador {

	public static CategoriaDto mapCategoriaDto(Categoria categoria) {
		return new CategoriaDto(
				categoria.getId(),
				categoria.getNome()
				);
		
	}
	public static Categoria mapCategoria(CategoriaDto categoriaDto) {
		return new Categoria(
				categoriaDto.getId(),
				categoriaDto.getNome()
				);
	}

	//https://www.youtube.com/watch?v=v1IFQWzuSrw
}
