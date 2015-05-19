/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.apu.controlador.formbeans;

import ar.edu.unju.fi.apu.controlador.beans.PacienteBean;
import ar.edu.unju.fi.apu.dao.IPacienteDAO;
import ar.edu.unju.fi.apu.dao.imp.ram.PacienteDAOImp;
import ar.edu.unju.fi.apu.dao.imp.ram.TablaPaciente;

import ar.edu.unju.fi.apu.modelo.dominio.Paciente;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Fernando
 */
@ManagedBean
@SessionScoped
public class PacienteFormBean implements Serializable{
    
    @ManagedProperty(value = "#{pacienteBean}" )
    private PacienteBean pacienteBean;
    private List<Paciente> pacienteFiltrados;
    private UploadedFile archivo; 
    
    public PacienteFormBean() {
    }

   public List<Paciente> obtenerPacientes(){
       IPacienteDAO iPacienteDAO = new PacienteDAOImp();
       if (TablaPaciente.pacientes==null){
           TablaPaciente.llenarPacientes();
       }
       
      
       return iPacienteDAO.obtenerTodos();
   }
    
    public PacienteBean getPacienteBean() {
        return pacienteBean;
    }

    /**
     * @param pacienteBean the pacienteBean to set
     */
    public void setPacienteBean(PacienteBean pacienteBean) {
        this.pacienteBean = pacienteBean;
    }

    /**
     * @return the pacienteFiltrados
     */
    public List<Paciente> getPacienteFiltrados() {
        return pacienteFiltrados;
    }

    /**
     * @param pacienteFiltrados the pacienteFiltrados to set
     */
    public void setPacienteFiltrados(List<Paciente> pacienteFiltrados) {
        this.pacienteFiltrados = pacienteFiltrados;
    }

    public void reiniciarPaciente(){
        this.pacienteBean.setPaciente(new Paciente());
    }

    public UploadedFile getArchivo() {
        return archivo;
    }

    public void setArchivo(UploadedFile archivo) {
        this.archivo = archivo;
    }
    
    public void agregarPaciente() {
        IPacienteDAO pacienteDAO = new PacienteDAOImp();
        //System.out.println(pacienteBean.getPaciente().getNumHC());
        try {
            InputStream inputStream = this.archivo.getInputstream();
            //voy leyendo el inputStream con el metodo read hasta que no haya mas datos
            //cuando llega al final .read retorna -1 y termina.
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int nRead;
            byte[] bytes = new byte[16384];
            while ((nRead = inputStream.read(bytes, 0, bytes.length)) != -1) {
                buffer.write(bytes, 0, nRead);
            }
            //escribo fisicamente lo que pudiera quedar en almacen temporal
            buffer.flush();
            this.pacienteBean.getPaciente().setFoto(buffer.toByteArray());
            //System.out.println(this.pacienteBean.getPaciente().getFoto().length);
        } catch (Exception e)
        {
            
        }
        //guardo el paciente
        pacienteDAO.crearPaciente(this.pacienteBean.getPaciente());
        archivo=null;
    }
    
    public void modificarPaciente() {
        IPacienteDAO pacienteDAO = new PacienteDAOImp();

        try {
            if (archivo.getFileName().isEmpty()==false){
                InputStream inputStream = this.archivo.getInputstream();
                //voy leyendo el inputStream con el metodo read hasta que no haya mas datos
                //cuando llega al final .read retorna -1 y termina.
                ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                int nRead;
                byte[] bytes = new byte[16384];
                while ((nRead = inputStream.read(bytes, 0, bytes.length)) != -1) {
                    buffer.write(bytes, 0, nRead);
                }
                //escribo fisicamente lo que pudiera quedar en almacen temporal
                buffer.flush();
                this.pacienteBean.getPaciente().setFoto(buffer.toByteArray());
                //System.out.println(this.pacienteBean.getPaciente().getFoto().length);
            }
        } catch (Exception e)
        {
            
        }
        //LINEA DE PRUEBA PARA GITHUB
        //guardo el paciente
        pacienteDAO.modificarPaciente(this.pacienteBean.getPaciente());
    }    
    
    public StreamedContent getArchivoFoto() throws IOException{
            IPacienteDAO pacienteDAO = new PacienteDAOImp();            
            FacesContext context = FacesContext.getCurrentInstance();
            
            if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
                // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
                return new DefaultStreamedContent();
            }
            else {
                // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
                String nroHC = context.getExternalContext().getRequestParameterMap().get("numHC");
                Paciente paciente = pacienteDAO.obtenerPaciente(Integer.parseInt(nroHC));
                if(paciente.getFoto()== null){
                    //no tiene foto
                    return null;
                }else{
                    return new DefaultStreamedContent(new ByteArrayInputStream(paciente.getFoto()));
                }
            }

        }    

    public StreamedContent getArchivoFotoModif() throws IOException{
        return (new DefaultStreamedContent(new ByteArrayInputStream(this.pacienteBean.getPaciente().getFoto())));
    }
    
    public void visualizarConfirmaEliminarPaciente(){
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('confirmaEliminarPaciente').show();");    
    }
    
    public void visualizarVentanaConfirmaAlta(){
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('confirmaAltaPaciente').show();");
    }    
    public void eliminarPaciente(){
        IPacienteDAO pacienteDAO= new PacienteDAOImp();
        pacienteDAO.eliminarPaciente(pacienteBean.getPaciente());
    }
    
    public Date getFechaActual(){
        return new Date(System.currentTimeMillis());
    }

}
