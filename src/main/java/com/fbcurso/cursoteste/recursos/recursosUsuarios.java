package com.fbcurso.cursoteste.recursos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fbcurso.cursoteste.entidades.Usuario;




@RestController
@RequestMapping(value = "/users")
public class recursosUsuarios {
    
    @GetMapping
    public ResponseEntity<Usuario> findAll() {
        
        Usuario usuario = new Usuario(1L, "isac", "isac.figueredo@gmail.com", "965411728", "12345");
        return ResponseEntity.ok().body(usuario);
    }
}
