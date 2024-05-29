package com.postgre.api.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postgre.api.dto.CategoriaDto;
import com.postgre.api.servico.ServicoCategoria;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/categorias")
@AllArgsConstructor
public class CategoriaControlador {
    private final ServicoCategoria servicocategoria;
    public CategoriaControlador(ServicoCategoria servicocategoria) {
        this.servicocategoria = servicocategoria;
    }
    @PostMapping
    public ResponseEntity<CategoriaDto> criarCategoria(@RequestBody CategoriaDto categoriaDto){
        CategoriaDto categoriaSalva = servicocategoria.criarCategoria(categoriaDto);
        return new ResponseEntity<>(categoriaSalva, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<CategoriaDto>> lerCategorias(){
    	List<CategoriaDto> listaCategorias = servicocategoria.lerCategoria();
    	//return ResponseEntity.ok(listaCategorias); -> outra possibilidade
    	return new ResponseEntity<>(listaCategorias,HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<CategoriaDto> lerCategoriaId(@PathVariable("id") Long categoriaid){
    	CategoriaDto categoriaEncontrada = servicocategoria.lerCategoriaId(categoriaid);
    	return new ResponseEntity<>(categoriaEncontrada, HttpStatus.FOUND);
    }
}
