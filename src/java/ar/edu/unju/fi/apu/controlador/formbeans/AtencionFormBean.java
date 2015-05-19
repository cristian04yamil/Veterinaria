/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.apu.controlador.formbeans;

import ar.edu.unju.fi.apu.controlador.beans.AtencionBean;
import ar.edu.unju.fi.apu.dao.IAtencionDAO;
import ar.edu.unju.fi.apu.dao.IPacienteDAO;
import ar.edu.unju.fi.apu.dao.imp.ram.AtencionDAOImp;
import ar.edu.unju.fi.apu.dao.imp.ram.PacienteDAOImp;
import ar.edu.unju.fi.apu.dao.imp.ram.TablaPaciente;
import ar.edu.unju.fi.apu.modelo.dominio.Atencion;
import ar.edu.unju.fi.apu.modelo.dominio.Paciente;
import ar.edu.unju.fi.apu.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author celso-pc
 */
@ManagedBean
@SessionScoped
public class AtencionFormBean implements Serializable {

    @ManagedProperty(value = "#{atencionBean}")
    private AtencionBean atencionBean;

    private Date fechaDesde;
    private Date fechaHasta;
    private Date fechaActual;
    private List<Atencion> algunasAtenciones;
    private Paciente pacienteFormBusqueda;
    /**
     * Creates a new instance of AtencionFormBean
     */
    public AtencionFormBean() {
        algunasAtenciones = new ArrayList<>();
        fechaActual = new Date();
        pacienteFormBusqueda = new Paciente();

    }

    public AtencionBean getAtencionBean() {
        return atencionBean;
    }

    public void setAtencionBean(AtencionBean atencionBean) {
        this.atencionBean = atencionBean;
    }

    public List<Atencion> getAtenciones() {
        IAtencionDAO atencionDAO = new AtencionDAOImp();
        return atencionDAO.obtenerTodos();
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public List<Atencion> getAlgunasAtenciones() {
        return algunasAtenciones;
    }

    public void setAlgunasAtenciones(List<Atencion> algunasAtenciones) {
        this.algunasAtenciones = algunasAtenciones;
    }

    public void buscarAtenciones() {
        IAtencionDAO atencionDAO = new AtencionDAOImp();
        algunasAtenciones = atencionDAO.obtenerAlgunasAtenciones(fechaDesde, fechaHasta, pacienteFormBusqueda);
    }

    public Paciente getPacienteFormBusqueda() {
        return pacienteFormBusqueda;
    }

    public void setPacienteFormBusqueda(Paciente pacienteFormBusqueda) {
        this.pacienteFormBusqueda = pacienteFormBusqueda;
    }

    public void limpiarFormulario() {
        Atencion atencion = new Atencion(0, null, null, obtenerUsuario(), null, null);
        atencionBean.setAtencion(atencion);
    }

    public void visualizarVentanaConfirmaAlta() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('confirmaAltaAtencion').show();");
    }

    public List<Paciente> obtenerPacientes() {
        IPacienteDAO pacienteDAO = new PacienteDAOImp();
        if (TablaPaciente.pacientes == null) {
            TablaPaciente.llenarPacientes();
        }
        return pacienteDAO.obtenerTodos();
    }

    public Usuario obtenerUsuario() {
        Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValido");
        return usuario;
    }

    public Date getFechaMax() {
        return new Date(System.currentTimeMillis());
    }

    public void grabarNuevaAtencion() {
        IAtencionDAO atencionDAO = new AtencionDAOImp();
        atencionDAO.crearAtencion(atencionBean.getAtencion());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacion Realizada", "Operacion Realizada"));
        RequestContext.getCurrentInstance().execute("PF('confirmaAltaAtencion').hide();PF('altaAtencion').hide()");

    }

    public void establecerAtencion(Atencion atencion) {
        atencionBean.setAtencion(atencion);
    }

    public void eliminarAtencion() {
        IAtencionDAO atencionDAO = new AtencionDAOImp();
        atencionDAO.eliminarAtencion(atencionBean.getAtencion());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacion Realizada", "Operacion Realizada"));
        RequestContext.getCurrentInstance().execute("PF('confirmaAltaAtencion').hide();PF('altaAtencion').hide()");

    }

    public void visualizarVentanaConfirmaModificacion(){
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('confirmaModificacionAtencion').show();");
    }
    
    public void actualizarAtencion(){
        IAtencionDAO atencionDAO = new AtencionDAOImp();
        atencionDAO.modificarAtencion(atencionBean.getAtencion());
        FacesContext.getCurrentInstance().addMessage(null, new  FacesMessage(FacesMessage.SEVERITY_INFO,"Operacion Realizada", "Operacion Realizada"));
        RequestContext.getCurrentInstance().execute("PF('confirmaModificacionAtencion').hide();PF('modificacionAtencion').hide()");
    }
    
    
}
