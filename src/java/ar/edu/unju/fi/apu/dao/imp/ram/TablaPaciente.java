/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.apu.dao.imp.ram;

import ar.edu.unju.fi.apu.modelo.dominio.Paciente;
import ar.edu.unju.fi.apu.modelo.dominio.Propietario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class TablaPaciente {
    //solo era declarar la variable
    public static List<Paciente> pacientes;
    
    public static void llenarPacientes(){
        pacientes=new ArrayList<>();
        Calendar calendario = Calendar.getInstance();
        calendario.set(2003, 2, 1);
        Propietario propietario = new Propietario("domicilio 1","(54) 388 154346580","11.223.344","Cosio","David",calendario.getTime(),true);
        
        pacientes.add(new Paciente(001, 2727, "michiBebe", calendario.getTime(), "Canino", 'M',propietario , null));
        calendario.set(2011, 2, 1);
        pacientes.add(new Paciente(002, 2728, "laika", calendario.getTime(), "Canino", 'H',propietario, null));
    
    } 
    
}
