/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.apu.controlador.beans;

import ar.edu.unju.fi.apu.modelo.dominio.Atencion;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author celso-pc
 */
@ManagedBean
@SessionScoped
public class AtencionBean{

    private Atencion atencion;
    /**
     * Creates a new instance of AtencionBean
     */
    public AtencionBean() {
        atencion=new Atencion();
    }

    public Atencion getAtencion() {
        return atencion;
    }

    public void setAtencion(Atencion atencion) {
        this.atencion = atencion;
    }
    
}
