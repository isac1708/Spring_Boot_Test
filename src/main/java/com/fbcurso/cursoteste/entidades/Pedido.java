package com.fbcurso.cursoteste.entidades;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fbcurso.cursoteste.entidades.enunm_Pedido.StatusPedido;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_order")
public class Pedido implements Serializable {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd 'T'HH:mm:ss'Z'", timezone = "GMT" )
    private Instant momento;

    

    private int statusPedido;


    @ManyToOne /*Essa anotação é usada para definir uma relação de muitos-para-um entre duas entidades. Ela indica que várias instâncias da entidade atual podem estar associadas a uma única instância da entidade referenciada. */
    @JoinColumn(name="cliente_id") /* Essa anotação é usada para especificar a coluna de chave estrangeira na tabela do banco de dados que representa a relação.
     Nesse caso, ela indica que a coluna "cliente_id" na tabela será usada como chave estrangeira para estabelecer a associação entre a entidade atual e a entidade "Usuario". */
    private Usuario cliente;


    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pedido other = (Pedido) obj;
        if (id != other.id)
            return false;
        return true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }
    public StatusPedido getStatusPedido() {
        return StatusPedido.valueOf(statusPedido);
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        if(statusPedido != null){
        this.statusPedido = statusPedido.getCode();}
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Pedido(long id, Instant momento, StatusPedido statusPedido, Usuario cliente) {
        this.id = id;
        this.momento = momento;
        setStatusPedido(statusPedido);
        this.cliente = cliente;
    }

    public Pedido() {
    }

}
