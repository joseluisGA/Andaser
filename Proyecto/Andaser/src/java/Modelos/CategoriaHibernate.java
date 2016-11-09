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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author minit
 */
@Entity
@Table(name="categoria", 
	uniqueConstraints = {@UniqueConstraint(columnNames="nombre" )})
public class CategoriaHibernate {
    
    private int id;
    private String nombre;
    private Set<Producto> producto = new HashSet<Producto>();
    private Set<Subcategoria> subcategoria = new HashSet<Subcategoria>();

    
    public CategoriaHibernate(){
        
    }
    
    public CategoriaHibernate(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    
    

    
    public CategoriaHibernate(int id, String nombre, Set<Producto> producto, Set<Subcategoria> subcategoria) {
        this.id = id;
        this.nombre = nombre;
        this.producto = producto;
        this.subcategoria = subcategoria;
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
 @Column(name="nombre", unique=true, nullable=false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")  
    public Set<Producto> getProducto() {
        return producto;
    }

    public void setProducto(Set<Producto> producto) {
        this.producto = producto;
    }
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")  
    public Set<Subcategoria> getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(Set<Subcategoria> subcategoria) {
        this.subcategoria = subcategoria;
    }
    
    
    
    
    
}
