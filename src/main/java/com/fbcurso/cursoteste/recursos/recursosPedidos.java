package com.fbcurso.cursoteste.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fbcurso.cursoteste.entidades.Pedido;
import com.fbcurso.cursoteste.servicos.ServicosPedidos;

@RestController
@RequestMapping(value = "/pedidos")
public class recursosPedidos {
    
    @Autowired
    private ServicosPedidos servicosPedidos;
    
    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        
        List<Pedido> list = servicosPedidos.findAll();
        return ResponseEntity.ok().body(list);
    }
    
    @GetMapping(value="/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id){
        Pedido obj = servicosPedidos.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
