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
 * @author Fernando
 */
public class Paciente implements Serializable{
    private int pacienteID;
    private int numHC;
    private String nombre;
    private Date fechaNacimiento;
    private String especie;//felino, canino, etc
    private char sexo;
    private Propietario propietario;
    private byte[] foto;

    public Paciente(){
    }
    /**
     * 
     * @param pacienteID
     * @param numHC
     * @param nombre
     * @param fechaNacimiento
     * @param especie
     * @param sexo
     * @param propietario
     * @param foto 
     */
    public Paciente(int pacienteID, int numHC, String nombre, Date fechaNacimiento, String especie, char sexo, Propietario propietario, byte[] foto) {
        this.pacienteID = pacienteID;
        this.numHC = numHC;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.especie = especie;
        this.sexo = sexo;
        this.propietario = propietario;
        this.foto = foto;
    }
    
    

    /**
     * @return the pacienteID
     */
    public int getPacienteID() {
        return pacienteID;
    }

    /**
     * @param pacienteID the pacienteID to set
     */
    public void setPacienteID(int pacienteID) {
        this.pacienteID = pacienteID;
    }

    /**
     * @return the numHC
     */
    public int getNumHC() {
        return numHC;
    }

    /**
     * @param numHC the numHC to set
     */
    public void setNumHC(int numHC) {
        this.numHC = numHC;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the especie
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * @param especie the especie to set
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    /**
     * @return the sexo
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the propietario
     */
    public Propietario getPropietario() {
        return propietario;
    }

    /**
     * @param propietario the propietario to set
     */
    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    /**
     * @return the foto
     */
    public byte[] getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        String s="";
        if(sexo == 'M' || sexo == 'm'){
            s="MACHO";
        }else{
                s="HEMBRA";
             }
        return s;
    }
    
    public boolean getConFoto(){
        boolean resu = false;
        if(foto != null){
            resu = true;
        }
        return resu;
    }
    
}
