/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.apu.dao;

import ar.edu.unju.fi.apu.modelo.dominio.Atencion;
import ar.edu.unju.fi.apu.modelo.dominio.Paciente;
import java.util.Date;
import java.util.List;

/**
 *
 * @author celso-pc
 */
public interface IAtencionDAO {

    void crearAtencion(Atencion atencion);

    void modificarAtencion(Atencion atencion);

    void eliminarAtencion(Atencion atencion);

    List<Atencion> obtenerTodos();

    Atencion obtenerAtencion(int atencionID);
    
    public List<Atencion> obtenerAlgunasAtenciones (Date fechaDesde, Date fechaHasta, Paciente paciente);
}
