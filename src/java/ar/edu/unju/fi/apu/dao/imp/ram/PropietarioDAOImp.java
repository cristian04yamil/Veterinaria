/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.apu.dao.imp.ram;

import ar.edu.unju.fi.apu.dao.IPropietarioDAO;
import ar.edu.unju.fi.apu.modelo.dominio.Propietario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author celso-pc
 */
public class PropietarioDAOImp implements IPropietarioDAO{

    @Override
    public void crearPropietario(Propietario propietario) {
        propietario.setEstado(true);
        TablaPropietario.tablaPropietario.add(propietario);
    }

    @Override
    public void modificarPropietario(Propietario propietario) {
        for(Propietario p: TablaPropietario.tablaPropietario){
            if(p.getDni().equals(propietario.getDni())){
                TablaPropietario.tablaPropietario.set(TablaPropietario.tablaPropietario.indexOf(p), propietario);
                break;
            }
        }
    }

    @Override
    public List<Propietario> obtenerTodos() {
        List<Propietario> propietarios = new ArrayList<>();
        for (Propietario p:TablaPropietario.tablaPropietario) {
            if (p.isEstado()==true){
                propietarios.add(p);
            }
        }
        return propietarios;
    }
    
}
