package com.fbcurso.cursoteste.servicos;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fbcurso.cursoteste.entidades.Produto;
import com.fbcurso.cursoteste.repositorios.RepositorioProdutos;

@Service
public class ServicosProduto {
    
    @Autowired
    private RepositorioProdutos repositorioProdutos;

    public List<Produto> findAll(){

        return repositorioProdutos.findAll();
    }

    public Produto findById(Long id){
        Optional<Produto> obj = repositorioProdutos.findById(id);
        return obj.get();

    }
}
