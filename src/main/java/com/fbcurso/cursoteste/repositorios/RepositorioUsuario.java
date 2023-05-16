package com.fbcurso.cursoteste.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fbcurso.cursoteste.entidades.Usuario;


public interface RepositorioUsuario extends JpaRepository<Usuario,Long>{
    
}