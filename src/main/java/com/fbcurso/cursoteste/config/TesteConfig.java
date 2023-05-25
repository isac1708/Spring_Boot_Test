package com.fbcurso.cursoteste.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fbcurso.cursoteste.entidades.Categoria;
import com.fbcurso.cursoteste.entidades.Pedido;
import com.fbcurso.cursoteste.entidades.Produto;
import com.fbcurso.cursoteste.entidades.Usuario;
import com.fbcurso.cursoteste.entidades.enunm_Pedido.StatusPedido;
import com.fbcurso.cursoteste.repositorios.RepositorioPedidos;
import com.fbcurso.cursoteste.repositorios.RepositorioProdutos;
import com.fbcurso.cursoteste.repositorios.RepositorioUsuario;
import com.fbcurso.cursoteste.repositorios.RepositorioCategoria;


@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{
    
    @Autowired 
    private RepositorioUsuario repositorioUsuario;

    @Autowired
    private RepositorioPedidos repositorioPedidos;
    
    @Autowired
    private RepositorioCategoria repositorioCategoria;

   @Autowired
   private RepositorioProdutos repositorioProdutos;

    @Override
    public void run(String... args) throws Exception {
        Usuario u1 = new Usuario(1L, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        Usuario u2 = new Usuario(2L, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Pedido o1 = new Pedido(1L, Instant.parse("2019-06-20T19:53:07Z"),StatusPedido.PAGO, u1);
        Pedido o2 = new Pedido(2L, Instant.parse("2019-07-21T03:42:10Z"), StatusPedido.AGUARDANDO_PAGAMENTO, u2);
        Pedido o3 = new Pedido(3L, Instant.parse("2019-07-22T15:21:22Z"), StatusPedido.AGUARDANDO_PAGAMENTO, u1);

        Categoria cat1 = new Categoria(1L, "Electronics");
        Categoria cat2 = new Categoria(2L, "Books");
        Categoria cat3 = new Categoria(3L, "Computers");

        Produto p1 = new Produto(1L, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Produto p2 = new Produto(2L, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Produto p3 = new Produto(3L, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Produto p4 = new Produto(4L, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Produto p5 = new Produto(5L, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");


        repositorioCategoria.saveAll(Arrays.asList(cat1,cat2,cat3));
        repositorioProdutos.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategorias().add(cat2);
        p2.getCategorias().add(cat1);
        p2.getCategorias().add(cat3);
        p3.getCategorias().add(cat3);
        p4.getCategorias().add(cat3);
        p5.getCategorias().add(cat2);

        repositorioProdutos.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
        repositorioUsuario.saveAll(Arrays.asList(u1,u2));
        repositorioPedidos.saveAll(Arrays.asList(o1,o2,o3));
        
    }
}
