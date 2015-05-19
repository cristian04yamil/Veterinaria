/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.apu.dao.imp.ram;

import ar.edu.unju.fi.apu.dao.IPacienteDAO;
import ar.edu.unju.fi.apu.modelo.dominio.Paciente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class PacienteDAOImp implements IPacienteDAO{

    @Override
    public void crearPaciente(Paciente paciente) {
        TablaPaciente.pacientes.add(paciente);
    }

    @Override
    public void modificarPaciente(Paciente paciente) {
        for (Paciente pa : TablaPaciente.pacientes) {
            if(pa.getNumHC() == paciente.getNumHC()){
                TablaPaciente.pacientes.set(TablaPaciente.pacientes.indexOf(pa), paciente);
                break;
            }
        }
    }

    @Override
    public void eliminarPaciente(Paciente paciente) {
        for (Paciente pa : TablaPaciente.pacientes) {
            if(pa.getNumHC() == paciente.getNumHC()){
                TablaPaciente.pacientes.remove(TablaPaciente.pacientes.indexOf(pa));
                break;
            }
        }
    }

    @Override
    public List<Paciente> obtenerTodos() {
       List<Paciente> pts = new ArrayList<>();
       
           for (Paciente p : TablaPaciente.pacientes) {
               pts.add(p);
           }
       
        return pts;
    }

    @Override
    public Paciente obtenerPaciente(int numHC) {
        Paciente unPaciente = new Paciente();
        for (Paciente p : TablaPaciente.pacientes) {
            if(p.getNumHC() == numHC){
                unPaciente = p;
            }
        }
        return unPaciente;
    }
    
}
