package com.fbcurso.cursoteste.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fbcurso.cursoteste.entidades.Categoria;
import com.fbcurso.cursoteste.entidades.Pedido;
import com.fbcurso.cursoteste.entidades.Usuario;
import com.fbcurso.cursoteste.entidades.enunm_Pedido.StatusPedido;
import com.fbcurso.cursoteste.repositorios.RepositorioPedidos;
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

        repositorioUsuario.saveAll(Arrays.asList(u1,u2));
        repositorioPedidos.saveAll(Arrays.asList(o1,o2,o3));
        repositorioCategoria.saveAll(Arrays.asList(cat1,cat2,cat3));

    }
}
