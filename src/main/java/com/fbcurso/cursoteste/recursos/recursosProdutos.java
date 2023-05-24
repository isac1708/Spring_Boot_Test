package com.fbcurso.cursoteste.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fbcurso.cursoteste.entidades.Produto;
import com.fbcurso.cursoteste.servicos.ServicosProduto;

@RestController //Essa anotação indica que a classe é um controlador REST. Um controlador REST é responsável por receber solicitações HTTP e retornar respostas HTTP correspondentes.
@RequestMapping(value = "/produtos") /*Essa anotação define o mapeamento de URL base para todos os métodos dentro dessa classe de controlador.
Neste caso, qualquer solicitação que comece com "/pedidos" será direcionada para este controlador.*/
public class recursosProdutos {
    
    @Autowired /*Essa anotação é usada para injetar uma instância de uma classe em outra classe. Nesse caso, a instância de ServicosPedidos será automaticamente injetada pelo Spring no controlador.*/
    private ServicosProduto servicosProduto;
    
    @GetMapping /*Essa anotação indica que o método findAll() será invocado quando houver uma solicitação HTTP GET para o URL mapeado. 
    Neste caso, quando uma solicitação GET for feita para "/produtos", o método findAll() será chamado.*/
    public ResponseEntity<List<Produto>> findAll() {
        
        List<Produto> list = servicosProduto.findAll();
        return ResponseEntity.ok().body(list);
    }
    
    @GetMapping(value="/{id}") /* Essa anotação indica que o método findById será invocado quando houver uma solicitação HTTP GET para o URL mapeado. 
    O valor /{id} indica que o ID do pedido será passado como parte da URL, por exemplo, "/pedidos/1" para buscar o pedido com ID 1. */
    public ResponseEntity<Produto> findById(@PathVariable Long id){  /* @PathVariable Long id: Essa anotação é usada para indicar que o valor do parâmetro id vem da parte da URL que corresponde ao {id} no mapeamento. 
    O valor do ID será extraído da URL e passado para o método findById. */
        Produto obj = servicosProduto.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
