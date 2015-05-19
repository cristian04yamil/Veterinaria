/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.apu.dao;

import ar.edu.unju.fi.apu.modelo.dominio.Paciente;
import java.util.List;

/**
 *
 * @author Fernando
 */
public interface IPacienteDAO {
    
    void crearPaciente(Paciente paciente);
    void modificarPaciente(Paciente paciente);
    void eliminarPaciente(Paciente paciente);
    List<Paciente> obtenerTodos();
    Paciente obtenerPaciente(int numHC);
    
}
