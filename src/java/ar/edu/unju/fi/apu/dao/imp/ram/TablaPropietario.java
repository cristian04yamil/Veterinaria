/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.apu.dao.imp.ram;

import ar.edu.unju.fi.apu.modelo.dominio.Propietario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 
 * @author Fernando
 */
public class TablaPropietario {
    public static List<Propietario> tablaPropietario;
    
    public static void llenarTabla(){   
        tablaPropietario = new ArrayList<>();
        Calendar calendario = Calendar.getInstance();
        calendario.set(2005, 2, 1);
        tablaPropietario.add(new Propietario("domicilio 1",
                                             "(54) 388 154346580", 
                                             "11.223.344", 
                                             "Cosio", 
                                             "David", 
                                             calendario.getTime(), 
                                             true));
        calendario.set(2010, 8, 20);
        tablaPropietario.add(new Propietario("domicilio 2",
                                             "(54) 388 156546544", 
                                             "98.002.966", 
                                             "Maidana", 
                                             "Celso", 
                                             calendario.getTime(), 
                                             true));
        calendario.set(2015, 10, 2);
        tablaPropietario.add(new Propietario("domicilio 3",
                                             "(54) 388 153578988", 
                                             "45.243.474", 
                                             "Zalasar", 
                                             "Tita", 
                                             calendario.getTime(), 
                                             true));

    }
}
