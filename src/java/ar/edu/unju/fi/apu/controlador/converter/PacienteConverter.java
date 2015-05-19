/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.apu.controlador.converter;

import ar.edu.unju.fi.apu.dao.IPacienteDAO;
import ar.edu.unju.fi.apu.dao.imp.ram.PacienteDAOImp;
import ar.edu.unju.fi.apu.dao.imp.ram.TablaPaciente;
import ar.edu.unju.fi.apu.modelo.dominio.Paciente;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author celso-pc
 */
@FacesConverter(forClass = Paciente.class, value="pacienteConverter")
public class PacienteConverter implements Converter{

    List<Paciente> pacientes;
    
    public PacienteConverter(){
        pacientes=new ArrayList<>();
        IPacienteDAO pacienteDAO = new PacienteDAOImp();
        if (TablaPaciente.pacientes==null){
            TablaPaciente.llenarPacientes();
        }
        pacientes=pacienteDAO.obtenerTodos();
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try{
            for (Paciente paciente:pacientes){
                if (String.valueOf(paciente.getNumHC()).equals(value)){
                    return paciente;
                }
            }
        }catch (Exception ex){
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid player"));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value!=""){
            Paciente paciente = (Paciente)value;
            return String.valueOf(paciente.getNumHC());
        }else{
            return "";
        }
    }
    
}
