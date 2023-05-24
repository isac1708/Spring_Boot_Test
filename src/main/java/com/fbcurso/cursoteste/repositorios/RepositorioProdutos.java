package com.fbcurso.cursoteste.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fbcurso.cursoteste.entidades.Produto;

public interface RepositorioProdutos extends JpaRepository<Produto,Long>{

     
}
