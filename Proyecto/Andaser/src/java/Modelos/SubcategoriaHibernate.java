/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author minit
 */
@Entity
@Table(name="subcategoria", 
	uniqueConstraints = {@UniqueConstraint(columnNames="nombre" )})
public class SubcategoriaHibernate {
    private int id;
    private Categoria categoria;
    private String nombreSubCat;
    private Set<Producto> producto = new HashSet<Producto>();
 
    
    public SubcategoriaHibernate(){
        
    }
    public SubcategoriaHibernate(int id, Categoria categoria, String nombre, Set<Producto> producto) {
        this.id = id;
        this.categoria = categoria;
        this.producto = producto;
        this.nombreSubCat = nombre;
        
    }
   
@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categoria", nullable = false)
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
 @OneToMany(fetch = FetchType.LAZY, mappedBy = "id_subcategoria")  
    public Set<Producto> getProducto() {
        return producto;
    }

    public void setProducto(Set<Producto> producto) {
        this.producto = producto;
    }

    
 @Column(name="nombre", unique=true, nullable=false)
    public String getNombreSubCat() {
        return nombreSubCat;
    }

    public void setNombreSubCat(String nombre) {
        this.nombreSubCat = nombre;
    }
    
    
}
