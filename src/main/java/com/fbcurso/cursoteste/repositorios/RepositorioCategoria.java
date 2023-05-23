package com.fbcurso.cursoteste.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fbcurso.cursoteste.entidades.Categoria;

public interface RepositorioCategoria extends JpaRepository<Categoria,Long>{

     
}
