/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.apu.controlador.beans;

import ar.edu.unju.fi.apu.modelo.dominio.Propietario;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author celso-pc
 */
@ManagedBean
@ViewScoped
public class PropietarioBean implements Serializable{
    public Propietario propietario;

    /**
     * Creates a new instance of PropietarioBean
     */
    public PropietarioBean() {
        propietario = new Propietario();
        
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
    
}
