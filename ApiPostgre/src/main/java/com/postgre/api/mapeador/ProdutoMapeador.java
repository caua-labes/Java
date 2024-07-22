package com.postgre.api.mapeador;

import com.postgre.api.dto.ProdutoDto;
import com.postgre.api.entidades.Produto;

public class ProdutoMapeador {
	
	public static ProdutoDto mapProdutoDto(Produto produto) {
		return new ProdutoDto(
				produto.getId(),
				produto.getDescricao(),
				produto.getQuantidade(),
				produto.getValor(),
				produto.getCategoria()
				);
	}
	
	public static Produto mapProduto(ProdutoDto produtoDto) {
		return new Produto(
				produtoDto.getId(),
				produtoDto.getDescricao(),
				produtoDto.getQuantidade(),
				produtoDto.getValor(),
				produtoDto.getCategoria());
	}
}
