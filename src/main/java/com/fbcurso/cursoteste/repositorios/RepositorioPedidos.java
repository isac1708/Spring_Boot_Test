package com.fbcurso.cursoteste.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fbcurso.cursoteste.entidades.Pedido;
;

public interface RepositorioPedidos extends JpaRepository<Pedido,Long>{

     
}
