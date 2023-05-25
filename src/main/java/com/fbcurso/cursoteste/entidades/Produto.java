package com.fbcurso.cursoteste.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_produto")
public class Produto implements Serializable {

    


    private static final long serialVersionUID=1L; 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String descricao;
    private double price;
    private String imgUrl;
    
   @ManyToMany @Fetch(FetchMode.JOIN)
   @JoinTable(name="tb_product_category",                    /* @JoinTable utilizada para especificar a tabela intermediária que sera criada no banco para representar essa relação muitos para muitos*/
   joinColumns=@JoinColumn(name = "product_id"),             /* especificar a coluna na tabela intermediária que faz refÊrencia a entidade "Produto" na relação muitos para muitos   */
   inverseJoinColumns = @JoinColumn(name="category_id"))     /* a coluna "category_id" na tabela intermediária será utilizada para armazenar as chaves estrangeiras das categorias dos produtos e faz a ligação entre produtos e categorias na relação muitos para muitos  */
   private Set<Categoria> categorias= new  HashSet<>();      /* no conjunto Set do objeto Categoria essa variavel representa a associação entre os produtos e as categorias e será mapeada pela tabela intermediaria */
    
    public Produto(long id, String nome, String descricao, double price, String imgUrl) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.price = price;
        this.imgUrl = imgUrl;
    }
    public Produto() {
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    
   
    public Set<Categoria> getCategorias() {
        return categorias;
    }

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
        Produto other = (Produto) obj;
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
    public String getNome() {
        return nome;
    }
    

    public void setNome(String nome) {
        this.nome = nome;
    }
   
    }


    

