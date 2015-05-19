/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.apu.dao;

import ar.edu.unju.fi.apu.modelo.dominio.Propietario;
import java.util.List;

/**
 *
 * @author celso-pc
 */
public interface IPropietarioDAO {
    
    void crearPropietario(Propietario propietario);
    void modificarPropietario(Propietario propietario);
    List<Propietario> obtenerTodos();
}
