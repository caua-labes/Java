package com.postgre.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.postgre.api.entidades.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

}
