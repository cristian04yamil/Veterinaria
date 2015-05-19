/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.apu.dao.imp.ram;

import ar.edu.unju.fi.apu.dao.IAtencionDAO;
import ar.edu.unju.fi.apu.modelo.dominio.Atencion;
import ar.edu.unju.fi.apu.modelo.dominio.Paciente;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author celso-pc
 */
public class AtencionDAOImp implements IAtencionDAO {

    @Override
    public void crearAtencion(Atencion atencion) {
        TablaAtenciones.tablaAtenciones.add(atencion);
    }

    @Override
    public void modificarAtencion(Atencion atencion) {
        for(Atencion a: TablaAtenciones.tablaAtenciones){
            if(String.valueOf(a.getAtencionID()).equals(String.valueOf(atencion.getAtencionID()))){
                TablaAtenciones.tablaAtenciones.set(TablaAtenciones.tablaAtenciones.indexOf(a), atencion);
                break;
            }
        }        
    }

    @Override
    public void eliminarAtencion(Atencion atencion) {
        for(Atencion at:obtenerTodos()){
            if (at.getAtencionID()==atencion.getAtencionID()){
                TablaAtenciones.tablaAtenciones.remove(TablaAtenciones.tablaAtenciones.indexOf(at));
                break;
            }
        }
    }

    @Override
    public List<Atencion> obtenerTodos() {
        if (TablaAtenciones.tablaAtenciones==null){
            TablaAtenciones.llenarAtenciones();
        }
        return TablaAtenciones.tablaAtenciones;
    }

    @Override
    public Atencion obtenerAtencion(int atencionID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Atencion> obtenerAlgunasAtenciones(Date fechaDesde, Date fechaHasta, Paciente paciente) {
        List<Atencion> atencionesFiltro = new ArrayList<>();
        for(Atencion unaAtencion: obtenerTodos()){
            boolean resultado=true;
            
            if ((resultado==true) && (fechaDesde != null) && (unaAtencion.getFechaAtencion()!= null)){
                if (unaAtencion.getFechaAtencion().compareTo(fechaDesde) <= -1){
                    resultado=false;
                }
            }
            
            if ((resultado==true) && (fechaHasta != null) && (unaAtencion.getFechaAtencion()!= null)){
                if (unaAtencion.getFechaAtencion().compareTo(fechaHasta) >= 1){
                    resultado=false;
                }
            }
            
            //falta comparar el paciente
            if ((resultado==true) && (paciente != null) && (unaAtencion.getPaciente() != null)){
                if (unaAtencion.getPaciente().getNumHC()!=paciente.getNumHC()){
                    resultado=false;
                }
            }
            
            if(resultado==true){
                atencionesFiltro.add(unaAtencion);
            }
        }
        return atencionesFiltro;
    }

}
