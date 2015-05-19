/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.apu.controlador.beans;

import ar.edu.unju.fi.apu.modelo.dominio.Paciente;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author Fernando
 */
@ManagedBean
@SessionScoped
public class PacienteBean implements Serializable{
    
    private Paciente paciente;
    
    public PacienteBean() {
        paciente = new Paciente();
    }

    /**
     * @return the paciente
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    
}
