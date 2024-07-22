package com.postgre.api.servico.ipl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.postgre.api.dto.ProdutoDto;
import com.postgre.api.entidades.Produto;
import com.postgre.api.excecoes.NaoEncontrado;
import com.postgre.api.mapeador.ProdutoMapeador;
import com.postgre.api.repositorio.ProdutoRepositorio;
import com.postgre.api.servico.ServicoProduto;

@Service
public class ImplServicoProduto implements ServicoProduto{

	private ProdutoRepositorio repositorioProduto;
	public ImplServicoProduto(ProdutoRepositorio repositorio) {
		this.repositorioProduto = repositorio;
	}
	@Override
	public ProdutoDto criarProduto(ProdutoDto produtoDto) {
		return ProdutoMapeador.mapProdutoDto(repositorioProduto.save(ProdutoMapeador.mapProduto(produtoDto)));
	}

	@Override
	public List<ProdutoDto> lerProdutos() {
		List<Produto> listaProdutos = repositorioProduto.findAll();
		return listaProdutos.stream().map(produto ->ProdutoMapeador.mapProdutoDto(produto)).collect(Collectors.toList());
	}

	@Override
	public ProdutoDto lerProdutoId(Long id) {
		return ProdutoMapeador.mapProdutoDto(repositorioProduto.findById(id).orElseThrow(()-> new NaoEncontrado("Produto não encontrado!")));
	}

	@Override
	public ProdutoDto alterarProduto(ProdutoDto produtoDto) {
		return ProdutoMapeador.mapProdutoDto(repositorioProduto.save(ProdutoMapeador.mapProduto(produtoDto)));
	}

	@Override
	public void deletarProduto(Long id) {
		lerProdutoId(id);
		repositorioProduto.deleteById(id);
		
	}
	
}
