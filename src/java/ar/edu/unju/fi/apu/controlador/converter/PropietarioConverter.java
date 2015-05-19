/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.apu.controlador.converter;

import ar.edu.unju.fi.apu.dao.IPropietarioDAO;
import ar.edu.unju.fi.apu.dao.imp.ram.PropietarioDAOImp;
import ar.edu.unju.fi.apu.dao.imp.ram.TablaPropietario;
import ar.edu.unju.fi.apu.modelo.dominio.Propietario;
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
@FacesConverter(forClass = Propietario.class, value="propietarioConverter")
public class PropietarioConverter implements Converter{

    private List<Propietario> propietarios;
    
    public PropietarioConverter(){
        propietarios=new ArrayList<>();
        IPropietarioDAO propietarioDAO = new PropietarioDAOImp();
        if (TablaPropietario.tablaPropietario==null){
            TablaPropietario.llenarTabla();
        }
        propietarios=propietarioDAO.obtenerTodos();
        
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try{
            for (Propietario propietario:propietarios){
                if(propietario.getDni().equals(value)){
                    return propietario;
                }
            }
        }catch (Exception ex){
             throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid player"));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != ""){
            Propietario propietario = (Propietario)value;
            String resultado = String.valueOf(propietario.getDni());
            return resultado;
        }else{
            return "";
        }
    }
    
}
