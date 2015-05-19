/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.apu.controlador.formbeans;

import ar.edu.unju.fi.apu.controlador.beans.UsuarioBean;
import ar.edu.unju.fi.apu.dao.IUsuarioDAO;
import ar.edu.unju.fi.apu.dao.imp.ram.UsuarioDAOImp;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author celso-pc
 */
@ManagedBean
@RequestScoped
public class UsuarioFormBean {
    @ManagedProperty(value = "#{usuarioBean}")
    private UsuarioBean usuarioBean;
    
    /**
     * Creates a new instance of UsuarioFormBean
     */
    public UsuarioFormBean() {  
    }

    public void actualizarDatos(){
        IUsuarioDAO usuarioDAO = new UsuarioDAOImp();
        usuarioDAO.modificar(usuarioBean.getUsuario());
        //usuarioDAO.modificar(usuarioBean.getUsuario());
        FacesMessage facesmessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Datos actualizados", "Datos Actualizados");
        FacesContext.getCurrentInstance().addMessage(null, facesmessage);
    }
    
    /**
     * @return the usuarioBean
     */
    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    /**
     * @param usuarioBean the usuarioBean to set
     */
    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }
    
}
