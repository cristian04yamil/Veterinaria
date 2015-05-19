/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.apu.controlador.formbeans;

import ar.edu.unju.fi.apu.controlador.beans.PropietarioBean;
import ar.edu.unju.fi.apu.dao.IPropietarioDAO;
import ar.edu.unju.fi.apu.dao.imp.ram.PropietarioDAOImp;
import ar.edu.unju.fi.apu.dao.imp.ram.TablaPropietario;
import ar.edu.unju.fi.apu.modelo.dominio.Propietario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author celso-pc
 */
@ManagedBean
@ViewScoped
public class PropietarioFormBean implements Serializable{
    @ManagedProperty(value = "#{propietarioBean}")
    private PropietarioBean propietarioBean;
    private List<Propietario> propietarioFiltrado;
    //private UploadedFile archivo;

    
    public Date getFechaActual(){
        return new Date(System.currentTimeMillis());
    }
    
    public void establecerPropietario(Propietario propietario){
        propietarioBean.setPropietario(propietario);
    }
    /**
     * Creates a new instance of PropietarioFormBean
     */
    public PropietarioFormBean() {
    }

    public void actualizarPropietario(){
        IPropietarioDAO propietarioDAO = new PropietarioDAOImp();
        propietarioDAO.modificarPropietario(propietarioBean.getPropietario());
        FacesContext.getCurrentInstance().addMessage(null, new  FacesMessage(FacesMessage.SEVERITY_INFO,"Operacion Realizada", "Operacion Realizada"));
        RequestContext.getCurrentInstance().execute("PF('confirmaModificacionPropietario').hide();PF('modificacionPropietario').hide()");
    }
    
    public void grabarNuevoPropietario(){
        IPropietarioDAO propietarioDAO = new PropietarioDAOImp();
        propietarioDAO.crearPropietario(propietarioBean.getPropietario());
        FacesContext.getCurrentInstance().addMessage(null, new  FacesMessage(FacesMessage.SEVERITY_INFO,"Operacion Realizada", "Operacion Realizada"));
        RequestContext.getCurrentInstance().execute("PF('confirmaAltaPropietario').hide();PF('altaPropietario').hide()");
    }
    
    public List<Propietario> obtenerPropietario(){
        IPropietarioDAO propietarioDAO = new PropietarioDAOImp();
        if (TablaPropietario.tablaPropietario==null){
            TablaPropietario.llenarTabla();
        }
        return propietarioDAO.obtenerTodos();
    }
    public void limpiarformulario(){
        propietarioBean.setPropietario(new Propietario());
    }
    public void visualizarVentanaConfirmaAlta(){
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('confirmaAltaPropietario').show();");
    }
    
        public void visualizarVentanaConfirmaModificacion(){
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('confirmaModificacionPropietario').show();");
    }

    public PropietarioBean getPropietarioBean() {
        return propietarioBean;
    }

    public void setPropietarioBean(PropietarioBean propietarioBean) {
        this.propietarioBean = propietarioBean;
    }

    public List<Propietario> getPropietarioFiltrado() {
        return propietarioFiltrado;
    }

    public void setPropietarioFiltrado(List<Propietario> propietarioFiltrado) {
        this.propietarioFiltrado = propietarioFiltrado;
    }

    
}
