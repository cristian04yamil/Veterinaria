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
public class Atencion implements Serializable{
    private int atencionID;
    private Paciente paciente;
    private Date fechaAtencion;
    private Usuario usuario;
    private String diagnostico;
    private String observaciones;

    public Atencion() {
    }

    public Atencion(int atencionID, Paciente paciente, Date fechaAtencion, Usuario usuario, String diagnostico, String observaciones) {
        this.atencionID = atencionID;
        this.paciente = paciente;
        this.fechaAtencion = fechaAtencion;
        this.usuario = usuario;
        this.diagnostico = diagnostico;
        this.observaciones = observaciones;
    }
    
    public int getAtencionID() {
        return atencionID;
    }

    public void setAtencionID(int atencionID) {
        this.atencionID = atencionID;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(Date fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
