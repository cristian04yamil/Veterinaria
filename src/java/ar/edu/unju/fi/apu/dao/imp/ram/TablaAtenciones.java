/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.apu.dao.imp.ram;

import ar.edu.unju.fi.apu.modelo.dominio.Atencion;
import ar.edu.unju.fi.apu.modelo.dominio.Paciente;
import ar.edu.unju.fi.apu.modelo.dominio.Propietario;
import ar.edu.unju.fi.apu.modelo.dominio.Usuario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author celso-pc
 */
public class TablaAtenciones {
 
    public static List<Atencion> tablaAtenciones;
    
    
    public static void llenarAtenciones(){
        tablaAtenciones=new ArrayList<>();
        Calendar calendar=Calendar.getInstance();
        Propietario propietario=new Propietario("domicilio 1",
                                             "(54) 388 154346580", 
                                             "11.223.344", 
                                             "Cosio", 
                                             "David", 
                                             new Date(), 
                                             true);
        Paciente paciente=new Paciente(001, 2727, "michiBebe", new Date(), "Canino", 'M',propietario , null);
        Usuario usuario=new Usuario("test", "test", null, null, true);
        calendar.set(2015, 05, 23);
        tablaAtenciones.add(new Atencion(1234, 
                                        paciente, 
                                        calendar.getTime(), 
                                        usuario, 
                                        "diagnostico 1", 
                                        "observacion 1"));
        
        propietario=new Propietario("domicilio 3",
                                             "(54) 388 153578988", 
                                             "45.243.474", 
                                             "Zalasar", 
                                             "Tita", 
                                             new Date(), 
                                             true);
        paciente=new Paciente(002, 2728, "laika", new Date(), "Canino", 'H',propietario, null);
        calendar.set(1999, 07, 12);
        tablaAtenciones.add(new Atencion(4321, 
                                        paciente, 
                                        calendar.getTime(), 
                                        usuario, 
                                        "diagnostico 2", 
                                        "observacion 2"));
        
    }
}
