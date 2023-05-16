package com.fbcurso.cursoteste.servicos;
 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbcurso.cursoteste.entidades.Usuario;
import com.fbcurso.cursoteste.repositorios.RepositorioUsuario;

@Service
public class ServicosUsuarios {
    
    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public List<Usuario> findAll(){

        return repositorioUsuario.findAll();
    }

    public Usuario findById(Long id){
        Optional<Usuario> obj = repositorioUsuario.findById(id);
        return obj.get();

    }
}
