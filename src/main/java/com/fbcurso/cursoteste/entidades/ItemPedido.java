package com.fbcurso.cursoteste.entidades;

import java.io.Serializable;

import com.fbcurso.cursoteste.entidades.pk.ItemPedidoPk;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name= "tb_pedido_item")
public class ItemPedido implements Serializable {
    private static final long serialVersionUID=1L; 

@EmbeddedId
private ItemPedidoPk id;

private int quantidade;
private Double preco;



@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
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
    ItemPedido other = (ItemPedido) obj;
    if (id == null) {
        if (other.id != null)
            return false;
    } else if (!id.equals(other.id))
        return false;
    return true;
}

public int getQuantidade() {
    return quantidade;
}

public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
}

public Double getPreco() {
    return preco;
}

public void setPreco(Double preco) {
    this.preco = preco;
}

public ItemPedido() {
}

public ItemPedido(Pedido pedido, Produto produto,  int quantidade, Double preco) {
    super();
    id.setPedido(pedido);
    id.setProduto(produto);
    this.quantidade = quantidade;
    this.preco = preco;

}

public Pedido getPedido(){
    return id.getPedido();
}

public void setPedido(Pedido pedido){
    id.setPedido(pedido);
}


public Produto getProduto(){
    return id.getProduto();
}

public void setProduto(Produto produto){
    id.setProduto(produto);
}




}
