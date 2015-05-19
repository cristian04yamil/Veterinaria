/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.apu.modelo.dominio;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author celso-pc
 */
public class Propietario extends Persona implements Serializable{
    private String direccion;
    private String telefono;

    public Propietario() {
    }

    public Propietario(String direccion, String telefono, String dni, String apellido, String nombre, Date fechaNacimiento, boolean estado) {
        super(dni, apellido, nombre, fechaNacimiento, estado);
        this.direccion = direccion;
        this.telefono = telefono;
    }



    
    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
