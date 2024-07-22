package com.postgre.api.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postgre.api.dto.ProdutoDto;
import com.postgre.api.servico.ServicoProduto;

@RestController
@RequestMapping("api/produtos")
public class ProdutoControlador {
	private ServicoProduto servicoProduto;
	
	public ProdutoControlador(ServicoProduto servico) {
		this.servicoProduto = servico;
	}
	
	@GetMapping
	public ResponseEntity<List<ProdutoDto>> getProduto(){
		List<ProdutoDto> listaProdutos = servicoProduto.lerProdutos();
		return new ResponseEntity<>(listaProdutos, HttpStatus.OK);
	}
}
