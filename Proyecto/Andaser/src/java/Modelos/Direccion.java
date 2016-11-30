/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author minit
 */
public class Direccion {
    private String calle, poblacion, provincia, pais;
    private int cp, tlfn1, tlfn2;

    public Direccion(String calle, String poblacion, String provincia, String pais, int cp, int tlfn1) {
        this.calle = calle;
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.pais = pais;
        this.cp = cp;
        this.tlfn1 = tlfn1;
    }

    public Direccion(String calle, String poblacion, String provincia, String pais, int cp, int tlfn1, int tlfn2) {
        this.calle = calle;
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.pais = pais;
        this.cp = cp;
        this.tlfn1 = tlfn1;
        this.tlfn2 = tlfn2;
    }

    
    
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getTlfn1() {
        return tlfn1;
    }

    public void setTlfn1(int tlfn1) {
        this.tlfn1 = tlfn1;
    }

    public int getTlfn2() {
        return tlfn2;
    }

    public void setTlfn2(int tlfn2) {
        this.tlfn2 = tlfn2;
    }
    
    
    
}
