/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.apu.dao.imp.ram;

import ar.edu.unju.fi.apu.dao.IUsuarioDAO;
import ar.edu.unju.fi.apu.modelo.dominio.Usuario;

/**
 *
 * @author celso-pc
 */
public class UsuarioDAOImp implements IUsuarioDAO{

    @Override
    public Usuario validarUsuario(String nombreUsuario, String password) {
        Usuario u = null;
        boolean existe = false;
        for(int i = 0; i<ListadoUsuarios.listadoUsuarios.length && existe==false;i++){
            Usuario usuarioDeListado = ListadoUsuarios.listadoUsuarios[i];
            if (usuarioDeListado!=null && usuarioDeListado.getNombreUsuario().equals(nombreUsuario) &&
               usuarioDeListado.getPassword().equals(password)){
               u = usuarioDeListado;
               existe = true;
            }
        }
        return u;
    }

    @Override
    public void modificar(Usuario unUsuario) {
        boolean existe = false;
        for(int i=0;i<ListadoUsuarios.listadoUsuarios.length && existe !=true; i++){
            Usuario usuarioDelListado = ListadoUsuarios.listadoUsuarios[i];
            if(usuarioDelListado.getNombreUsuario().equals(unUsuario.getNombreUsuario())){
                ListadoUsuarios.listadoUsuarios[i] = unUsuario;
                existe = true;
            }
        }
    }

    @Override
    public Usuario obtenerUsuario(String nombreUsuario) {
        Usuario u = null;
        boolean existe = false;
        for(int i = 0; i<ListadoUsuarios.listadoUsuarios.length && existe==false;i++){
            Usuario usuarioDeListado = ListadoUsuarios.listadoUsuarios[i];
            if (usuarioDeListado!=null && usuarioDeListado.getNombreUsuario().equals(nombreUsuario)){
               u = usuarioDeListado;
               existe = true;
            }
        }
        return u;
    }
    
}
