/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="caracteristica", 
	uniqueConstraints = {@UniqueConstraint(columnNames="nombre" )})
public class Caracteristica {
    private int id;
    private String nombre;
    private String contenido;
    private Producto producto;

    public Caracteristica(int id, String nombre, String contenido, Producto producto) {
        this.id = id;
        this.nombre = nombre;
        this.contenido = contenido;
        this.producto = producto;
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
@Column(name="contenido", nullable=false)
    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REF", nullable = false)
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    
    
    
    
}

