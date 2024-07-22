package com.postgre.api.servico;

import java.util.List;

import com.postgre.api.dto.ProdutoDto;

public interface ServicoProduto {
	ProdutoDto criarProduto(ProdutoDto produtoDto);
	List<ProdutoDto> lerProdutos();
	ProdutoDto lerProdutoId(Long id);
	ProdutoDto alterarProduto(ProdutoDto produtoDto);
	void deletarProduto(Long id);
}
