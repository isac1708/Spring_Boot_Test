package com.fbcurso.cursoteste.servicos;
 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbcurso.cursoteste.entidades.Pedido;
import com.fbcurso.cursoteste.repositorios.RepositorioPedidos;

@Service
public class ServicosPedidos {
    
    @Autowired
    private RepositorioPedidos repositorioPedido;

    public List<Pedido> findAll(){

        return repositorioPedido.findAll();
    }

    public Pedido findById(Long id){
        Optional<Pedido> obj = repositorioPedido.findById(id);
        return obj.get();

    }
}
