/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="producto", 
	uniqueConstraints = {@UniqueConstraint(columnNames="nombre" )})
public class Producto {
    
    private String REF;
    private String nombre;
    private String descripcion;
    private Categoria categoria;
    private Subcategoria id_subcategoria;
    private int precio1;
    private int precio2;
    private int precio3;
    private String ficha;
    private String imagen;
    private Set<Caracteristica> caracteristica = new HashSet<Caracteristica>();

    public Producto(String REF, String nombre, String descripcion, String envase, String endurecedor, String ficha, Categoria id_categoria, Subcategoria id_subcategoria, Set<Caracteristica> caracteristica, int precio1, int precio2, int precio3, String imagen) {
        this.REF = REF;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = id_categoria;
        this.id_subcategoria = id_subcategoria;
        this.precio1 = precio1;
        this.precio2 = precio2;
        this.precio3 = precio3;
       
        this.ficha = ficha;
        this.imagen = imagen;
        this.caracteristica = caracteristica;
    }

    
    @Id
    @Column(name="REF",unique=true, nullable=false)
    public String getREF() {
        return REF;
    }

    public void setREF(String REF) {
        this.REF = REF;
    }
    @Column(name="nombre", unique=true, nullable=false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Column(name="descripcion", nullable=true)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
 @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categoria", nullable = false)
    public Categoria getCategoria() {
        return categoria;
    }
   
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
     @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_subcategoria", nullable = false)
    public Subcategoria getId_subcategoria() {
        return id_subcategoria;
    }

    public void setId_subcategoria(Subcategoria id_subcategoria) {
        this.id_subcategoria = id_subcategoria;
    }
    
     @Column(name="precio1", nullable=true)
    public int getPrecio1() {
        return precio1;
    }

    public void setPrecio1(int precio1) {
        this.precio1 = precio1;
    }
 @Column(name="precio2", nullable=true)
    public int getPrecio2() {
        return precio2;
    }

    public void setPrecio2(int precio2) {
        this.precio2 = precio2;
    }
 @Column(name="precio3", nullable=true)
    public int getPrecio3() {
        return precio3;
    }

    public void setPrecio3(int precio3) {
        this.precio3 = precio3;
    }
 
 @Column(name="ficha", nullable=true)
    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }
   
 @Column(name="imagen", nullable=true)
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
@OneToMany (fetch=FetchType.LAZY, mappedBy="producto", cascade=CascadeType.ALL)
    public Set<Caracteristica> getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(Set<Caracteristica> caracteristica) {
        this.caracteristica = caracteristica;
    }
    
    
}
