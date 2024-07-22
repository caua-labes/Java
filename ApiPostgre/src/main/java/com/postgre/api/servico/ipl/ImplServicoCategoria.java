package com.postgre.api.servico.ipl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.postgre.api.dto.CategoriaDto;
import com.postgre.api.entidades.Categoria;
import com.postgre.api.excecoes.NaoEncontrado;
import com.postgre.api.mapeador.CategoriaMapeador;
import com.postgre.api.repositorio.CategoriaRepositorio;
import com.postgre.api.servico.ServicoCategoria;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImplServicoCategoria implements ServicoCategoria{
	
	private CategoriaRepositorio repositorioCategoria;
	public ImplServicoCategoria(CategoriaRepositorio repositorioCategoria) {
        this.repositorioCategoria = repositorioCategoria;
    }
	@Override
	public CategoriaDto criarCategoria(CategoriaDto categoriadto) {
		Categoria categoria = CategoriaMapeador.mapCategoria(categoriadto);
		Categoria categoriaSalva = repositorioCategoria.save(categoria);
		return CategoriaMapeador.mapCategoriaDto(categoriaSalva);
	}
	@Override
	public List<CategoriaDto> lerCategoria(){
		/*List<CategoriaDto> listaCategoriaDto = new ArrayList<CategoriaDto>();
		for(Categoria categoria : repositorioCategoria.findAll()) {
			listaCategoriaDto.add(CategoriaMapeador.mapCategoriaDto(categoria));
		};*/
		List<Categoria> listaCategoria =  repositorioCategoria.findAll();
		return listaCategoria.stream().map((categoria) -> CategoriaMapeador.mapCategoriaDto(categoria)).collect(Collectors.toList());
	}
	@Override
	public CategoriaDto lerCategoriaId(Long Id) {
		Categoria categoriaSe = repositorioCategoria.findById(Id).orElseThrow(()-> new NaoEncontrado("Categoria não encontrada!"));
		CategoriaDto categoriaSelect = CategoriaMapeador.mapCategoriaDto(categoriaSe);
		return categoriaSelect;
	}
	@Override
	public CategoriaDto alterarCategoria(Long id,CategoriaDto categoriaAtualizada) {
		Categoria categoriaAlt = repositorioCategoria.findById(id).orElseThrow(() -> new NaoEncontrado("Nenhuma categoria com este id"));
		categoriaAlt.setNome(categoriaAtualizada.getNome());
		Categoria categoriaSalva = repositorioCategoria.save(categoriaAlt);
		return CategoriaMapeador.mapCategoriaDto(categoriaSalva);
	}
	@Override
	public void deletarCategoria(Long id) {
		Categoria categoriaDel = repositorioCategoria.findById(id).orElseThrow(()-> new NaoEncontrado("Não existe nenhuma categoria com este id"));
		repositorioCategoria.deleteById(categoriaDel.getId());
		
	}
	


}
