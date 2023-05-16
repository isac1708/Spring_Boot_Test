package com.fbcurso.cursoteste.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fbcurso.cursoteste.entidades.Usuario;
import com.fbcurso.cursoteste.servicos.ServicosUsuarios;




@RestController
@RequestMapping(value = "/users")
public class recursosUsuarios {
    
    @Autowired
    private ServicosUsuarios servicosUsuarios;
    
    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        
        List<Usuario> list = servicosUsuarios.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        Usuario obj = servicosUsuarios.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
